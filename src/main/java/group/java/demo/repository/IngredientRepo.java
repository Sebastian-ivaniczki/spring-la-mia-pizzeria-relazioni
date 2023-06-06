package group.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.entity.Ingredient;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

}
