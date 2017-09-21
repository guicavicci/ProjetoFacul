package beans;

public class CentroCusto {
    private int codigo;
    private String nomeArea;
    private String gestor;
    
    
    public String getAll(){
        return codigo + "\n" + nomeArea + "\n" + gestor + "\n"; 
    }
    
    public void setAll(int codigo, String nomeArea, String gestor, Endereco endereco)
    {
    this.codigo = codigo;
    this.nomeArea = nomeArea;
    this.gestor = gestor; 
    }
        
    public CentroCusto() {
        super();
    }

    public CentroCusto(int codigo, String nomeArea, String gestor, Endereco endereco)
    {
        super();
        this.codigo = codigo;
        this.nomeArea = nomeArea;
        this.gestor = gestor;
    }
    



    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNomeArea() {
        return nomeArea;
    }
    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }
    public String getGestor() {
        return gestor;
    }
    public void setGestor(String gestor) {
        this.gestor = gestor;
    }



}

