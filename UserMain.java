/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author muhammadhilalnasir
 */

public class UserMain implements UI {
    private final ArrayList<Object> circuitElements = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * starts the program.
     */
    public void start() {
        displayInstructions();
        runInput();
    }

    /**
     * Processes user input in a loop until the "end" command is given.
     */
    public void runInput() {
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("end")) {
                end();
                break;
            } else if (input.equalsIgnoreCase("spice")) {
                spice();
            } else {
                ComponentInput(input);
            }
        }
    }

    /**

     */
    private void ComponentInput(String input) {
        String[] values = input.split("\\s+");
        if (values.length != 4) {
            System.out.println("Invalid");
            return;
        }

        try {
            String type = values[0].toLowerCase();
            int node1Id = Integer.parseInt(values[1]);
            int node2Id = Integer.parseInt(values[2]);
            double value = Double.parseDouble(values[3]);

            Node node1 = new Node(node1Id);
            Node node2 = new Node(node2Id);

            if (type.equals("v")) {
                VoltageSource voltageSource = new VoltageSource(value, node1, node2);
                circuitElements.add(voltageSource);
            } else if (type.equals("r")) {
                Resistor resistor = new Resistor(value, node1, node2);
                circuitElements.add(resistor);
            } else {
                System.out.println("Invalid Input.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    /**
     * User instructions
     */
    public void displayInstructions() {
        System.out.println("Enter cyour circuit's components");
        System.out.println("'r <node1> <node2> <resistance>' for resistors");
        System.out.println("'v <node1> <node2> <voltage>' for voltage sources");
        System.out.println("'spice' to display the circuit in SPICE format") ;
        System.out.println("'end' to end the program");
    }

    /**
     * Spice format
     */
    public void spice() {
        for (Object element : circuitElements) {
            System.out.println(element);
        }
    }
    /**
     * Prints ending message and ends program
     */
    public void end() {
        System.out.println("Code Ended");
    }

    /**
     * Main method to start the program.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        UserMain userMain = new UserMain();
        userMain.start();
        
    }
}
