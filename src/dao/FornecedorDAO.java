package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Fornecedor;
import conexao.ConexaoFactory;

public class FornecedorDAO {
    
        private Connection con;
        
        public FornecedorDAO () throws Exception {
            con = new ConexaoFactory().conectar();
        }
        
        public String fechar () throws Exception {
            con.close();
            return "Conexao fechada com sucesso";
            
        }
    

        public String adcFornecedor(Fornecedor forn) throws Exception {
            PreparedStatement estrutura = null;
            estrutura = con.prepareStatement
                    ("INSERT INTO Fornecedor (numero_contrato, vigencia_contrato, gerente_contrato) VALUES(?,?,?)");
            estrutura.setString(1, forn.getNumeroContrato());
            estrutura.setString(2, forn.getVigenciaContrato());
            estrutura.setString(3, forn.getGerenteContrato());
            estrutura.execute();
            estrutura.close();
            return "Gravado com sucesso";
        
        }
        
        public int delete(String nc) throws Exception {
            PreparedStatement estrutura = con.prepareStatement ("delete from Fornecedor where numero_contrato = ?");
            estrutura.setString(1, nc);
            int i = estrutura.executeUpdate();
            estrutura.close();
            return i;
        
}

        public String alterarGerente(String gerente, String nc) throws Exception {
            PreparedStatement estrutura = con.prepareStatement("update Fornecedor set gerente_contrato = ? where numero_contrato = ?");
            estrutura.setString(1, gerente);
            estrutura.setString(2, nc);
            estrutura.executeUpdate();
            estrutura.close();
            return "Alterado com sucesso";
        }
        
        public Fornecedor getFornecedor(String ni) throws Exception{
            Fornecedor forn = new Fornecedor();
            PreparedStatement estrutura = null;
            estrutura = con.prepareStatement
                    ("SELECT numero_contrato, vigencia_contrato, gerente_contrato FROM Fornecedor WHERE numero_contrato = ?");
            estrutura.setString (1,ni);
            ResultSet resultado = estrutura.executeQuery();                            
            if(resultado.next()) {
                forn.setNumeroContrato(resultado.getString("numero_contrato"));
                forn.setVigenciaContrato(resultado.getString("vigencia_contrato"));
                forn.setGerenteContrato(resultado.getString("gerente_contrato"));    
                
            }
            resultado.close();
            estrutura.close();
            return forn;

        }
        
        
}


