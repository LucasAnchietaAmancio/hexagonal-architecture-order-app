package anvratech.hexagonal.architecture.core.entities.aggregates;

import anvratech.hexagonal.architecture.core.entities.Clients;
import anvratech.hexagonal.architecture.core.exceptions.BusinessRuleViolationException;
import anvratech.hexagonal.architecture.core.entities.OrderItems;
import anvratech.hexagonal.architecture.core.entities.Items;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@Table(name="Orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="orderId", updatable=false, nullable=false)
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name="clientId", nullable=false)
    private Clients client;

    @Column(name="totalValue", nullable=false, precision=19, scale =2)
    private BigDecimal totalValue;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrderItems> orderItems = new ArrayList<>();

    @Column(name="status", nullable=false)
    private char status;

    @Column(name="createdAt", nullable=false)
    private LocalDateTime createdAt;

    protected Orders() {
    }

    private Orders(Clients client, BigDecimal totalValue, char status, LocalDateTime createdAt) {
        this.client = client;
        this.totalValue = totalValue;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static Orders create(Clients client, char status) {
        return new Orders(client, BigDecimal.ZERO, status, LocalDateTime.now());
    }

    public BigDecimal calculateTotalValue() {
        for(Integer i = 0; i < orderItems.size(); i++) {
            OrderItems itemSelected = orderItems.get(i);
            
            this.totalValue = this.totalValue.add(itemSelected.getUnitPriceAtPurchase().multiply(BigDecimal.valueOf(itemSelected.getQuantity())));
        }

        return totalValue;
    }

    public void addItem(Items item, Integer quantity) {
        if(quantity == null || quantity <= 0) {
            throw new BusinessRuleViolationException("Quantity must be greater than zero.");
        }

        OrderItems orderItem = OrderItems.create(this, item, quantity, item.getUnitPrice());

        this.orderItems.add(orderItem);
        this.calculateTotalValue();
    }

}
