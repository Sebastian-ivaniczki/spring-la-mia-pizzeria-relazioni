package group.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.entity.SpecialOffer;
import group.java.demo.repository.SpecialOfferRepo;
import jakarta.transaction.Transactional;



@Service
public class SpecialOfferServ {

	
	@Autowired
	private SpecialOfferRepo specialRepo;
	
	public List<SpecialOffer> findAll(){
		return specialRepo.findAll();
	}
	
	public Optional<SpecialOffer> findById(Integer id){
		return specialRepo.findById(id);
	}
	
	public SpecialOffer save(SpecialOffer specialOffer) {
		return specialRepo.save(specialOffer);
	}
	
	public void delet(SpecialOffer specialOffer) {
		specialRepo.delete(specialOffer);
	}
	
	 @Transactional
	   public Optional<SpecialOffer> findByIdWithPizza(Integer id){
		   
		   Optional<SpecialOffer> specialOfferOpt = specialRepo.findById(id);
		   Hibernate.initialize(specialOfferOpt.get().getPizza());
		   return specialOfferOpt;
	   }
}
