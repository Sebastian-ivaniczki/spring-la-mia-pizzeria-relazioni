package group.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.java.demo.entity.SpecialOffer;

public interface SpecialOfferRepo extends JpaRepository<SpecialOffer, Integer>{

}
