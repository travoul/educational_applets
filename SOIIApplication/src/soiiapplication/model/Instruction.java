/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author henrisilver
 */
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