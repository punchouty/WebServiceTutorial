package com.store.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Store {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String name;
	private String branchName;
	@NotNull
	private double lattitude;
	@NotNull
	private double longitiude;
	
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", branchName=" + branchName + ", lattitude=" + lattitude
				+ ", longitiude=" + longitiude + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitiude() {
		return longitiude;
	}
	public void setLongitiude(double longitiude) {
		this.longitiude = longitiude;
	}
	public Long getId() {
		return id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
