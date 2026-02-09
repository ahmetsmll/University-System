import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends javax.swing.JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    
     public LoginFrame() {
        setTitle("Teacher Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); 

        
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);

        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginManager loginManager = new LoginManager();
                String user = usernameField.getText();
                String pass = String.valueOf(passwordField.getPassword());

                if (loginManager.loginCheck(user, pass)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    new StudentListFrame(); 
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password!");
                }
            }
        });

        add(panel);
        setVisible(true);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
                       new LoginFrame();
        
        
             
            }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

