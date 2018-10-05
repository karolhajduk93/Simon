import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Simon_Game extends JFrame implements ActionListener{

    static int buttonClicked = 0;
    int patternCounter = -1, displayCounter = -1;
    boolean display = false;
    ArrayList<Integer> pattern = new ArrayList<>();
    ArrayList<Integer> move = new ArrayList<>();


    public static void main(String[] args) {
        new Simon_Game();
    }

    public Simon_Game(){
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("SIMON");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer timer = new Timer(500, this);


        Draw draw = new Draw();
        this.add(draw);
        timer.start();

        createPattern();
        display = true;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getX() > 0 && e.getX() < 240 && e.getY() > 0 && e.getY() < 230 && !display){
                    buttonClicked = 1;
                    move.add(0);
                    move.add(1);
                    patternCounter += 2;
                    patternCheck();

                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 0 && e.getY() < 230 && !display){
                    buttonClicked = 2;
                    move.add(0);
                    move.add(2);
                    patternCounter += 2;
                    patternCheck();
                }
                else if(e.getX() > 0 && e.getX() < 240 && e.getY() > 230 && e.getY() < 500 && !display){
                    buttonClicked = 3;
                    move.add(0);
                    move.add(3);
                    patternCounter += 2;
                    patternCheck();
                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 230 && e.getY() < 500 && !display){
                    buttonClicked = 4;
                    move.add(0);
                    move.add(4);
                    patternCounter += 2;
                    patternCheck();

                }
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                buttonClicked = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        if(!display) {
            buttonClicked = 0;
            repaint();
        }
        else {
            displayCounter++;
            if(displayCounter <= pattern.size() - 1) {
                buttonClicked = pattern.get(displayCounter);
                repaint();
            }
            else {
                displayCounter = -1;
                display = false;
            }
        }
    }

    public void createPattern(){
        Random random = new Random();
        pattern.add(0);
        pattern.add(random.nextInt(4) + 1);
        System.out.println(pattern.toString());
    }

    public void patternCheck(){
        if(move.get(patternCounter) == pattern.get(patternCounter)) {
            if (patternCounter == pattern.size() - 1) {
                createPattern();
                display = true;
                move.clear();
                patternCounter = -1;
            }
        }
        else {
            move.clear();
            pattern.clear();
            createPattern();
            display = true;
            patternCounter = -1;

        }
    }

}
