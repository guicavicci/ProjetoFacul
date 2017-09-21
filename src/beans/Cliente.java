package beans;

public class Cliente {
    private String numeroInstalacao;
	private String atualizacaoCadastral;
    private String debitoPendente;
    
    public String getAll() {
        return atualizacaoCadastral + "\n" + numeroInstalacao + "\n" + debitoPendente;
        
    }
    
    public void setAll( String ac, String ni, String dp) {
        atualizacaoCadastral=ac;
        numeroInstalacao=ni;
        debitoPendente=dp;
        
    }
    
    public Cliente() {
        super();
    }
    public Cliente(String numeroInstalacao, String atualizacaoCadastral, String debitoPendente) {
        this.numeroInstalacao = numeroInstalacao;
    	this.atualizacaoCadastral = atualizacaoCadastral;
        this.debitoPendente = debitoPendente;
    }
    public String getAtualizacaoCadastral() {
        return atualizacaoCadastral;
    }
    public void setAtualizacaoCadastral(String atualizacaoCadastral) {
        this.atualizacaoCadastral = atualizacaoCadastral;
    }
    public String getNumeroInstalacao() {
        return numeroInstalacao;
    }
    public void setNumeroInstalacao(String numeroInstalacao) {
        this.numeroInstalacao = numeroInstalacao;
    }
    public String getDebitoPendente() {
        return debitoPendente;
    }
    public void setDebitoPendente(String debitoPendente) {
        this.debitoPendente = debitoPendente;
    }
    
    

}


