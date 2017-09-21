package beans;

import java.util.Date;

public class Funcionario extends PessoaFisica{
	
	private int numeroMatricula;
	private String cargo;
	private double salario;
	
	public String getAll() {
		return numeroMatricula + "\n" + cargo + "\n" + "\n" + salario;
	}
	
	public void setAll (int nm, String cg, double s) {
		numeroMatricula=nm;
		cargo=cg;
		salario=s;
		
	}
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(int numeroMatricula, String cargo, double salario) {
		this.numeroMatricula = numeroMatricula;
		this.cargo = cargo;
		this.salario = salario;
	}
	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	

}
