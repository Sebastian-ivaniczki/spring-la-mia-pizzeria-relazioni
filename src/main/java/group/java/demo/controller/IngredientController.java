package group.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import group.java.demo.service.IngredientService;

@Controller
public class IngredientController {
	@Autowired
	private IngredientService ingredientService;

}
