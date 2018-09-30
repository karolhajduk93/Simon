import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Simon_Game extends JFrame{

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

        Draw draw = new Draw();
        this.add(draw);

      

        this.setVisible(true);
    }
}
