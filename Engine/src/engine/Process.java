/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

/**
 *
 * @author henrisilver
 */
public class Process {
    private int numberOfLines;
    private int currentLine;
    private int startOfCR;
    private int endOfCR;
    private boolean running;
    private boolean inCritical;
    
    public Process(int num, int start, int end) {
        numberOfLines = num;
        currentLine = 0;
        startOfCR = start;
        endOfCR = end;
        running = false;
        inCritical = false;
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

    public boolean isRunning() {
        return running;
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

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setInCritical(boolean inCritical) {
        this.inCritical = inCritical;
    }
    
}
