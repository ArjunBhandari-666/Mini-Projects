import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;
class DBMSMiniProject
{  
    public static void main(String arg[])  
    {  
        try  
        {  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(700,300);
            form.setVisible(true);
        }  
        catch(Exception e)  
        {  
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}    

class CreateLoginForm extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
    CreateLoginForm()  
    {     
        
        JLabel background=new JLabel(new ImageIcon("DBMS-Mini-Project\\Assets\\Sahyadri-Campus.jpg"));
        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        userLabel = new JLabel();  
        userLabel.setText("Login ID");  
            
        textField1 = new JTextField(10);   
  
        passLabel = new JLabel();
        passLabel.setText("Password");    
          
        textField2 = new JPasswordField(20);   
          
        b1 = new JButton("SUBMIT"); 
          
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    
        newPanel.add(textField1);    
        newPanel.add(passLabel);     
        newPanel.add(textField2); 
        newPanel.add(b1);
        newPanel.setBorder(BorderFactory.createTitledBorder("LOGIN"));
        background.add(newPanel,CENTER_ALIGNMENT);  
        add(background,SwingConstants.CENTER);
        b1.addActionListener(this);  
        setTitle("LOGIN FORM");    
        setResizable(false);
    }  
      
    public void actionPerformed(ActionEvent ae)
    {  
        boolean auth=CheckPassword.password(textField1.getText(),textField2.getText());
        if(auth==true){
            String userRole=CheckPassword.userRole(textField1.getText());
            if(userRole.equalsIgnoreCase("Student")){
                new LoggedIn(userRole,textField1.getText());
                dispose();
            }
            else if(userRole.equalsIgnoreCase("Head")){
                new LoggedIn(userRole,textField1.getText());
                dispose();
            }
            else if(userRole.equalsIgnoreCase("Super")){
                new LoggedIn(userRole,textField1.getText());
                dispose();
            }
        }
        else{
            textField1.setText("");
            textField2.setText("");
            b1.setText("Try Again");
        }
    }  
}  
