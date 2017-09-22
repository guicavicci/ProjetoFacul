package bo;

import beans.Endereco;
import dao.EnderecoDAO;

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


}
