package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PessoaFisica;
import conexao.ConexaoFactory;

public class PessoaFisicaDAO {
	private Connection con;
	
	public PessoaFisicaDAO () throws Exception {
		con = new ConexaoFactory().conectar();
		
	}
	
	public String fechar () throws Exception {
		con.close();
		
		
		return "Conexão fechada com sucesso";
		
	}
	
	public String gravar(PessoaFisica pf) throws Exception {
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("INSERT INTO Pessoa (id, nome, email, telefone, cpf, rg, data_nascimento) VALUES(?,?,?,?,?,?,?)");
		estrutura.setInt (1,pf.getId());
		estrutura.setString (2,pf.getNome());
		estrutura.setString (3,pf.getEmail());
		estrutura.setString(4, pf.getTelefone());
		estrutura.setString(5, pf.getCpf());
		estrutura.setString(6, pf.getRg());
		estrutura.setString(7, pf.getDataNascimento());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";


	}
	
	public PessoaFisica getPessoaFisica(int n) throws Exception{
		PessoaFisica pf = new PessoaFisica();
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("SELECT nome, email, telefone, cpf, rg, data_nascimento FROM Pessoa WHERE id = ?");
		estrutura.setInt (1,n);
		ResultSet resultado = estrutura.executeQuery();							
		if(resultado.next()) {
			pf.setNome(resultado.getString("nome"));
			pf.setEmail(resultado.getString("email"));
			pf.setTelefone(resultado.getString("telefone"));
			pf.setCpf(resultado.getString("cpf"));
			pf.setRg(resultado.getString("rg"));
			pf.setDataNascimento(resultado.getString("data_nascimento"));


		}
		resultado.close();
		estrutura.close();
		return pf;

	}
	
	public int delete (int num) throws Exception {
		PreparedStatement estrutura = con.prepareStatement("DELETE FROM Pessoa WHERE id = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
		
	}
	
	
	public String atualizarEmail (String x, int y) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE Pessoa SET email = ? WHERE id =?");
		estrutura.setString(1,  x);
		estrutura.setInt(2, y);
		int z = estrutura.executeUpdate();
		return "Total de " + z + "Linhas atualizadas";
	}
	
	
	

}



