import java.sql.*; 
import java.lang.Exception;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class SuperQueries {
    public static void getOptions(String u,javax.swing.JComboBox<String> JCB)
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
                    
                        JCB.removeAllItems();
                        JCB.setSize(JCB.getPreferredSize());
                        ResultSet rs=stmt.executeQuery("select ticketid from ticket where ssn='"+u+"'");
                        while(rs.next())
                        {
                            JCB.addItem(rs.getString("ticketid"));
                        }
                        JCB.setSize(JCB.getPreferredSize());
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
    public static JPanel TicketCard(String tid,String title, String desc, String status)
    {
        JPanel Ticket=new JPanel();
        JLabel TicketID=new JLabel(),Title=new JLabel(),Description=new JLabel(),Status=new JLabel();
        Ticket.setBackground(new java.awt.Color(255, 255, 153));

        TicketID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TicketID.setForeground(new java.awt.Color(102, 102, 102));
        TicketID.setText(tid);

        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(title);

        Description.setText(desc);

        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText(status);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TicketID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        return Ticket;
    }
    public static ResultSet seeTickets(String u){
 
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
                    // String tid,String title, String desc, String status
                    ResultSet rs=stmt.executeQuery("select ticketid,title,description,status from Ticket where ssn='"+u+"'");
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
    public static void AllTicketsAssigned(String u,JPanel TV)
    {
        javax.swing.GroupLayout ViewPortLayout = new javax.swing.GroupLayout(TV);
                TV.setLayout(ViewPortLayout);
                ViewPortLayout.setHorizontalGroup(
                    ViewPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                );
                ViewPortLayout.setVerticalGroup(
                    ViewPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                );
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=seeTickets(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                // String SSN,String name, String Status, String email,String Phno,String dept
                TV.add(TicketCard(rs.getString("ticketid"),rs.getString("title"),rs.getString("description"),rs.getString("status")));
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
}
