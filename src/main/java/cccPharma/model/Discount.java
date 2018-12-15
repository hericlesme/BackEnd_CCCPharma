package cccPharma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Discount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private double fraction;
    private String description;
    
    public Discount() {
    	
    }
    
    public Discount(double fraction, String description) {
    	this.fraction = fraction;
    	this.description = description;
    }

	public Long getId() {
		return id;
	}

	public double getFraction() {
		return fraction;
	}

	public void setFraction(double fraction) {
		this.fraction = fraction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fraction);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Discount other = (Discount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(fraction) != Double.doubleToLongBits(other.fraction))
			return false;
		return true;
	}
    
}
