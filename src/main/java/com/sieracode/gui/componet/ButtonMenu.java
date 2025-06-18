package com.sieracode.gui.componet;

import com.sieracode.util.swing.ShadowRenderer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ButtonMenu extends JButton {

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
        setIcon(new ImageIcon(getClass().getResource("/recurso/icon/" + iconName + ".png")));
    }

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    private Animator animator;
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(0x1c, 0x4a, 0x47); // #1c4a47 (verde oscuro)
    private String iconName;
    private BufferedImage shadow;
    private int shadowSize = 6;

    // Paleta de colores
    private final Color DARK_GRAY = new Color(0x20, 0x20, 0x20);     // #202020
    private final Color DARK_GREEN = new Color(0x1b, 0x2e, 0x28);     // #1b2e28
    private final Color DARK_TEAL = new Color(0x1c, 0x4a, 0x47);      // #1c4a47
    private final Color PRIMARY_GREEN = new Color(0x00, 0x72, 0x61);  // #007261
    private final Color LIGHT_BLUE = new Color(0xb2, 0xd2, 0xdb);     // #b2d2db

    public ButtonMenu() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(DARK_GREEN); // Fondo verde oscuro (#1b2e28)
        setForeground(LIGHT_BLUE); // Texto azul claro (#b2d2db)
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;
                pressedPoint = me.getPoint();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                animatSize = fraction * targetSize;
                repaint();
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int space = shadowSize;
        int width = getWidth() - space * 2;
        int height = getHeight() - space * 2;
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        if (pressedPoint != null) {
            Area area = new Area(new RoundRectangle2D.Double(space, space, width, height, 20, 20));
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            area.intersect(new Area(new Ellipse2D.Double((pressedPoint.x - animatSize / 2), (pressedPoint.y - animatSize / 2), animatSize, animatSize)));
            g2.fill(area);
        }
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);
    }

    @Override
    public void paint(Graphics grphcs) {
        if (isSelected()) {
            int space = shadowSize;
            int width = getWidth() - space * 2;
            int height = getHeight() - space * 2;
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(new GradientPaint(
                    0, 0, DARK_TEAL, // #1c4a47
                    0, height * 2, PRIMARY_GREEN // #007261
            ));
            g2.drawImage(shadow, 0, 0, null);
            g2.fillRoundRect(space, space, width - 1, height - 1, 20, 20);
        }
        super.paint(grphcs);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            // Estado seleccionado: ícono especial, texto azul claro, efecto azul claro
            setIcon(new ImageIcon(getClass().getResource("/recurso/icon/" + iconName + "s.png")));
            setForeground(LIGHT_BLUE); // #b2d2db
            setEffectColor(LIGHT_BLUE); // #b2d2db
        } else {
            // Estado normal: ícono regular, texto azul claro, efecto verde oscuro
            setIcon(new ImageIcon(getClass().getResource("/recurso/icon/" + iconName + ".png")));
            setForeground(LIGHT_BLUE); // #b2d2db
            setEffectColor(DARK_TEAL); // #1c4a47
        }
    }

    private BufferedImage createImage() {
        int width = getWidth() < shadowSize ? shadowSize : getWidth() - shadowSize * 2;
        int height = getHeight() < shadowSize ? shadowSize : getHeight() - shadowSize * 2;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, img.getWidth(), img.getHeight(), 20, 20);
        return new ShadowRenderer(shadowSize, 0.4f, PRIMARY_GREEN).createShadow(img);
    }

    private void createShadow() {
        shadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = shadow.createGraphics();
        g2.drawImage(createImage(), -1, -1, null);
        g2.dispose();
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createShadow();
    }
}
