package com.uxeron.psp.Validators;
import java.util.*;

public class PasswordChecker implements Validator {

    // Possible ValidationError errors:
    //  TooShort - the given password is too short
    //  MissingUppercase - the given password does not have any uppercase characters
    //  MissingSpecial - the given password does not have any special symbols

    private static int minPasswordLength = 8;

    private static Character[] specialChars = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '_', '+', '=', '-'};

    public static Collection<ValidationError> validate(String data) {

        ArrayList<ValidationError> list = new ArrayList<>();

        if (!PasswordValidLength(data))
            list.add(new ValidationError("TooShort"));

        if (!PasswordHasUppercase(data))
            list.add(new ValidationError("MissingUppercase"));

        if(!PasswordHasSpecialChar(data))
            list.add(new ValidationError("MissingSpecial"));

        return list;
    }
    
    public static boolean PasswordValidLength (String password) {
        if (password.length() >= minPasswordLength)
            return true;
        return false;
    }

    public static boolean PasswordHasUppercase (String password) {
        if (password == password.toLowerCase())
            return false;
        return true;
    }

    public static boolean PasswordHasSpecialChar (String password) {
        int count = 0;

        for (int i =0; i < specialChars.length; i++)
            if (password.indexOf(specialChars[i]) != -1)
                count++;

        if (count > 0)
            return true;
        return false;
    }
}
