/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.controllers;

import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.RetornoHttp;
import br.rotas.approtas.model.Rota;
import br.rotas.approtas.service.ClienteService;
import java.net.URI;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @RequestMapping(value = "clienteRotaMobile", method = RequestMethod.POST)
    public RetornoHttp clienteRotaMobile(@RequestBody ArrayList<Cliente> clientes) throws Exception{
        System.out.println("qtd de clientes: "+clientes.size());
        try{
           for(Cliente c : clientes){
               System.out.println("Nome: "+c.getNome());
               System.out.println("foto: "+c.getFoto());
                service.updateMobile(c);
        } 
        }catch(Exception e){
            return new RetornoHttp(e.getMessage(), "erro");
        }
   
           return new RetornoHttp("tudo certo", "ok");     
    }
    
    @RequestMapping(value = "atualizalatlngrota", method = RequestMethod.POST)
    public ResponseEntity<?> autalizaCoordenadasRota(@RequestBody Cliente cliente) throws Exception{
        System.out.println("Rota autalizada ... "+cliente.getRota().getId());
        if (service.autalizaCoordenadasRota(cliente)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody Cliente cliente) throws Exception{
        if(service.update(cliente)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> inserir(@RequestBody Cliente cliente) throws Exception{
        
        System.out.println("nome "+cliente.getNome());
        System.out.println("onde "+cliente.getOndeDeixar());
        System.out.println("nome "+cliente.getRua().getId());
        System.out.println("nome "+cliente.getNumero());
        System.out.println("nome "+cliente.getRua().getId());
        System.out.println("nome "+cliente.getCidade().getId());
        System.out.println("Complemento "+cliente.getComplemento());
                
        service.inserir(cliente);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(String.valueOf(cliente.getId())).buildAndExpand(cliente.getId()).toUri();
	System.out.println("location : "+location.getPath());
		
		 return ResponseEntity.created(location).build();
    }
    
    
    
    @RequestMapping(value = "clientesMobile", method = RequestMethod.GET)
    public ArrayList<Cliente> getClientesMobile() throws Exception{
        System.out.println("Vai retornar os clientes");
        return service.getClientesMobile();
    }
    
    @RequestMapping(value = "clientes", method = RequestMethod.GET)
    public ArrayList<Cliente> getClientes() throws Exception{
        System.out.println("Vai retornar os clientes");
        return service.getClientes();
    }
    
    @RequestMapping(value = "/clientes/rota/{id}", method = RequestMethod.GET)
    public ArrayList<Cliente> getClientesPorRota(@PathVariable int id) throws Exception{
        return service.getClientesPorRota(id);
    }
    
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public Cliente getCliente(@PathVariable int id) throws Exception{
        return service.getCliente(id);
    }
}
