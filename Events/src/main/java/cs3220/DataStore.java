package cs3220;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs3220.model.Event;

@Component
public class DataStore 
{
	private List<Event> eventList;
	public DataStore()
	{
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-d");
		eventList=new ArrayList<Event>();
		eventList.add(new Event("Room 19 Valentine Party", LocalDate.parse("2023-01-14",df), "Amy Lynn"));
		eventList.add(new Event("Room 10 Kindergarten Graduation", LocalDate.parse("2023-05-15",df), "George Yurt"));
		eventList.add(new Event("Jonathan's birthday", LocalDate.parse("2023-07-23",df), "Jessica Hernandez"));
		
	}
	
	public Event getEvent(int id) {
		for (Event e : eventList)
			if (e.getId() == id)
				return e;
		return null;
	}
	
	public List<Event> getEvents() {
		return eventList;
	}

	public void setEntries(List<Event> events) {
		eventList = events;
	}

	
}
