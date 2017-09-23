package bo;

import beans.Endereco;
import beans.Fornecedor;
import dao.EnderecoDAO;
import dao.FornecedorDAO;

public class EnderecoBO {
	
	public static String cadastrarEndereco(Endereco end)throws Exception{
        if (end.getCep().length()>8){
            return "Digite um CEP válido!";
        }
        
        EnderecoDAO dao = new EnderecoDAO();
        String x = dao.gravar(end);
        dao.fechar();
        return x;
    }
	
    public static Endereco consultarPorCep(String c) throws Exception{
        //consultar por CEP
        if(c.indexOf("@")>0 || c.indexOf("#")>0 || c.indexOf("%")>0 || c.indexOf("&")>0){
            return new Endereco();
        }
        EnderecoDAO dao = new EnderecoDAO();
        Endereco endereco = dao.selecionarEndereco(c);
        dao.fechar();
        return endereco;
    }
    
	
	  
    public static String mudarCidade(String x, String y) throws Exception {
        //mudar cidade
        
    
        if(x.indexOf("@")>0 || x.indexOf("#")>0 || x.indexOf("%")>0 || x.indexOf("&")>0) {
            return "Digite um nome de cidade valido!";
        
        }
          EnderecoDAO dao = new EnderecoDAO();
          String p = dao.updateCidade (x, y);
          return p + "Cidade(s) atualizada(s)";
    }
    
    
public static String deletarCidade(String cep) throws Exception {
    //deletar cidade
    
    if(cep.indexOf("@")>0 || cep.indexOf("#")>0 || cep.indexOf("%")>0 || cep.indexOf("&")>0) {
        String x = "Digite um cep válido.";
        return x;
        
    }
    FornecedorDAO dao = new FornecedorDAO();
    int d = dao.delete(cep);
    return d + "Deletado(s).";
}


}
