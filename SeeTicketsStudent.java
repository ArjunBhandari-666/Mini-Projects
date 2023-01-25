import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import java.awt.*;
import java.sql.*; 
import java.lang.Exception;
class TicketViewClass extends JFrame
{
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
        JButton Discard=new JButton(),Refresh=new JButton(),SeeDetails=new JButton();
        Ticket.setBackground(new java.awt.Color(102, 102, 255));
        Ticket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

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
                    RunQueriesStudent.createTicket("update ticket set userid='"+u+"-a' where ticketid ='"+ticketid+"'");
                else
                    RunQueriesStudent.createTicket("update ticket set userid='"+u+"-d' where ticketid ='"+ticketid+"'");
            }
        });

        Refresh.setBackground(new java.awt.Color(255, 255, 102));
        Refresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Refresh.setText("REFRESH");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunQueriesStudent.createTicket("update ticket set status='Pending' where ticketid ='"+ticketid+"'");
            }
        });

        SeeDetails.setBackground(new java.awt.Color(255, 255, 102));
        SeeDetails.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        SeeDetails.setText("View Details");
        SeeDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //See Comments on ticket
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
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SeeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Discard, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Discard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
}