package testes;

import javax.swing.JOptionPane;

import beans.Fatura;
import bo.FaturaBO;

public class TesteFatura {
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
        FaturaBO bo = null;
        try{
            bo = new FaturaBO();
            do{
                char op =texto
                        ("Escolha uma opÃ§Ã£o:\n "
                                + "<G> - Criar Fatura\n "
                                + "<C> - Consultar Fatura\n "
                                + "<A> - Alterar Fatura"
                                + "<D> - Deletar Fatura").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new FaturaBO();
                    Fatura nf = new Fatura();
                    nf.setAll(
                    		textint("Digite o numero da fatura:"), 
                    		textint("Digite o consumo realizado em KW/H:"), 
                    		textint("Digite a data de vencimento da fatura:"), 
                    		texto("Digite a forma de pagamento: "), 
                    		textdoub("Digite o valor da fatura: "), 
                    		textdoub("Digite a taxa em KW/h:"));;
                    System.out.println(bo.novaFatura(nf));

                }else if (op=='C'){
                	//Consultar
                    bo = new FaturaBO();
                    Fatura cf = bo.consultarFatura(textint("Digite o número da fatura:"));
                    
                    System.out.println("Número da Fatura: " + cf.getNumeroFatura());
                    System.out.println("Consumo em Kw/h: " + cf.getConsumoKwh());
                    System.out.println("Data de Vencimento:" + cf.getDataVencimento());
                    System.out.println("Forma de Pagamento:" + cf.getFormaPagamento());
                    System.out.println("Valor da fatura:" + cf.getValor());
                    System.out.println("Taxa do Kw/h:" + cf.getTaxaKwh());
                    	
                }else if (op=='A'){
                    // alterar fatura
                	bo = new FaturaBO();
                    String af = bo.alterarFatura(textint("Digite o número da data de vencimento:"), 
                    		textint("Digite o número da fatura:"));
                    		              		
                    System.out.println(af + "Vencimento atualizado.");


                }
                else if (op == 'D') {
                	//Deletar
             	
                	bo = new FaturaBO();
                	String df = bo.deletarFatura(textint("Digite o Numero da Fatura que deseja deletar: "));
                	System.out.println(df + "Fatura deletada.");
                	
                }
                else{
                    System.out.println("Opcao inválida!!!");
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
