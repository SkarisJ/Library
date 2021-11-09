package com.uxeron.psp.Validators;

public class ValidationError {
    String error;

    public ValidationError(String errorString) {
        error = errorString;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
 
        if (!(o instanceof ValidationError))
            return false;

        ValidationError v = (ValidationError) o;
        return error.equals(v.error);
    }
}
