package com.sieracode.gui.componet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class WinButton extends javax.swing.JPanel {

    public WinButton() {
        initComponents();
        setOpaque(false);
    }

    public void initEvent(JFrame fram, PanelBackground panel) {
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           System.exit(0);
            }
        });
        cmdMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           fram.setState(JFrame.ICONIFIED);
            }
        });
        cmdRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           if(fram.getExtendedState() == JFrame.MAXIMIZED_BOTH){
               panel.setRound(15);
               fram.setExtendedState(JFrame.NORMAL);
           } else {
               panel.setRound(0);
               fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
           }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdClose = new com.sieracode.util.swing.ShapeButton();
        cmdMi = new com.sieracode.util.swing.ShapeButton();
        cmdRe = new com.sieracode.util.swing.ShapeButton();

        cmdClose.setBackground(new java.awt.Color(239, 32, 32));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdMi.setBackground(new java.awt.Color(255, 193, 52));

        cmdRe.setBackground(new java.awt.Color(93, 230, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cmdRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.sieracode.util.swing.ShapeButton cmdClose;
    private com.sieracode.util.swing.ShapeButton cmdMi;
    private com.sieracode.util.swing.ShapeButton cmdRe;
    // End of variables declaration//GEN-END:variables
}
