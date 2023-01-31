import javax.swing.*;
import java.awt.event.*;  

class Login extends JFrame implements ActionListener   {

    public Login() {
        initComponents();
    }                      
    private void initComponents() {

        Password = new javax.swing.JPasswordField();
        Username = new javax.swing.JTextField();
        LOGIN = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Password.setBackground(new java.awt.Color(81,75,150));
        Password.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Password.setBorder(null);
        Password.setOpaque(false);

        Username.setBackground(new java.awt.Color(81,75,150));
        Username.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Username.setBorder(null);
        Username.setOpaque(false);

        LOGIN.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Login\\Login Button.png"));
        LOGIN.setBorder(null);
        LOGIN.addActionListener(this);

        BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Login\\Login.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
            .addGroup(layout.createSequentialGroup()
                .addGap(700, 700, 700)
                .addComponent(LOGIN))
        );
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        pack();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }               
    public void actionPerformed(ActionEvent ae)
    {  
        boolean auth=CheckPassword.password(new String(Password.getPassword()),Username.getText());
        if(auth==true){
            String userRole=CheckPassword.userRole(Username.getText());
            if(userRole.equalsIgnoreCase("Student")){
                new LoggedIn(userRole,Username.getText());
                dispose();
            }
            else if(userRole.equalsIgnoreCase("Head")){
                new LoggedIn(userRole,Username.getText());
                dispose();
            }
            else if(userRole.equalsIgnoreCase("Super")){
                new LoggedIn(userRole,Username.getText());
                dispose();
            }
        }
        else{
            Password.setText("");
            Username.setText("");
            LOGIN.setText("AGAIN");
        }
    }  
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton LOGIN;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;  
}
