package project.winesupplystore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long manufacturerid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
	@JsonIgnore
	private List<Product> products;

	//koodi restin helpottamiseksi 
	public Manufacturer() {}
	
	public Long getManufacturerid() {
		return manufacturerid;
	}

	public void setManufacturerid(Long manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Manufacturer( String name) {
		super();
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerid=" + manufacturerid + ", name=" + name + ", products=" + products + "]";
	}
	
	
}
