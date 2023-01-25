import java.sql.*; 
public class CheckPassword {
 
    public static boolean password(String user,String pass) {
 
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
                    String str="select userid,password from login";
                    ResultSet rs = stmt.executeQuery(str);
                    String u="";
                    String p="";
                    while (rs.next()) 
                    {
                        u=rs.getString("userid");
                        p=rs.getString("password");
                        if(user.equals(u)&&pass.equals(p))
                            return true;
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
        return false;
    }

    public static String userRole(String user) {
        if(user.length()==10){
            return "Student";
        }
        else if(user.length()==8){
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
                        String str="select head_ssn from dept";
                        ResultSet rs = stmt.executeQuery(str);
                        String ssn="";
                        while (rs.next()) 
                        {
                            ssn=rs.getString("head_ssn");
                            if(user.equals(ssn))
                                return "Head";
                        }
                        str="select ssn from EMP";
                        rs = stmt.executeQuery(str);
                        ssn="";
                        while (rs.next()) 
                        {
                            ssn=rs.getString("ssn");
                            if(user.equals(ssn))
                                return "Super";
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
        }
        return "NA";
    }
}