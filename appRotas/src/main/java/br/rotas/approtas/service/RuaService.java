/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.service;

import br.rotas.approtas.dao.RuaDAO;
import br.rotas.approtas.model.Rua;
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
    public class RuaService {
    
        private static final RuaDAO dao = new RuaDAO();
        
        public static void main(String args[])throws Exception{
            inserirRuasOpenStreetMaps();
        }
        
        public static void inserirRuasOpenStreetMaps(){
            try{
                
                  for(Rua rua : dao.getRuasTemp()){
                      dao.inserir(rua);
                  }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
         public ArrayList<Rua> getRuasCidade(int idCidade) throws Exception{
             System.out.println("dentro do service getRuasCidade");
            return dao.getRuasCidade(idCidade);
        }
        
        public ArrayList<Rua> getRuas() throws Exception{
            return dao.getRuas();
        }
        
        public static void inserirRuasTempOpenStreetMaps(){

            try{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/alencarmachado/Dropbox/Public/morga/sistemaRota/mapSG.osm");

            //Element nodes = document.getDocumentElement();

            NodeList ways = document.getElementsByTagName("way");

            for(int i = 0; i < ways.getLength(); i++){
                Element way = (Element) ways.item(i);




                for(int j = 0; j < way.getElementsByTagName("tag").getLength(); j++){
                    Element tag = (Element) way.getElementsByTagName("tag").item(j);
                 


                    for(int k = 0; k < tag.getAttributes().getLength(); k++){
                         //System.out.println("..nodeValue: "+tag.getAttributes().item(k).getNodeValue());
                         //System.out.println("..: "+tag.getAttributes().item(k).getTextContent());
                           // System.out.println(".ee: "+tag.getAttributes().item(k).getLocalName());


                           String street = tag.getAttribute("k");

                           if(street.equals("name")){
                               if(tag.getAttribute("v").startsWith("Rua ")){
                                   
                                   String nomeRua = tag.getAttribute("v");
                                   
                                   System.out.println(" (v) : name "+nomeRua);
                                   dao.inserirTemp(nomeRua);
                               }
                           }

                           if(street.equals("addr:street")){
                                String nomeRua = tag.getAttribute("v");
                               System.out.println("(v) : addr:street "+tag.getAttribute("v"));
                               dao.inserirTemp(nomeRua);
                           }
                           // System.out.println("k-> "+tag.getAttribute("k")); changeset="51555907" uid="1871742" 
                    }


               
                }


            }



        }catch(Exception e){
            e.printStackTrace();
        }
       
    
    }

}