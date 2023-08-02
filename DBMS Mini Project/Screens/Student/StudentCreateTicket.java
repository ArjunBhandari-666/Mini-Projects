import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
public class StudentCreateTicket extends javax.swing.JFrame {

    public StudentCreateTicket(String u) {
        initComponents(u);
    }
                      
    private void initComponents(String u) {

        ChangePass = new javax.swing.JButton();
        ViewTick = new javax.swing.JButton();
        CreateTick = new javax.swing.JButton();
        CREATE = new javax.swing.JButton();
        Department = new javax.swing.JComboBox<>();
        Title = new javax.swing.JComboBox<>();
        TextArea = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        SignOut = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChangePass.setBackground(new java.awt.Color(35, 29, 118));
        ChangePass.setFont(new java.awt.Font("Segoe UI", 0, 14));
        ChangePass.setForeground(new java.awt.Color(255, 255, 255));
        ChangePass.setText("Change Password");
        ChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Change Pass Screen
                JTextField CurrentPass = new javax.swing.JTextField();
                JPasswordField NewPass = new javax.swing.JPasswordField();
                JButton Change = new javax.swing.JButton();
                CurrentPass.setBackground(new java.awt.Color(81, 75, 150));
                CurrentPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                CurrentPass.setForeground(new java.awt.Color(255, 255, 255));
                CurrentPass.setBorder(null);

                NewPass.setBackground(new java.awt.Color(81, 75, 150));
                NewPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                NewPass.setForeground(new java.awt.Color(255, 255, 255));
                NewPass.setBorder(null);

                Change.setBackground(new java.awt.Color(244, 116, 88));
                Change.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                Change.setForeground(new java.awt.Color(255, 255, 255));
                Change.setText("CHANGE");
                Change.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        String msg=RunQueriesStudent.changePasswordTo(u,CurrentPass.getText(),new String(NewPass.getPassword()));
                        new ErrorScreen(msg);
                    }
                });
                BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Student\\Student-ChangePassword.png")); // NOI18N
                getContentPane().removeAll();
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1710, 1710, 1710)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(CurrentPass, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(NewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BackGround)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(430, 430, 430)
                        .addComponent(CurrentPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BackGround)
                );
            }
        });

        ViewTick.setBackground(new java.awt.Color(35, 29, 118));
        ViewTick.setFont(new java.awt.Font("Segoe UI", 0, 18));
        ViewTick.setForeground(new java.awt.Color(255, 255, 255));
        ViewTick.setText("View Ticket");
        ViewTick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                JScrollPane ScrollPane=new JScrollPane();
                JPanel TV=new JPanel();
                ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                TV.setBackground(new java.awt.Color(57, 44, 207));
                RunQueriesStudent.AllTickets(u, TV);
                ScrollPane.setViewportView(TV);

        BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Student\\Student-ViewTicket.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1710, 1710, 1710)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
        );

        pack();
            }
        });

        CreateTick.setBackground(new java.awt.Color(35, 29, 118));
        CreateTick.setFont(new java.awt.Font("Segoe UI", 0, 18));
        CreateTick.setForeground(new java.awt.Color(255, 255, 255));
        CreateTick.setText("Create Ticket");
        CreateTick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Student\\Student-CreateTicket.png"));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1060, 1060, 1060)
                        .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1210, 1210, 1210)
                        .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1710, 1710, 1710)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BackGround)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BackGround)
                );
            }
        });

        CREATE.setBackground(new java.awt.Color(244, 116, 88));
        CREATE.setFont(new java.awt.Font("Segoe UI", 0, 18));
        CREATE.setForeground(new java.awt.Color(255, 255, 255));
        CREATE.setText("CREATE");
        CREATE.setToolTipText("");
        CREATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String query="insert into ticket (userid,deptid,title,status,description) values ('"+u+"',";
                int deptid=0;
                if(Title.getItemCount()<2)
                {
                    new ErrorScreen("<html>You need to<br>SELECT DEPT<br>SELECT TITLE");
                    return;
                }
                if(Description.getText().length()<1)
                {
                    new ErrorScreen("<html>You need to<br>PROVIDE A DESCRIPTION");
                    return;
                }
                //"Campus","Maintainance","Lost and Found","Computer Sci","Info Sci","Mechanical","Electronics","Hostel","Unknown"
                if(Department.getSelectedIndex()==0)
                    deptid=33;
                if(Department.getSelectedIndex()==1)
                    deptid=66;
                if(Department.getSelectedIndex()==2)
                    deptid=66;
                if(Department.getSelectedIndex()==3)
                    deptid=23;
                if(Department.getSelectedIndex()==4)
                    deptid=45;
                if(Department.getSelectedIndex()==5)
                    deptid=88;
                if(Department.getSelectedIndex()==6)
                    deptid=55;
                if(Department.getSelectedIndex()==7)
                    deptid=11;
                if(Department.getSelectedIndex()==8)
                    deptid=33;
                query+=deptid+",'"+Title.getSelectedItem()+"','Pending','"+Description.getText()+"')";
                RunQueriesStudent.runQuery(query);
                Description.setText("Come back later");
                CREATE.setEnabled(false);
                CREATE.setVisible(false);
            }
        });

        Title.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Department First" }));
        Department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Campus","Maintainance","Lost and Found","Computer Sci","Info Sci","Mechanical","Electronics","Hostel","Unknown" }));
        Department.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Title.setModel(new javax.swing.DefaultComboBoxModel<>(GetTitles.TitlesFromDept(Department.getSelectedIndex())));
            }
        });

        TextArea.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Description.setColumns(20);
        Description.setFont(new java.awt.Font("Segoe UI", 0, 14));
        Description.setLineWrap(true);
        Description.setRows(5);
        Description.setWrapStyleWord(true);
        TextArea.setViewportView(Description);

        SignOut.setBackground(new java.awt.Color(244, 116, 88));
        SignOut.setFont(new java.awt.Font("Segoe UI", 0, 18));
        SignOut.setForeground(new java.awt.Color(255, 255, 255));
        SignOut.setText("Sign Out");
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login.main(null);
                dispose();
            }
        });

        BackGround.setIcon(new javax.swing.ImageIcon("C:\\DBMS\\WorkingPath\\Frontend\\NewDBMS-Mini-Project\\ASSETS\\Student\\Student-CreateTicket.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1060, 1060, 1060)
                .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1210, 1210, 1210)
                .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1710, 1710, 1710)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(590, 590, 590)
                .addComponent(ChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(CreateTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(ViewTick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackGround)
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
            java.util.logging.Logger.getLogger(StudentCreateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCreateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCreateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCreateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* SignOut and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCreateTicket(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton ChangePass;
    private javax.swing.JButton SignOut;
    private javax.swing.JButton CreateTick;
    private javax.swing.JComboBox<String> Department;
    private javax.swing.JTextArea Description;
    private javax.swing.JButton CREATE;
    private javax.swing.JScrollPane TextArea;
    private javax.swing.JComboBox<String> Title;
    private javax.swing.JButton ViewTick;
    // End of variables declaration                   
}
class GetTitles
{
    public static String[] TitlesFromDept(int Dept)
    {
        //"Campus","Maintainance","Lost and Found","Computer Sci","Info Sci","Mechanical","Electronics","Hostel","Unknown"
        if(Dept==0)
            return new String[]{"Can not find Room/Dept","Facility Related","Others"};

        if(Dept==1)
            return new String[]{"Electrical Equipment Malfunction","Missing Classroom Item","Accident/Damage","Cleanliness Related","Broken Pipeline/Wire","Others"};
            
        if(Dept==2)
        return new String[]{"Lost an Item","Found an Item"};
        
        if(Dept==3||Dept==4||Dept==5||Dept==6)
            return new String[]{"Curriculum Related","Project Related","Academic Doubts","Counselling Needed","Placement Related","Faculty Related","Exam Related","Others"};

        if(Dept==7)
        return new String[]{"Room Change","Room Problem","Warden Related","Hostel Facilities","Mess/Food","Others"};
            
        if(Dept==8)
            return new String[]{"Principal","Admission","Request of/for Documents","Others"};
        return new String[]{"Choose Department First"};
    }
}