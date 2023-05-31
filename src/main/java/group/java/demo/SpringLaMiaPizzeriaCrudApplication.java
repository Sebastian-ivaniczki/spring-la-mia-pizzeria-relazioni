package group.java.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import group.java.demo.entity.Pizza;
import group.java.demo.service.PizzaService;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
		
		
	}
	
	@Autowired
	private PizzaService pizzaService;
	
	@Override
	public void run(String... args) throws Exception {
		Pizza p = new Pizza("margherita 1", "buona buona" ,"https://www.unmondodisapori.it/wp-content/uploads/2017/10/margherita.jpg", 5.00f);
		Pizza p1 = new Pizza("margherita 2", "buona buona" ,"https://www.unmondodisapori.it/wp-content/uploads/2017/10/margherita.jpg", 5.00f);
		Pizza p2 = new Pizza("margherita 3", "buona buona" ,"https://www.unmondodisapori.it/wp-content/uploads/2017/10/margherita.jpg", 5.00f);
		Pizza p3 = new Pizza("margherita 4", "buona buona" ,"https://www.unmondodisapori.it/wp-content/uploads/2017/10/margherita.jpg", 5.00f);
		Pizza p4 = new Pizza("margherita 5", "buona buona" ,"https://www.unmondodisapori.it/wp-content/uploads/2017/10/margherita.jpg", 5.00f);
		pizzaService.save(p);
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
	}

}
