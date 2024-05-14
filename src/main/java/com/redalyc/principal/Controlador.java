package com.redalyc.principal;

import com.redalyc.modelo.RecuperadorHTML;
import com.redalyc.modelo.Revista;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/buscar")
public class Controlador {

    RecuperadorHTML recuperador = new RecuperadorHTML();
    HashSet<String> volumenesHS = new HashSet<String>();
    HashSet<String> articulosHS = new HashSet<String>();

    /*
    * @brief Función para manejar la petición con las revistas
    * @param Cuerpo JSON con la clave y url de la revista
    * @return JSON con el URL de los artículos de la revista
    */
    @PostMapping()
    public String obtenerArt(@RequestBody List<Revista> revistas){
        //Variables aux
        Pattern plantilla = Pattern.compile("(http|https)://\\S*/issue/archive");
        Pattern plantilla2 = Pattern.compile("(http|https)://\\S*/issue/view/[0-9]+");
        Pattern plantilla3 = Pattern.compile("(http|https)://\\S*/article/view/[0-9]+");

        int articulosT = 0;

        //Analizar revista por revista
        for (Revista revista : revistas){
            String html = recuperador.obtenerHTML(revista.getUrl());

            if(html.contains("<meta name=\"generator\" content=\"Open Journal Systems")) {
                System.out.println("Clave: "+revista.getClave()+" URL: "+ revista.getUrl());

                //Obtener los Links de los volúmenes
                Matcher matcher = plantilla.matcher(html);
                if (matcher.find()) {
                    // Obtener la subcadena que coincide con la expresión regular
                    String volumenes = matcher.group();
                    System.out.println("\tVolúmenes: " + volumenes);
                    String volumenesHTML = recuperador.obtenerHTML(volumenes);

                    Matcher matcher2 = plantilla2.matcher(volumenesHTML);
                    while(matcher2.find()){
                        volumenesHS.add(matcher2.group());
                    }
                    int i =1;
                    for(String vol : volumenesHS){
                        System.out.println("\t\t"+i+". "+vol);
                        String volumenHTML = recuperador.obtenerHTML(vol);
                        Matcher matcher3 = plantilla3.matcher(volumenHTML);


                        while(matcher3.find()){
                            articulosHS.add(matcher3.group());
                        }
                        i++;

                        int j =1;
                        for (String art : articulosHS){
                            System.out.println("\t\t\t"+j+". "+art);
                            j++;
                            articulosT++;
                        }
                        articulosHS.clear();
                    }
                    volumenesHS.clear();

                } else {
                    System.out.println("No se encontraron volúmenes.");
                }


            }

        }
        System.out.println("Total de articulos encontrados: "+articulosT);

        return "Busqueda realizada\n";
    }
}
