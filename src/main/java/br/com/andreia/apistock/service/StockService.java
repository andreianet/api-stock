package br.com.andreia.apistock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andreia.apistock.repository.StockRepository;
import br.com.andreia.apistock.model.Stock;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockrepository;
	
	public Stock salvar(Stock stock){
		stock.getQuotes().forEach(q -> q.setStock(stock));
		return stockrepository.save(stock);
	}
	
	public List<Stock> getStock(){
		return stockrepository.findAll();
	}
	
	public String delete (Long id) {
		stockrepository.deleteById(id);
		return "Stock removed!" + id;
	}
	
	public Stock update(Stock stock) {
		Stock existingStock = stockrepository.findById(stock.getId()).orElse(null);
		existingStock.setName(stock.getName());
		existingStock.setQuotes(stock.getQuotes());
		return stockrepository.save(existingStock);
		
	}
}
