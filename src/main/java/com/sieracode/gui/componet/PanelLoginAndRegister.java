package com.sieracode.gui.componet;

import com.sieracode.controller.UserController;
import com.sieracode.util.Button;
import com.sieracode.util.MyPasswordField;
import com.sieracode.util.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 * Clase: PanelCover
 *
 * @author Guillermo Diaz Ramos
 *
 * Este panel personalizado muestra un fondo degradado y un botón que permite
 * ejecutar una acción personalizada a través de un ActionListener.
 *
 * Es utilizado en la ventana de inicio de sesión para proporcionar un diseño
 * visual atractivo y funcionalidad interactiva.
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private UserController userController;

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        userController = new UserController();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        // Título de la interfaz de registro
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);

        // Campo de texto para el nombre de usuario
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/recurso/icon/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 60%"); // Ancho del 60% del contenedor

        MyTextField txtMail = new MyTextField();
        txtMail.setPrefixIcon(new ImageIcon(getClass().getResource("/recurso/icon/mail.png")));
        txtMail.setHint("Email");
        register.add(txtMail, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/recurso/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(205, 250, 250));
        cmd.setText("SING UP");
        cmd.addActionListener(e -> {
            String username = txtUser.getText();
            long telefono = Long.parseLong(txtMail.getText());
            String password = new String(txtPass.getPassword());
            boolean result = userController.register(username, telefono, password);  // Llama al controlador para registrar
            if (result) {
                System.out.println("Registro exitoso");
                 userController.clearFields(this); 
            } else {
                System.out.println("Error al registrar usuario");
                 userController.clearFields(this); 
            }
        });
        register.add(cmd, "w 40%, h 40");
    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);

        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/recurso/icon/user.png")));
        txtUser.setHint("Name");
        login.add(txtUser, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/recurso/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");

        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(205, 250, 250));
        cmd.setText("SING IN");

        cmd.addActionListener(e -> {
            String username = txtUser.getText();
            String password = new String(txtPass.getPassword());
            boolean result = userController.login(username, password);  // Llama al controlador para hacer login
            if (result) {
                System.out.println("Login exitoso");
                  userController.clearFields(this); 
            } else {
                System.out.println("Error al iniciar sesión");
                 userController.clearFields(this); 
            }
        });
        login.add(cmd, "w 40%, h 40");
    }

    /**
     * Método para alternar entre las interfaces de Login y Register.
     *
     * @param show Si es true, muestra la interfaz de Login. Si es false,
     * muestra la interfaz de Register.
     */
    public void showLogin(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    public void clearFields() {
        // Limpiar los campos de texto
        for (java.awt.Component comp : register.getComponents()) {
            if (comp instanceof MyTextField myTextField) {
                myTextField.setText("");
            } else if (comp instanceof MyPasswordField myPasswordField) {
                myPasswordField.setText("");
            }
        }

        for (java.awt.Component comp : login.getComponents()) {
            if (comp instanceof MyTextField myTextField) {
                myTextField.setText("");
            } else if (comp instanceof MyPasswordField myPasswordField) {
                myPasswordField.setText("");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
