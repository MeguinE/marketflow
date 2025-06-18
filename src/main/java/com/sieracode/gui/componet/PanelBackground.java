package com.sieracode.gui.componet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * PanelBackground es un panel personalizado que dibuja un fondo con bordes
 * redondeados y una seccion para crear interfaces modernas con esquinas
 * redondeadas y cabezeras decorativas
 */
public class PanelBackground extends javax.swing.JPanel {

    // Paleta de colores proporcionada
    private final Color DARK_GRAY = new Color(0x20, 0x20, 0x20);     // #202020
    private final Color DARK_GREEN = new Color(0x1b, 0x2e, 0x28);     // #1b2e28
    private final Color DARK_TEAL = new Color(0x1c, 0x4a, 0x47);      // #1c4a47
    private final Color PRIMARY_GREEN = new Color(0x00, 0x72, 0x61);  // #007261
    private final Color LIGHT_BLUE = new Color(0xb2, 0xd2, 0xdb);     // #b2d2db

    // Radio para los bordes redondeados (valor predeterminado: 15 píxeles)
    private int round = 15;

    public int getRound() {
        return round;
    }

    /**
     * Establece el radio de redondeo para los bordes del panel.
     *
     * @param round El nuevo valor de redondeo en píxeles
     */
    public void setRound(int round) {
        this.round = round;
        repaint();// Vuelve a dibujar el panel cuando cambia el radio
    }

    /**
     * Constructor del panel. Configura propiedades iniciales y colores
     * predeterminados.
     */
    public PanelBackground() {
        initComponents();
        setOpaque(false);// Hace el panel transparente para mostrar el fondo personalizado
        setBackground(new Color(250,250,250));
        setForeground(PRIMARY_GREEN);// Color para la sección superior
    }

    /**
     * Método sobrescrito para dibujar el componente personalizado.
     *
     * Este método crea: 1. Un fondo redondeado completo 2. Una sección superior
     * con bordes redondeados solo en la parte superior
     *
     * @param grphcs El contexto gráfico para dibujar
     */
    @Override
    public void paint(Graphics grphcs) {
        //Crea una copia del contexto original para no afectarl el original
        Graphics2D g2 = (Graphics2D) grphcs.create();

        // Activar suavizado para bordes más limpios
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int heigh = getHeight();
        int header = 208;// Altura de la sección superior

        //Dibuja el fondo completo con bordes redondeados
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, heigh, round, round);

        // Crea una forma combinada para la sección superior
        // Área con bordes redondeados en la parte superior
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, header, round, round));

        // Añade un rectángulo en la parte inferior de la sección para "cortar" los bordes redondeados inferiores
        area.add(new Area(new Rectangle2D.Double(0, header - 10, width, 10)));

        // Crea un gradiente para la sección superior usando la paleta
        g2.setPaint(new java.awt.GradientPaint(
                0, 0, DARK_TEAL, // Color inicial: #1c4a47
                width, 0, PRIMARY_GREEN // Color final: #007261
        ));
        g2.fill(area);
        
        // Agrega un borde decorativo en la parte inferior de la sección
        g2.setColor(DARK_GREEN); // #1b2e28
        g2.drawLine(0, header, width, header);


        //libera recursos del contexto gráfico
        g2.dispose();

        //pinta los componentes hijos si es que existen
        super.paint(grphcs);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
