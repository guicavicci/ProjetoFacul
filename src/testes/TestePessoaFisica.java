package testes;

import javax.swing.JOptionPane;

import beans.PessoaFisica;
import bo.PessoaFisicaBO;
import dao.PessoaFisicaDAO;

public class TestePessoaFisica {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        PessoaFisicaBO bo = null;
        try{
            bo = new PessoaFisicaBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar PessoaFisica\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar email\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new PessoaFisicaBO();
                    PessoaFisica obj = new PessoaFisica();
                    obj.setAll(
                    		textint("Digite o id: "),
                    		texto("Digite o nome: "),
                    		texto("Digite o email:"),
                    		texto("Digite o telefone: "),
                    		texto("Digite o cpf: "),
                    		texto("Digite o rg:"),
                    		texto ("Digite a data de nascimento: "));
                    System.out.println(bo.adicionarNovaPessoa(obj));

                }else if (op=='C'){
                	//Consultar
                    bo = new PessoaFisicaBO();
                    PessoaFisica pf = bo.consultarPorcodigo(textint("Digite o id da PessoaFisica:"));
                    
                    System.out.println("Nome: " + pf.getNome());
                    System.out.println("Email: " + pf.getEmail());
                    System.out.println("Telefone: " + pf.getTelefone());

                }else if (op=='A'){
                    bo = new PessoaFisicaBO();
                    String p = bo.trocarEmail(
                    		texto("Digite o email que deseja atualizar:"),
                    		textint ("Digite o id da PessoaFisica"));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new PessoaFisicaBO();
                	String d = bo.deletarPessoaFisica(textint
                			("Digite o id da Pessoa Fisica que deseja deletar:"));
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "PessoaFisicaDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


