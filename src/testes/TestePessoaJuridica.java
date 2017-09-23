package testes;

import javax.swing.JOptionPane;

import beans.PessoaJuridica;
import bo.PessoaJuridicaBO;
import dao.PessoaJuridicaDAO;

public class TestePessoaJuridica {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        PessoaJuridicaBO bo = null;
        try{
            bo = new PessoaJuridicaBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar\n "
                                + "<C> - Consultar\n "
                                + "<A> - Atualizar Inscricao\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new PessoaJuridicaBO();
                    PessoaJuridica obj = new PessoaJuridica();
                    obj.setAll(
                    		textint("Digite o id: "),
                    		texto("Digite o nome: "),
                    		texto("Digite o email:"),
                    		texto("Digite o telefone: "),
                    		texto("Digite o numero do contrato: "),
                    		texto("Digite a razao social: "),
                    		texto ("Digite ao cnpj: "),
                    		texto ("Digite a inscricao estadual"));
                    System.out.println(bo.adicionarNovoPJ(obj));

                }else if (op=='C'){
                	//Consultar
                    bo = new PessoaJuridicaBO();
                    PessoaJuridica pj = bo.consultarPorId(textint("Digite o id da PessoaJuridica:"));
                    
                    System.out.println("Numero do contrato: " + pj.getNumeroContrato());
                    System.out.println("Razao social: " + pj.getRazaoSocial());
                    System.out.println("CNPJ: " + pj.getCnpj());
                    System.out.println("Inscricao estadual" + pj.getInscricaoEstadual());

                }else if (op=='A'){	
                    bo = new PessoaJuridicaBO();
                    String p = bo.mudarInscricao(
                    		texto("Digite o nova Inscricao: "),
                    		texto ("Digite o cnpj que deseja atualizar a inscricao: "));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new PessoaJuridicaBO();
                	String d = bo.deletarPessoaJuridica(texto
                			("Digite o cnpj da Pessoa Juridica que deseja deletar:"));
                	System.out.println(d);
                	
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


