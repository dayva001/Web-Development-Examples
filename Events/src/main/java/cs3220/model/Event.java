package cs3220.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
public class Event {
	@NotBlank
	private String name;
	private LocalDate date;
	@NotBlank
	private String creator;
	private List<EventItem> eventItems;
	private static int idSeed=0;
	private final int id;
	
	
	public Event(String name, LocalDate date, String creator)
	{
		id = idSeed++;
		this.name=name;
		this.date = date;
		this.creator = creator;
		eventItems = new ArrayList<EventItem>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public List<EventItem> getItems()
	{
		return eventItems;
	}
	
	public EventItem getItem(int id)
	{
		for(EventItem i: eventItems)
		{
			if(i.getId() == id)
			{
				return i;
			}
		}
		return null;
	}
	
	public void deleteItem(int id)
	{
		for(int i=0;i<eventItems.size(); i++)
		{
			if(eventItems.get(i).getId() == id)
			{
				eventItems.remove(i);
			}
		}
	}
	
	public void addItem(EventItem item)
	{
		eventItems.add(item);
	}
	
	public int getId()
	{
		return id;
	}
}


