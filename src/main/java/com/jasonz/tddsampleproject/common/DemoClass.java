package com.jasonz.tddsampleproject.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DemoClass {
    public String convertDateToString(Date arg){
        String strFormat = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern(strFormat);
        DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat(strFormat);
        String strDate = dateFormat.format(arg);
        return strDate;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
