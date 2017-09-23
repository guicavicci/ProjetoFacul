package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import beans.Endereco;
import bo.ClienteBO;
import bo.EnderecoBO;
import bo.ClienteBO;
import dao.ClienteDAO;

public class TesteCliente {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        ClienteBO bo = null;
        Cliente cliente = null;
        try{
            bo = new ClienteBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Cliente\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Cliente\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                	bo = new ClienteBO();
                    Cliente obj = new Cliente();
                    obj.setAll(	
                    		texto("Digite o numero instalacao: "),
                    		texto("Digite o atualizaca cadastral:"),
                    		texto("Digite o debito pendente: "));                  		
                    System.out.println(bo.adicionarCliente(obj));		

                }else if (op=='C'){
                	//Consultar
                    bo = new ClienteBO();
                    String numeroInscricao = texto("Digite o numero da inscricao : ");
					cliente = ClienteBO.consultarCodigo(numeroInscricao);
					JOptionPane.showMessageDialog(null, "Numero da instalacao : " + cliente.getNumeroInstalacao()
						+ "\nDebito Pendente : " + cliente.getDebitoPendente()
						+ "\nAtualizacao Cadastral" + cliente.getAtualizacaoCadastral(), "TA AI", JOptionPane.OK_OPTION);

                }else if (op=='A'){
                	cliente.setAll(
							texto ("Digite o numero da inscricao : "),
							texto ("Digite a atualizacao cadastral : "),
							texto ("Digite o debito pendente : "));

                }
                else if (op == 'D') {
                	//Deletar
            	
                 	String d = bo.excluirClienteNumero(texto
                			("Digite o numero da instalacao que deseja deletar:"));
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "ClienteDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


