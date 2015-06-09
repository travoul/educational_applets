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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author henrisilver
 */
public class ProcessModel {
    private int numberOfLines;
    private int currentLine;
    private int startOfCR;
    private int endOfCR;
    private int startOfLoop;
    private boolean inCritical;
    private int loop;
    private int simulationMode;
    
    public ProcessModel(int num, int start, int end, int sloop, int mode) {
        numberOfLines = num;
        currentLine = 0;
        startOfCR = start;
        endOfCR = end;
        startOfLoop = sloop;
        inCritical = false;
        loop = 0;
        simulationMode = mode;
    }
    
    public boolean nextLine(ProcessModel other) {
        if((currentLine+1) != startOfCR || !other.isInCritical()) {
            currentLine++;
            if(currentLine > numberOfLines) {
                System.out.println("\n\nLOOPOU\n");
                loop++;
                currentLine = startOfLoop;
            }
            checkCriticalRegion();
            return false;
        }
        else {
            System.out.println("\n\nTEM GENTE NA REGIAO :)\n");
            return true;
        }
    }
    
    public void checkCriticalRegion() {
        if(simulationMode == 2)
            this.inCritical = false;
        else if(currentLine == startOfCR)
            this.inCritical = true;
        else if (currentLine == endOfCR)
            this.inCritical = false;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public int getStartOfCR() {
        return startOfCR;
    }

    public int getEndOfCR() {
        return endOfCR;
    }
    
    public int getLoop() {
        return loop;
    }
    
    public int getStartOfLoop() {
        return startOfLoop;
    }

    public boolean isInCritical() {
        return inCritical;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public void setStartOfCR(int startOfCR) {
        this.startOfCR = startOfCR;
    }

    public void setEndOfCR(int endOfCR) {
        this.endOfCR = endOfCR;
    }

    public void setInCritical(boolean inCritical) {
        this.inCritical = inCritical;
    }
    
    public void setLoop(int loop) {
        this.loop = loop;
    }
    
    public void setStartOfLoop(int startOfLoop) {
        this.startOfLoop = startOfLoop;
    }

}
