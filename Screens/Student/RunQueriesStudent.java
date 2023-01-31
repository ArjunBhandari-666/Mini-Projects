import javax.swing.BorderFactory;
// import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import java.lang.Exception;
import java.util.regex.*;
public class RunQueriesStudent {
    public static void runQuery(String q) {
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
    public static void AllTickets(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        JPanel jp=new JPanel();
        ResultSet rs=seeTicketsStudent(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                TV.add(seeTicketsStudent(rs.getString("ticketid"),"TITLE : "+rs.getString("title"),"Description : "+rs.getString("description"),"STATUS : "+rs.getString("status"),u));
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
        jp.setOpaque(false);
        jp.setBackground(new Color(0,0,0));
        TitledBorder b=BorderFactory.createTitledBorder("All Tickets");
        b.setTitleColor(new Color(0,0,0));
        jp.setBorder(b);
    }
    public static JPanel seeTicketsStudent(String ticketid,String title, String desc, String status,String u)
    {
        JPanel Ticket=new JPanel();
        JLabel TicketID=new JLabel(),Title=new JLabel(),Status=new JLabel(),Description=new JLabel();
        JButton Discard=new JButton(),Refresh=new JButton();
        Ticket.setBackground(new java.awt.Color(51, 51, 255));
        Ticket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        TicketID.setFont(new java.awt.Font("Segoe UI", 0, 18));
        TicketID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketID.setText("TICEKT ID : #"+ticketid);
        TicketID.setOpaque(true);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(title);
        Title.setOpaque(true);

        Discard.setBackground(new java.awt.Color(255, 255, 102));
        Discard.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Discard.setText("DISCARD");
        Discard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(status.equalsIgnoreCase("Resolved"))
                    RunQueriesStudent.runQuery("update ticket set userid='"+u+"-a' where ticketid ='"+ticketid+"'");
                else
                    RunQueriesStudent.runQuery("update ticket set userid='"+u+"-d' where ticketid ='"+ticketid+"'");
            }
        });

        Refresh.setBackground(new java.awt.Color(255, 255, 102));
        Refresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Refresh.setText("REFRESH");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunQueriesStudent.runQuery("update ticket set status='Pending' where ticketid ='"+ticketid+"'");
            }
        });

        Status.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText(status);
        Status.setOpaque(true);

        Description.setBackground(new java.awt.Color(0, 0, 255));
        Description.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Description.setForeground(new java.awt.Color(255, 255, 255));
        Description.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Description.setText(desc);
        Description.setOpaque(true);
        if(status.equalsIgnoreCase("STATUS : "+"Pending"))
        {    
            Status.setBackground(new java.awt.Color(255, 255, 0));
            TicketID.setBackground(new java.awt.Color(255, 255, 0));
            Title.setBackground(new java.awt.Color(255, 255, 0));
        }
        else if(status.equalsIgnoreCase("STATUS : "+"Accepted"))
        {    
            Status.setBackground(new java.awt.Color(0,0,255));
            TicketID.setBackground(new java.awt.Color(0,0,255));
            Title.setBackground(new java.awt.Color(0,0,255));
        }
        else if(status.equalsIgnoreCase("STATUS : "+"Acknowledged"))
        {    
            Status.setBackground(new java.awt.Color(255, 127, 0));
            TicketID.setBackground(new java.awt.Color(255, 127, 0));
            Title.setBackground(new java.awt.Color(255, 127, 0));
        }
        else if(status.equalsIgnoreCase("STATUS : "+"Resolved"))
        {    
            Status.setBackground(new java.awt.Color(0,255,0));
            TicketID.setBackground(new java.awt.Color(0,255,0));
            Title.setBackground(new java.awt.Color(0,255,0));
            Refresh.setText("REJECT");
            Discard.setText("ACCEPT");
            Refresh.setBackground(new java.awt.Color(255,0,0));
            Discard.setBackground(new java.awt.Color(0,255,0));
        }
        else if(status.equalsIgnoreCase("STATUS : "+"Rejected"))
        {    
            Status.setBackground(new java.awt.Color(255, 0, 0));
            TicketID.setBackground(new java.awt.Color(255, 0, 0));
            Title.setBackground(new java.awt.Color(255, 0, 0));
        }
 
        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(Discard, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TicketLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(TicketLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Discard, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(TicketID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        return Ticket;
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
                    ResultSet rs=stmt.executeQuery("select ticketid,title,description,status from ticket where userid='"+u+"'");
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

