/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.service;

import br.rotas.approtas.dao.RotaDAO;
import br.rotas.approtas.model.Rota;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 */
public class RotaService {
 
    private static final RotaDAO dao = new RotaDAO();
    
    public ArrayList<Rota> getRotasCidade(int idCidade) throws Exception{
        return dao.getRotasCidade(idCidade);
    }
    
    public boolean incluirClientesRota(Rota rota)throws Exception{
        return dao.incluirClientesRota(rota);
    }
    
    public boolean alteraClientesRota(Rota rota) throws Exception{
        return dao.alterarClientesRota(rota);
    }
    
}
