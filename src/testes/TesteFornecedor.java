package testes;

import javax.swing.JOptionPane;

import beans.Fornecedor;
import bo.FornecedorBO;
import dao.FornecedorDAO;

public class TesteFornecedor {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        FornecedorBO bo = null;
        try{
            bo = new FornecedorBO();
            do{
                char op =texto
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar Fornecedor\n "
                                + "<C> - Consultar\n "
                                + "<A> - Alterar Gerente\n"
                                + "<D> - Deletar").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new FornecedorBO();
                    Fornecedor obj = new Fornecedor();
                    obj.setAll(
                    		texto("Digite o numero do contrato: "),
                    		texto("Digite a vigencia do contrato:"),
                    		texto("Digite o nome do gerente do contrato: "));
                    System.out.println(bo.adicionarNovoFornecedor(obj));

                }else if (op=='C'){
                	//Consultar
                    bo = new FornecedorBO();
                    Fornecedor forn = bo.consultarPorContrato(texto("Digite o contrato do Fornecedor:"));
                    
                    System.out.println("Numero do contrato: " + forn.getNumeroContrato());
                    System.out.println("Vigencia do contrato: " + forn.getVigenciaContrato());
                    System.out.println("Gerente: " + forn.getGerenteContrato());

                }else if (op=='A'){
                    bo = new FornecedorBO();
                    String p = bo.mudarGerente(
                    		texto("Digite o nome do novo gerente:"),
                    		texto ("Digite o numero do contrato que irá ter o gerente alterado:"));
                    		              		
                    System.out.println(p);


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new FornecedorBO();
                	String d = bo.deletarFornecedor(texto
                			("Digite o numero de contrato do fornecedor que deseja deletar:"));
                	System.out.println(d);
                	
                }
                else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "FornecedorBO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


