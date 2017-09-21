package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String adicionarCliente(Cliente cli)throws Exception {
		if (cli.getNumeroInstalacao().length()>30){
			return "Excedeu o limite de caracteres.";
		}
		
		
		cli.getNumeroInstalacao();
		
		//new Integer - dando parse de String para Integer usando o construtor do Integer.
		//Integer numInstalacao = new Integer(cli.getNumeroInstalacao());
		
		//Devolvendo um int com o método intValue().
		//numInstalacao.intValue();
		
		ClienteDAO dao = new ClienteDAO();
		Cliente clienteResult = dao.selecionarCliente(cli.getNumeroInstalacao());
		Integer numInstalacaoCliente = new Integer(clienteResult.getNumeroInstalacao());
		
		
		if(numInstalacaoCliente.intValue() > 0){
		
			dao.fechar();
			return "Este cliente ja existe!";
		}
		String x= dao.inserirCliente(cli);
		dao.fechar();
		return x; 
	}
	public static Cliente consultarCodigo(String numero) throws Exception{
		if(Integer.parseInt(numero)<1){
			return new Cliente();
		}
		ClienteDAO dao = new ClienteDAO();
		Cliente objeto = dao.selecionarCliente(numero);
		dao.fechar();
		return objeto;
	}
	
	public static int excluirClienteNumero (int numero)throws Exception{
		if(numero<1){
			return 0;
		}
		ClienteDAO dao = new ClienteDAO();
		int x = dao.deletarCliente(numero);
		dao.fechar();
		return x;
	}
	
}
