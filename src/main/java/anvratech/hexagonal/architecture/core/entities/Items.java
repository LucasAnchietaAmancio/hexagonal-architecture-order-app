package anvratech.hexagonal.architecture.core.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Items")
public class Items {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="itemId", updatable=false, nullable=false)
    private UUID itemId;    
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="description", nullable=false, columnDefinition="TEXT")
    private String description;
    
    @Column(name="unitPrice", nullable=false, precision = 19, scale = 2)
    private BigDecimal unitPrice;
    
    @OneToMany(mappedBy="item")
    private List<OrderItems> orderItems = new ArrayList<>();

    protected Items() {
    }

    private Items(String name, String description, BigDecimal unitPrice) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public static Items create(String name,String description, BigDecimal unitPrice) {
        return new Items(name, description, unitPrice);
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}
