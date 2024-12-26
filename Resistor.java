/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab7;

/**
 *
 * @author muhammadhilalnasir
 */

/**
 * Resistors are connected between nodes
 */
public class Resistor {
    private final double resistance; 
    private final Node node1; 
    private final Node node2;
    private final int id;
    private static int counter =1; 

    /**
throw illegalargumentexpetion if less than 0 or null .
     */
    public Resistor(double resistance, Node node1, Node node2) {
        if (resistance <= 0) {
            throw new IllegalArgumentException("less than Zero error.") ;
        }
        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("NUll error.");
        }
        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;
        this.id = counter++;
    }


    public Node[] getNodes() {
        return new Node[]{node1, node2};
    }


    public double getResistance() {
        return resistance;
    }


    @Override
    public String toString() {
        return String.format("R%d %s  %s %.2f", id, node1, node2, resistance );
    }
}

