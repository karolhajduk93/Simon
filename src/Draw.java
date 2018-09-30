import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent {

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        if(Simon_Game.buttonClicked == 1) {
            g2.setColor(Color.green);
        }
        else
            g2.setColor(Color.green.darker());
        g2.fillRect(0,0, 240, 230);

        if(Simon_Game.buttonClicked == 2) {
            g2.setColor(Color.red);
        }
        else
            g2.setColor(Color.red.darker());
        g2.fillRect(240,0, 240, 230);


        if(Simon_Game.buttonClicked == 3) {
            g2.setColor(Color.yellow);
        }
        else
            g2.setColor(Color.yellow.darker());
        g2.fillRect(0,230, 240, 230);

        if(Simon_Game.buttonClicked == 4) {
            g2.setColor(Color.blue);
        }
        else
            g2.setColor(Color.blue.darker());
        g2.fillRect(240,230, 240, 230);

        g2.setColor(Color.BLACK);

        g2.setStroke(new BasicStroke(200));

        int r = 200, r2 = 50;
        g2.drawOval(140 - r, 130 - r,600, 600);

        g2.setStroke(new BasicStroke(2));
        g2.fillOval(240 - r2, 230 - r2,r2 * 2, r2 * 2);
        g2.drawString("SIMON", 223, 235); // will be progress number in exchange of SIMON

        g2.drawLine(240, 230 - r, 240, 230 - r2);
        g2.drawLine(240, 230 + r2, 240, 230 + r);

        g2.drawLine(240 - r, 230, 240 - r2, 230);
        g2.drawLine(240 + r2, 230, 240 + r, 230);
    }
}
