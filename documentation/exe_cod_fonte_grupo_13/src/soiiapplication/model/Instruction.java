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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Class that represent the model of a instruction
public class Instruction {
    private final StringProperty number;
    private final StringProperty instr;
    
    public Instruction(String num, String inst) {
        this.number = new SimpleStringProperty(num);
        this.instr = new SimpleStringProperty(inst);
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String num) {
        this.number.set(num);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public String getInstr() {
        return instr.get();
    }

    public void setInstr(String inst) {
        this.instr.set(inst);
    }

    public StringProperty instrProperty() {
        return instr;
    }
}