package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import beans.Endereco;
import conexao.ConexaoFactory;

public class EnderecoDAO {

private Connection con;

public EnderecoDAO() throws Exception {
    con = new ConexaoFactory().conectar();
}    
    public String fechar() throws Exception {
        con.close();
        return "Fechado com sucesso";
    }
    public String gravar(Endereco end) throws Exception {
        PreparedStatement estrutura = null;
        estrutura = con.prepareStatement("insert into Pessoa (cep,rua,numero,cidade) VALUES (?,?,?,?)");
        estrutura.setString(1,end.getCep());
        estrutura.setString(2, end.getRua());
        estrutura.setInt(3, end.getNumero());
        estrutura.setString(4, end.getCidade());
        estrutura.execute();
        estrutura.close();
        return "Gravado com sucesso";
    }
    public int delete(String cep) throws Exception {
        PreparedStatement estrutura = con.prepareStatement ("delete from PESSOAS where cep = ?");
        estrutura.setString(1, cep);
        int i = estrutura.executeUpdate();
        estrutura.close();
        return i;
    }
    
    public int atualizarCidade(String cidade) throws Exception {
        PreparedStatement estrutura = con.prepareStatement("update PESSOA set cidade = ?");
        estrutura.setString(1, cidade);
        int i = estrutura.executeUpdate();
        estrutura.close();
        return i;
    }
    
    public Endereco selecionarEndereco(String cep) throws Exception{
		Endereco end = new Endereco();
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("SELECT cep, rua, numero, cidade FROM Pessoa WHERE cep = ?");
		estrutura.setString (1,cep);
		ResultSet resultado = estrutura.executeQuery();							
		if(resultado.next()) {
			end.setCep(resultado.getString("cep"));
			end.setCidade(resultado.getString("cidade"));
			end.setNumero(resultado.getInt("numero"));
			end.setRua(resultado.getString("rua"));
			
		}
		resultado.close();
		estrutura.close();
		return end;

	}
    
    public List<Endereco> listarPorEndereco(String n) throws Exception {
        List<Endereco> lista = new ArrayList<Endereco>();
        Endereco obj = null;
        
        PreparedStatement estrutura = con.prepareStatement("select * from PESSOA where CEP like ?");
        estrutura.setString(1, "%" + n + "%");
        ResultSet resultado = estrutura.executeQuery();
        while(resultado.next()) {
            obj = new Endereco();
            obj.setCep(resultado.getString("cep"));
            obj.setRua(resultado.getString("rua"));
            obj.setNumero(resultado.getInt("numero"));
            obj.setCidade(resultado.getString("cidade"));
            lista.add(obj);
        }
        resultado.close();
        estrutura.close();
        return lista;
    }
}

