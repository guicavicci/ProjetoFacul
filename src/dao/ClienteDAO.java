package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PessoaFisica;
import beans.Cliente;
import conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;
	
	public ClienteDAO () throws Exception {
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar () throws Exception {
		con.close();
		return "Conexao fechada com sucesso";
		
	}
	
	public String inserirCliente(Cliente cliente) throws Exception {
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("INSERT INTO Cliente (numero_instalacao, debito_pendente, atualizacao_cadastral) VALUES(?,?,?)");
		estrutura.setString(1, cliente.getNumeroInstalacao());
		estrutura.setString(2, cliente.getAtualizacaoCadastral());
		estrutura.setString(3, cliente.getDebitoPendente());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";


	}
	
	public Cliente selecionarCliente(String ni) throws Exception{
		Cliente cliente = new Cliente();
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("SELECT numero_instalacao, atualizacao_cadastral, debito_pendente FROM Cliente WHERE numero_instalacao = ?");
		estrutura.setString (1,ni);
		ResultSet resultado = estrutura.executeQuery();							
		if(resultado.next()) {
			cliente.setNumeroInstalacao(resultado.getString("numero_instalacao"));
			cliente.setAtualizacaoCadastral(resultado.getString("atualizacao_cadastral"));
			cliente.setDebitoPendente(resultado.getString("debito_pendente"));
			
		}
		resultado.close();
		estrutura.close();
		return cliente;

	}
	
	public int deletarCliente(int num) throws Exception {
		PreparedStatement estrutura = con.prepareStatement("DELETE FROM Pessoa WHERE id = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
		
	}
	
	
	public int atualizarCliente (Cliente cliente) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE Pessoa SET email = ? WHERE NR_CLIENTE =?");
		estrutura.setString(1, cliente.getDebitoPendente());
		estrutura.setString(2, cliente.getAtualizacaoCadastral());
		int z = estrutura.executeUpdate();
		return z;
	}
	
	
	

}
