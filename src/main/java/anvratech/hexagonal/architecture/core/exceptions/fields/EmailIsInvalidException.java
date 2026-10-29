package anvratech.hexagonal.architecture.core.exceptions.fields;

import anvratech.hexagonal.architecture.core.exceptions.BusinessRuleViolationException;

public class EmailIsInvalidException extends BusinessRuleViolationException{
    public EmailIsInvalidException() {
        super("This email is invalid please provide a valid email address");
    }
}
