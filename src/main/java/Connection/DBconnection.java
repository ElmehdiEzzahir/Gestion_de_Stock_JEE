package Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	  static Connection Con;
      private DBconnection(){
          ConnectDB();
      }
  
  public static Connection ConnectDB(){
      try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
          System.out.println("ConnectDB");

          return con;
      }
      catch(Exception e){
          System.out.println(e);
      }
      return null;
  }
      public static Connection createCon(){
      if(Con == null){ 
          synchronized(DBconnection.class){
          if(Con == null){
           System.out.println("createCon");
           Con = DBconnection.ConnectDB();
           System.out.println(Con);

          }
          }

      }
         return Con;  
  }
	

}




