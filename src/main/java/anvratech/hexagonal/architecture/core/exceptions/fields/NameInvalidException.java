package anvratech.hexagonal.architecture.core.exceptions.fields;

import anvratech.hexagonal.architecture.core.exceptions.BusinessRuleViolationException;

public class NameInvalidException extends BusinessRuleViolationException {
    public NameInvalidException() {
        super("Name cannot be null or empty please provide a valid name");
    }
}
