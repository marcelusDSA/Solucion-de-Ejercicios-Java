import edu.upc.dsa.MySQLTablaPieces;
import edu.upc.dsa.MySQLprovides;
import edu.upc.dsa.MySQLtablaComment;
import edu.upc.dsa.PapaBD;
import org.junit.Test;

/**
 * Created by marcelus on 1/10/15.
 */
public class TestSQLclass {
    @Test
    public void test () throws Exception{
        //MySQLtablaComment dao = new MySQLtablaComment();
       // dao.readDataBase();
        PapaBD papaBD = new MySQLtablaComment();
        PapaBD papaBD1 =new MySQLTablaPieces();
        PapaBD papaBD2 = new MySQLprovides();

            papaBD.readDataBase();
            papaBD1.readDataBase();
            papaBD2.readDataBase();

    }
}


