package beans;

public class Fornecedor extends PessoaJuridica{
	
	private String numeroContrato;
	private String vigenciaContrato;
	private String gerenteContrato;
	
	public String getAll() {
		return numeroContrato + "\n" + vigenciaContrato + gerenteContrato;
		
	}
	
	public void setAll (String nc, String vc, String gc) {
		numeroContrato = nc;
		vigenciaContrato = vc;
		gerenteContrato = gc;
	
	}
	
	public Fornecedor() {
		super();
	}
	public Fornecedor(String numeroContrato, String vigenciaContrato, String gerenteContrato) {
		super();
		this.numeroContrato = numeroContrato;
		this.vigenciaContrato = vigenciaContrato;
		this.gerenteContrato = gerenteContrato;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getVigenciaContrato() {
		return vigenciaContrato;
	}
	public void setVigenciaContrato(String vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}
	public String getGerenteContrato() {
		return gerenteContrato;
	}
	public void setGerenteContrato(String gerenteContrato) {
		this.gerenteContrato = gerenteContrato;
	}
	
	
	
}
	
	