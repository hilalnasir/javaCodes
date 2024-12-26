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

public class Node {
    private final int id;
    private static int nextId = 0; 


    public Node(int id) {
        this.id = nextId;
        nextId++;
    }

    /**
     * returns ID
     * 
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Node " + id;
    }
}
