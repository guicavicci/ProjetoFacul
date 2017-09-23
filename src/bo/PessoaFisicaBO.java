package bo;

import beans.PessoaFisica;
import dao.PessoaFisicaDAO;

public class PessoaFisicaBO {
	
    public static String adicionarNovaPessoa(PessoaFisica pf)throws Exception{
       
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        if (dao.getPessoaFisica(pf.getId()).getId()>0){
            dao.fechar();
            return "Este número já existe";
        }
        String x = dao.gravar(pf);
        dao.fechar();
        return x;
    }

    public static PessoaFisica consultarPorcodigo(int pPessoaFisica) throws Exception{
        if(pPessoaFisica < 1){
            return new PessoaFisica();
        }
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        PessoaFisica objeto = dao.getPessoaFisica(pPessoaFisica);
        dao.fechar();
        return objeto;
    }
    
    public static String trocarEmail(String x, int y) throws Exception {
    
    		
    	if(x.indexOf("@")<4) {
    		return "Digite um email valido";   		
    	
    	}
    	  PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	  String p = dao.atualizarEmail(x, y);
    	  return p;
    }
    	  
    public static String deletarPessoaFisica (int id) throws Exception {
    	
    	if(id < 1) {
    		return "Digite um id valido.";
    		
    	}
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	int z = dao.delete(id);
    	return z + "Deletado com sucesso.";
    }
    	
    
}

