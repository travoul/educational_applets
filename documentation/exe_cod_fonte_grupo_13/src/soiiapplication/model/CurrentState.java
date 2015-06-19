/* SSC0640 - Operating Systems 1
 * Institute of Mathematical and Computer Sciences
 * University of Sao Paulo
 * Project 2 - Mutual Exclusion and Critical Region Applet
 * 17/06/2015
 ***************************************************************
 * Authors
 * Guilherme Nishina Fortes 			- No. USP 7245552
 * Henrique de Almeida Machado da Silveira 	- No. USP 7961089
 * Marcello de Paula Ferreira Costa 		- No. USP 7960690
 * Sergio Yudi Takeda 				- No. USP 7572996
 ***************************************************************
 * GROUP 13
 */

package soiiapplication.model;

// Class that represents the CurrentState in the simulation
public class CurrentState {
    private int currentProcessID;
    private int process1CurrentLine;
    private int process2CurrentLine;
    private int whoIsInCriticalRegion;
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
