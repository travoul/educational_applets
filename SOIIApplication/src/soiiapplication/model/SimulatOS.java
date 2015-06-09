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
        //while(first.getLoop() < maxLoops || second.getLoop() < maxLoops) {
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
            //System.out.println("Active Process: " + current.hashCode() + " in line: " + current.getCurrentLine());
            //System.out.println("Other Process: " + other.hashCode() + " in line: " + other.getCurrentLine());
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