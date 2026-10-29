package anvratech.hexagonal.architecture.value_objects;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import anvratech.hexagonal.architecture.core.exceptions.fields.EmailIsInvalidException;
import anvratech.hexagonal.architecture.core.value_objects.EmailValueObject;

public class EmailValueObjectTest {
    
    @ParameterizedTest
    @ValueSource(strings={"test@email.com.br"})
    @DisplayName("It must successfully create a valid email")
    public void ItMustEmailCreate(String emailValid) {
        Assertions.assertEquals(emailValid, EmailValueObject.create(emailValid).getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings={
        "test@",
        "test.email",
        "test@email.",
        "testemail.com.br",
        "test @email"
        
    })
    @DisplayName("It must throws returned for invalid email")
    public void ItMustReturnedError(String invalidEmails) {
        EmailIsInvalidException exception = assertThrows(EmailIsInvalidException.class, () -> {
            EmailValueObject.create(invalidEmails);
        });

        Assertions.assertEquals("This email is invalid please provide a valid email address", exception.getMessage());
    }
}
