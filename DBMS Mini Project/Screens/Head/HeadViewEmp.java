import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author arjun
 */
public class HeadViewEmp extends javax.swing.JFrame {

    /**
     * Creates new form HeadCommentHistory
     */
    public HeadViewEmp(String u) {
        initComponents(u);
    }               
    private void initComponents(String u) {

        AssignTickets = new javax.swing.JButton();
        TicketHistory = new javax.swing.JButton();
        ViewSTD = new javax.swing.JButton();
        ViewPane = new javax.swing.JScrollPane();
        SignOut = new javax.swing.JButton();
        TV=new JPanel();
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

        TicketHistory.setBackground(new java.awt.Color(35, 29, 118));
        TicketHistory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TicketHistory.setForeground(new java.awt.Color(255, 255, 255));
        TicketHistory.setText("Ticket History");
        TicketHistory.setToolTipText("");
        TicketHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadCommentHistory.main(u);
                dispose();
            }
        });

        ViewSTD.setBackground(new java.awt.Color(35, 29, 118));
        ViewSTD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ViewSTD.setForeground(new java.awt.Color(255, 255, 255));
        ViewSTD.setText("View STD");
        ViewSTD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeadViewSTD.main(u);
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
        RunQueriesHead.AllEMP(u, TV);
        ViewPane.setViewportView(TV);

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

        background.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Head\\Head-ViewEMP.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1725, 1725, 1725)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(TicketHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
            
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(TicketHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(AssignTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(ViewSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(ViewPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(background)
        );

        pack();
    }// </editor-fold>                         

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
            java.util.logging.Logger.getLogger(HeadViewEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadViewEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadViewEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadViewEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeadViewEmp(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AssignTickets;
    private javax.swing.JButton SignOut;
    private javax.swing.JPanel TV;
    private javax.swing.JButton TicketHistory;
    private javax.swing.JScrollPane ViewPane;
    private javax.swing.JButton ViewSTD;
    private javax.swing.JLabel background;
    // End of variables declaration                   
}
