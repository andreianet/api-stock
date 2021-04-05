package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Stock;
import repository.StockRepository;
import service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockService stockService;
	
	
	@GetMapping
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public List<Stock> list(){		
		return stockRepository.findAll();
	}
	
	//select * from contact where id = ?
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Stock> findById(@PathVariable long id){
	  return stockRepository.findById(id)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock create(@Validated @RequestBody Stock stock) {
		return stockRepository.save(stock);
	}
	
	@PatchMapping(value="/{name}")
	public ResponseEntity<Stock> update(@PathVariable("id") long id,
	                                        @RequestBody Stock stock){
	    return stockRepository.findById(id)
	        .map(record -> {	        	
	        	record.setQuotes(stock.getQuotes());
	        	Stock up = stockRepository.save(record);
	        	return ResponseEntity.ok().body(up);
	        }).orElse(ResponseEntity.notFound().build());
	}	  
	
	@DeleteMapping(path ={"/{id}"})	
	public ResponseEntity<?> delete(@PathVariable ("id") Long Id){
		if(!stockRepository.existsById(Id)) {
			return ResponseEntity.notFound().build();
		}
		stockService.delete(Id);
		return ResponseEntity.noContent().build();
	}
	

}
