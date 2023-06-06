package group.java.demo.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "name it's obligatory to be filled")
	private String name;
	@NotBlank(message = "description it's obligatory to be filled")
	private String description;
	//@NotBlank(message = "the immage must be an url")
	private String img;
	@NotNull(message = "price it's obligatory to be filled")
    @DecimalMin(value = "0.01", message = "price has to be < than {value}")
    @DecimalMax(value = "999.99", message = "price has to be > than {value}")
   private float price;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private SpecialOffer specialOffer;	
	
	@ManyToMany
	List<Ingredient> ingredients;
	public Pizza() { }
	
	public Pizza(String name, String description, String img, float price) {
		setName(name);
		setDescription(description);
		setImg(img);
		setPrice(price);
	}
	
	public Pizza(String name, String description, String img, float price,SpecialOffer specialOffer) {
		setName(name);
		setDescription(description);
		setImg(img);
		setPrice(price);
		setSpecialOffer(specialOffer);
	}
	
	//constructor whit ingredient
	
	public Pizza(String name, String description, String img, float price,SpecialOffer specialOffer, Ingredient...ingredients ) {
		
		this(name, description, img, price, specialOffer);
		setIngredients(ingredients);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}

	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}

	public List<Ingredient> getIngredient() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredient) {
		this.ingredients = ingredient;
	}
	
	
	//add ingredient and remove
	
	public void setIngredients(Ingredient[] ingredient) {
			
			setIngredients(Arrays.asList(ingredient));
	}
	
	public void removeIngredient(Ingredient ingredient) {
		
		ingredients.remove(ingredient);
		
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName() + " - " + getDescription() + " - " + getPrice() + "offer"+ getSpecialOffer();
	}
	
	
}
