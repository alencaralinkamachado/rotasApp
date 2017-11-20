/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.service;

import br.rotas.approtas.dao.ClienteDAO;
import br.rotas.approtas.model.Cliente;
import br.rotas.approtas.model.Rota;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 */
public class ClienteService {
    private static final ClienteDAO dao = new ClienteDAO();
    
    public boolean autalizaCoordenadasRota(Cliente cli) throws Exception{
        return dao.autalizaCoordenadasRota(cli);
    }
    
    public boolean inserir(Cliente cliente) throws Exception{
        return dao.inserir(cliente);
    }
    
    public ArrayList<Cliente> getClientes() throws Exception{
        return dao.getClientes();
    }
    
     public ArrayList<Cliente> getClientesMobile() throws Exception{
        return dao.getClientesMobile();
    }
    
    public Cliente getCliente( int id) throws Exception{
        return dao.getCliente(id);
    }
    
    public ArrayList<Cliente> getClientesPorRota(int rota) throws Exception{
        return dao.getClientesPorRota(rota);
    }
    
   public boolean update(Cliente cliente) throws Exception{
       return dao.update(cliente);
   }
   
   public boolean updateMobile(Cliente cliente) throws Exception{
       return dao.updateMobile(cliente);
   }
    
}
