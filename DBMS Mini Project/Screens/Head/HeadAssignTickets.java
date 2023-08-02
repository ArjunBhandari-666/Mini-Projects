public class HeadAssignTickets extends javax.swing.JFrame {

    public HeadAssignTickets(String u) {
        initComponents(u);
    }                
    private void initComponents(String u) {

        SignOut = new javax.swing.JButton();
        StdDetails = new javax.swing.JButton();
        ViewHist = new javax.swing.JButton();
        EmpDetails = new javax.swing.JButton();
        EmpSSNbox = new javax.swing.JComboBox<>();
        TicketIDbox = new javax.swing.JComboBox<>();
        AssignButton = new javax.swing.JButton();
        UserName = new javax.swing.JLabel();
        ViewPane = new javax.swing.JScrollPane();
        TicketViewPanel = new javax.swing.JPanel();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        SignOut.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\SignOutButton.png"));
        SignOut.setBorder(null);
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login.main(null);
                dispose();
            }
        });

        StdDetails.setBackground(new java.awt.Color(35, 29, 118));
        StdDetails.setForeground(new java.awt.Color(255, 255, 255));
        StdDetails.setText("STD Details");
        StdDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadViewSTD.main(u);
                dispose();
            }
        });

        ViewHist.setBackground(new java.awt.Color(35, 29, 118));
        ViewHist.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        ViewHist.setForeground(new java.awt.Color(255, 255, 255));
        ViewHist.setText("View History");
        ViewHist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadCommentHistory.main(u);
                dispose();
            }
        });

        EmpDetails.setBackground(new java.awt.Color(35, 29, 118));
        EmpDetails.setForeground(new java.awt.Color(255, 255, 255));
        EmpDetails.setText("EMP Details");
        EmpDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadViewEmp.main(u);
                dispose();
            }
        });

        EmpSSNbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        EmpSSNbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "#EMP SSN" }));
        RunQueriesHead.getOptions(u,"ssn",EmpSSNbox);

        TicketIDbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        TicketIDbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "#TICKET ID" }));
        RunQueriesHead.getOptions(u,"ticketid",TicketIDbox);

        AssignButton.setBackground(new java.awt.Color(244, 116, 88));
        AssignButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        AssignButton.setForeground(new java.awt.Color(255, 255, 255));
        AssignButton.setText("ASSIGN");
        AssignButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AssignButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RunQueriesHead.runQuery("update ticket set ssn='"+EmpSSNbox.getSelectedItem().toString()+"',status='Assigned' where ticketid="+TicketIDbox.getSelectedItem().toString());
                HeadCommentHistory.main(u);
                dispose();
            }
        });

        UserName.setFont(new java.awt.Font("Segoe UI", 0, 36)); 
        UserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserName.setText(u);

        ViewPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ViewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TicketViewPanel.setBackground(new java.awt.Color(35, 29, 118));
        TicketViewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        javax.swing.GroupLayout TicketViewPanelLayout = new javax.swing.GroupLayout(TicketViewPanel);
        TicketViewPanel.setLayout(TicketViewPanelLayout);
        TicketViewPanelLayout.setHorizontalGroup(
            TicketViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        TicketViewPanelLayout.setVerticalGroup(
            TicketViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        RunQueriesHead.AllTickets(u, TicketViewPanel);
        ViewPane.setViewportView(TicketViewPanel);

        BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\Head-AssignTicket.png")); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1730, 1730, 1730)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewHist, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StdDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(TicketIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1390, 1390, 1390)
                .addComponent(EmpSSNbox, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1530, 1530, 1530)
                .addComponent(AssignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(ViewHist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(EmpDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(StdDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TicketIDbox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(EmpSSNbox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(640, 640, 640)
                .addComponent(AssignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
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
                new HeadAssignTickets(u).setVisible(true);
            }
        });
    }
    private javax.swing.JButton AssignButton;
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton EmpDetails;
    private javax.swing.JComboBox<String> EmpSSNbox;
    private javax.swing.JButton SignOut;
    private javax.swing.JButton StdDetails;
    private javax.swing.JComboBox<String> TicketIDbox;
    private javax.swing.JPanel TicketViewPanel;
    private javax.swing.JLabel UserName;
    private javax.swing.JButton ViewHist;
    private javax.swing.JScrollPane ViewPane;      
}
