package testes;

import javax.swing.JOptionPane;

import beans.CentroCusto;
import bo.CentroCustoBO;

public class TesteCentroCusto {
	
	static String texto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}
	
	static int textint (String textint) {
		return Integer.parseInt(JOptionPane.showInputDialog(textint));
		
	}

    public static void main(String[] args) {
        CentroCustoBO bo = null;
        try{
            bo = new CentroCustoBO();
            do{
                char op =JOptionPane.showInputDialog
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar\n "
                                + "<C> - Consultar\n "
                                + "<M> - Mudar Area").toUpperCase().charAt(0);
                if (op=='G'){
                    bo = new CentroCustoBO();
                    CentroCusto obj = new CentroCusto();
                    obj.setCodigo(textint("Digite o Codigo da area: "));
                    obj.setNomeArea(texto("Digite o Nome da area: "));
                    obj.setGestor(texto("Digite o Nome do gestor da area: "));
                    System.out.println(bo.adicionarNovaArea(obj));

                }else if (op=='C'){
                    bo = new CentroCustoBO();
                    CentroCusto cc = bo.consultarPorcodigo(textint("Codigo: "));
                    System.out.println("Codigo da area: " + cc.getCodigo());
                    System.out.println("Nome da area: " + cc.getNomeArea());
                    System.out.println("Nome do gestor da area: " + cc.getGestor());


                }else if (op=='M'){
                    bo = new CentroCustoBO();
                    String x = bo.TrocarArea(texto("Digite a nova area: "),
                    textint("Digite o codigo: "));
                    System.out.println(x + "Area foi(s) foi(ram) atualizada(s)");

                }else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "CentroCustoBO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


