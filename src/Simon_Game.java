import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

public class Simon_Game extends JFrame implements ActionListener{

    static int buttonClicked = 0;
    int patternCounter = -1, displayCounter = -1;
    boolean display;
    int tic;

    String green = "file:.\\src\\Button1.wav";
    String red = "file:.\\src\\Button2.wav";
    String yellow = "file:.\\src\\Button3.wav";
    String blue = "file:.\\src\\Button4.wav";
    String correct = "file:.\\src\\Correct.wav";
    String incorrect = "file:.\\src\\Incorrect.wav";
    static ArrayList<Integer> pattern = new ArrayList<>();
    static ArrayList<Integer> move = new ArrayList<>();
    static Clip clip;
    boolean firstTry = false;


    public static void main(String[] args) {
        new Simon_Game();
    }

    public Simon_Game(){
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("SIMON");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer timer = new Timer(20, this);


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
                    clip.stop();
                    playSoundEffect(green);
                    tic = 1;
                    move.add(0);
                    move.add(1);
                    patternCounter += 2;
                    patternCheck();

                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 0 && e.getY() < 230 && !display){
                    buttonClicked = 2;
                    clip.stop();
                    playSoundEffect(red);
                    tic = 1;
                    move.add(0);
                    move.add(2);
                    patternCounter += 2;
                    patternCheck();
                }
                else if(e.getX() > 0 && e.getX() < 240 && e.getY() > 230 && e.getY() < 500 && !display){
                    buttonClicked = 3;
                    clip.stop();
                    playSoundEffect(yellow);
                    tic = 1;
                    move.add(0);
                    move.add(3);
                    patternCounter += 2;
                    patternCheck();
                }
                else if(e.getX() > 240 && e.getX() < 500 && e.getY() > 230 && e.getY() < 500 && !display){
                    buttonClicked = 4;
                    clip.stop();
                    playSoundEffect(blue);
                    tic = 1;
                    move.add(0);
                    move.add(4);
                    patternCounter += 2;
                    patternCheck();

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

        tic++;
        if(tic % 30 == 0) { // so displaying colour in clicking part occurs always in same periods of time
                            // because after clicking tic = 1
            if(buttonClicked != 0 && !firstTry) {
                clip.stop();
                firstTry = true;
            }

            if (!display) {

                clip.stop();
                buttonClicked = 0;
                repaint();
            } else {
                if (buttonClicked != 0)
                    clip.stop();
                displayCounter++;
                if (displayCounter <= pattern.size() - 1) {
                    buttonClicked = pattern.get(displayCounter);
                    if (buttonClicked == 1) {
                        playSoundEffect(green);
                    }
                    if (buttonClicked == 2) {
                        playSoundEffect(red);
                    }
                    if (buttonClicked == 3) {
                        playSoundEffect(yellow);
                    }
                    if (buttonClicked == 4) {
                        playSoundEffect(blue);
                    }
                    repaint();
                } else {
                    displayCounter = -1;
                    display = false;
                }
            }
        }
    }

    public void createPattern(){
        Random random = new Random();
        pattern.add(0);
        pattern.add(random.nextInt(4) + 1);
    }

    public void patternCheck(){
        if(move.get(patternCounter) == pattern.get(patternCounter)) {
            if (patternCounter == pattern.size() - 1) {
                createPattern();
                clip.stop();
                playSoundEffect(correct);
                display = true;
                move.clear();
                patternCounter = -1;
            }
        }
        else {
            clip.stop();
            playSoundEffect(incorrect);
            move.clear();
            pattern.clear();
            createPattern();
            display = true;
            patternCounter = -1;

        }
    }

    public static void playSoundEffect(String sound){
        URL soundLocation;

        try {
            soundLocation = new URL(sound);
            clip = AudioSystem.getClip();
            AudioInputStream inputStream;
            inputStream = AudioSystem.getAudioInputStream(soundLocation);
            clip.open(inputStream);
            clip.loop(0);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }

}
