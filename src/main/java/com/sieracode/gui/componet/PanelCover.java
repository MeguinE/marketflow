package com.sieracode.gui.componet;

import com.sieracode.util.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
public class PanelCover extends javax.swing.JPanel {

    // Paleta de colores
    private final Color DARK_GREEN = new Color(0x1b, 0x2e, 0x28);     // #1b2e28
    private final Color DARK_TEAL = new Color(0x1c, 0x4a, 0x47);      // #1c4a47
    private final Color PRIMARY_GREEN = new Color(0x00, 0x72, 0x61);  // #007261
    private final Color LIGHT_BLUE = new Color(0xb2, 0xd2, 0xdb);     // #b2d2db
    private final Color SOFT_WHITE = new Color(0xfa, 0xfa, 0xfa);    // #fafafa

    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private Boolean isLogin = false;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }

    private void init() {
        // Título principal
        title = new JLabel("welcome Back!");
        title.setFont(new Font("sansserif", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        add(title);

        // Descripción
        description = new JLabel("To keep connected with us please");
        description.setForeground(new Color(245, 245, 245));
        add(description);

        // Descripción adicional
        description1 = new JLabel("login whit your personal info");
        description1.setForeground(new Color(245, 245, 245));
        add(description1);

        // Botón de acción
        button = new ButtonOutLine();
        button.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        button.setForeground(SOFT_WHITE); // Texto blanco suave
        button.setBorderColor(SOFT_WHITE); // Borde blanco suave
        button.setText("SIGN IN");
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setHoverBackgroundColor(SOFT_WHITE); // Fondo blanco al pasar el mouse
        button.setHoverForegroundColor(PRIMARY_GREEN); // Texto verde al pasar el mouse
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
        });
        add(button, "w 60%, h 46");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Dibuja un fondo con gradiente suave usando la paleta de colores
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;

        // Gradiente diagonal suave
        GradientPaint gra = new GradientPaint(
                0, 0, DARK_GREEN,
                getWidth(), getHeight(), DARK_TEAL
        );

        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Elemento decorativo en la esquina inferior derecha
        int circleSize = Math.min(getWidth(), getHeight()) * 3 / 4;
        g2.setColor(new Color(0x00, 0x72, 0x61, 30)); // Verde semitransparente
        g2.fillOval(
                getWidth() - circleSize / 2,
                getHeight() - circleSize / 2,
                circleSize,
                circleSize
        );

        super.paintComponent(grphcs);
    }

    /**
     * Registra un ActionListener para el botón
     */
    public void addEvent(ActionListener event) {
        this.event = event;
    }

    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }

    public void registerRaight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }

    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginRaight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }

    /**
     * Cambia el texto según el modo (login/register)
     */
    private void login(boolean login) {
        if (this.isLogin != login) {

            if (login) {
                title.setText("Hello Friend!");
                description.setText("Enter your personal details");
                description1.setText("and start journey wiht us please");
                button.setText("SING UP");

            } else {
                title.setText("welcome Back!");
                description.setText("To keep connected with us please");
                description1.setText("login whit your personal info");
                button.setText("SING IN");

            }
            this.isLogin = login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
