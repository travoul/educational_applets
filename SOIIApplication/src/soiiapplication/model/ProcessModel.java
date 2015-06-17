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

// Class that represents the model of a process executing a function
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
        if(simulationMode == 2 || (currentLine+1) != startOfCR || !other.isInCritical()) {
            currentLine++;
            if(currentLine > numberOfLines) {
                loop++;
                currentLine = startOfLoop;
            }
            checkCriticalRegion();
            return false;
        }
        else {
            return true;
        }
    }
    
    public void checkCriticalRegion() {
        if(currentLine == startOfCR)
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
