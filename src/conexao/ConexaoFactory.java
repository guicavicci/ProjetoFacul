package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
    
    public Connection conectar () throws Exception {
        
       return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm73759","150297");
       //return DriverManager.getConnection("jdbc:mysql://localhost:3306/testegui","gneves","root");
    }

}


