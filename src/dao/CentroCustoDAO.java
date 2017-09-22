package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.CentroCusto;
import conexao.ConexaoFactory;

public class CentroCustoDAO {
    private Connection con;

    public CentroCustoDAO() throws Exception{
        con = new ConexaoFactory().conectar();
    }
    public String fechar()throws Exception{
        con.close();
        return "Fechado com sucesso!";
    }
    public String gravar(CentroCusto cc) throws Exception{
        PreparedStatement estrutura = null;
        estrutura = con.prepareStatement
                ("INSERT INTO Centro_custo "
                        + "(codigo, nome_area, gestor) VALUES" 
                        +"(?,?,?)");
        estrutura.setInt(1, cc.getCodigo());
        estrutura.setString(2, cc.getNomeArea());
        estrutura.setString(3, cc.getGestor());
        estrutura.execute();
        estrutura.close();
        return "Gravado com sucesso!";
    }

    public CentroCusto getCodigo(int n)throws Exception{
        CentroCusto cc = new CentroCusto();
        PreparedStatement estrutura = con.prepareStatement("SELECT * FROM Centro_custo WHERE codigo = ?");
        estrutura.setInt(1, n);
        ResultSet resultado = estrutura.executeQuery();
        if(resultado.next()){
            cc.setCodigo(resultado.getInt("codigo"));
            cc.setNomeArea(resultado.getString("nome_area"));
            cc.setGestor(resultado.getString("gestor"));
        }
        resultado.close();
        estrutura.cancel();
        return cc;
    }

    public int delete(int num) throws Exception{
        PreparedStatement estrutura = con.prepareStatement("DELETE FROM Centro_custo WHERE codigo = ?");
        estrutura.setInt(1, num);
        int i = estrutura.executeUpdate();
        estrutura.close();
        return i;
    }

    public int mudarArea(String area, int cod)throws Exception{
        PreparedStatement estrutura = con.prepareStatement("UPDATE Centro_custo SET nome_area=? WHERE codigo=?");
        estrutura.setString(1, area);
        estrutura.setInt(2,  cod);
        int x = estrutura.executeUpdate();
        estrutura.close();
        return x;
    }

}


