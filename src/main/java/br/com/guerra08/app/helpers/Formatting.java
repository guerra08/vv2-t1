package br.com.guerra08.app.helpers;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatting {

    public static String valueToCurrencyString(Double value){
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(value);
    }

}
