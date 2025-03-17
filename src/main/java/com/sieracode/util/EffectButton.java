package com.sieracode.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Clase: Button
 *
 * Esta clase extiende JButton para crear un botón personalizado con un efecto
 * de onda (ripple effect) cuando se hace clic. El efecto consiste en un círculo
 * que se expande desde el punto donde se hizo clic.
 *
 * Utiliza la biblioteca de animación TimingFramework para controlar la
 * animación del efecto.
 */
public class EffectButton extends JButton {

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    // Variables para controlar la animación y el efecto de onda
    private Animator animator;
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(255, 255, 255);

    /**
     * Constructor de la clase Button. Configura el botón y añade un listener
     * para manejar el efecto de onda al hacer clic.
     */
    public EffectButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 0, 5, 0));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                // Configura el tamaño máximo del efecto de onda
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;// Inicia el tamaño del efecto en 0
                pressedPoint = me.getPoint();// Guarda el punto donde se hizo clic
                alpha = 0.5f;// Establece la transparencia inicial del efecto

                // Si la animación ya está en curso, la detiene antes de iniciar una nueva
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();// Inicia la animación
            }
        });
        // Configuración de la animación
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Controla la transparencia del efecto durante la animación
                if (fraction > 0.5f) {// Reduce la transparencia en la segunda mitad de la animación
                    alpha = 1 - fraction;
                }
                // Actualiza el tamaño del efecto de onda
                animatSize = fraction * targetSize;
                repaint();
            }
        };
        // Crea el animador con una duración de 700 ms
        animator = new Animator(700, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
    }

    /**
     * Método sobrescrito para personalizar la apariencia del botón. Dibuja el
     * fondo redondeado y el efecto de onda.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, height, height);
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}