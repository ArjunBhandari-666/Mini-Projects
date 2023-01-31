
public class ErrorScreen extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ErrorScreen(String message) {
        initComponents(message);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ErrorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               setVisible(true);
            }
        });
    }                        
    private void initComponents(String message) {

        TopPadding1 = new javax.swing.JLabel();
        setTitle("Error");
        setBackground(new java.awt.Color(135, 206, 235));
        setResizable(false);

        TopPadding1.setBackground(new java.awt.Color(255, 204, 204));
        TopPadding1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TopPadding1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TopPadding1.setText(message);
        TopPadding1.setAlignmentY(0.0F);
        TopPadding1.setIconTextGap(0);
        TopPadding1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPadding1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPadding1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }                 
    public javax.swing.JLabel TopPadding1;          
}
