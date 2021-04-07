package br.com.andreia.apistock.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblstock")
	public class Stock {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, unique = true)
		private String name;
		
		@Column(nullable = false)
		//private double quotes;
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "stock", fetch = FetchType.EAGER)
		//@JoinColumn(name="stock_id")
		private List<stockHistory> quotes;

}



