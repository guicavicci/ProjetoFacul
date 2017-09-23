package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Fatura;
import conexao.ConexaoFactory;

public class FaturaDAO
{
	private Connection con;
	
	public FaturaDAO(){}

	//Construtor (abre conexão)
	public FaturaDAO(Connection con)throws Exception
	{
		con = new ConexaoFactory().conectar();
	}
	//Fecha conexão
	public String fechar()throws Exception
	{
		con.close();
		return "Conexão fechada com sucesso!";
	}
	//Criar fatura
	public String criar(Fatura fatura)throws Exception
	{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
		("INSERT INTO FATURA"+
		"(NM_FATURA, CONSUMO_KWH, DT_VENCIMENTO, PAGAMENTO, TAXA, VALOR) VALUES"+
		"(?,?,?,?,?,?)");
		estrutura.setLong(1, fatura.getNumeroFatura());
		estrutura.setDouble(2, fatura.getConsumoKwh());
		estrutura.setString(3, fatura.getDataVencimento());
		estrutura.setString(4, fatura.getFormaPagamento());
		estrutura.setDouble(6, fatura.getValor());
		estrutura.setDouble(5, fatura.getTaxaKwh());
		int nm = estrutura.executeUpdate();
		estrutura.close();
		return nm + " linha foi criada!";
	}
	//Pegar fatura
	public Fatura getFatura(long numero) throws Exception
	{
		Fatura fatura = new Fatura();
		PreparedStatement estrutura = con.prepareStatement
		("SELECT * FROM FATURA WHERE NM_FATURA = ?");
		estrutura.setLong(1, numero);
		ResultSet resultado = estrutura.executeQuery();
		if(resultado.next())
		{
			fatura.setNumeroFatura(resultado.getInt("NM_FATURA"));
			fatura.setConsumoKwh(resultado.getDouble("CONSUMO_KWH"));
			fatura.setDataVencimento(resultado.getString("DT_VENCIMENTO"));
			fatura.setFormaPagamento(resultado.getString("PAGAMENTO"));
			fatura.setTaxaKwh(resultado.getDouble("TAXA"));
			fatura.setValor(resultado.getDouble("VALOR"));
		}
		return fatura;
	}
	//Deletar fatura
	public int delete(long numero)throws Exception
	{
		PreparedStatement estrutura = con.prepareStatement
		("DELETE FROM FATURA WHERE NM_FATURA = ?");
		estrutura.setLong(1, numero);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	public int updateTaxa(double taxa, long numero) throws Exception
	{
		PreparedStatement estrutura = con.prepareStatement
		("UPDATE FATURA SET TAXA = ? WHERE NM_FATURA = ?");
		estrutura.setDouble(1, taxa);
		estrutura.setLong(2, numero);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	//CREATE, SELECT, UPDATE, DELETE FEITOS :)))))
}


