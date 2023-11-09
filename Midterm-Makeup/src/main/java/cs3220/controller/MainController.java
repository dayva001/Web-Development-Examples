package cs3220.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataController;
import cs3220.model.Comment;
import cs3220.model.Post;

@Controller
public class MainController {
	public final DataController data;
	
	public MainController()
	{
		data = new DataController();
	}
	
	public MainController(DataController data) 
	{
		this.data=data;
	}
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("posts", data.getPosts());
		return "index";
	}
	
	@GetMapping("postQuestion")
	public String postQuestion(Model model)
	{
		Post temp = new Post("","", LocalDateTime.now());
		model.addAttribute("post", temp);
		return "postQuestion";
	}
	
	@PostMapping("postQuestion")
	public String postQuestion(Model model, Post post)
	{
		data.addPost(post);
		return "redirect:/";
	}
	
	@RequestMapping("viewPost/{id}")
	public String viewPost(Model model, @PathVariable int id)
	{
		model.addAttribute("post",data.getPost(id));
		return "viewPost";
	}
	
	@GetMapping("viewPost/{id}/postComment")
	public String postComment(Model model, @PathVariable int id)
	{
		Comment temp = new Comment("","", LocalDateTime.now());
		model.addAttribute("comment",temp);
		return "postComment";
	}
	
	@PostMapping("viewPost/{id}/postComment")
	public String postComment(Model model, @PathVariable int id, Comment c)
	{
		data.getPost(id).addComment(c);
		return "redirect:/viewPost/" + id;
	}

}
