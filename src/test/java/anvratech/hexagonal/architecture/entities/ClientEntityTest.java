package anvratech.hexagonal.architecture.entities;

import anvratech.hexagonal.architecture.core.entities.Clients;
import anvratech.hexagonal.architecture.core.exceptions.fields.NameInvalidException;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.DisplayName;


public class ClientEntityTest {
    
    @ParameterizedTest
    @CsvSource(value={"teste, test@email.com.br"})
    @DisplayName("It must successfully create a valid client entiti")
    public void itMustClientCreate(String name, String email) {
        Clients client = Clients.create(name, email);
        Assertions.assertEquals(email, client.getEmail());
        Assertions.assertEquals(name, client.getName());
    }

    @ParameterizedTest
    @CsvSource(value={"'',test@email.com.br",",test@email.com.br"})
    public void ItMustReturnedErrorForEmpityValue(String name, String email) {
        NameInvalidException exception = Assertions.assertThrows(NameInvalidException.class, () -> {
            Clients.create(name, email);
        });

        Assertions.assertEquals("Name cannot be null or empty please provide a valid name", exception.getMessage());
    }
}
