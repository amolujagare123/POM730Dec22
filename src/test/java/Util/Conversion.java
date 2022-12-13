package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry)
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry ="India";break;
            case "DE" : convertedCountry ="Germany";break;
            case "CN" : convertedCountry ="China";break;
            case "ID" : convertedCountry ="Indonesia";break;
            case "KE" : convertedCountry ="Kenya";break;
        }

        return convertedCountry;
    }


    public static String getGender(String genderID) // DB - 0 /1 /2
    {
        String gender ="";

        switch (genderID)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }

        return gender;
    }


    public static String convertDate(String dateDBStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateDBStr);
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }


}
