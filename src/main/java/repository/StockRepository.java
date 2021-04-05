package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	static Stock findByName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
