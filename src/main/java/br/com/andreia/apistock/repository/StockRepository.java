package br.com.andreia.apistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andreia.apistock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	Stock findByName(String Name);	

}
