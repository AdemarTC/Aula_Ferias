package br.com.aulaferias.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {


	private static Connection conexao = null;
	private static Conexao self = null;  

	public static Connection getConnection(){
		if(conexao == null){
			try{

				Class.forName("org.postgresql.Driver"); 
				conexao = DriverManager.getConnection("jdbc:postgresql://localhost/aula_ferias", "postgres", "admin");
//				System.out.println("Conectado com sucesso!");

			}catch(SQLException e){
				System.out.println("Não pode conectar: " + e.getMessage());
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		return conexao;

	}

	public static synchronized Conexao getInstancia(){
		if (self == null)  
			return new Conexao();  
		else  
			return self; 
	}

	@Override  
	protected void finalize() throws Throwable {  
		if (self != null) {  
			desconectar();  
		}  
	}  

	public void desconectar() {  
		try {  
			conexao.close();  
		} catch (SQLException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
	}  


}

