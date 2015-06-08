/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soiiapplication.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import soiiapplication.model.Instruction;
import soiiapplication.model.SimulatOS;
import soiiapplication.model.CurrentState;

/**
 * FXML Controller class
 *
 * @author henrisilver
 */
public class SimulationController implements Initializable {

    private ObservableList<Instruction> instructions_1 = FXCollections.observableArrayList();
    private ObservableList<Instruction> instructions_2 = FXCollections.observableArrayList();
    
    private SimulatOS simulator;
    private CurrentState currentState;
    private ArrayList<CurrentState> generatedStates;
    private int listPosition, firstLastLine, secondLastLine;

    @FXML
    private Label currentProcess;

    @FXML
    private Label criticalRegion;

    @FXML
    private Label criticalBlock;
    
    @FXML
    private Button previousButton;
    
    @FXML
    private TableView<Instruction> process_1_tableView;

    @FXML
    private TableView<Instruction> process_2_tableView;

    @FXML
    private TableColumn<Instruction, String> process_1_tableColumn_instr;

    @FXML
    private TableColumn<Instruction, String> process_2_tableColumn_instr;

    @FXML
    private TableColumn<Instruction, String> process_1_tableColumn_num;

    @FXML
    private TableColumn<Instruction, String> process_2_tableColumn_num;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listPosition = 0;
        firstLastLine = 0;
        secondLastLine = 0;
        previousButton.setDisable(true);
        previousButton.setOpacity(0.5);
        simulator = new SimulatOS(7, 4, 6, 2, 7, 4, 6, 2, 3);
        generatedStates = new ArrayList<CurrentState>();
        addInstructions();

        process_1_tableView.setMouseTransparent(true);
        process_2_tableView.setMouseTransparent(true);

        process_1_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        process_2_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        process_1_tableView.setItems(instructions_1);
        process_2_tableView.setItems(instructions_2);

        process_1_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_2_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_1_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        process_2_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        
    }
    
    private void addInstructions() {
        addInstructions_1();
        addInstructions_2();
    }

    private void addInstructions_1() {
        instructions_1.add(new Instruction("1", "void thread(){"));
        instructions_1.add(new Instruction("2", "\ttype variables;"));
        instructions_1.add(new Instruction("3", "\twhile(TRUE) {"));
        instructions_1.add(new Instruction("4", "\t\tdoWhateverNonCritical();"));
        instructions_1.add(new Instruction("5", "\t\tenterCriticalRegion();"));
        instructions_1.add(new Instruction("6", "\t\tdoWhateverCritical();"));
        instructions_1.add(new Instruction("7", "\t\tleaveCriticalRegion();"));
        instructions_1.add(new Instruction("8", "\t\tdoWhateverNonCritical();"));
        instructions_1.add(new Instruction("9", "\t}"));
        instructions_1.add(new Instruction("10", "}"));
    }
  
    private void addInstructions_2() {
        instructions_2.add(new Instruction("1", "void thread(){"));
        instructions_2.add(new Instruction("2", "\ttype variables;"));
        instructions_2.add(new Instruction("3", "\twhile(TRUE) {"));
        instructions_2.add(new Instruction("4", "\t\tdoWhateverNonCritical();"));
        instructions_2.add(new Instruction("5", "\t\tenterCriticalRegion();"));
        instructions_2.add(new Instruction("6", "\t\tdoWhateverCritical();"));
        instructions_2.add(new Instruction("7", "\t\tleaveCriticalRegion();"));
        instructions_2.add(new Instruction("8", "\t\tdoWhateverNonCritical();"));
        instructions_2.add(new Instruction("9", "\t}"));
        instructions_2.add(new Instruction("10", "}"));
    }
    
    @FXML
    private void nextButtonClicked(MouseEvent event) throws Exception {
        previousButton.setDisable(false);
        previousButton.setOpacity(1.0);
        if(generatedStates.isEmpty() || listPosition  == generatedStates.size()) {
            currentState = simulator.simulate();
            generatedStates.add(currentState);
            listPosition++;
        }
        else {
            currentState = generatedStates.get(listPosition);
            listPosition++;
        }
        displayState(currentState);
    }
    
    @FXML
    private void previousButtonClicked(MouseEvent event) throws Exception {
        
        if(listPosition > 0){
            currentState = generatedStates.get(--listPosition);
        
            if(listPosition==1) {
                previousButton.setDisable(true);
                previousButton.setOpacity(0.5);
            }
        }
        
        displayState(currentState);
    }

    private void displayState(CurrentState cs) {
        
        updateTable(process_1_tableColumn_instr, instructions_1, firstLastLine, cs.getProcess1CurrentLine());
        if(firstLastLine != cs.getProcess1CurrentLine())
            firstLastLine = cs.getProcess1CurrentLine();
        
        updateTable(process_2_tableColumn_instr, instructions_2, secondLastLine, cs.getProcess2CurrentLine());
        if(secondLastLine != cs.getProcess2CurrentLine())
            secondLastLine = cs.getProcess2CurrentLine();  
    }
    private void updateTable(TableColumn<Instruction, String> process, ObservableList<Instruction> inst, int lastLine, int currentLine) {
        Instruction x;
        System.out.println("l: " + lastLine+"\tc: " + currentLine);
        if(lastLine != currentLine) {
            x = inst.get(lastLine);
            if(x.getInstr().contains("HERE")) {
                x.setInstr(x.getInstr().substring(0, x.getInstr().indexOf("HERE")));
        	inst.set(lastLine, x);
            }
        }
        
        if(currentLine != 0) {
            x = inst.get(currentLine);
            x.setInstr(x.getInstr()+"HERE");
            inst.set(currentLine, x);
        }
        
        process.setCellFactory(column -> {
            return new TableCell<Instruction,String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        if (item.contains("HERE"))
                            setText(item.substring(0, item.indexOf("HERE")));
                        else
                            setText(item);

                        // Style all dates in March with a different color.
                        if (item.contains("HERE")) {
                            setTextFill(Color.CHOCOLATE);
                            setStyle("-fx-background-color: yellow");
                        } else {
                            setTextFill(Color.BLACK);
                            setStyle("");
                        }
                    }
                }
            };
        });
    }
    
//    @FXML
//    public void simulateButtonClicked(MouseEvent event) throws Exception {
//      	Instruction x = instructions.get(count);
//        if(x.getInstr().contains("HERE")) {
//      		x.setInstr(x.getInstr().substring(0, x.getInstr().indexOf("HERE")));
//        	instructions.set(count, x);
//        }
//      
//        count++;
//        x = instructions.get(count);
//        x.setInstr(x.getInstr()+"HERE");
//        instructions.set(count, x);
//        //process_1_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
//        process_1_tableColumn_instr.setCellFactory(column -> {
//            return new TableCell<Instruction,String>() {
//                @Override
//                protected void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//
//                    if (item == null || empty) {
//                        setText(null);
//                        setStyle("");
//                    } else {
//                        if (item.contains("HERE"))
//                            setText(item.substring(0, item.indexOf("HERE")));
//                        else
//                            setText(item);
//
//                        // Style all dates in March with a different color.
//                        if (item.contains("HERE")) {
//                            setTextFill(Color.CHOCOLATE);
//                            setStyle("-fx-background-color: yellow");
//                        } else {
//                            setTextFill(Color.BLACK);
//                            setStyle("");
//                        }
//                    }
//                }
//            };
//        });
//    }

}