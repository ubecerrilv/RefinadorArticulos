package com.redalyc.pruebas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PruebasRegex {
    public static void main(String[] args) {
        // Aquí se muestra un ejemplo con más texto y múltiples coincidencias
        String texto = "https://scielo.isciii.es/scielo.php?script=sci_arttext&pid=S1578-908X2013000100001&lng=es&nrm=iso&tlng=es";
        String regex = "(http|https)://scielo\\.\\S*/scielo\\.php\\?script=sci_arttext&pid=\\S*&lng=\\S*lng=\\S\\S";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
