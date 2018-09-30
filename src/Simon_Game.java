import javax.swing.*;

public class Simon_Game extends JFrame{

    public static void main(String[] args) {
        new Simon_Game();
    }

    public Simon_Game(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("SIMON");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setVisible(true);
    }
}
