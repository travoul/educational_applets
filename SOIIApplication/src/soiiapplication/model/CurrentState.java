/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.model;

/**
 *
 * @author henrisilver
 */
public class CurrentState {
    private int currentProcessID;
    private int process1CurrentLine;
    private int process2CurrentLine;
    private int whoIsInCriticalRegion;
    // 0_ninguem
    // 1_primeiro
    // 2_segundi
    private boolean criticalBlock;
    
    public CurrentState(int pid, int firstLine, int secondLine, boolean firstCR, boolean secondCR, boolean block) {
        currentProcessID = pid;
        process1CurrentLine = firstLine;
        process2CurrentLine = secondLine;
        
        if(!firstCR && !secondCR)
             whoIsInCriticalRegion = 0;
        else if(firstCR && !secondCR)
            whoIsInCriticalRegion = 1;
        else if(!firstCR && secondCR)
            whoIsInCriticalRegion = 2;
        else 
            whoIsInCriticalRegion = 3;
        
        criticalBlock = block;
    }

    public int getCurrentProcessID() {
        return currentProcessID;
    }

    public int getProcess1CurrentLine() {
        return process1CurrentLine;
    }

    public int getProcess2CurrentLine() {
        return process2CurrentLine;
    }

    public int getWhoIsInCriticalRegion() {
        return whoIsInCriticalRegion;
    }

    public boolean isCriticalBlock() {
        return criticalBlock;
    }
    
}
