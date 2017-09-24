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
    
    public boolean autalizaCoordenadas(Cliente cli) throws Exception{
        return dao.autalizaCoordenadas(cli);
    }
    
    public boolean inserir(Cliente cliente) throws Exception{
        return dao.inserir(cliente);
    }
    
    public ArrayList<Cliente> getClientes() throws Exception{
        return dao.getClientes();
    }
    
    public ArrayList<Cliente> getClientesPorRota(int rota) throws Exception{
        return dao.getClientesPorRota(rota);
    }
    
}
