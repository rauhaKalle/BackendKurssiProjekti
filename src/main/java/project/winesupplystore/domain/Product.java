package project.winesupplystore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	//helpompi laittaa kaikki erikseen myöhemmin validoinnin kannalta
	private String name;
	private String type;
	private String country;
	private double productionYear;
	
	@ManyToOne
	@JoinColumn(name = "manufacturerid")
	private Manufacturer manufacturer;
	
	//koodi restin helpottamiseksi 
	public Product() {}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(double productionYear) {
		this.productionYear = productionYear;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Product(String name, String type, String country, double productionYear, Manufacturer manufacturer) {
		super();
		this.name = name;
		this.type = type;
		this.country = country;
		this.productionYear = productionYear;
		this.manufacturer = manufacturer;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", country=" + country + ", productionYear=" + productionYear
				+ "]";
	}
	
	
}
