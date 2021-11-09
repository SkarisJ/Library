package com.uxeron.psp.Validators;
import java.util.*;

public class PhoneValidator implements Validator {

    private static final Map<String, String> prefixMap = new HashMap<>();
    static {
        prefixMap.put("8", "+370");
    }

    // Length includes the prefix
    private static final Map<String, Integer> lengthMap = new HashMap<>();
    static {
        lengthMap.put("+370", 12);
    }

    // Possible ValidationError errors:
    //  HasNonNumeric - the given phone number has symbols other than numbers
    //  InvalidLength - the given phone number has the wrong length
    public static Collection<ValidationError> validate(String data) {

        ArrayList<ValidationError> list = new ArrayList<>();

        if(!PhoneMadeOfDigits(data))
            list.add(new ValidationError("HasNonNumeric"));
        else if(!ValidPhoneLength(data))
            list.add(new ValidationError("InvalidLength"));

        return list;
    }

    // Finds and adds the appropriate prefix from prefixMap
    public static String replacePrefix(String number) {

        String key = number.substring(0, 1);

        if (prefixMap.containsKey(key))
        {
            number = prefixMap.get(key).concat(number.substring(1));
        }

        return number;
    }
    
    public static boolean PhoneMadeOfDigits (String phone) {
        try {
            Double.parseDouble(phone);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean ValidPhoneLength (String phone) {
        String key = phone.substring(0, 1);
        int numberLen = lengthMap.get(prefixMap.get(key));

        if(lengthMap.get(prefixMap.get(key)) == -1)
            return false;

        if (replacePrefix(phone).length() != numberLen)
            return false;
        return true;
    }
}
