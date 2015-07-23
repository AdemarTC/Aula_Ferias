package br.com.aulaferias.usuarioResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.aulaferias.usuario.dao.impl.UsuarioDAO;
import br.com.aulaferias.usuario.model.UsuarioVO;

//api rest - Comunicação entre o Front-end e Back-end (o que ele faz);


//** Anotações

//@Path - caminho para chegar nas classe e nos métodos da classe

//@GET - pegar dados do servidor;
//@POST - postar dados no servidor
//@PUT - Atualizar dados no servidor
//@DELETE - deletar dados do servidor

//@Produces o que vai produzir
//@Consumes o que vai consumir

//@PathParam ele pega o parametro da url

@Path("usuario")
public class UsuarioResource {
	
	@GET
//	@Produces(MediaType.APPLICATION_JSON)  // outra forma de criar um json.
	@Produces("application/json")
	@Path("buscarTodos")
	public List<UsuarioVO> buscarTodos(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<UsuarioVO> listaUsuario = usuarioDAO.buscarTodos();
		
		return listaUsuario;
	}
	
	@GET
	@Produces("application/json")
	@Path("pesquisarPorId/{sequencial}")
	public UsuarioVO pesquisarPorId(@PathParam("sequencial") Integer sequencial){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		UsuarioVO usuarioRetorno = usuarioDAO.buscarPorParametro(sequencial);
		
		return usuarioRetorno;
		
	}
	@POST
	@Consumes("application/json")
	@Path("salvar")
	public void salvar(UsuarioVO usuarioVO){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.cadastrar(usuarioVO);
		
	}
	
	@DELETE
	@Path("excluir/{sequencialUsuario}")
	public void excluir(@PathParam("sequencialUsuario") Integer sequencialUsuario){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		UsuarioVO usuarioVO = new UsuarioVO();
		
		usuarioVO.setSequencial(sequencialUsuario);
		
		usuarioDAO.excluir(usuarioVO);
		
	}
	
	@PUT
	@Consumes("application/json")
	@Path("atualizar")
	public void atualizar(UsuarioVO usuarioVO){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.atualizar(usuarioVO);
		
	}

}
