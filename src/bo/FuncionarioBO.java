package bo;

import beans.Funcionario;
import dao.FuncionarioDAO;
import dao.PessoaFisicaDAO;

public class FuncionarioBO {
	
    public static String adicionarNovoFuncionario(Funcionario func)throws Exception{
            
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.getFuncionario(func.getNumeroMatricula()).getNumeroMatricula()>0) {
        
            dao.fechar();
            return "Essa matricula já existe.";
        }
        String x = dao.gravar(func);
        dao.fechar();
        return x;
    }
    
    public static Funcionario consultarPorMatricula(int func) throws Exception{
        if(func < 1){
            return new Funcionario();
        }
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario objeto = dao.getFuncionario(func);
        dao.fechar();
        return objeto;
    }
    
    public static String aumentarSalario(double s, String nm) throws Exception {
        
		
    	if(nm.length()<1) {
    		return "Digite um valor valido!";   		
    	
    	}
    	  FuncionarioDAO dao = new FuncionarioDAO();
    	  String p = dao.upSalario(s, nm);
    	  return p;
    }
    
    public static String apagarFuncionario(int nm) throws Exception {
    	
    	if(nm < 1) {
    		return "Digite um numero de matricula valido!";
    		
    	}
    	FuncionarioDAO dao = new FuncionarioDAO();
    	int z = dao.delete(nm);
    	return z + "Deletado com sucesso.";
    }
    
    

}
