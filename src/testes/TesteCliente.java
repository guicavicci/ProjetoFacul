package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import bo.ClienteBO;

public class TesteCliente {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	public static void main(String[] args) {
		try {
			String opcao = "XX";
			while(!opcao.equals("E")){
				opcao = texto("=======Escolha uma opcao======"
					+ "\n A - Para Gravar novo Cadastro"
					+ "\n B - Para Consultar Cadastro"
					+ "\n C - Para Editar um Cadastro"
					+ "\n D - Para Excluir um Cadastro"
					+ "\n E - Sair"
					+ "");
				Cliente cliente = new Cliente();
				switch(opcao.toUpperCase()){
					case "A":
						cliente.setAll(
								texto("Digite a atualizacao cadastral"),
								texto ("Digite o numero da inscricao:"),
								texto ("Digite o debito pendente: "));
						texto(ClienteBO.adicionarCliente(cliente));				
						break;
					case "B":
						String numeroInscricao = texto("Digite o numero da inscricao : ");
						cliente = ClienteBO.consultarCodigo(numeroInscricao);
						JOptionPane.showMessageDialog(null, "Numero da instalação : " + cliente.getNumeroInstalacao()
							+ "\nDébito Pendente : " + cliente.getDebitoPendente()
							+ "\nAtualização Cadastral" + cliente.getAtualizacaoCadastral(), "TA AI", JOptionPane.OK_OPTION);
						break;
					case "C":
						cliente.setAll(
								texto ("Digite o numero da inscricao : "),
								texto ("Digite a atualizacao cadastral : "),
								texto ("Digite o debito pendente : "));
										
						JOptionPane.showMessageDialog(null, "OPA", ClienteBO.editarClientePorCodigo(cliente), JOptionPane.OK_OPTION);
						break;
					case "D":
						JOptionPane.showMessageDialog(null, "OPA", ClienteBO.excluirClienteNumero(texto("Digite o numero da inscricao : ")), JOptionPane.OK_OPTION);
						break;
					case "E":
						JOptionPane.showMessageDialog(null, "FALOUS", "FALOUS", JOptionPane.OK_OPTION);
						break;
					default :
					JOptionPane.showMessageDialog(null, "SELECIONE UMA OPÇÃO VALIDA", "OPA", JOptionPane.OK_OPTION);
				}
			}
	
}catch(Exception e) {
	e.printStackTrace();
}
	}

}
