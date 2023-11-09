package cs3220;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs3220.model.Comment;
import cs3220.model.Post;

@Component
public class DataController {
	List<Post> posts;
	
	public DataController()
	{
		posts = new ArrayList<Post>();
		posts.add(new Post("When is the midterm?", "John", LocalDateTime.of(2023, Month.OCTOBER, 4, 11,1)));
		posts.add(0,new Post("I got a 404 Error. Please Help!!!", "Jane", LocalDateTime.of(2023, Month.OCTOBER, 20, 20,16)));
		posts.get(0).addComment(new Comment("John","Maybe you should check your URL mapping",LocalDateTime.of(2023, Month.OCTOBER, 20,20,20)));
		posts.get(0).addComment(new Comment("Tom","Also check if the template file is in the right place",LocalDateTime.of(2023, Month.OCTOBER, 20,21,12)));

	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public Post getPost(int id)
	{
		for(int i=0;i<posts.size();i++)
		{
			if(posts.get(i).getId()==id)
			{
				return posts.get(i);
			}

		}
		return null;
	}
	
	public void addPost(Post p)
	{
		posts.add(0,p);
	}
	
}
