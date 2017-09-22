package beans;


public class PessoaFisica extends Pessoa{
	private String cpf;
	private String rg;
	private String dataNascimento;
	
	public String getAll () {
		return super.getAll() + "\n" + cpf + "\n" + rg + "\n" + dataNascimento;
		
	}
	
	public void setAll(int i, String n, String em, String t, String c, String r, String dn) {
		super.setAll(i, n, em, t);
		cpf =c;
		rg=r;
		dataNascimento = dn;
		
	}
	
	
	public PessoaFisica() {
		super();
	}
	public PessoaFisica(int id, String nome, String email, String telefone, String cpf, String rg,
			String dataNascimento, Pessoa pessoa) {
		super(id, nome, email, telefone);
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;

	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento= dataNascimento;
	}

	
	
	
}