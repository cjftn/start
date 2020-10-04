
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cjftn
 */
public class sqlDB {
    Connection con=null;
    public sqlDB() {
        System.out.println("dbConnect() 호출됨");
        try {
            System.out.println("000");
            String url =  "jdbc:sqlserver://127.0.0.1:1433;databaseName=projectA;user=sa;password=gameGC";            
            System.out.println(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("1111");
            con = DriverManager.getConnection(url);
            System.out.println("222");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dbConnect 성공!");
    }
    public ArrayList select(String Gname) throws SQLException{
        Statement st=con.createStatement();
        ResultSet re=st.executeQuery("select * from game where game_name like '"+Gname+"%' order by count desc;");
        int a=1;
        int i=0;
         String[] st1 =new String[1000];
        ArrayList ar=new ArrayList();
        while (re.next()) {
           i++;
            System.out.println(re.getString(a));
            st1[i]=(re.getString(a));
            System.out.println(re.getString(a+1));
            st1[i+1]=(re.getString(a+1));
            System.out.println(re.getInt(a+2));
            st1[i+2]=(re.getString(a+2));
            ar.add(st1[i]+" "+st1[i+1]+"  점수 : "+st1[i+2]);
        }
        
//        ArrayList st1=new ArrayList();
//        ArrayList ar=new ArrayList();
//        while (re.next()) {
//           i++;
//            System.out.println(re.getString(a));
//            st1.add(re.getString(a));
//            System.out.println(re.getString(a+1));
//            st1.add(re.getString(a+1));
//            System.out.println(re.getInt(a+2));
//            st1.add(re.getString(a+2));
//            ar.add(st1.get(i)+" "+st1.get(i+1)+"  점수 : "+st1.get(i+2));
//        }
        System.out.println("print end");
        return ar;
    }
    public ArrayList print() throws SQLException{
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select * from game order by count desc;");
        int a=1;
        int i=0;
        String[] st =new String[1000];
        ArrayList ar=new ArrayList();
        while (res.next()) {
           i++;
            System.out.println(res.getString(a));
            st[i]=(res.getString(a));
            System.out.println(res.getString(a+1));
            st[i+1]=(res.getString(a+1));
            System.out.println(res.getInt(a+2));
            st[i+2]=(res.getString(a+2));
            ar.add(st[i]+" "+st[i+1]+"  점수 : "+st[i+2]);
        }
        System.out.println("print end");
        return ar;
    }
    public void input(String name,String name2, int count) throws SQLException{
        try {
            Statement st=con.createStatement();
            System.out.println("inpu start");
            boolean re=st.execute("insert into game(game_name,user_name,count) values ('"+name+"','"+name2+"',"+count+");");
            st.execute("commit;");
            System.out.println("inpu 2"+re);
//            for (int i = 1;  re.next(); i++) {
//                System.out.println(re.getString(i));
//            }
            System.out.println("input end");
            
        
        } catch (SQLException ex) {
            Logger.getLogger(sqlDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
    }
    
    
}
