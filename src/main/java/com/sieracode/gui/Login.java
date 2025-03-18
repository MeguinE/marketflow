package com.sieracode.gui;

import com.sieracode.gui.componet.PanelCover;
import com.sieracode.gui.componet.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Clase: Login
 *
 * @author Guillermo Diaz Ramos
 *
 * Esta clase representa una ventana de inicio de sesión con una animación de
 * transición en el panel de portada (PanelCover). Utiliza la biblioteca
 * MigLayout para el diseño y la biblioteca de animación TimingFramework para
 * animaciones suaves.
 */
public class Login extends javax.swing.JFrame {

    //variables de diseño y animacion
    private MigLayout layout;
    private PanelCover cover;
    private boolean isLogin;

    private PanelLoginAndRegister loginAndR;

    //tamaños para la animacion
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    //formato decimal para cálculos de animacion
    private final DecimalFormat df = new DecimalFormat("##0.##");

    public Login() {
        initComponents();
        init();
        setLocationRelativeTo(null);
    }
    public Login(boolean dato){
        
    }

    /**
     * Método init: Configura el diseño, el panel de portada y la animación.
     */
    private void init() {
        // Configura el layout con márgenes y relleno
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loginAndR = new PanelLoginAndRegister(this);
        // Configura el objetivo de la animación
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Calcula el tamaño y la posición del panel de portada durante la animación
                double fractionCover;
                double fractionLogin;
                double size = coverSize;

                // Ajusta el tamaño durante la primera mitad de la animación
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }

                // Calcula la posición del panel de portada según el estado (login o no)
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRaight(fractionCover * 100);
                    } else {
                        cover.loginRaight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndR.showLogin(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));

                // Actualiza las restricciones del layout para el panel de portada
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndR, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                background.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };

        // Configura el animador con una duración de 1000 ms (1 segundo)
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);

        background.setLayout(layout);
        background.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        background.add(loginAndR, "width " + loginSize + "%, pos 1al 0 n 100%");

        // Añade un evento al panel de portada para iniciar la animación al hacer clic
        cover.addEvent((ActionEvent e) -> {
            if (!animator.isRunning()) {
                animator.start();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
public void close(){
    this.dispose();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
