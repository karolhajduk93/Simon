import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Simon_Game extends JFrame implements ActionListener{

    static int buttonClicked = 0;
    public static void main(String[] args) {
        new Simon_Game();
    }

    public Simon_Game(){
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("SIMON");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer timer = new Timer(600, this);


        Draw draw = new Draw();
        this.add(draw);
        timer.start();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getX() > 0 && e.getX() < 240 && e.getY() > 0 && e.getY() < 230){
                    buttonClicked = 1;
                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 0 && e.getY() < 230){
                    buttonClicked = 2;
                }
                else if(e.getX() > 0 && e.getX() < 240 && e.getY() > 230 && e.getY() < 500){
                    buttonClicked = 3;
                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 230 && e.getY() < 500){
                    buttonClicked = 4;
                }
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
            buttonClicked = 0;
            repaint();

    }
}
