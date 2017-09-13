/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Rua;
import br.rotas.approtas.service.RuaService;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alencarmachado
 */
@RestController
@RequestMapping("/rua")
public class RuaController {
 
    private static final RuaService service = new RuaService();
    
    @RequestMapping(value = "ruas", method = RequestMethod.GET)
    public ArrayList<Rua> getRuas(){
        try{
            
            return service.getRuas();
            
        }catch(Exception e){
            e.printStackTrace();
             
        }
        return null;
    }
    
    @RequestMapping(value = "/ruas/cidade/{id}", method = RequestMethod.GET)
    public ArrayList<Rua> getRuasCidade(@PathVariable String id){
        try {
            System.out.println("vai trazer as ruas do id "+id);
            return service.getRuasCidade(Integer.parseInt(id));
        } catch (Exception ex) {
            //Logger.getLogger(RuaController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
    
}
