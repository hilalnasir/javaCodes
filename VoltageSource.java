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


public class VoltageSource {
    private final double voltage ;
    private final Node node1; 
    private final Node node2; 
    private final int id; 
    private static int counter = 1; 


    public VoltageSource(double voltage, Node node1, Node node2) {
        this.voltage = voltage;
        this.node1 =node1;
        this.node2 = node2;
        this.id = counter++;
    }

    /**
returns in spice format
     */
    @Override
    public String toString() {
        return String.format("V%d %s %s DC %.2f", id, node1, node2, voltage) ;
    }
}

