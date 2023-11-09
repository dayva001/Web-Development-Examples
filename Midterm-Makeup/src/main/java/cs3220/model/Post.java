package cs3220.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post 
{
	LocalDateTime postTime;
	String poster, postName;
	List<Comment> comments;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" hh:mm a MM/dd/yyy");
	private static int idSeed=0;
	private final int id;
	
	public Post( String postName, String poster, LocalDateTime postTime)
	{
		this.postTime = postTime;
		this.poster = poster;
		this.postName = postName;
		comments = new ArrayList<Comment>();
		id=idSeed++;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}
	
	public String getFormattedTime()
	{
		return postTime.format(formatter);
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public List<Comment> getComments()
	{
		return comments;
	}
	
	public void addComment(Comment c)
	{
		comments.add(c);
	}
	
	public int getId()
	{
		return id;
	}
}
