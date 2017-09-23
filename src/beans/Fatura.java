package beans;

public class Fatura
{
	private long numeroFatura;
	private double consumoKwh;
	private String dataVencimento;
	private String formaPagamento;
	private double taxaKwh;
	private double valor;
	
	public Fatura(long numeroFatura, double consumoKwh, String dataVencimento, String formaPagamento, double taxaKwh)
	{
		setNumeroFatura(numeroFatura);
		setConsumoKwh(consumoKwh);
		setDataVencimento(dataVencimento);
		setFormaPagamento(formaPagamento);
		setTaxaKwh(taxaKwh);
		valor = taxaKwh * consumoKwh;
		setValor(valor);
	}
	
	public Fatura(){}
	
	public String getAll()
	{
		return "N�mero Fatura: "+numeroFatura+
				"\nConsumo (KW/h): "+consumoKwh+
				"\nData de vencimento: "+dataVencimento+
				"\nForma de Pagamento: "+formaPagamento+
				"\nTaxa (Reais por KW/h)"+taxaKwh+
				"\nValor: R$ "+valor;
	}
	
	public void setAll(long numeroFatura, double consumoKwh, String dataVencimento, String formaPagamento, double taxaKwh, double valor)
	{
		setNumeroFatura(numeroFatura);
		setConsumoKwh(consumoKwh);
		setDataVencimento(dataVencimento);
		setFormaPagamento(formaPagamento);
		setTaxaKwh(taxaKwh);
		setValor(valor);
	}

	public long getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(long numeroFatura) {
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

	public double getTaxaKwh() {
		return taxaKwh;
	}

	public void setTaxaKwh(double taxaKwh) {
		this.taxaKwh = taxaKwh;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}


