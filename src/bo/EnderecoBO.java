package bo;

import beans.Endereco;
import dao.EnderecoDAO;
import dao.FornecedorDAO;

public class EnderecoBO {
	
	public static String cadastrarEndereco(Endereco end)throws Exception{
        if (end.getCep().length()>8){
            return "Digite um CEP válido!";
        }
        
        EnderecoDAO dao = new EnderecoDAO();
        if (dao.selecionarEndereco(end.getRua()).getRua().length()>0){
            dao.fechar();
            return "Este número já existe";
        }
        String x = dao.gravar(end);
        dao.fechar();
        return x;
    }
	
	  
    public static String mudarCidade(String x, int y) throws Exception {
        //mudar cidade
        
    
        if(x.indexOf("@")>0 || x.indexOf("#")>0 || x.indexOf("%")>0 || x.indexOf("&")>0) {
            return "Digite um nome de cidade valido!";
        
        }
          EnderecoDAO dao = new EnderecoDAO();
          int p = dao.updateCidade (x, y);
          return p + "Cidade(s) atualizada(s)";
    }
    
    
public static String deletarFornecedor (String cep) throws Exception {
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
