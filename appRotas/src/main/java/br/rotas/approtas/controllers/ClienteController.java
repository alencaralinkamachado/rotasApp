/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.service.ClienteService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author alencarmachado
 */
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    private static final ClienteService service = new ClienteService();
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> inserir(@RequestBody Cliente cliente) throws Exception{
        
        System.out.println("nome "+cliente.getNome());
        System.out.println("onde "+cliente.getOndeDeixar());
        System.out.println("nome "+cliente.getRua().getId());
        System.out.println("nome "+cliente.getNumero());
        System.out.println("nome "+cliente.getRua().getId());
        System.out.println("nome "+cliente.getCidade().getId());
                
        service.inserir(cliente);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(String.valueOf(cliente.getId())).buildAndExpand(cliente.getId()).toUri();
	System.out.println("location : "+location.getPath());
		
		 return ResponseEntity.created(location).build();
    }
    
}