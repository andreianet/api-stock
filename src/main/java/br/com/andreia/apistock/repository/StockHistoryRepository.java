package br.com.andreia.apistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.andreia.apistock.model.stockHistory;

@Repository
public interface StockHistoryRepository extends JpaRepository<stockHistory, Long>{
	

}
