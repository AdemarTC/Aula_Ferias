package br.com.aulaferias.usuario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aulaferias.database.Conexao;
import br.com.aulaferias.usuario.dao.IUsuarioDAO;
import br.com.aulaferias.usuario.model.UsuarioVO;

public class UsuarioDAO implements IUsuarioDAO {

	Connection con = Conexao.getConnection();
	
	public void cadastrar(UsuarioVO usuarioVO) {
		
		String sql = "INSERT INTO usuario (nom_usuario, nom_sobrenome, nom_email, nom_senha)"
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement prepatrador = con.prepareStatement(sql);
			prepatrador.setString(1, usuarioVO.getNome());
			prepatrador.setString(2, usuarioVO.getSobrenome());
			prepatrador.setString(3, usuarioVO.getEmail());
			prepatrador.setString(4, usuarioVO.getSenha());
			
			prepatrador.execute();
			prepatrador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(UsuarioVO usuarioVO) {
		
		String sql = "DELETE FROM usuario WHERE seq_usuario = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, usuarioVO.getSequencial());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluido com Sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void excluirPorSequencial(Integer sequencial) {
		
		String sql = "DELETE FROM usuario WHERE seq_usuario = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, sequencial);
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluido com Sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void atualizar(UsuarioVO usuarioVO) {
		
		
		String sql = "UPDATE usuario SET nom_usuario = ?, nom_sobrenome = ?, nom_email = ?, nom_senha = ? WHERE seq_usuario = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, usuarioVO.getNome());
			preparador.setString(2, usuarioVO.getSobrenome());
			preparador.setString(3, usuarioVO.getEmail());
			preparador.setString(4, usuarioVO.getSenha());
			preparador.setInt(5, usuarioVO.getSequencial());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Atualizado com Sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public UsuarioVO buscarPorId(UsuarioVO usuarioVO) {
		
		String sql = "SELECT * FROM usuario WHERE seq_usuario = ?";

		UsuarioVO usuario = null;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, usuarioVO.getSequencial());

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()) { //se foi para o próximo

				usuario = new UsuarioVO();
				usuario.setSequencial(resultado.getInt("seq_usuario"));
				usuario.setNome(resultado.getString("nom_usuario"));
				usuario.setEmail(resultado.getString("nom_sobrenome"));
				usuario.setEmail(resultado.getString("nom_email"));
				usuario.setSenha(resultado.getString("nom_senha"));


			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro" + e.getMessage());
		}

		return usuario;
	}
	
	public UsuarioVO buscarPorParametro(Integer sequencial) {
		
		String sql = "SELECT * FROM usuario WHERE seq_usuario = ?";

		UsuarioVO usuario = null;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, sequencial);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next()) { //se foi para o próximo

				usuario = new UsuarioVO();
				usuario.setSequencial(resultado.getInt("seq_usuario"));
				usuario.setNome(resultado.getString("nom_usuario"));
				usuario.setSobrenome(resultado.getString("nom_sobrenome"));
				usuario.setEmail(resultado.getString("nom_email"));
				usuario.setSenha(resultado.getString("nom_senha"));


			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro" + e.getMessage());
		}

		return usuario;
	}

	public List<UsuarioVO> buscarTodos() {
		try {

			String sql = "SELECT * FROM usuario;";

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			List<UsuarioVO> listaUsuario = new ArrayList<UsuarioVO>();

			while(resultado.next()) {

				UsuarioVO usuario = new UsuarioVO();

				usuario.setSequencial(resultado.getInt("seq_usuario"));
				usuario.setNome(resultado.getString("nom_usuario"));
				usuario.setSobrenome(resultado.getString("nom_sobrenome"));
				usuario.setEmail(resultado.getString("nom_email"));
				usuario.setSenha(resultado.getString("nom_senha"));
			

				listaUsuario.add(usuario);
			}
			
			resultado.close();
			preparador.close();
			
			return listaUsuario;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
