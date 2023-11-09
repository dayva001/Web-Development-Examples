package cs3220.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataStore;
import cs3220.model.Event;
import cs3220.model.EventItem;
import jakarta.validation.Valid;

@Controller
public class IndexController {
	
	public final DataStore data;
	
	public IndexController(DataStore data) 
	{
		this.data=data;
	}
	
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("events",data.getEvents());
		return "index";
	}
	
	@GetMapping("/addEvent")
	public String addEvent(Model model)
	{
		model.addAttribute("event",new Event("",LocalDate.now(),""));
		return "addEvent";
	}
	
	@PostMapping("/addEvent")
	public String added(@Valid @ModelAttribute("event") Event event, Model model, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addEvent";
		}
		data.getEvents().add(event);
		return "redirect:/";
	}
	
	@GetMapping("/editEvent/{id}")
	public String editEvent(@PathVariable int id, Model model)
	{
		model.addAttribute("event",data.getEvent(id));
		return "addEvent";
	}
	
	@PostMapping("/editEvent/{id}")
	public String edited(@PathVariable int id,@Valid @ModelAttribute("event") Event newEvent, Model model, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "edit";
		}
		Event event = data.getEvent(id);
		event.setName(newEvent.getName());
		event.setDate(newEvent.getDate());
		event.setCreator(newEvent.getCreator());
		return "redirect:/";
	}
	
	@RequestMapping("/viewEvent/{id}")
	public String viewEvent(@PathVariable int id,  Model model)
	{
		model.addAttribute("event", data.getEvent(id));
		model.addAttribute("itemList", data.getEvent(id).getItems());
		return "viewEvent";
	}
	
	@GetMapping("viewEvent/{id}/addItem")
	public String addItem(@PathVariable int id, Model model)
	{
		model.addAttribute("item",new EventItem("",1,""));
		model.addAttribute("event", data.getEvent(id));
		model.addAttribute("itemList", data.getEvent(id).getItems());
		return "addItem";
	}
	
	@PostMapping("viewEvent/{id}/addItem")
	public String addedItem(@PathVariable int id, String name, int amount, String bringer, Model model)
	{	
		data.getEvent(id).addItem( new EventItem(name, amount, bringer));
		model.addAttribute("event", data.getEvent(id));
		model.addAttribute("itemList", data.getEvent(id).getItems());
		return "redirect:/viewEvent/{id}";
	}
	
	@GetMapping("viewEvent/{id1}/signUp/{id2}")
	public String signUp(@PathVariable int id1, @PathVariable int id2,  Model model)
	{
		model.addAttribute("event", data.getEvent(id1));
		model.addAttribute("item", data.getEvent(id1).getItem(id2));
		return "signUp";
	}
	
	@PostMapping("viewEvent/{id1}/signUp/{id2}")
	public String signedUp(@PathVariable int id1, @PathVariable int id2, String name, Model model)
	{	
		data.getEvent(id1).getItem(id2).setBringer(name);
		return "redirect:/viewEvent/{id1}";
	}
	
	@RequestMapping("viewEvent/{id1}/deleteItem/{id2}")
	public String deleteItem(@PathVariable int id1, @PathVariable int id2,  Model model)
	{
		model.addAttribute("event", data.getEvent(id1));
		model.addAttribute("item", data.getEvent(id1).getItem(id2));
		data.getEvent(id1).deleteItem(id2);
		return "redirect:/viewEvent/{id1}";
	}
}
