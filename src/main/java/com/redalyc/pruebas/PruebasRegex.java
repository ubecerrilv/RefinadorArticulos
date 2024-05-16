package com.redalyc.pruebas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PruebasRegex {
    public static void main(String[] args) {
        // Aquí se muestra un ejemplo con más texto y múltiples coincidencias
        String texto = "<title>\n" +
                "\t\tVol. 80 No. 4 (2021)\n" +
                "\t\t\t\t\t\t\t| Revista de la Sociedad Entomológica Argentina\n" +
                "\t\t\t</title>";
        String regex = "Vol\\. ([0-9]+) \\S*\\. ([0-9]+) \\(([0-9]+)\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
