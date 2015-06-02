/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.util.Random;

/**
 *
 * @author henrisilver
 */
public class SimulatOS {
    private Process first;
    private Process second;
    private Process current;
    private Process other;
    private int maxLoops;
    
    public SimulatOS(int num1, int start1, int end1, int sloop1, int num2, 
                                    int start2, int end2, int sloop2, int max) {
        first = new Process(num1, start1, end1, sloop1);
        second = new Process(num2, start2, end2,sloop2);
        maxLoops = max;
    }
    
    public void simulate() {
        while(first.getLoop() < maxLoops || second.getLoop() < maxLoops) {
            schedule();
            current.nextLine(other);
            System.out.println("Active Process: " + current.hashCode() + " in line: " + current.getCurrentLine());
            System.out.println("Other Process: " + other.hashCode() + " in line: " + other.getCurrentLine());
        }
    }

    public void schedule() {
        Random generator = new Random();
        if(generator.nextBoolean()) {
            current = first;
            other = second;
        }
        else {
            current = second;
            other = first;
        }
    }
    
}
