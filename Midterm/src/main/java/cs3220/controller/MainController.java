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



@Controller
public class MainController {
	
	public final DataStore data;
	
	public MainController(DataStore data) 
	{
		this.data=data;
	}
	
	@GetMapping("/")
	public String index(Model model)
	{
		
		int weekNum = data.getWeeks().size()-1;
		model.addAttribute("weeks", data.getWeeks());
		model.addAttribute("week", data.getWeeks().get(weekNum));
		model.addAttribute("jobs",data.getJobs());
		return "index";
	}
	
	@PostMapping("/")
	public String postIndex(Model model, int weekNum)
	{
		return "index";
	}
		
	@RequestMapping("/addWeek")
	public String addWeek(Model model)
	{
		int newWeek = data.getWeeks().size()-1;
		return "redirect:/";
	}
 
}