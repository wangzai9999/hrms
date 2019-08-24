package com.util;




import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConver implements Converter<String, Date> {

    DateFormat[] format={new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),new SimpleDateFormat("yyyy-MM-dd HH:mm"),new SimpleDateFormat("yyyy-MM-dd HH"),new SimpleDateFormat("yyyy-MM-dd")};

        // TODO Auto-generated method stub
    @Override
    public Date convert(String time) {
        for (DateFormat dateFormat : format) {
            try {
                return dateFormat.parse(time.toString());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
        }
        return null;
    }


}
