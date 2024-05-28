package com.redalyc.principal;

import com.redalyc.modelo.RecuperadorHTML;
import com.redalyc.modelo.Revista;
import com.redalyc.modelo.RevistaC;
import com.redalyc.modelo.Volumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/buscar")
public class Controlador {

    @Autowired
    private RestTemplate restTemplate;

    RecuperadorHTML recuperador = new RecuperadorHTML();
    HashSet<String> volumenesHS = new HashSet<String>();
    HashSet<String> articulosHS = new HashSet<String>();
    ArrayList<RevistaC> revistasc = new ArrayList<RevistaC>();

    /*
    * @brief Función para manejar la petición con las revistas
    * @param Cuerpo JSON con la clave y url de la revista
    * @return JSON con el URL de los artículos de la revista
    */
    @PostMapping()
    public String/*ArrayList<RevistaC>*/ obtenerArt(@RequestBody List<Revista> revistas){
        //Variables aux
        Pattern plantilla = Pattern.compile("(http|https)://\\S*/issue/archive");
        Pattern plantilla2 = Pattern.compile("(http|https)://\\S*/issue/view/[0-9]+");
        Pattern plantilla3 = Pattern.compile("(http|https)://\\S*/article/view/[0-9]+");
        Pattern plantilla4 = Pattern.compile("Vol\\. ([0-9]+) \\S*\\. ([0-9]+) \\(([0-9]+)\\)");
/*
        int articulosT = 0;

        //Analizar revista por revista
        for (Revista revista : revistas){
            //Variables aux
            ArrayList<Volumen> volumnesAL = new ArrayList<Volumen>();
            RevistaC revistaCompleta = new RevistaC();

            //Setear datos ya obtenidos
            revistaCompleta.setClave(revista.getClave());

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
                        //Variables aux
                        String volNum="-1";
                        String noPul="-1";
                        String year="-1";
                        Volumen volumenCompleto = new Volumen();
                        ArrayList<String> articulosAL = new ArrayList<String>();
                        //articulosAL.clear();

                        System.out.print("\t\t"+i+". "+vol);
                        String volumenHTML = recuperador.obtenerHTML(vol);

                        Matcher matcher4 = plantilla4.matcher(volumenHTML);
                        while (matcher4.find()){
                            volNum = matcher4.group(1);
                            noPul = matcher4.group(2);
                            year = matcher4.group(3);

                        }

                        Matcher matcher3 = plantilla3.matcher(volumenHTML);


                        while(matcher3.find()){
                            articulosHS.add(matcher3.group());
                        }
                        i++;

                        int j =1;
                        for (String art : articulosHS){
                            System.out.println("\t\t\t"+j+". "+art);
                            articulosAL.add(art);
                            j++;
                            articulosT++;
                        }
                        //Setear el arreglo de articulos al volumen
                        volumenCompleto.setArticulos(articulosAL);
                        volumenCompleto.setNumero(Integer.parseInt(volNum));
                        volumenCompleto.setNoPublicacion(Integer.parseInt(noPul));
                        volumenCompleto.setYear(Integer.parseInt(year));

                        //Agregar el volumen al arreglo
                        volumnesAL.add(volumenCompleto);

                        articulosHS.clear();

                    }//FIN POR CADA VOLUMEN
                    volumenesHS.clear();

                } else {
                    System.out.println("No se encontraron volúmenes.");
                }


            }//FIN SI ES OJS
            revistaCompleta.setVolumnes(volumnesAL);

            //restTemplate.postForLocation("urcorrespondiente:6001/getArticulosData",revistaCompleta);+
            revistasc.add(revistaCompleta);
        }//FIN POR CADA REVISTA
        System.out.println("Total de articulos encontrados: "+articulosT);

        return revistasc;//"Busqueda realizada\n";*/
        return "";
    }
}
