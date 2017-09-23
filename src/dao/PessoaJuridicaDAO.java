package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PessoaFisica;
import beans.PessoaJuridica;
import conexao.ConexaoFactory;

public class PessoaJuridicaDAO {
	
		private Connection con;
		
		public PessoaJuridicaDAO () throws Exception {
			
			con = new ConexaoFactory().conectar();
			
		}
		
		public String fechar () throws Exception {
			con.close();
			return "Conexao fechada com sucesso!";
			
		}
		
		public String gravar(PessoaJuridica pj) throws Exception {
			PreparedStatement estrutura = null;
			estrutura = con.prepareStatement
					("INSERT INTO Pessoa (id, nome, email, telefone, numero_contrato, razao_social, inscricao_estadual) VALUES(?,?,?,?,?,?,?)");
			estrutura.setInt (1,pj.getId());
			estrutura.setString (2,pj.getNome());
			estrutura.setString (3,pj.getEmail());
			estrutura.setString(4, pj.getTelefone());
			estrutura.setString(5, pj.getNumeroContrato());
			estrutura.setString(6, pj.getRazaoSocial());
			estrutura.setString(7, pj.getCnpj());
			estrutura.setString(7, pj.getInscricaoEstadual());
			
			estrutura.execute();
			estrutura.close();
			return "Gravado com sucesso";


		}
		
		public PessoaJuridica getPessoaJuridica(int n) throws Exception{
			PessoaJuridica pj = new PessoaJuridica();
			PreparedStatement estrutura = null;
			estrutura = con.prepareStatement
					("SELECT id, nome, email, telefone, numero_contrato, razao_social, cnpj, inscricao_estadual FROM Pessoa WHERE id = ?");
			estrutura.setInt (1,n);
			ResultSet resultado = estrutura.executeQuery();							
			if(resultado.next()) {
				pj.setNome(resultado.getString("nome"));
				pj.setEmail(resultado.getString("email"));
				pj.setTelefone(resultado.getString("telefone"));
				pj.setNumeroContrato(resultado.getString("numero_contrato"));
				pj.setRazaoSocial(resultado.getString("razao_social"));
				pj.setCnpj(resultado.getString("cnpj"));
				pj.setInscricaoEstadual(resultado.getString("inscricao_estadual"));


			}
			resultado.close();
			estrutura.close();
			return pj;

		}
	
		public String delete (String c) throws Exception {
			PreparedStatement estrutura = con.prepareStatement("DELETE FROM Pessoa WHERE cnpj = ?");
			estrutura.setString(1, c);
			int i = estrutura.executeUpdate();
			estrutura.close();
			return i + "PJ's deletados";
			
		}
		
		public String atualizarInscricao (String x, String y) throws Exception{
			PreparedStatement estrutura = con.prepareStatement
			("UPDATE Pessoa SET inscricao_estadual = ? WHERE cnpj =?");
			estrutura.setString(1,  x);
			estrutura.setString(2, y);
			int z = estrutura.executeUpdate();
			return z + "linhas atualizadas";
		}
		
		

}
