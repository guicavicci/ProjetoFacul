package beans;

public class Endereco {
    private String cep;
    private String rua;
    private int numero;
    private String cidade;

    public Endereco() {
        super();
    }    
    public Endereco(String cep, String rua, int numero, String cidade) {
        super();
        setCep(cep);
        setRua(rua);
        setNumero(numero);
        setCidade(cidade);
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getAll() {
        return "\n" + cep + "\n" + rua + "\n" + numero + "\n" + cidade; 
    }
    
    public void setAll(String c, String r, int n, String cid){
        cep = c;
        rua = r;
        numero = n;
        cidade = cid;
    }
}


