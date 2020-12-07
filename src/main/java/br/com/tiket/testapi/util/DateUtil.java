package br.com.tiket.testapi.util;

import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtil {

    public static String getDate(){

        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(1);
        String stringDate = date.format(DateTimeFormatter.ofPattern(ConstantUtils.DATE_FORMAT));
        return stringDate;
    }
}
