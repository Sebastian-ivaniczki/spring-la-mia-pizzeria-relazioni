package group.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import group.java.demo.entity.Pizza;
import group.java.demo.service.PizzaService;
import jakarta.validation.Valid;

@Controller
public class ControllerPizza {
		
	
	
	
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "index";
		
	}
	
	@PostMapping("/pizzas/by/name")
	public String getBookByTitle(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> pizzas = pizzaService.findByName(name);
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/pizzas/{id}")
    public String getSinglePizza(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> optpizza = pizzaService.findById(id);
        Pizza pizza = optpizza.get();
        if (pizza == null) {
            
            return "error";
        }
        
        
        model.addAttribute("pizza", pizza);
        
        return "singlepizza";
    }
	
	//create
	
	@GetMapping("pizzas/create")
	public String createPizza(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "create"; 
		
	}
	
	//store pizza
	@PostMapping("pizzas/create")
	public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors() ) {
			for(ObjectError err :bindingResult.getAllErrors()) {
				System.err.println("error: " + err.getDefaultMessage());
				
				model.addAttribute("pizza", pizza);
				model.addAttribute("errors", bindingResult);
				//if (bindingResult.hasFieldErrors(name))
				
				bindingResult.getFieldError("name").getDefaultMessage();
				return "create";
			}
		}
		pizzaService.save(pizza);
		
		return "redirect:/";
		
	}
	
	//delete
	
	@GetMapping("/pizza/delete/{id}")
	public String delt(@PathVariable Integer id) {
		
		
		Optional<Pizza>  pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		pizzaService.deltPizza(pizza);
		
		
		return "redirect:/";
	}
	
	//Update 
	
	@GetMapping("/pizza/update/{id}")
	public String edit(Model model, @PathVariable Integer id) {
		
		Optional<Pizza>  pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		 model.addAttribute("pizza", pizza);
		 
		 return "update";
		
	}
	
	//save the updates 
	@PostMapping("/pizza/update/{id}")
	public String update(@PathVariable Integer id,
						@ModelAttribute Pizza pizza) {
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	

}
