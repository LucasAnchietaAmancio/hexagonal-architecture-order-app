package anvratech.hexagonal.architecture.entities;

import anvratech.hexagonal.architecture.core.entities.Clients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientEntityTest {
    
    @Test
    public void testClientCreation() {

        String name = "TestName";
        String email = "test@email.com";

        Clients client = Clients.create(name, email);
        Assertions.assertEquals(name, client.getName());
        Assertions.assertEquals(email, client.getEmail());
    }
}
