package br.rotas.approtas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaBDPostgres {
	
        private static final String DB_TESTE = "db_rotasteste";
        private static final String DB_PRODUCAO = "db_rotas2_producao";
    
	public static void main(String args[]){
		getConexao();
		System.out.println("... conexão ok");
	}
	
	
	
	public static Connection getConexao(){
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
		
			String url ="jdbc:postgresql://200.132.36.170:5432/"+DB_TESTE;
                        String user="postgres";
			String password = "amj!#7";
			
			c = DriverManager.getConnection(url, user, password);
		} catch (Exception e) { 
			e.printStackTrace();
			}
		return c;
	}
}
