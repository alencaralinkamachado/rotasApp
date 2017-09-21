/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rotas.approtas.util;

import br.rotas.approtas.dao.ConectaBDPostgres;
import br.rotas.approtas.model.Cidade;
import br.rotas.approtas.model.Rua;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alencarmachado
 */
public class CargaRuasBD_Producao {

    public static void main(String args[]) throws Exception{
     cargaRuasBaseTesteParaProducao();
    }

    public static Connection getConexao() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://200.132.36.170:5432/db_rotas2_producao";
            String user = "postgres";
            String password = "amj!#7";

            c = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void cargaRuasBaseTesteParaProducao() throws Exception {

          CargaRuasBD_Producao crp = new CargaRuasBD_Producao();
        
        for(Rua r : crp.getRuas()){
            crp.inserir(r);
        }
        
    }

    private Connection connProd;
    private PreparedStatement stmtProd;
    private ResultSet resProd;

    private void fecharConexoesProd() throws Exception {
        if (resProd != null) {
            resProd.close();
            stmtProd.close();
            connProd.close();
        } else {
            stmtProd.close();
            connProd.close();
        }
    }
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet res;

    private void fecharConexoes() throws Exception {
        if (res != null) {
            res.close();
            stmt.close();
            conn.close();
        } else {
            stmt.close();
            conn.close();
        }
    }

    public  boolean inserir(Rua rua) throws Exception {
        connProd = getConexao();
        boolean retorno = false;

        String sql = "insert into rua(nome_rua, id_cidade) "
                + "values (?,?)";
        stmtProd = connProd.prepareStatement(sql);
        stmtProd.setString(1, rua.getNome());
        stmtProd.setInt(2, rua.getCidade().getId());

        stmtProd.executeUpdate();

        fecharConexoesProd();
        return retorno;
    }

    public ArrayList<Rua> getRuas() throws Exception{
        ArrayList<Rua> ruas = new ArrayList<>();
        
        	
		conn = ConectaBDPostgres.getConexao();
		stmt = conn.prepareStatement("select * from rua r, cidade c where r.id_cidade = c.id_cidade");
		res = stmt.executeQuery();		
                
                
		//id_unidade, id_material, id_origem, ent_validade, ent_qtd, ent_data
		while(res.next()){
			Rua rua = new Rua();
                        rua.setId(res.getInt("idrua"));
                        rua.setNome(res.getString("nome_rua"));                        
                        rua.setCidade(new Cidade(res.getInt("id_cidade"),
                                res.getString("nome_cidade"), 
                                res.getString("latitude_cidade"),
                                res.getString("longitude_cidade")));
                        ruas.add(rua);                        
		}
        
        return ruas;
    }

}
