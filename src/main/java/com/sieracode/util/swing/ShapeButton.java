package com.sieracode.util.swing;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ShapeButton extends JButton {

    private boolean selected = false;  // Estado para saber si el botón está seleccionado
    private final java.awt.Color defaultColor;  // Color de fondo por defecto
    private final java.awt.Color selectedColor;  // Color cuando está seleccionado

    public ShapeButton() {
        defaultColor = getBackground();  // Guardamos el color de fondo por defecto
        selectedColor = defaultColor.darker();  // Un color más oscuro cuando está seleccionado

        setContentAreaFilled(false);
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Establecer un listener para manejar el cambio de estado del botón
        addActionListener(e -> {
            selected = !selected;  // Cambiar el estado al hacer click
            repaint();  // Volver a pintar el botón después de cambiar el estado
        });
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        // Cambiar el color dependiendo del estado (si está seleccionado o no)
        if (selected) {
            g2.setColor(selectedColor);  // Color más oscuro si está seleccionado
        } else {
            g2.setColor(defaultColor);  // Color normal si no está seleccionado
        }

        g2.fillOval(x, y, size, size);  // Dibuja el círculo

        super.paint(grphcs);  // Llamada al paint original para otros elementos
    }
}
