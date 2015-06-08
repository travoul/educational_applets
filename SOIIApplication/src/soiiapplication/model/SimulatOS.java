/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.model;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author henrisilver
 */
public class SimulatOS {
    private ProcessModel first;
    private ProcessModel second;
    private ProcessModel current;
    private ProcessModel other;
    private int currentProcessID;
    private boolean criticalBlock;
    private int maxLoops;
    
    public SimulatOS(int num1, int start1, int end1, int sloop1, int num2, 
                                    int start2, int end2, int sloop2, int max) {
        first = new ProcessModel(num1, start1, end1, sloop1);
        second = new ProcessModel(num2, start2, end2,sloop2);
        maxLoops = max;
    }
    
    public CurrentState simulate() {
        //while(first.getLoop() < maxLoops || second.getLoop() < maxLoops) {
            schedule();
            criticalBlock = current.nextLine(other);
            System.out.println("Active Process: " + current.hashCode() + " in line: " + current.getCurrentLine());
            System.out.println("Other Process: " + other.hashCode() + " in line: " + other.getCurrentLine());
            return new CurrentState(currentProcessID,  first.getCurrentLine(), second.getCurrentLine(), first.isInCritical(), second.isInCritical(), criticalBlock);
    }

    public void schedule() {
        Random generator = new Random();
        if(generator.nextBoolean()) {
            currentProcessID = 1;
            current = first;
            other = second;
        }
        else {
            currentProcessID = 2;
            current = second;
            other = first;
        }
    }
    
}