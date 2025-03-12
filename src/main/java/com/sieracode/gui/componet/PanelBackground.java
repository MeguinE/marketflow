package com.sieracode.gui.componet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class PanelBackground extends javax.swing.JPanel {
    
    private int round = 15;
    
    public PanelBackground() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(242, 242, 242));
        setForeground(new Color(23, 102, 255));
    }
    
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int heigh = getHeight();
        int header = 200;
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, heigh, round, round);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, header, round, round));
        area.add(new Area(new Rectangle2D.Double(0, header-10, width, 10)));
        g2.setColor(getForeground());
        g2.fill(area);
        g2.dispose();
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
