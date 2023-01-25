import java.sql.*; 
import java.lang.Exception;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class RunQueriesHead {
    public static JPanel seeEMPStatusHead(String SSN,String name, String Status, String email,String Phno,String dept)
    {
        JPanel Ticket=new JPanel();
        JLabel ssn=new JLabel(),Name=new JLabel(),Stats=new JLabel(),Email=new JLabel(),Phone=new JLabel();
        JLabel deptno=new JLabel();
        Ticket.setBackground(new java.awt.Color(255, 255, 204));

        ssn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ssn.setForeground(new java.awt.Color(102, 102, 102));
        ssn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ssn.setText(SSN);

        Name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Name.setText(name);

        Stats.setBackground(new java.awt.Color(204, 255, 204));
        Stats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Stats.setText(Status);
        Stats.setOpaque(true);

        Email.setText(email);

        Phone.setText(Phno);

        deptno.setBackground(new java.awt.Color(255, 204, 102));
        deptno.setText(dept);
        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ssn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(Stats, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deptno, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ssn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Stats, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Phone))
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deptno, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))))
                .addContainerGap())
        );
        return Ticket;
    }
    public static ResultSet seeEMP(String u){
 
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
                    // String SSN,String name, String Status, String email,String Phno,String dept
                    ResultSet rs=stmt.executeQuery("select ssn,name,status,email,phno,dept_no from emp where dept_no in (select dept_no from EMP where ssn = '"+u+"')");
                    return rs;
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
        return null;
    }
    public static ResultSet seeSTD(String u){
 
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
                    // String SSN,String name, String Status, String email,String Phno,String dept
                    ResultSet rs=stmt.executeQuery("select usn,name,status,email,phno,roomno from student where roomno in (select roomno from rooms where branch in (select branch from rooms where roomno in(select roomno from dept where head_ssn = '"+u+"')))");
                    return rs;
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
        return null;
    }
    public static void AllEMPStatus(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=seeEMP(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                // String SSN,String name, String Status, String email,String Phno,String dept
                TV.add(seeEMPStatusHead(rs.getString("ssn"),rs.getString("name"),rs.getString("status"),rs.getString("email"),rs.getString("phno"),rs.getString("dept_no")));
                TV.add(Box.createRigidArea(new Dimension(5, 18)));
            }
            if(!(rs.getFetchSize()>=1))
                TV.add(new JLabel("No tickets, create one",SwingConstants.CENTER));
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
    public static void AllSTDStatus(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=seeSTD(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                // String SSN,String name, String Status, String email,String Phno,String dept
                TV.add(seeEMPStatusHead(rs.getString("USN"),rs.getString("name"),rs.getString("status"),rs.getString("email"),rs.getString("phno"),rs.getString("Roomno")));
                TV.add(Box.createRigidArea(new Dimension(5, 18)));
            }
            if(!(rs.getFetchSize()>=1))
                TV.add(new JLabel("No tickets, create one",SwingConstants.CENTER));
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
    public static void getOptions(String u,String topic,javax.swing.JComboBox<String> JCB)
    {
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
                    if(topic.equalsIgnoreCase("ssn"))
                    {
                        JCB.removeAllItems();
                        JCB.setSize(JCB.getPreferredSize());
                        ResultSet rs=stmt.executeQuery("select ssn from EMP where dept_no in (select dept_no from EMP where ssn='"+u+"')");
                        while(rs.next())
                        {
                            JCB.addItem(rs.getString("ssn"));
                        }
                        JCB.setSize(JCB.getPreferredSize());
                    }
                    else if(topic.equalsIgnoreCase("ticketid"))
                    {
                        JCB.removeAllItems();
                        JCB.setSize(JCB.getPreferredSize());
                        ResultSet rs=stmt.executeQuery("select ticketid from ticket where deptid in (select dept_no from EMP where ssn = '"+u+"') order by case when status ='Pending' then '000'||status when status='Resolved' then 'ZZZ'||status else status end");
                        while(rs.next())
                        {
                            JCB.addItem(rs.getString("ticketid"));
                        }
                        JCB.setSize(JCB.getPreferredSize());
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

class TicketViewClassHead extends JFrame
{
    public static void AllTickets(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=seeTicketsStudent(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                TV.add(seeTicketsHead(rs.getString("ticketid"),rs.getString("title"),rs.getDate("lastmodtime"),rs.getString("status"),u));
                TV.add(Box.createRigidArea(new Dimension(5, 18)));
            }
            if(!(rs.getFetchSize()>=1))
                TV.add(new JLabel("No tickets, create one",SwingConstants.CENTER));
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
    public static JPanel seeTicketsHead(String ticketid,String title, java.sql.Date date, String status,String u)
    {
        JPanel TicketCard=new JPanel();
        JLabel TicketID=new JLabel(),Title=new JLabel(),Status=new JLabel(),Date=new JLabel();
        TicketCard.setBackground(new java.awt.Color(204, 204, 255));

        TicketID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TicketID.setForeground(new java.awt.Color(153, 153, 153));
        TicketID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketID.setText("#"+ticketid);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title.setText(title);

        Status.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Status.setText(status);
        Status.setToolTipText("");

        Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Date.setText(date.toString());
        javax.swing.GroupLayout TicketCardLayout = new javax.swing.GroupLayout(TicketCard);
        TicketCard.setLayout(TicketCardLayout);
        TicketCardLayout.setHorizontalGroup(
            TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketCardLayout.createSequentialGroup()
                .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TicketCardLayout.createSequentialGroup()
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        TicketCardLayout.setVerticalGroup(
            TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TicketID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TicketCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return TicketCard;
    }


    
    

    public static ResultSet seeTicketsStudent(String u){
 
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
                    ResultSet rs=stmt.executeQuery("select ticketid,title,lastmodtime,status from ticket where deptid in (select dept_no from EMP where ssn = '"+u+"') order by case when status ='Pending' then '000'||status when status='Resolved' then 'ZZZ'||status else status end");
                    return rs;
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
        return null;
    }
    
}