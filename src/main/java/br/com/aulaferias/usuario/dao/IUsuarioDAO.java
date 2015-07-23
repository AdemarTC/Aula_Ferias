package br.com.aulaferias.usuario.dao;

import java.util.List;

import br.com.aulaferias.usuario.model.UsuarioVO;

public interface IUsuarioDAO {
	
	public void cadastrar(UsuarioVO usuarioVO);
	
	public void excluir(UsuarioVO usuarioVO);
	
	public void excluirPorSequencial(Integer sequencial);
	
	public void atualizar(UsuarioVO usuarioVO);
	
	public UsuarioVO buscarPorId(UsuarioVO usuarioVO);
	
	public List<UsuarioVO> buscarTodos();
	
	

}
