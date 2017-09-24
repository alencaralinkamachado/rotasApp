/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Rota;
import br.rotas.approtas.service.RotaService;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alencarmachado
 */
@RestController
@RequestMapping(value = "rota")
public class RotaController {
    
    private static final RotaService service = new RotaService();
    
    @RequestMapping(value = "/rotas/cidade/{id}", method = RequestMethod.GET)
    public ArrayList<Rota> getRuasCidade(@PathVariable String id){
        try {
            
            return service.getRotasCidade(Integer.parseInt(id));
        } catch (Exception ex) {
            //Logger.getLogger(RuaController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
    
    /*
    
     @RequestMapping(value = "atualizalatlng", method = RequestMethod.POST)
    public ResponseEntity<?> autalizaCoordenadas(@RequestBody Cliente cliente) throws Exception{
        if (service.autalizaCoordenadas(cliente)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    
    */
    
    @RequestMapping(value = "/rota/clientes", method = RequestMethod.POST)
    public ResponseEntity<?> incluiClientesRota(@RequestBody Rota rota) throws Exception{
        if(service.incluirClientesRota(rota)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    } 
    
}
