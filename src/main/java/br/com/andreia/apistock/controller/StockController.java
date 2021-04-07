package br.com.andreia.apistock.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.andreia.apistock.repository.StockRepository;
import br.com.andreia.apistock.service.StockService;
import br.com.andreia.apistock.model.Stock;

@RestController
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockService stockService;
	
	
	@GetMapping("/stock")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Stock> list(){		
		return stockRepository.findAll();
	}
	
	//select * from contact where id = ?
	@GetMapping(path = {"{idStock}"})
	public ResponseEntity<Stock> search(@PathVariable Long idStock){
	  return stockRepository.findById(idStock)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	
	//tentar realizar o post com stock e stockhistory
	@PostMapping("/stock")
	@ResponseStatus(HttpStatus.CREATED)
	public Stock create(@RequestBody Stock stock) {
		return stockService.salvar(stock);
	}
	
	@PatchMapping(value="/{name_stock}")
	public ResponseEntity<Stock> update(@PathVariable("id") long id,
	                                        @RequestBody Stock stock){
	    return stockRepository.findById(id)
	        .map(record -> {	        	
	        	record.setQuotes(stock.getQuotes());
	        	Stock up = stockRepository.save(record);
	        	return ResponseEntity.ok().body(up);
	        }).orElse(ResponseEntity.notFound().build());
	}	  
	
	@DeleteMapping(path ={"{id}"})	
	public ResponseEntity<?> delete(@PathVariable ("id") long Id){
		if(!stockRepository.existsById(Id)) {
			return ResponseEntity.notFound().build();
		}
		stockService.delete(Id);
		return ResponseEntity.noContent().build();
	}
	

}
