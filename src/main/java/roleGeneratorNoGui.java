//File: roleGeneratorNoGui.java
//Created: 23/07/2019
//Finished: 23/07/2019
//Name: Hisbaan Noorani
//
//This program 

import java.util.*;

public class roleGeneratorNoGui {

    public Scanner sc = new Scanner(System.in);
    public String[] roles;
    public String[] names;

    public static void main(String[] args) {
        new roleGeneratorNoGui();
    }

    roleGeneratorNoGui() {
        input();

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " | " + roles[i]);
        }
    }

    public void input() {
        System.out.println("Enter the number of players:");
        int players = sc.nextInt();

        names = new String[players];
        roles = new String[players];

        for (int i = 0; i < players; i++) {
            System.out.println("Enter a name (" + (i + 1) + "):");
            names[i] = sc.next();
        }

        names = shuffle(names);

        int numberOfMafia;

        if (players > 7) {
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
}