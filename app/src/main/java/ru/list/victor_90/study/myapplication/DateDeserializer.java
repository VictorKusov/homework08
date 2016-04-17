package ru.list.victor_90.study.myapplication;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateDeserializer implements JsonDeserializer<java.util.Date> {

    private final String[] DATE_FORMATS = new String[] {
            Constants.DATE_FORMAT
    };

    @Override
    public java.util.Date deserialize(JsonElement jsonElement, Type typeOF,
                                      JsonDeserializationContext context) throws JsonParseException {
        try {
            long value = jsonElement.getAsLong();
            return new java.util.Date(value);
        } catch (Exception e) {}

        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) {
            }
        }
        throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}
