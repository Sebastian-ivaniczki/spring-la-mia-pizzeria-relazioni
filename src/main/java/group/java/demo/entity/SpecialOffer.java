package group.java.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SpecialOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate start;
	private LocalDate end;
	private String name;
	private int perc;
	
	@OneToMany(mappedBy = "specialOffer")
	private List<Pizza> pizza;
	
	public SpecialOffer() {}
	public SpecialOffer(LocalDate start,LocalDate end,String name,int perc) {
		
		setEnd(end);
		setName(name);
		setPerc(perc);
		setStart(start);
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPerc() {
		return perc;
	}
	public void setPerc(int perc) {
		this.perc = perc;
	}
	public List<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	
	

}
