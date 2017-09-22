package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.CentroCusto;
import beans.Funcionario;
import conexao.ConexaoFactory;

public class FuncionarioDAO {
	
	 private Connection con;

	    public FuncionarioDAO() throws Exception{
	        con = new ConexaoFactory().conectar();
	    }
	    public String fechar()throws Exception{
	        con.close();
	        return "Fechado com sucesso!";
	    }
	    

	    public String gravar(Funcionario func) throws Exception{
	        PreparedStatement estrutura = null;
	        estrutura = con.prepareStatement
	                ("INSERT INTO Funcionario "
	                        + "(numero_matricula, cargo, salario) VALUES" 
	                        +"(?,?,?)");
	        estrutura.setInt(1, func.getNumeroMatricula());
	        estrutura.setString(2, func.getCargo());
	        estrutura.setDouble(3, func.getSalario());
	        estrutura.execute();
	        estrutura.close();
	        return "Gravado com sucesso!";
	    }
	    
	    public Funcionario getFuncionario(int n)throws Exception{
	    	Funcionario func = new Funcionario();
	        PreparedStatement estrutura = con.prepareStatement("SELECT numero_matricula, cargo, salario FROM Funcionario WHERE numero_matricula = ?");
	        estrutura.setInt(1, n);
	        ResultSet resultado = estrutura.executeQuery();
	        if(resultado.next()){
	        	func.setNumeroMatricula(resultado.getInt("numero_matricula"));
	        	func.setCargo(resultado.getString("cargo"));
	        	func.setSalario(resultado.getDouble("salario"));

	        }
	        
	        resultado.close();
	        estrutura.cancel();
	        return func;
	    }
	    
	    public int delete(int num) throws Exception{
	        PreparedStatement estrutura = con.prepareStatement("DELETE FROM Funcionario WHERE numero_matricula = ?");
	        estrutura.setInt(1, num);
	        int i = estrutura.executeUpdate();
	        estrutura.close();
	        return i;
	    }
	    
	    public String upSalario(Double s, String nm)throws Exception{
	        PreparedStatement estrutura = con.prepareStatement("UPDATE Funcionario SET salario = salario + ?/100*salario WHERE numero_matricula=?");
	        estrutura.setDouble(1,  s);
	        estrutura.setString(2, nm);
	        int x = estrutura.executeUpdate();
	        estrutura.close();
	        return "O numero de linhas atualizadas foram" + x;
	    }
	    

}
