package Util;

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




}
