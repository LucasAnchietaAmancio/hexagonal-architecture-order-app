package anvratech.hexagonal.architecture.core.entities;

import java.util.UUID;
import java.math.BigDecimal;

import anvratech.hexagonal.architecture.core.entities.aggregates.Orders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="OrderItems")
public class OrderItems {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="orderItemId", updatable=false, nullable=false)
    private UUID orderItemId;
    
    @ManyToOne
    @JoinColumn(name="orderId", nullable=false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name="itemId", nullable=false)
    private Items item;

    @Column(name="quantity", nullable=false)
    private Integer quantity;

    @Column(name="unitPriceAtPurchase", nullable=false, precision = 19, scale = 2)
    private BigDecimal unitPriceAtPurchase;

    protected OrderItems() {
    }

    private OrderItems(Orders order, Items item, Integer quantity, BigDecimal unitPriceAtPurchase) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.unitPriceAtPurchase = unitPriceAtPurchase;
    }

    public static OrderItems create(Orders order, Items item, Integer quantity, BigDecimal unitPriceAtPurchase) {
        return new OrderItems(order, item, quantity, unitPriceAtPurchase);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPriceAtPurchase() {
        return unitPriceAtPurchase;
    }

}
