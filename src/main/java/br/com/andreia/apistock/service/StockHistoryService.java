package br.com.andreia.apistock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import br.com.andreia.apistock.model.stockHistory;
import br.com.andreia.apistock.repository.StockHistoryRepository;


public class StockHistoryService {
	
	@Autowired
	private StockHistoryRepository stockhistoryrepository;
	
	public stockHistory salvar(stockHistory stockHis){
		return stockhistoryrepository.save(stockHis);
	}
	
	public List<stockHistory> getStock(){
		return stockhistoryrepository.findAll();
	}
	
	public String delete (Long id) {
		stockhistoryrepository.deleteById(id);
		return "StockHistory removed!" + id;
	}
}
