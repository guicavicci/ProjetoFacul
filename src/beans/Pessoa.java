package beans;

public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	public String getAll() {
		return id + "\n" + nome + "\n" + email + "\n" + telefone;
		
	}
	
	public void setAll(int i, String n, String em, String t) {
		id =i;
		email =em;
		telefone =t;
		
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public Pessoa () {
		super();
	}

	public Pessoa(int id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}


}