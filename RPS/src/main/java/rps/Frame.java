package rps;

import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Frame implements ActionListener {

    private final JButton rock;
    private final JButton paper;
    private final JButton scissors;
    private static final JLabel title = new JLabel();
    @Getter @Setter
    private static JLabel playerOneScore = new JLabel();
    private static final JLabel notification =  new JLabel();
    @Getter @Setter
    private static JLabel playerTwoScore = new JLabel();
    @Getter
    private static JLabel round = new JLabel();
    @Getter
    private static JLabel tie = new JLabel();


    Frame(){

        title.setFont(new Font("Ink Free", Font.BOLD, 30));
        title.setBounds(100,0,300,30);
        title.setText("Rock-Paper-Scissors");

        notification.setFont(new Font("Ink Free", Font.BOLD, 25));
        notification.setBounds(130,50,300,25);
        notification.setText("Player one starts!");

        round.setFont(new Font("Ink Free", Font.BOLD, 30));
        round.setBounds(180,300,300,30);
        round.setText("Round: " + RockPaperScissors.getRoundCount());

        playerOneScore.setFont(new Font("Ink Free", Font.BOLD,25));
        playerOneScore.setBounds(160, 370,300,25);
        playerOneScore.setText("Player one: " + RockPaperScissors.getPlayerOne().getWinCount());

        playerTwoScore.setFont(new Font("Ink Free", Font.BOLD,25));
        playerTwoScore.setBounds(160,400,300,25);
        playerTwoScore.setText("Player two: " + RockPaperScissors.getPlayerTwo().getWinCount());

        tie.setFont(new Font("Ink Free", Font.BOLD,25));
        tie.setBounds(200,425,300,25);
        tie.setText("Ties: " + RockPaperScissors.getTieCount() );


        rock = new JButton("Rock");
        rock.addActionListener(this);
        rock.setBounds(180,100,100,50);

        paper = new JButton("Paper");
        paper.addActionListener(this);
        paper.setBounds(180,150,100,50);

        scissors = new JButton("Scissors");
        scissors.addActionListener(this);
        scissors.setBounds(180,200,100,50);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rock-Paper-Scissors");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(title);
        frame.add(notification);
        frame.add(round);
        frame.add(playerOneScore);
        frame.add(playerTwoScore);
        frame.add(tie);

        frame.add(rock);
        frame.add(paper);
        frame.add(scissors);


    }


    @Override
    public void actionPerformed(ActionEvent e) {



            if (e.getSource() == rock) {
            File rock = new File("src/main/resources/rock.wav");

                try{
                    AudioInputStream AIStream = AudioSystem.getAudioInputStream(rock);
                    Clip clip = AudioSystem.getClip();
                    clip.open(AIStream);
                    clip.setFramePosition(0);
                    clip.start();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }
                if (RockPaperScissors.isPlayerOneTurn()) {
                    RockPaperScissors.getPlayerOne().setChoice("Rock");
                    RockPaperScissors.setPlayerOneTurn(false);
                    JOptionPane.showMessageDialog(null, "Player one chose rock.");
                    notification.setText("Player two turn!");


                } else{
                    RockPaperScissors.getPlayerTwo().setChoice("Rock");
                   JOptionPane.showMessageDialog(null, "Player two chose rock.");
                    RockPaperScissors.setPlayerOneTurn(true);
                    notification.setText("Player one turn!");

                }


            } else if (e.getSource() == paper) {

                File rock = new File("src/main/resources/paper.wav");

                try{
                    AudioInputStream AIStream = AudioSystem.getAudioInputStream(rock);
                    Clip clip = AudioSystem.getClip();
                    clip.open(AIStream);
                    clip.setFramePosition(0);
                    clip.start();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }

                if (RockPaperScissors.isPlayerOneTurn()) {
                    RockPaperScissors.getPlayerOne().setChoice("Paper");
                    JOptionPane.showMessageDialog(null, "Player one chose paper.");
                    RockPaperScissors.setPlayerOneTurn(false);
                    notification.setText("Player two turn!");


                } else {
                    RockPaperScissors.getPlayerTwo().setChoice("Paper");
                    JOptionPane.showMessageDialog(null, "Player two chose paper.");
                    RockPaperScissors.setPlayerOneTurn(true);
                    notification.setText("Player one turn!");

                }


            } else if (e.getSource() == scissors) {
                File rock = new File("src/main/resources/scissors.wav");

                try{
                    AudioInputStream AIStream = AudioSystem.getAudioInputStream(rock);
                    Clip clip = AudioSystem.getClip();
                    clip.open(AIStream);
                    clip.setFramePosition(0);
                    clip.start();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong!");
                }

                if (RockPaperScissors.isPlayerOneTurn()) {
                    RockPaperScissors.getPlayerOne().setChoice("Scissors");
                    JOptionPane.showMessageDialog(null, "Player one chose scissors.");
                    RockPaperScissors.setPlayerOneTurn(false);
                    notification.setText("Player two turn!");


                } else {
                    RockPaperScissors.getPlayerTwo().setChoice("Scissors");
                    JOptionPane.showMessageDialog(null, "Player two chose scissors.");
                    RockPaperScissors.setPlayerOneTurn(true);
                    notification.setText("Player one turn!");

                }
            }

             RockPaperScissors.match();
        }
    }

