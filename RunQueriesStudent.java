import java.sql.*; 
import java.lang.Exception;
import java.util.regex.*;

public class RunQueriesStudent {
    public static void createTicket(String q) {
 
        Connection conn = null;
        try 
        {
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sys as SYSDBA";
            String password = "GAPS";
            conn = DriverManager.getConnection(dbURL, username, password);
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (conn != null && !conn.isClosed()) 
                {
                    Statement stmt=conn.createStatement();
                    stmt.executeQuery(q);
                }
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
    }
   
    public static String changePasswordTo(String u,String c, String n) {
        Connection conn = null;
        System.out.print(u+c+n);
        try 
        {
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sys as SYSDBA";
            String password = "GAPS";
            conn = DriverManager.getConnection(dbURL, username, password);
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (conn != null && !conn.isClosed()) 
                {
                    if(!isValidPassword(n))
                        return "<html>Invalid, use:<br>1. 8-20 Letters<br>2. Capital and Small letters<br>3. Digits";
                    Statement stmt=conn.createStatement();
                    ResultSet rs=stmt.executeQuery("select password from login where userid='"+u+"'");
                    rs.next();
                    if((c.toString()).equals(rs.getString("password")))
                    {
                        stmt=conn.createStatement();
                        stmt.executeQuery("update login set password ='"+n+"' where userid='"+u+"'");
                        return "UPDATED!!";
                    }
                    else 
                    {
                        return "<html>Incorrect <br>Current Password";
                    }
                }
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        return "ERROR";
    }
    public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
