package testes;

import javax.swing.JOptionPane;

import beans.Endereco;
import bo.EnderecoBO;
import dao.EnderecoDAO;

public class TesteEndereco {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        EnderecoBO bo = null;
        try{
            bo = new EnderecoBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Endereco\n "
                                + "<C> - Consultar\n "
                                + "<A> - Mudar Cidade\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new EnderecoBO();
                    Endereco obj = new Endereco();
                    obj.setAll(	
                    		texto("Digite o cep: "),
                    		texto("Digite o rua:"),
                    		textint("Digite o numero: "),
                    		texto("Digite o cidade: "));                  		
                    System.out.println(bo.cadastrarEndereco(obj));

                }else if (op=='C'){
                	//Consultar
                    bo = new EnderecoBO();
                    Endereco end = bo.consultarPorCep(texto("Digite o cep do Endereco:"));
                    
                    System.out.println("CEP: " + end.getCep());
                    System.out.println("Rua: " + end.getRua());
                    System.out.println("Numero: " + end.getNumero());
                    System.out.println("Cidade: " + end.getCidade());

                }else if (op=='A'){
                    bo = new EnderecoBO();
                    String end = bo.mudarCidade(
                    		texto("Digite a nova cidade: "),
                    		texto ("Digite o cep que terá a cidade alterada: "));
                    		              		
                    System.out.println(end + "campo email atualizado");


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new EnderecoBO();
                	String d = bo.deletarCidade(texto
                			("Digite o cep que deseja excluir: "));
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "EnderecoDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


