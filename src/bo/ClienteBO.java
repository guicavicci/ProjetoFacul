package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String adicionarCliente(Cliente cli)throws Exception {
		if (cli.getNumeroInstalacao().length()>30){
			return "Excedeu o limite de caracteres.";
		}
		
		ClienteDAO dao = new ClienteDAO();
		Cliente clienteResult = consultarCodigo(cli.getNumeroInstalacao());
		
		if(clienteResult.getNumeroInstalacao() != null){
		
			dao.fechar();
			return "Este cliente ja existe!";
		}
		String x= dao.inserirCliente(cli);
		dao.fechar();
		return x; 
	}
	
	public static Cliente consultarCodigo(String numero) throws Exception{
		if(numero != null && Integer.parseInt(numero)<1){
			return null;
		}
		ClienteDAO dao = new ClienteDAO();
		Cliente objeto = dao.selecionarCliente(numero);
		dao.fechar();
		return objeto;
	}
	
	public static String editarClientePorCodigo(Cliente cliente) throws Exception{
		if(cliente.getNumeroInstalacao() == null && cliente.getNumeroInstalacao().isEmpty()){
			return null;
		}
		ClienteDAO dao = new ClienteDAO();
		int sucesso = dao.atualizarCliente(cliente);
		dao.fechar();
		if(sucesso == 1){
			return "Alterado com sucesso";
		}
		return "Falha na altera��o, tente novamente";
		
		
	}
	
	public static String excluirClienteNumero (String numero)throws Exception{
		if(numero != null && Integer.parseInt(numero)<1){
			return "Excluido";
		}
		ClienteDAO dao = new ClienteDAO();
		int sucesso = dao.deletarCliente(numero);
		dao.fechar();
		if(sucesso == 0){
			return "Exclu�do com sucesso !";
		}
		return "ERRO";
	}
	
}
