package cs3220.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("firstName", "John");
		model.addAttribute("lastName", "Smith");
		return "index";
	}

	@GetMapping("/add")
	public String add()
	{
		return "add";
	}
	
	@PostMapping("/add")
	public String result(int a, int b, Model model)
	{
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("sum", a+b);
		return "result";
	}
}
