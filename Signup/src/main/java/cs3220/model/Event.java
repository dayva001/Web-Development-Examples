package cs3220.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	private String name;
	private Date date;
	private String creator;
	SimpleDateFormat format = new SimpleDateFormat("M/dd/yy");
	
	public Event(String name, Date date, String creator)
	{
		this.name=name;
		this.date = date;
		this.creator = creator;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public String getDateAsString() {
		return format.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
