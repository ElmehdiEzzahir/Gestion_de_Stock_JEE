package Connection;
import java.sql.*;

public class SelectOP {
    public static ResultSet getData(String query){
    Connection con= null;
    Statement st=null;
    ResultSet rs=null;
    try{
    con=DBconnection.createCon();
    st=con.createStatement();
    rs=st.executeQuery(query);
    return rs;
    }
    catch(Exception e){ System.out.println(e);
    return null;}

}	
}

