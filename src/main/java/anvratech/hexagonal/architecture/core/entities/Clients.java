package anvratech.hexagonal.architecture.core.entities;

import java.util.UUID;

import anvratech.hexagonal.architecture.core.exceptions.fields.NameInvalidException;
import anvratech.hexagonal.architecture.core.entities.aggregates.Orders;
import anvratech.hexagonal.architecture.core.value_objects.EmailValueObject;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Clients")
public class Clients {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="clientId", updatable=false, nullable=false)
    private UUID clientId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="email", nullable=false, unique=true)
    private EmailValueObject email;
    
    @OneToMany(mappedBy="client")
    private List<Orders> orders = new ArrayList<>();

    protected Clients() {
    }

    private Clients(String name, EmailValueObject email) {
        this.name = name;
        this.email = email;
    }

    public static Clients create(String name, String email) {
        if(name == null || name.trim().isEmpty()) {
            throw new NameInvalidException();
        }
        return new Clients(name, EmailValueObject.create(email));
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

}
