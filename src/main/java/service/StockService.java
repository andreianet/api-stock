package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.NegException;
import model.Stock;
import repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockrepository;
	
	public Stock salvar(Stock stock) {
		Stock stockExist = StockRepository.findByName(stock.getName());
		
		if(stockExist != null && !stockExist.equals(stock)) {
			throw new NegException("Já existe Stock cadastrado com este Name");
			
		}
		return stockrepository.save(stock);
	}
	
	public void delete (Long Id) {
		
	}
}
