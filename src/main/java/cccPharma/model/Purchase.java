package cccPharma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long idUser;
    private LocalDate purchasedDate;
    private double totalCost;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "purchase_products",
            joinColumns = { @JoinColumn(name = "purchase_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<Product> products;
    
    
    public Purchase() {
    	
    }
    
    public Purchase(Long idUser, LocalDate purshasedDate, double totalCost) {
    	this.idUser = idUser;
    	this.purchasedDate = purchasedDate;
    	this.totalCost = totalCost;
    }

	public Long getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
    
}
