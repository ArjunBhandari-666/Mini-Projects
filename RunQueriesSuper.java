import java.sql.*; 
import java.lang.Exception;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class RunQueriesSuper {
    public static JPanel TicketCard(String tid,String title, String desc, String status)
    {
        JPanel Ticket=new JPanel();
        JLabel TID=new JLabel(),Title=new JLabel(),Desc=new JLabel(),Status=new JLabel();
        Ticket.setBackground(new java.awt.Color(255, 255, 153));

        TID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TID.setForeground(new java.awt.Color(102, 102, 102));
        TID.setText(tid);

        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(title);

        Desc.setText(desc);

        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText(status);

        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TID, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Desc, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TID, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Desc, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
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
    
}