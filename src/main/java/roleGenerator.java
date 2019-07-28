//File: roleGenerator.java
//Created: 24/07/2019
//Finished: 24/07/2019
//Name: Hisbaan Noorani
//
//This program 

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;

public class roleGenerator implements ActionListener, WindowListener {
    //universal values
    public final boolean DEBUG = true;
    public Font courier = new Font("Courier New", Font.PLAIN, 24);
    public Font courierSmall = new Font("Courier New", Font.PLAIN, 16);

    //main menu variables
    JFrame mainMenuFrame = new JFrame("Mafia Role Randomizer");
    JLabel introLabel = new JLabel("<html>Mafia<br>Role<br>Randomizer</html>", SwingConstants.CENTER);
    JButton mainMenuStartButton = new JButton("Start");

    //number menu variables
    JFrame numberFrame = new JFrame("Mafia Role Randomizer");
    JButton numberFrameContinueButton = new JButton("Continue");
    JTextField numberField = new JTextField();

    //name menu variables
    JFrame nameFrame = new JFrame("Mafia Role Randomizer");
    JPanel namePanel = new JPanel();
    JLabel nameFrameInstructions = new JLabel("Enter one name in each box:", SwingConstants.CENTER);
    JButton nameFrameContinueButton = new JButton("Continue");
    JTextField[] namesInput;

    //output screen variables
    JFrame outputFrame = new JFrame("Mafia Role Randomizer");
    JPanel outputPanel = new JPanel();
    JButton outputFrameExitButton = new JButton("Exit");
    JTextField[] namesOutput;
    JTextField[] rolesOutput;

    //list variables
    int players = 0;
    String[] names;
    String[] roles;

    public static void main(String[] args) {
        new roleGenerator();
    }

    roleGenerator() {
        mainMenu();
    }

    public void mainMenu() {
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.setLayout(new BorderLayout());
        mainMenuFrame.setResizable(false);
        if(mainMenuFrame.getWindowListeners().length < 1) mainMenuFrame.addWindowListener(this);

        introLabel.setFont(new Font("Courier New", Font.PLAIN, 50));
//        introLabel.setHorizontalAlignment(JLabel.CENTER);
        mainMenuFrame.add(introLabel, BorderLayout.CENTER);

        mainMenuFrame.add(mainMenuStartButton, BorderLayout.SOUTH);
        if (mainMenuStartButton.getActionListeners().length < 1) mainMenuStartButton.addActionListener(this);

        mainMenuFrame.setVisible(true);
        numberFrame.setVisible(false);
        nameFrame.setVisible(false);
        outputFrame.setVisible(false);
    }

    public void numberMenu() {
        numberFrame.setSize(400, 125);
        numberFrame.setLayout(new GridLayout(3, 1));
        numberFrame.setResizable(false);
        if(numberFrame.getWindowListeners().length < 1) numberFrame.addWindowListener(this);

        JLabel instructions = new JLabel("Enter the amount of players:", SwingConstants.CENTER);
        instructions.setFont(courier);
        numberFrame.add(instructions);

        numberFrame.add(numberField);
        numberField.setFont(courier);
        numberField.setHorizontalAlignment(JTextField.CENTER);
        if (numberField.getActionListeners().length < 1) numberField.addActionListener(this);

        numberFrame.add(numberFrameContinueButton);
        numberFrameContinueButton.setFont(courierSmall);
        if(numberFrameContinueButton.getActionListeners().length < 1) numberFrameContinueButton.addActionListener(this);
        numberField.setEditable(true);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(true);
        nameFrame.setVisible(false);
        outputFrame.setVisible(false);
    }

    public void nameMenu() {
        nameFrame.setSize(450, (50 * players + 1) + 22);
        nameFrame.setLayout(new BorderLayout());
        nameFrame.setResizable(false);
        if(nameFrame.getWindowListeners().length < 1) nameFrame.addWindowListener(this);

        nameFrame.add(namePanel, BorderLayout.CENTER);
        namePanel.setLayout(new GridLayout(players + 1, 1));

        namePanel.add(nameFrameInstructions);
        nameFrameInstructions.setFont(courier);

        for(int i = 0; i < players; i++) {
            namesInput[i] = new JTextField();
            namesInput[i].setEditable(true);
            namesInput[i].setFont(courier);
            namesInput[i].setHorizontalAlignment(SwingConstants.CENTER);
            namePanel.add(namesInput[i]);
        }

        nameFrame.add(nameFrameContinueButton, BorderLayout.SOUTH);
        nameFrameContinueButton.setFont(courierSmall);
        if(nameFrameContinueButton.getActionListeners().length < 1) nameFrameContinueButton.addActionListener(this);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(false);
        nameFrame.setVisible(true);
        outputFrame.setVisible(false);
    }

    public void outputScreen() {
        outputFrame.setSize(600, (players * 50) + 22) ;
        outputFrame.setLayout(new BorderLayout());
        outputFrame.setResizable(false);
        if(outputFrame.getWindowListeners().length < 1) outputFrame.addWindowListener(this);

        outputFrame.add(outputPanel, BorderLayout.CENTER);
        outputPanel.setLayout(new GridLayout(players, 2));
        
        for(int i = 0; i < players; i++) {
            namesOutput[i] = new JTextField(names[i]);
            rolesOutput[i] = new JTextField(roles[i]);

            namesOutput[i].setFont(courier);
            rolesOutput[i].setFont(courier);

            namesOutput[i].setEditable(false);
            rolesOutput[i].setEditable(false);

            namesOutput[i].setHorizontalAlignment(JTextField.CENTER);
            rolesOutput[i].setHorizontalAlignment(JTextField.CENTER);

            outputPanel.add(namesOutput[i]);
            outputPanel.add(rolesOutput[i]);
        }

        outputFrame.add(outputFrameExitButton, BorderLayout.SOUTH);
        outputFrameExitButton.setFont(courierSmall);
        if (outputFrameExitButton.getActionListeners().length < 1) outputFrameExitButton.addActionListener(this);

        mainMenuFrame.setVisible(false);
        numberFrame.setVisible(false);
        nameFrame.setVisible(false);
        outputFrame.setVisible(true);
    }

    public String[] shuffle(String[] array) {
        boolean continueRandomizing = true;
        String[] temp = new String[array.length];

        while (continueRandomizing) {
            int random = (int) (Math.random() * array.length);
            int random2 = (int) (Math.random() * array.length);

            if (array[random] != null && temp[random2] == null) {
                temp[random2] = array[random];
                array[random] = null;

                for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        continueRandomizing = true;
                        break;
                    } else {
                        continueRandomizing = false;
                    }
                }
            }
        }

        return temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainMenuStartButton) {
            numberMenu();
        }

        if (e.getSource() == numberField || e.getSource() == numberFrameContinueButton) {
            try {
                players = Integer.parseInt(numberField.getText());
            } catch (NumberFormatException ex) {
                System.err.println("Number is too large");
            }

            if (DEBUG) System.out.println(players);

            namesInput = new JTextField[players];
            names = new String[players];
            roles = new String[players];
            namesOutput = new JTextField[players];
            rolesOutput = new JTextField[players];

            nameMenu();
        }

        if(e.getSource() == nameFrameContinueButton) {
            for(int i = 0; i < players; i++) {
                names[i] = namesInput[i].getText();
            }

            names = shuffle(names);

            int numberOfMafia;

            if (players != 7) {
                numberOfMafia = players / 4;
            } else {
                numberOfMafia = 2;
            }

            for (int i = 0; i < numberOfMafia; i++) {
                roles[i] = "Mafia";
            }

            roles[numberOfMafia] = "Detective";
            roles[numberOfMafia + 1] = "Doctor";

            for (int i = numberOfMafia + 2; i < players; i++) {
                roles[i] = "Villager";
            }

            outputScreen();
        }

        if (e.getSource() == outputFrameExitButton) {
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.PLAIN, 20)));
            JOptionPane.showMessageDialog(outputFrame ,"Thanks for using the mafia role generator!", "", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
