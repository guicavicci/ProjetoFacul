package bo;

import beans.Fornecedor;
import dao.FornecedorDAO;

public class FornecedorBO {
    
    public static String adicionarNovoFornecedor(Fornecedor f)throws Exception{
        //add novo fornecedor
        if (f.getNumeroContrato().length() < 0){
            return "Digite um número de contrato válido.";
        }
        
        FornecedorDAO dao = new FornecedorDAO();
        String x = dao.adcFornecedor(f);
        dao.fechar();
        return x;
    }

    public static Fornecedor consultarPorContrato(String c) throws Exception{
        //consultar por número de contrato
        if(c.indexOf("@")>0 || c.indexOf("#")>0 || c.indexOf("%")>0 || c.indexOf("&")>0){
            return new Fornecedor();
        }
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor objeto = dao.getFornecedor(c);
        dao.fechar();
        return objeto;
    }
    
    public static String mudarGerente(String a, String g) throws Exception {
        //alterar gerente
        
    
        if(a.indexOf("@")>0 || a.indexOf("#")>0 || a.indexOf("%")>0 || a.indexOf("&")>0 || a.indexOf("!")>0 || a.indexOf("_")>0) {
            return "Digite um gerente válido!";
        
        }
          FornecedorDAO dao = new FornecedorDAO();
          String p = dao.alterarGerente(a, g);
          return p;
    }
          
    public static String deletarFornecedor (String dforn) throws Exception {
        //deletar fornecedor
        
        if(dforn.length() < 0) {
            String fv = "Digite um fornecedor válido.";
            return fv;
            
        }
        FornecedorDAO dao = new FornecedorDAO();
        int d = dao.delete(dforn);
        return d + "Deletado com sucesso.";
    }
        
    
}

