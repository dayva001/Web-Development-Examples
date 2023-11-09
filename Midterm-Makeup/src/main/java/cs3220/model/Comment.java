package cs3220.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment 
{
	LocalDateTime timestamp;	
	String commenter, content;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" hh:mm a MM/dd/yyy");
	
	public Comment(String commenter, String content, LocalDateTime timestamp)
	{
		this.commenter = commenter;
		this.content = content;
		this.timestamp = timestamp;
	}
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String getFormattedTime()
	{
		return timestamp.format(formatter);
	}
	
	public void setCommentTime(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}


