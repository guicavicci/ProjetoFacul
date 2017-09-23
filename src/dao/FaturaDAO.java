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
    //Criar Fatura
    public String criar(Fatura Fatura)throws Exception
    {
        PreparedStatement estrutura = null;
        estrutura = con.prepareStatement
        ("INSERT INTO Fatura"+
        "(nm_fatura, consumo_kwh,dt_vencimento, pagamento, valor, taxa) VALUES"+
        "(?,?,?,?,?,?)");
        estrutura.setInt(1, Fatura.getNumeroFatura());
        estrutura.setDouble(2, Fatura.getConsumoKwh());
        estrutura.setString(3, Fatura.getDataVencimento());
        estrutura.setString(4, Fatura.getFormaPagamento());
        estrutura.setDouble(5, Fatura.getValor());
        estrutura.setDouble(6, Fatura.getTaxaKwh());
        int nm = estrutura.executeUpdate();
        estrutura.close();
        return nm + " linha foi criada!";
    }
    //Pegar Fatura
    public Fatura getFatura(int numero) throws Exception
    {
        Fatura Fatura = new Fatura();
        PreparedStatement estrutura = con.prepareStatement
        ("SELECT * FROM Fatura WHERE nm_fatura = ?");
        estrutura.setInt(1, numero);
        ResultSet resultado = estrutura.executeQuery();
        if(resultado.next())
        {
            Fatura.setNumeroFatura(resultado.getInt("nm_fatura"));
            Fatura.setConsumoKwh(resultado.getDouble("consumo_kwh"));
            Fatura.setDataVencimento(resultado.getString("dt_vencimento"));
            Fatura.setFormaPagamento(resultado.getString("pagamento"));
            Fatura.setValor(resultado.getDouble("valor"));
            Fatura.setTaxaKwh(resultado.getDouble("taxa"));
        }
        return Fatura;
    }
    //Deletar Fatura
    public int delete(int numero)throws Exception
    {
        PreparedStatement estrutura = con.prepareStatement
        ("DELETE FROM Fatura WHERE nm_fatura = ?");
        estrutura.setInt(1, numero);
        int i = estrutura.executeUpdate();
        estrutura.close();
        return i;
    }
    
    public String atualizarPagamento(String pgto, int nm) throws Exception {
        PreparedStatement estrutura = con.prepareStatement("update Fatura set pagamento = ? where nm_fatura = ?");
        estrutura.setString(1, pgto);
        estrutura.setInt(2, nm);
        int i = estrutura.executeUpdate();
        estrutura.close();
        return i + "ALterado(s).";
    }
    
}


	