package group.java.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.entity.Pizza;
import group.java.demo.repository.PizzaRepo;


@Service
public class PizzaService {

	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll(){
		return pizzaRepo.findAll();
	}
	
	
	
	
	public Pizza save(Pizza pizza) {
		
		return pizzaRepo.save(pizza);
	
	}
	
	public Optional<Pizza> findById(Integer id){
		
		return pizzaRepo.findById(id);
		
	}
	
	public List<Pizza> findByName(String name){
		
		return pizzaRepo.findByNameContaining(name);
		
	}
	
   public void deltPizza (Pizza pizza) {
	   pizzaRepo.delete(pizza);
   }
   
  
}
