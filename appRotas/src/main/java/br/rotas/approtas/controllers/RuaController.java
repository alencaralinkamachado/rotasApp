/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Rua;
import br.rotas.approtas.service.RuaService;
import java.util.ArrayList;
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
    
}
