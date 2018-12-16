package cccPharma.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Purchase {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String barCode;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private LocalDate purchasedDate;
    private double totalCost;
    private int quantity;
    
    public Purchase() {
    	
    }

    @JsonCreator
    public Purchase(Product product, int quantity) {
    	this.purchasedDate = LocalDate.now();
    	this.totalCost = product.getPrice() * quantity;
    	this.barCode = product.getBar_code();
    	this.product = product;
    	this.quantity = quantity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantify(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchasedDate == null) ? 0 : purchasedDate.hashCode());
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Purchase other = (Purchase) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchasedDate == null) {
			if (other.purchasedDate != null)
				return false;
		} else if (!purchasedDate.equals(other.purchasedDate))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		return true;
	}
    
	public String toString() {
		String ret;
		ret = "Compradas " + this.quantity + " unidade(s) de " + this.product.getName();
		ret += " na data " + this.purchasedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		ret += " o custo total da compra foi de R$" + String.format("%.2f", this.totalCost);
		return ret;
	}
}
