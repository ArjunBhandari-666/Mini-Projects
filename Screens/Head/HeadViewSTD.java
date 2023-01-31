
public class HeadViewSTD extends javax.swing.JFrame {

    /**
     * Creates new form HeadCommentHistory
     */
    public HeadViewSTD(String u) {
        initComponents(u);
    }                    
    private void initComponents(String u) {

        AssignTickets = new javax.swing.JButton();
        ViewHIst = new javax.swing.JButton();
        ViewEMP = new javax.swing.JButton();
        ViewPane = new javax.swing.JScrollPane();
        TV = new javax.swing.JPanel();
        SignOut = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AssignTickets.setBackground(new java.awt.Color(35, 29, 118));
        AssignTickets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AssignTickets.setForeground(new java.awt.Color(255, 255, 255));
        AssignTickets.setText("Assign Tickets");
        AssignTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadAssignTickets.main(u);
                dispose();
            }
        });

        ViewHIst.setBackground(new java.awt.Color(35, 29, 118));
        ViewHIst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ViewHIst.setForeground(new java.awt.Color(255, 255, 255));
        ViewHIst.setText("Ticket History");
        ViewHIst.setToolTipText("");
        ViewHIst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadCommentHistory.main(u);
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
        
        SignOut.setBackground(new java.awt.Color(244, 116, 88));
        SignOut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SignOut.setForeground(new java.awt.Color(255, 255, 255));
        SignOut.setText("Sign Out");
        SignOut.setBorder(null);
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login.main(null);
                dispose();
            }
        });

        ViewPane.setBorder(null);
        ViewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TV.setBackground(new java.awt.Color(35, 29, 118));
        TV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout TVLayout = new javax.swing.GroupLayout(TV);
        TV.setLayout(TVLayout);
        TVLayout.setHorizontalGroup(
            TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1456, Short.MAX_VALUE)
        );
        TVLayout.setVerticalGroup(
            TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        RunQueriesHead.AllSTD(u, TV);
        ViewPane.setViewportView(TV);

        background.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\Head-ViewSTD.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1725, 1725, 1725)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewEMP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewHIst, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(ViewEMP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(ViewHIst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
        );

        pack();
    }                          

    /**
     * @param args the command line arguments
     */
    public static void main(String u) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HeadViewSTD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadViewSTD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadViewSTD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadViewSTD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeadViewSTD(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AssignTickets;
    private javax.swing.JButton SignOut;
    private javax.swing.JPanel TV;
    private javax.swing.JButton ViewEMP;
    private javax.swing.JButton ViewHIst;
    private javax.swing.JScrollPane ViewPane;
    private javax.swing.JLabel background;
    // End of variables declaration                   
}
