package group.java.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.entity.Ingredient;
import group.java.demo.repository.IngredientRepo;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepo ingredientRepo;
	
	public List<Ingredient> findAll(){
		return ingredientRepo.findAll();
	}
	
	public Ingredient save(Ingredient ingredient) {
		return ingredientRepo.save(ingredient);
	}
}
