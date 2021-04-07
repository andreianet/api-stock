package br.com.andreia.apistock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "stockhistory")
public class stockHistory {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@JsonIgnore //Para não criar um loop Infinito
		@ManyToOne //Muitos Quotes para um Stock
		@JoinColumn(name="stock_id")
		private Stock stock;
		
		private Double price;
	

}
