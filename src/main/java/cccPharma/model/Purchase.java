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

    private String barCode;
    private Product product;
    private LocalDate purchasedDate;
    private double totalCost;
    private int quantify;
    
    public Purchase() {
    	
    }
    
    public Purchase(String barcode, Product product, int quantify) {
    	this.purchasedDate = LocalDate.now();
    	this.totalCost = product.getPrice() * quantify;
    	this.barCode = barcode;
    	this.product = product;
    	this.quantify = quantify;
    }
}
