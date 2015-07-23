import java.util.List;

import br.com.aulaferias.usuario.dao.impl.UsuarioDAO;
import br.com.aulaferias.usuario.model.UsuarioVO;


public class UsusarioTeste {

	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<UsuarioVO> listaUusarioretornadoDoBanco = usuarioDAO.buscarTodos();
		
		for (UsuarioVO usuarioRetornadodoBanco : listaUusarioretornadoDoBanco) {
			
			System.out.println("Id: " + usuarioRetornadodoBanco.getSequencial() + "\n" + "Nome: " + usuarioRetornadodoBanco.getNome()
					+ "\n" + "Email: " + usuarioRetornadodoBanco.getEmail() + "\n" + "Senha: " + usuarioRetornadodoBanco.getSenha());
			
		}
		
		
//		pesquisarPorParametro();		
//		pesquisarPorIdObjeto();		
//		excluirPorSequencial();
//		cadastrar();
//		atualizar();
//		excluirPorIdObjeto();

	}

	public static void pesquisarPorParametro() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuarioVO = new UsuarioVO();
		
		Integer sequencial = 1;
				
		UsuarioVO usuarioRetornadodoBanco = usuarioDAO.buscarPorParametro(sequencial);
		
		System.out.println("Id: " + usuarioRetornadodoBanco.getSequencial() + "\n" + "Nome: " + usuarioRetornadodoBanco.getNome()
				+ "\n" + "Email: " + usuarioRetornadodoBanco.getEmail() + "\n" + "Senha: " + usuarioRetornadodoBanco.getSenha());
	}

	public static void pesquisarPorIdObjeto() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuarioVO = new UsuarioVO();
		
		
		usuarioVO.setSequencial(1);
		
		
		UsuarioVO usuarioRetornadodoBanco = usuarioDAO.buscarPorId(usuarioVO);
		
		System.out.println("Id: " + usuarioRetornadodoBanco.getSequencial() + "\n" + "Nome: " + usuarioRetornadodoBanco.getNome()
				+ "\n" + "Email: " + usuarioRetornadodoBanco.getEmail() + "\n" + "Senha: " + usuarioRetornadodoBanco.getSenha());
	}

	public static void excluirPorSequencial() {
		Integer sequencial = 11;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluirPorSequencial(8);
	}

	public static void cadastrar(){

		UsuarioVO usuarioVO = new UsuarioVO();

		UsuarioDAO usuDAO = new UsuarioDAO();

		usuarioVO.setNome("Delly");
		usuarioVO.setSobrenome("Godoy");
		usuarioVO.setEmail("dellybela@gamil.com");
		usuarioVO.setSenha("123");

		usuDAO.cadastrar(usuarioVO);

	}
	
	public static void atualizar(){

		UsuarioVO usuVO = new UsuarioVO();
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuVO.setNome("Isabelly");
		usuVO.setSobrenome("Raboso");
		usuVO.setEmail("isaraposo#gmail.com");
		usuVO.setSenha("768");
		usuVO.setSequencial(8);
		
		usuDAO.atualizar(usuVO);

	}
	
	public static void excluir(){
		
		excluirPorIdObjeto();
		
	}

	public static void excluirPorIdObjeto() {
		
		UsuarioVO usuarioVO = new UsuarioVO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioVO.setSequencial(9);
		
		usuarioDAO.excluir(usuarioVO);
	}
	
	

}
