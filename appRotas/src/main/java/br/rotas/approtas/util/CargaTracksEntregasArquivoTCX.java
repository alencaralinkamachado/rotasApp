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
public class CargaTracksEntregasArquivoTCX {
 
    private String filePc = "/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/rotasSaoGabriel/arquivosTCX/teste1.tcx";
    private String fileServer = "/opt/tracks/teste1.tcx";
    public static void main(String args[]){
        new CargaTracksEntregasArquivoTCX().getTcx();
    }
    
    
    public  Polyline getTcx(){
           Track ponto = new Track();
          ArrayList<Track> listaTracks = new ArrayList<Track>();;
          ArrayList<Track> pontosEntrega = new ArrayList<Track>();;
        int contador = 0;
        try{
        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(this.filePc);

            Element nodes = document.getDocumentElement();

            NodeList laps = document.getElementsByTagName("Lap");
            System.out.println("tbm laps: " + laps.getLength());
            for (int i = 0; i < laps.getLength(); i++) {
                Element lap = (Element) laps.item(i);
                System.out.println("Lap: "+i);
                //System.out.println("... " + Double.parseDouble(lap.getAttribute("StartTime")));
                System.out.println("... " + lap.getAttribute("StartTime"));
                //System.out.println("qtd nos no Lap "+lap.getChildNodes().getLength());
                //NodeList filhos = lap.getChildNodes();
                
                //System.out.println("Filhos: "+filhos.getLength());
                
                NodeList traks = lap.getElementsByTagName("Track");
                System.out.println("qtd traks "+traks.getLength());
                                                                                
                for(int a = 0; a < traks.getLength(); a++){
                   
                    Element track = (Element) traks.item(a);
                    System.out.println(" ");
                    NodeList trackpoints = track.getElementsByTagName("Trackpoint");
                    
                    System.out.println("Lap: "+i);
                    System.out.println("qtd trackPoint: "+trackpoints.getLength());
                    
                    
                    
                    for( int x = 0; x < trackpoints.getLength(); x++){
                    Element trackpoint = (Element) trackpoints.item(x);
                    NodeList positions = trackpoint.getElementsByTagName("Position");
                   // System.out.println("valor de X ="+x);
                   
                    
                   for(int j = 0; j < positions.getLength(); j++){
                       
                       Element position = (Element) positions.item(j);
                       
                        Element latitude = (Element) position.getFirstChild();
                       System.out.println(x+" lati: "+latitude.getTextContent());
                       
                        Element longitude = (Element) position.getLastChild();
                        System.out.println("long: "+longitude.getTextContent());
                        contador++;
                        ponto = new Track(contador, Double.parseDouble(latitude.getTextContent() ) , Double.parseDouble(longitude.getTextContent()));
                         
                         listaTracks.add(ponto);
                         
                       
                        
                        //System.out.println("valor de j ="+j);
                    }
                    
                        
                    //System.out.println("nome: "+trackpoint.item(x).getNodeName());
                }
                    
                    
                }
                                             
           
                 System.out.println(" ");
                 System.out.println(" ");
                 
                 System.out.println("Ultimossss! ");
                  pontosEntrega.add(ponto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TOTAL: **** "+contador);
        return new Polyline(1, "testes", listaTracks, pontosEntrega);
    }
    
}
