import java.sql.*; 
import java.lang.Exception;
// import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class RunQueriesHead
{
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

    public static void AllTickets(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=seeTickets(u);
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
        TicketCard.setBackground(new java.awt.Color(57, 44, 207));

        Date.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Date.setText(date.toString());
        Date.setBorder(new javax.swing.border.MatteBorder(null));

        TicketID.setBackground(new java.awt.Color(102, 102, 255));
        TicketID.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        TicketID.setForeground(new java.awt.Color(153, 153, 153));
        TicketID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketID.setText("#"+ticketid);
        TicketID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        TicketID.setOpaque(true);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(title);
        Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Status.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText(status);
        Status.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout TicketCardLayout = new javax.swing.GroupLayout(TicketCard);
        TicketCard.setLayout(TicketCardLayout);
        TicketCardLayout.setHorizontalGroup(
            TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketCardLayout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TicketCardLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(TicketID, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(719, Short.MAX_VALUE)))
            .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketCardLayout.createSequentialGroup()
                    .addContainerGap(269, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        TicketCardLayout.setVerticalGroup(
            TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketCardLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TicketCardLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TicketID, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(TicketCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TicketCardLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );
        return TicketCard;
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
    public static void SeeComments(String tid,JPanel TV)
    {
        ResultSet rs=seeComment(tid);
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                TV.add(seeCommentCard(rs.getString("ssn"),rs.getString("comments"),rs.getString("status"),rs.getDate("datemade")));
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
    public static ResultSet seeComment(String tid){
 
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
                    ResultSet rs=stmt.executeQuery("select tc.ssn,tc.comments,t.status,tc.datemade from ticket_comments tc,ticket t where tc.ticketid='"+tid+"' and t.ticketid='"+tid+"'");
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
    public static JPanel seeCommentCard(String ssn,String comments, String status,java.sql.Date date)
    {
        
        JLabel SSN = new javax.swing.JLabel();
        JLabel Comment = new javax.swing.JLabel();
        JLabel Status = new javax.swing.JLabel();
        JLabel Date = new javax.swing.JLabel();
        JPanel Card=new JPanel();
        SSN.setText("#"+ssn);
        Comment.setText(comments);
        Status.setText(status);
        Date.setText(date.toString());

        Card.setBackground(new java.awt.Color(57, 44, 207));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SSN.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        SSN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SSN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        Comment.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Comment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Comment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Status.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        javax.swing.GroupLayout CardLayout = new javax.swing.GroupLayout(Card);
        Card.setLayout(CardLayout);
        CardLayout.setHorizontalGroup(
            CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SSN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Comment, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addGroup(CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CardLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CardLayout.setVerticalGroup(
            CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SSN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CardLayout.createSequentialGroup()
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        return Card;
    }

    public static void AllEMP(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=FetchEmpDetails(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                TV.add(addEmp(rs.getString("ssn"),rs.getString("name"),rs.getString("status")));
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
    public static void AllSTD(String u,JPanel TV)
    {
        TV.removeAll();
        TV.setLayout(new BoxLayout(TV,BoxLayout.Y_AXIS));
        ResultSet rs=FetchStdDets(u);
        TV.add(Box.createRigidArea(new Dimension(5, 18)));
        try 
        {
            while(rs.next())
            {
                TV.add(addEmp(rs.getString("usn"),rs.getString("name"),rs.getString("status")));
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
    public static JPanel addEmp(String ssn,String name, String status)
    {
        JPanel Card=new JPanel();
        JLabel SSN=new JLabel(),NAME=new JLabel(),STATUS=new JLabel();
        Card.setBackground(new java.awt.Color(57, 44, 207));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SSN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        SSN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SSN.setText("SSN : "+ssn);
        SSN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        NAME.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAME.setText("Name : "+name);
        NAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        STATUS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        STATUS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STATUS.setText("STATUS : "+status);
        STATUS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout CardLayout = new javax.swing.GroupLayout(Card);
        Card.setLayout(CardLayout);
        CardLayout.setHorizontalGroup(
            CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SSN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CardLayout.setVerticalGroup(
            CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(STATUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NAME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SSN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );
        return Card;
    }
    

    public static ResultSet FetchEmpDetails(String u){
 
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
                    ResultSet rs=stmt.executeQuery("select ssn,name,status from emp where dept_no in (select dept_no from EMP where ssn = '"+u+"')");
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

    public static ResultSet FetchStdDets(String u){
 
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
}