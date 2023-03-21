package Connection;
import java.sql.*;
public class Transactions {
		public static Boolean IsValid;
    public static void DATA(String Query,String result) {
        Connection con= null;
        Statement st=null;
        IsValid=true;
        try{
    
        con=DBconnection.createCon();
        st=con.createStatement();
        st.executeUpdate(Query);
        if (!result.equals(""))
                     System.out.println(result);

        }
        catch(Exception e){
            IsValid=false;
        	System.out.println(e);
        	}
    }
}
