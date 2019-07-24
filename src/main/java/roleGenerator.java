//File: roleGenerator.java
//Created: 24/07/2019
//Finished: 24/07/2019
//Name: Hisbaan Noorani
//
//This program 

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.net.http.HttpResponse;

public class roleGenerator implements ActionListener {
    //main menu variables
    JFrame mainMenuFrame = new JFrame("Main Menu");
    JButton mainMenuStartButton = new JButton("Start");

    //number menu variables
    JFrame numberFrame = new JFrame("Enter the number of players:");
    JButton numberFrameContinueButton = new JButton("Continue");

    //name menu variables
    JFrame nameFrame = new JFrame("Enter the names of the players:");
    JButton nameFrameContinueButton = new JButton("Continue");

    //output screen variables
    JFrame outputFrame = new JFrame("Roles");
    JButton outputFrameRestartButton = new JButton("Restart");

    public static void main(String[] args) {
        new roleGenerator();
    }

    roleGenerator() {
        mainMenu();
    }

    public void mainMenu() {
        mainMenuFrame.setSize(800, 800);
        mainMenuFrame.setLayout(new BorderLayout());
        mainMenuFrame.setResizable(false);

        mainMenuFrame.add(mainMenuStartButton, BorderLayout.SOUTH);
        if (mainMenuStartButton.getActionListeners().length < 1) mainMenuStartButton.addActionListener(this);

        mainMenuFrame.setVisible(true);
        numberFrame.setVisible(false);
        nameFrame.setVisible(false);
        outputFrame.setVisible(false);
    }

    public void numberMenu() {
        numberFrame.setSize(800,800);
        numberFrame.setLayout(new BorderLayout());
        numberFrame.setResizable(false);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(true);
        nameFrame.setVisible(false);
        outputFrame.setVisible(false);
    }

    public void nameMenu() {
        nameFrame.setSize(800,800);
        nameFrame.setLayout(new BorderLayout());
        nameFrame.setResizable(false);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(false);
        nameFrame.setVisible(true);
        outputFrame.setVisible(false);
    }

    public void outputScreen() {
        outputFrame.setSize(800,800);
        outputFrame.setLayout(new BorderLayout());
        outputFrame.setResizable(false);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(false);
        nameFrame.setVisible(false);
        outputFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainMenuStartButton) {
           numberMenu();
        }
    }
}
