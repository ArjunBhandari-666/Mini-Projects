class LoggedInStudent extends javax.swing.JFrame {
    public LoggedInStudent() {
        initComponents();
    }
                  
    public void initComponents() {

        SignOut = new javax.swing.JButton();
        Welcome = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        SeeTickets = new javax.swing.JButton();
        CreateTickets = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        CreateTicketPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        TitleLabel = new javax.swing.JLabel();
        DeptLabel = new javax.swing.JLabel();
        DescLabel = new javax.swing.JLabel();
        RunCreateTicket = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setLineWrap (true);
        Logo = new javax.swing.JPanel();
        LogoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TicketsView = new javax.swing.JPanel();
        ChangePasswordPanel = new javax.swing.JPanel();
        ChangePassButton = new javax.swing.JButton();
        CurrentPassField = new javax.swing.JPasswordField(20);
        CurrentPassLab = new javax.swing.JLabel();
        NewPassLab = new javax.swing.JLabel();
        NewPassField = new javax.swing.JPasswordField(20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(135, 206, 235));
        setResizable(false);

        SignOut.setBackground(new java.awt.Color(51, 255, 204));
        SignOut.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
                DBMSMiniProject.main(null);
            }
        });

        Welcome.setBackground(new java.awt.Color(135, 206, 235));
        Welcome.setFont(new java.awt.Font("Segoe UI", 0, 36));
        Welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Welcome.setLabelFor(this);
        Welcome.setText("WELCOME "+username);
        Welcome.setOpaque(true);

        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Menu.setOpaque(false);
        Menu.setPreferredSize(new java.awt.Dimension(100, 370));

        SeeTickets.setBackground(new java.awt.Color(153, 153, 255));
        SeeTickets.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        SeeTickets.setForeground(new java.awt.Color(255, 255, 255));
        SeeTickets.setText("See Tickets");
        SeeTickets.setMargin(new java.awt.Insets(0, 0, 0, 0));
        SeeTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //SEE TICKET Panel View
                ChangePassword.setBackground(new java.awt.Color(153,153,255));
                ChangePasswordPanel.setVisible(false);
                SeeTickets.setBackground(new java.awt.Color(102, 0, 255));
                CreateTickets.setBackground(new java.awt.Color(153, 153, 255));
                jScrollPane1.setVisible(true);
                TicketViewClass.AllTickets(username,TicketsView);






                CreateTicketPanel.setVisible(false);
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
            }
        });

       
        CreateTickets.setBackground(new java.awt.Color(102, 0, 255));
        CreateTickets.setFont(new java.awt.Font("Segoe UI", 0, 18));
        CreateTickets.setForeground(new java.awt.Color(255, 255, 255));
        CreateTickets.setText("Create");


        jScrollPane1.setViewportView(TicketsView);
        
        CreateTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Create Ticket Panel View
                SeeTickets.setBackground(new java.awt.Color(153, 153, 255));
                CreateTickets.setBackground(new java.awt.Color(102, 0, 255));
                jScrollPane1.setVisible(false);
                CreateTicketPanel.setVisible(true);
                ChangePassword.setBackground(new java.awt.Color(153,153,255));
                ChangePasswordPanel.setVisible(false);
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateTicketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(CreateTicketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
            }
        });

        ChangePassword.setBackground(new java.awt.Color(153, 153, 255));
        ChangePassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        ChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        ChangePassword.setText("<html>Change<br>Password");
        ChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //CHANGE PASSWORD
                SeeTickets.setBackground(new java.awt.Color(153, 153, 255));
                CreateTickets.setBackground(new java.awt.Color(153, 153, 255));
                jScrollPane1.setVisible(false);
                CreateTicketPanel.setVisible(false);
                ChangePassword.setBackground(new java.awt.Color(102, 0, 255));
                ChangePasswordPanel.setVisible(true);
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChangePasswordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(ChangePasswordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CreateTickets, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChangePassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(SeeTickets, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addComponent(CreateTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeeTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        CreateTicketPanel.setBackground(new java.awt.Color(102, 102, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Department First" }));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Campus","Maintainance","Lost and Found","Computer Sci","Info Sci","Mechanical","Electronics","Hostel","Unknown" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(GetTitles.TitlesFromDept(jComboBox1.getSelectedIndex())));
            }
        });
        ChangePasswordPanel.setBackground(new java.awt.Color(102, 102, 255));

        ChangePassButton.setBackground(new java.awt.Color(51, 51, 255));
        ChangePassButton.setFont(new java.awt.Font("Segoe UI", 0, 24));
        ChangePassButton.setForeground(new java.awt.Color(255, 255, 255));
        ChangePassButton.setText("CHANGE PASSWORD");
        ChangePassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String msg=RunQueriesStudent.changePasswordTo(username,new String(CurrentPassField.getPassword()),new String(NewPassField.getPassword()));
                new ErrorScreen(msg);
            }
        });

        
        CurrentPassField.setBackground(new java.awt.Color(204, 204, 255));
        CurrentPassField.setFont(new java.awt.Font("Segoe UI", 0, 24));

        CurrentPassLab.setBackground(new java.awt.Color(204, 204, 255));
        CurrentPassLab.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        CurrentPassLab.setForeground(new java.awt.Color(255, 255, 255));
        CurrentPassLab.setText("Current Password");
        CurrentPassLab.setOpaque(true);

        NewPassLab.setBackground(new java.awt.Color(204, 204, 255));
        NewPassLab.setFont(new java.awt.Font("Segoe UI", 1, 24));
        NewPassLab.setForeground(new java.awt.Color(255, 255, 255));
        NewPassLab.setText("New Password");
        NewPassLab.setOpaque(true);

        NewPassField.setBackground(new java.awt.Color(204, 204, 255));
        NewPassField.setFont(new java.awt.Font("Segoe UI", 0, 24));
        

        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setText("TITLE");

        DeptLabel.setForeground(new java.awt.Color(255, 255, 255));
        DeptLabel.setText("DEPARTMENT");

        DescLabel.setForeground(new java.awt.Color(255, 255, 255));
        DescLabel.setText("DESCRIPTION (255 Char)");

        RunCreateTicket.setBackground(new java.awt.Color(51, 51, 255));
        RunCreateTicket.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RunCreateTicket.setForeground(new java.awt.Color(255, 255, 255));
        RunCreateTicket.setText("CREATE TICKET");
        RunCreateTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String query="insert into ticket (userid,deptid,title,status,description) values ('"+username+"',";
                int deptid=0;
                if(jComboBox2.getItemCount()<2)
                {
                    new ErrorScreen("<html>You need to<br>SELECT DEPT<br>SELECT TITLE");
                    return;
                }
                if(jTextArea1.getText().length()<1)
                {
                    new ErrorScreen("<html>You need to<br>PROVIDE A DESCRIPTION");
                    return;
                }
                //"Campus","Maintainance","Lost and Found","Computer Sci","Info Sci","Mechanical","Electronics","Hostel","Unknown"
                if(jComboBox1.getSelectedIndex()==0)
                    deptid=33;
                if(jComboBox1.getSelectedIndex()==1)
                    deptid=66;
                if(jComboBox1.getSelectedIndex()==2)
                    deptid=66;
                if(jComboBox1.getSelectedIndex()==3)
                    deptid=23;
                if(jComboBox1.getSelectedIndex()==4)
                    deptid=45;
                if(jComboBox1.getSelectedIndex()==5)
                    deptid=88;
                if(jComboBox1.getSelectedIndex()==6)
                    deptid=55;
                if(jComboBox1.getSelectedIndex()==7)
                    deptid=11;
                if(jComboBox1.getSelectedIndex()==8)
                    deptid=33;
                query+=deptid+",'"+jComboBox2.getSelectedItem()+"','Pending','"+jTextArea1.getText()+"')";
                RunQueriesStudent.createTicket(query);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        javax.swing.GroupLayout ChangePasswordPanelLayout = new javax.swing.GroupLayout(ChangePasswordPanel);
        ChangePasswordPanel.setLayout(ChangePasswordPanelLayout);
        ChangePasswordPanelLayout.setHorizontalGroup(
            ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePasswordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChangePasswordPanelLayout.createSequentialGroup()
                        .addGroup(ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CurrentPassLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewPassLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChangePasswordPanelLayout.createSequentialGroup()
                        .addComponent(ChangePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );
        ChangePasswordPanelLayout.setVerticalGroup(
            ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePasswordPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CurrentPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CurrentPassLab, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ChangePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPassLab, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(ChangePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );
        javax.swing.GroupLayout CreateTicketPanelLayout = new javax.swing.GroupLayout(CreateTicketPanel);
        CreateTicketPanel.setLayout(CreateTicketPanelLayout);
        CreateTicketPanelLayout.setHorizontalGroup(
            CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                        .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescLabel)
                            .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                                .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeptLabel))
                                .addGap(18, 18, 18)
                                .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TitleLabel)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(25, Short.MAX_VALUE))))
            .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(RunCreateTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CreateTicketPanelLayout.setVerticalGroup(
            CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateTicketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel)
                    .addComponent(DeptLabel))
                .addGap(4, 4, 4)
                .addGroup(CreateTicketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addGap(18, 18, 18)
                .addComponent(DescLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RunCreateTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        LogoLabel.setBackground(new java.awt.Color(102, 102, 255));
        LogoLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        LogoLabel.setForeground(new java.awt.Color(0, 0, 153));
        LogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoLabel.setText("G A P S");
        LogoLabel.setOpaque(true);

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateTicketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(CreateTicketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    public static void main(String user) {
        username=user;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoggedInStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoggedInStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoggedInStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggedInStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoggedInStudent().setVisible(true);
            }
        });
    }
                  
    public javax.swing.JButton SeeTickets,CreateTickets,SignOut,RunCreateTicket,ChangePassword,ChangePassButton;
    public javax.swing.JLabel DeptLabel,DescLabel,TitleLabel,Welcome,LogoLabel,CurrentPassLab,NewPassLab;
    public javax.swing.JPanel Logo,CreateTicketPanel,Menu,TicketsView,ChangePasswordPanel;
    public javax.swing.JComboBox<String> jComboBox1,jComboBox2;
    public javax.swing.JTextArea jTextArea1;    
    public static String username;     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField CurrentPassField,NewPassField;
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
