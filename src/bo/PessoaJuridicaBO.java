package bo;

import beans.PessoaJuridica;
import dao.PessoaJuridicaDAO;

public class PessoaJuridicaBO {
	

    public static String adicionarNovoPJ(PessoaJuridica pj)throws Exception{
    	//add novo pj
        if (pj.getRazaoSocial().length() < 5){
            return "Digite uma Razao Social válida.";
        }
        
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        PessoaJuridica peju = new PessoaJuridica();
        int z = peju.getId();
        if (z > 0){
            dao.fechar();
            return "Este número já existe";
        }
        String x = dao.gravar(pj);
        dao.fechar();
        return x;
    }

    public static PessoaJuridica consultarPorId(int c) throws Exception{
    	//consultar por id
        PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        PessoaJuridica objeto = dao.getPessoaJuridica(c);
        dao.fechar();
        return objeto;
    }
    
    public static String mudarInscricao(String x, String y) throws Exception {
    	//mudar inscricao
    
    		
    	if(x.indexOf("@")>0 || x.indexOf("#")>0 || x.indexOf("%")>0 || x.indexOf("&")>0) {
    		return "Digite uma inscricao valida!";   		
    	
    	}
    	  PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
    	  String p = dao.atualizarInscricao(x, y);
    	  return p;
    }
    	  
    public static String deletarPessoaJuridica (String id) throws Exception {
    	//deletar pj
    	
    	if(id.length() < 1) {
    		return "Digite um id valido.";
    		
    	}
    	PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
    	String z = dao.delete(id);
    	return z + "Deletado com sucesso.";
    }
    	
    
}