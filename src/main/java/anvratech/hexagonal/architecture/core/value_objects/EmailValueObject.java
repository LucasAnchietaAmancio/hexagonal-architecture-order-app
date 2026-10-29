package anvratech.hexagonal.architecture.core.value_objects;

import org.apache.commons.validator.routines.EmailValidator;

import anvratech.hexagonal.architecture.core.exceptions.fields.EmailIsInvalidException;

public class EmailValueObject {

    private String email;

    public EmailValueObject(String email) {
        this.email = email;
    }

    public static EmailValueObject create(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new EmailIsInvalidException();
        }
        return new EmailValueObject(email);
    }

    public String getEmail() {
        return email;
    }
}
