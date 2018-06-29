package com.pantryadmin.Service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class LanguageMessageService {

    public static Locale[] supportedLocales = {
            //Locale.ENGLISH,
            new Locale("en", "US"),
            new Locale("hi", "IN")
    };


    public static String getLocalMessage(Locale currentLocale, String key) {
        ResourceBundle labels =
                ResourceBundle.getBundle("message",currentLocale);
        String value  = labels.getString(key);
        System.out.println(
                "Locale = " + currentLocale.toString() + ", " +
                        "key = " + key + ", " +
                        "value = " + value);
        return value;
    }
}
