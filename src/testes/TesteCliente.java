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
	Cliente cliente = new Cliente();
	cliente.setAll(
			texto("Digite a atualizacao cadastral"),
			texto ("Digite o numero da inscricao:"),
			texto ("Digite o debito pendente: "));
	
	
	
	cliente.setNumeroInstalacao(texto("numero_instalacao"));
	System.out.println(ClienteBO.adicionarCliente(cliente));
}catch(Exception e) {
	e.printStackTrace();
}
	}

}
