package bo; 

import beans.Endereco;
import beans.Fatura;
import dao.EnderecoDAO;
import dao.FaturaDAO;

public class FaturaBO {
	
	//criando nova fatura - Feito 
    public static String novaFatura(Fatura fat)throws Exception{
     
     FaturaDAO dao = new FaturaDAO();

   	 if (fat.getConsumoKwh() <= 0){
   		 return "E obrigatorio digitar um valor positivo de consumo!";
   	 }
   	 if (fat.getDataVencimento().length()<1) {
   		 return "A data nao e valida";
   	 }
	
   	 String nf = dao.criar(fat);
   	 dao.fechar();
   	 return nf;
   	
   	 
    }
    
    // Consultando Fatura - Feito 
    

    public static Fatura consultarFatura(int numero) throws Exception{
   	 if(numero < 1){
   		 return new Fatura();
   	 }
   	 FaturaDAO dao = new FaturaDAO();
   	 Fatura cf = dao.getFatura(numero);
   	 dao.fechar();
   	 return cf;
    }
    
    // alterando fatura 
   
    
    public static String alterarFatura(String pgto, int nm) throws Exception {
        
		
    	if(nm < 1) {
    		return "Digite um Numero Valido!";   		
    	
    		
    	}
    	  FaturaDAO dao = new FaturaDAO();
    	  String z = dao.atualizarPagamento(pgto, nm);
    	  return z + "Alterado(s).";
    	  
    }
    
    
    //deletando fatura - Feito 
    
  public static String deletarFatura (int numero) throws Exception {
    	
    	if(numero < 1) {
    		return "Digite um id valido.";
    	}
    	FaturaDAO dao = new FaturaDAO();
    	int df = dao.delete(numero);
    	return df + "Deletado com sucesso.";
    }
    	
 
    
    
}
