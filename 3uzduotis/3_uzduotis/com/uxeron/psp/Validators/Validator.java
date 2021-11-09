package com.uxeron.psp.Validators;
import java.util.*;

public interface Validator {
    // Checks if the passed string follows all defined rules, 
    // and returns a ValidationError object for each rule that was not followed.
    public static Collection<ValidationError> validate(String data) {
        return new ArrayList<ValidationError>();
    }
}
