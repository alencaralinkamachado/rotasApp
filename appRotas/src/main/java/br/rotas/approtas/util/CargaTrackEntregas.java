/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.util;

import br.rotas.approtas.model.Polyline;
import br.rotas.approtas.model.Track;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author alencarmachado
 */
public class CargaTrackEntregas {

    public static void main(String args[]) {
       
    }

    public Polyline polyEverton() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR-Everton_Alencar+Machado_Machado_2017-10-06_04-34-14.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));
                traks.add(track);
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Polyline(2, "Everton", traks);
    }
    
    public Polyline polyDirceu() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR-Rota-Dirceu_paulo-Alencar+Machado_Machado_2017-10-06_15-30-15.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));
                traks.add(track);
                /*  for(int j = 0; j < way.getElementsByTagName("tag").getLength(); j++){
                Element tag = (Element) way.getElementsByTagName("tag").item(j);
            try{
                
                
                for(int k = 0; k < tag.getAttributes().getLength(); k++){
                     //System.out.println("..nodeValue: "+tag.getAttributes().item(k).getNodeValue());
                     //System.out.println("..: "+tag.getAttributes().item(k).getTextContent());
                       // System.out.println(".ee: "+tag.getAttributes().item(k).getLocalName());
                      
                                              
                       String street = tag.getAttribute("k");
                       
                       if(street.equals("name")){
                           if(tag.getAttribute("v").startsWith("Rua ")){
                               System.out.println(" (v) : name "+tag.getAttribute("v"));
                           }
                       }
                       
                       if(street.equals("addr:street")){
                           System.out.println("(v) : addr:street "+tag.getAttribute("v"));
                       }
                       // System.out.println("k-> "+tag.getAttribute("k")); changeset="51555907" uid="1871742" 
                }
                
              
            }  catch(NullPointerException ex){
                //System.out.println("null");
            }
            
            }*/

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Polyline(1, "Dirceu_Paulo", traks);
    }
    
    
    public ArrayList<Track> polyDirceuTrack() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR-Rota-Dirceu_paulo-Alencar+Machado_Machado_2017-10-06_15-30-15.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
               if(i % 2 == 0){
                    Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));                
                    traks.add(track);
                }               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return traks;
    }
    
    public ArrayList<Track> polyDirceuInicioTrack() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR_Dirceu_Inicio_Alencar+Machado_Machado_2017-10-04_16-16-04.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                if(i % 2 == 0){
                    Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));                
                    traks.add(track);
                }
                
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return traks;
    }
    
     public ArrayList<Track> polyHilarioTrack() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR_Hilario_Alencar+Machado_Machado_2017-10-04_04-35-53.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                if(i % 2 == 0){
                    Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));                
                    traks.add(track);
                }
                
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return traks;
    }
    
    public ArrayList<Track> polyEliTrack() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR_ELI_Alencar+Machado_Machado_2017-10-05_04-34-20.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                if(i % 2 == 0){
                    Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));                
                    traks.add(track);
                }
                
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return traks;
    }
    
     public ArrayList<Track> polyEvertonTrack() {

        ArrayList<Track> traks = new ArrayList<Track>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/POLAR-Everton_Alencar+Machado_Machado_2017-10-06_04-34-14.gpx");

            Element nodes = document.getDocumentElement();

            NodeList trkpts = document.getElementsByTagName("trkpt");
            System.out.println("tbm trkpts: " + trkpts.getLength());
            for (int i = 0; i < trkpts.getLength(); i++) {
                
                Element trkpt = (Element) trkpts.item(i);

                System.out.println("... " + Double.parseDouble(trkpt.getAttribute("lat")));

                System.out.println("trkpt lat: " + trkpt.getAttribute("lat") + " lng: " + trkpt.getAttribute("lon"));
                if(i % 2 == 0){
                    Track track = new Track(i, Double.parseDouble(trkpt.getAttribute("lat")), Double.parseDouble(trkpt.getAttribute("lon")));                
                    traks.add(track);
                }
                
                 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return traks;
    }
    
}
