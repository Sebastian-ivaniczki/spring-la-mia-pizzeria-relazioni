package group.java.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ManyToMany(mappedBy = "ingredient")
	List<Pizza> pizza;
	
	public Ingredient() {}
	public Ingredient(String name) {
		setName(name);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name" + getName();
	}
	
}
