package bo;

import beans.CentroCusto;
import dao.CentroCustoDAO;


public class CentroCustoBO {

    public static String fecharConexao () throws Exception {
        CentroCustoDAO dao = new CentroCustoDAO ();
        dao.fechar();
        return "Conexao Fechada";
    }
    public static String adicionarNovaArea(CentroCusto cc)throws Exception{
        if (cc.getNomeArea().length()>40){
            return "Excedeu a quantidade de caracteres";
        }

        CentroCustoDAO dao = new CentroCustoDAO();
        if (dao.getCodigo(cc.getCodigo()).getCodigo()>0){
            dao.fechar();
            return "Este numero ja existe";
        }
        String x = dao.gravar(cc);
        dao.fechar();
        return x;
    }

    public static CentroCusto consultarPorcodigo(int pCentroCusto) throws Exception{
        if(pCentroCusto < 1){
            return new CentroCusto();
        }
        CentroCustoDAO dao = new CentroCustoDAO();
        CentroCusto objeto = dao.getCodigo(pCentroCusto);
        dao.fechar();
        return objeto;
    }

    public static String TrocarArea(String x, int y) throws Exception {
    if (x.indexOf("*") > 0 || x.indexOf("%") > 0) {
    	return "Invalido!";
    	
    }
    CentroCustoDAO dao = new CentroCustoDAO();
      int p = dao.mudarArea(x, y);
      return p + "Linhas atualiadas";
    }

    public static String deletarCentroCusto (int codigo) throws Exception {

        if(codigo < 1) {
            return "Digite um codigo valido.";

        }
        CentroCustoDAO dao = new CentroCustoDAO();
        int z = dao.delete(codigo);
        return z + "Deletado com sucesso.";
    }


}


