package testes;

import javax.swing.JOptionPane;
import beans.CentroCusto;
import dao.CentroCustoDAO;

public class TesteCentroCusto {

    public static void main(String[] args) {
        CentroCustoDAO dao = null;
        try{
            dao = new CentroCustoDAO();
            do{
                char op =JOptionPane.showInputDialog
                        ("Escolha uma opção:\n "
                                + "<G> - Gravar\n "
                                + "<C> - Consultar\n "
                                + "<M> - Mudar Area").toUpperCase().charAt(0);
                if (op=='G'){
                    dao = new CentroCustoDAO();
                    CentroCusto obj = new CentroCusto();
                    obj.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo da area: ")));
                    obj.setNomeArea(JOptionPane.showInputDialog("Digite o Nome da area: "));
                    obj.setGestor(JOptionPane.showInputDialog("Digite o Nome do gestor da area: "));
                    System.out.println(dao.gravar(obj));

                }else if (op=='C'){
                    dao = new CentroCustoDAO();
                    CentroCusto cc = dao.getCodigo(Integer.parseInt(JOptionPane.showInputDialog("Codigo: ")));
                    System.out.println("Codigo da area: " + cc.getCodigo());
                    System.out.println("Nome da area: " + cc.getNomeArea());
                    System.out.println("Nome do gestor da area: " + cc.getGestor());


                }else if (op=='M'){
                    dao = new CentroCustoDAO();
                    int x = dao.mudarArea(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: ")));
                    System.out.println(x + "Area foi(s) foi(ram) atualizado(s)");

                }else{
                    System.out.println("Opção inválida!!!");
                }
            }while(JOptionPane.showConfirmDialog
                    (null, "Continuar?", "CentroCustoDAO",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE)==0);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                dao.fechar();
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }

}


