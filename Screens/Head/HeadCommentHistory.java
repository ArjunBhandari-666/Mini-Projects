
public class HeadCommentHistory extends javax.swing.JFrame {

    public HeadCommentHistory(String u) {
        initComponents(u);
    }                     
    private void initComponents(String u) {

        AssignTickets = new javax.swing.JButton();
        ViewEMP = new javax.swing.JButton();
        ViewSTD = new javax.swing.JButton();
        Check = new javax.swing.JButton();
        TicketIDbox = new javax.swing.JComboBox<>();
        ViewPane = new javax.swing.JScrollPane();
        CardPanel = new javax.swing.JPanel();
        SignOut = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AssignTickets.setBackground(new java.awt.Color(35, 29, 118));
        AssignTickets.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        AssignTickets.setForeground(new java.awt.Color(255, 255, 255));
        AssignTickets.setText("Assign Tickets");
        AssignTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadAssignTickets.main(u);
                dispose();
            }
        });

        ViewEMP.setBackground(new java.awt.Color(35, 29, 118));
        ViewEMP.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        ViewEMP.setForeground(new java.awt.Color(255, 255, 255));
        ViewEMP.setText("View Employee");
        ViewEMP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadViewEmp.main(u);
                dispose();
            }
        });

        ViewSTD.setBackground(new java.awt.Color(35, 29, 118));
        ViewSTD.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        ViewSTD.setForeground(new java.awt.Color(255, 255, 255));
        ViewSTD.setText("View STD");
        ViewSTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadViewSTD.main(u);
                dispose();
            }
        });

        Check.setBackground(new java.awt.Color(244, 116, 88));
        Check.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        Check.setForeground(new java.awt.Color(255, 255, 255));
        Check.setText("CHECK");
        Check.setBorder(null);
        Check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunQueriesHead.SeeComments(TicketIDbox.getSelectedItem().toString(), CardPanel);
                ViewPane.setBorder(null);
                ViewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                ViewPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                ViewPane.setViewportView(CardPanel);
                pack();
            }
        });
        CardPanel.setBackground(new java.awt.Color(35, 29, 118));
        CardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout CardPanelLayout = new javax.swing.GroupLayout(CardPanel);
        CardPanel.setLayout(CardPanelLayout);
        CardPanelLayout.setHorizontalGroup(
            CardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addContainerGap(80, Short.MAX_VALUE))
        );
        CardPanelLayout.setVerticalGroup(
            CardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addContainerGap(344, Short.MAX_VALUE))
        );

        TicketIDbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        TicketIDbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ticket ID #" }));
        RunQueriesHead.getOptions(u,"ticketid",TicketIDbox);

        ViewPane.setBorder(null);
        ViewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ViewPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ViewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ViewPane.setViewportView(CardPanel);

        SignOut.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\SignOutButton.png"));
        SignOut.setText("Sign Out");
        SignOut.setBorder(null);
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login.main(null);
                dispose();
            }
        });

        background.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\Head-ViewHistory.png")); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1725, 1725, 1725)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewEMP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1160, 1160, 1160)
                .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(TicketIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(ViewSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(590, 590, 590)
                .addComponent(ViewEMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(TicketIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
        );
        pack();
    }     

    public static void main(String u) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HeadCommentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadCommentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadCommentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadCommentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeadCommentHistory(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AssignTickets;
    private javax.swing.JPanel CardPanel;
    private javax.swing.JButton Check;
    private javax.swing.JButton SignOut;
    private javax.swing.JComboBox<String> TicketIDbox;
    private javax.swing.JButton ViewEMP;
    private javax.swing.JScrollPane ViewPane;
    private javax.swing.JButton ViewSTD;
    private javax.swing.JLabel background;
    // End of variables declaration                   
}
