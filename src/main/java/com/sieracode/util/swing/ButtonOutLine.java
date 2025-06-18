package com.sieracode.util.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonOutLine extends JButton {

    // Propiedades personalizadas
    private Color borderColor = Color.WHITE;
    private Color hoverBackgroundColor;
    private Color hoverForegroundColor;
    private Color pressedBackgroundColor;
    private boolean mouseOver = false;
    private boolean mousePressed = false;

    public ButtonOutLine() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(8, 15, 8, 15)); // Padding interno mejorado
        setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        setForeground(Color.WHITE); // Texto blanco por defecto
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Listeners para efectos de hover y press
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                repaint();
            }
        });
    }

    // Getters y setters para las nuevas propiedades
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getHoverForegroundColor() {
        return hoverForegroundColor;
    }

    public void setHoverForegroundColor(Color hoverForegroundColor) {
        this.hoverForegroundColor = hoverForegroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Determinar colores según el estado
        Color bg = getBackground();
        Color fg = getForeground();
        
        if (mousePressed && pressedBackgroundColor != null) {
            bg = pressedBackgroundColor;
        } else if (mouseOver) {
            if (hoverBackgroundColor != null) bg = hoverBackgroundColor;
            if (hoverForegroundColor != null) fg = hoverForegroundColor;
        }
        
        // Dibujar fondo si es necesario
        if (bg != null && bg.getAlpha() > 0) {
            g2.setColor(bg);
            g2.fillRoundRect(0, 0, width, height, height, height);
        }
        
        // Dibujar borde
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, width - 1, height - 1, height, height);
        
        // Guardar estado original para texto
        Color originalFg = getForeground();
        setForeground(fg);
        
        super.paintComponent(grphcs);
        
        // Restaurar color original
        setForeground(originalFg);
    }
}