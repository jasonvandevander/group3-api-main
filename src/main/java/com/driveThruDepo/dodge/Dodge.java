package com.driveThruDepo.dodge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dodge")
public class Dodge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, name = "car_id")
	private long id;
	private String image;
	private String model;
	private String year;
	private String color;
	private double price;
	private String status;
	private double mileage;
	private int numberOfCars;
	private String dateOfInventory;
	
	public Dodge() {}

	public Dodge(String image, String model, String year, String color, double price, String status, double mileage,
			int numberOfCars, String dateOfInventory) {
		super();
		this.image = image;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
		this.status = status;
		this.mileage = mileage;
		this.numberOfCars = numberOfCars;
		this.dateOfInventory = dateOfInventory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}

	public String getDateOfInventory() {
		return dateOfInventory;
	}

	public void setDateOfInventory(String dateOfInventory) {
		this.dateOfInventory = dateOfInventory;
	}

	@Override
	public String toString() {
		return "Dodge [id=" + id + ", image=" + image + ", model=" + model + ", year=" + year + ", color=" + color
				+ ", price=" + price + ", status=" + status + ", mileage=" + mileage + ", numberOfCars=" + numberOfCars
				+ ", dateOfInventory=" + dateOfInventory + "]";
	}

}
