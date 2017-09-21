package beans;

public class Fatura
{
    private int numeroFatura;
    private double consumoKwh;
    private String dataVencimento;
    private String formaPagamento;
    private double valor;
    private double taxaKwh;
    
    public Fatura(int numeroFatura, double consumoKwh, String dataVencimento, String formaPagamento, double valor, double taxaKwh)
    {
        setNumeroFatura(numeroFatura);
        setConsumoKwh(consumoKwh);
        setDataVencimento(dataVencimento);
        setFormaPagamento(formaPagamento);
        setValor(valor);
        setTaxaKwh(taxaKwh);
    }
    
    public Fatura(){}
    
    public String getAll()
    {
        return "Número Fatura: "+numeroFatura+
                "\nConsumo (KW/h): "+consumoKwh+
                "\nData de vencimento: "+dataVencimento+
                "\nForma de Pagamento: "+formaPagamento+
                "\nValor: R$ "+valor+
                "\nTaxa (Reais por KW/h)"+taxaKwh;
    }
    public void setAll(int numeroFatura, double consumoKwh, String dataVencimento, String formaPagamento, double valor, double taxaKwh)
    {
        setNumeroFatura(numeroFatura);
        setConsumoKwh(consumoKwh);
        setDataVencimento(dataVencimento);
        setFormaPagamento(formaPagamento);
        setValor(valor);
        setTaxaKwh(taxaKwh);
    }

    public int getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(int numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public double getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxaKwh() {
        return taxaKwh;
    }

    public void setTaxaKwh(double taxaKwh) {
        this.taxaKwh = taxaKwh;
    }
    
    
    
    
}


