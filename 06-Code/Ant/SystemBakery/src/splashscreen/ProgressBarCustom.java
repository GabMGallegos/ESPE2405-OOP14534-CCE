package splashscreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBarCustom extends JProgressBar {

    private Color colorString = new Color(255, 255, 255); // Color del texto por defecto

    public Color getColorString() {
        return colorString;
    }

    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    public ProgressBarCustom() {
        setPreferredSize(new Dimension(100, 10));
        setBackground(new Color(77, 77, 77));
        setForeground(new Color(190, 190, 190));
        setUI(new BasicProgressBarUI() {

            @Override
            public void paint(Graphics g, JComponent c) {
                // Personaliza la pintura del JProgressBar
                super.paint(g, c);
                Graphics g2 = (Graphics) g.create();
                try {
                    g2.setColor(getForeground());
                    int progressWidth = (int) (getWidth() * ((float) getValue() / getMaximum()));
                    g2.fillRect(0, 0, progressWidth, getHeight());

                    // Dibuja el texto de progreso
                    g2.setColor(getColorString());
                    String progressText = getValue() + "%";
                    int textWidth = g2.getFontMetrics().stringWidth(progressText);
                    int textHeight = g2.getFontMetrics().getHeight();
                    g2.drawString(progressText, (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 2);
                } finally {
                    g2.dispose();
                }
            }
        });
    }
}
