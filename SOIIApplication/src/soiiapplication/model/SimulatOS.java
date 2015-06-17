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

import java.util.Random;

// Class that represents our simulator and that schedules processes
public class SimulatOS {
    private ProcessModel first;
    private ProcessModel second;
    private ProcessModel current;
    private ProcessModel other;
    private int currentProcessID;
    private boolean criticalBlock;
    private int simulationMode;
    private int currentStep;

    public int getCurrentStep() {
        return currentStep;
    }
    
    public SimulatOS(int num1, int start1, int end1, int sloop1, int num2, 
                                    int start2, int end2, int sloop2, int mode) {
        first = new ProcessModel(num1, start1, end1, sloop1, mode);
        second = new ProcessModel(num2, start2, end2, sloop2, mode);
        simulationMode = mode;
        currentStep = 0;
    }
    
    public CurrentState simulate() {
            if(simulationMode == 1)
            {
                scheduleCrit();
                currentStep++;
            }
            
            else if(simulationMode == 2)
            {
                schedulenonCrit();
                currentStep++;
            }
            
            else if(simulationMode == 3)
                scheduleRandom();
            
            criticalBlock = current.nextLine(other);
            return new CurrentState(currentProcessID,  first.getCurrentLine(), second.getCurrentLine(), first.isInCritical(), second.isInCritical(), criticalBlock);
    }
    
    private void scheduleCrit() {
   
        if(currentStep == 0 || currentStep == 1 || currentStep == 4 || currentStep == 6 || currentStep == 8 || currentStep == 10 )
        {
            currentProcessID = 1;
            current = first;
            other = second;
        }
        else
        {
            currentProcessID = 2;
            current = second;
            other = first;
        }
    }
    
    private void schedulenonCrit() {
         
        if(currentStep == 0 || currentStep == 1 || currentStep == 6 || currentStep == 7)
        {
            currentProcessID = 1;
            current = first;
            other = second;
        }
        else
        {
            currentProcessID = 2;
            current = second;
            other = first;
        }
        
    }

    private void scheduleRandom() {
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