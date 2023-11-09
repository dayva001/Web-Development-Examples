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
		model.addAttribute("weeks",data.getWeeks());
		return "index";
	}
	

}
