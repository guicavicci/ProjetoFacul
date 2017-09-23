package testes;

import javax.swing.JOptionPane;

import beans.Funcionario;
import bo.FuncionarioBO;
import dao.FuncionarioDAO;

public class TesteFuncionario {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}
	
	static double textdoub (String textdoub) {
		return Integer.parseInt(JOptionPane.showInputDialog(textdoub));
		
	}

    public static void main(String[] args) {
        FuncionarioBO bo = null;
        try{
            bo = new FuncionarioBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Funcionario\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Salario\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new FuncionarioBO();
                    Funcionario obj = new Funcionario();
                    obj.setAll(
                    		textint("Digite o numero da matricula: "),
                    		texto("Digite o cargo: "),
                    		textdoub("Digite o salario:"));
                    System.out.println(bo.adicionarNovoFuncionario(obj));

                }else if (op=='C'){
                	//Consultar
                    bo = new FuncionarioBO();
                    Funcionario func = bo.consultarPorMatricula(textint("Digite a matricula do Funcionario:"));
                    
                    System.out.println("Numero da matricula: " + func.getNumeroMatricula());
                    System.out.println("Cargo: " + func.getCargo());
                    System.out.println("Salario: " + func.getSalario());

                }else if (op=='A'){
                    bo = new FuncionarioBO();
                    String p = bo.aumentarSalario(
                    		textdoub("Digite quantos % deseja aumentar no salario:"),
                    		texto("Digite o Numero da matricula do funcionario: "));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new FuncionarioBO();
                	String d = bo.apagarFuncionario(textint
                			("Digite o Numero da matricula do funcionario que deseja deletar:"));
                	System.out.println(d + "Linhas deletadas.");
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "CentroCustoDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


