package bo;

import beans.CentroCusto;
import dao.CentroCustoDAO;

public class CentroCustoBO {
    public static String adicionarNovoCliente(CentroCusto cc) throws Exception{
        if (cc.getNomeArea().length()>40){
            return "Excedeu a quantidade de caracteres";
        
        }
        if(cc.getCodigo()>0){
            return "Numero inválido";
    
        }
        CentroCustoDAO dao = new CentroCustoDAO();
        String x = dao.gravar(cc);
        dao.fechar();
        return x;
    }

    public static CentroCusto consultarPorcodigo(int NumeroCentroCusto) throws Exception{
        if(NumeroCentroCusto < 1){
            return new CentroCusto();
        }
        CentroCustoDAO dao = new CentroCustoDAO();
        CentroCusto objeto = dao.getCodigo(NumeroCentroCusto);
        dao.fechar();
        return objeto;
    }
}

