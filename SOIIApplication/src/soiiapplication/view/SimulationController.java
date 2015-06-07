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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import soiiapplication.model.Instruction;

/**
 * FXML Controller class
 *
 * @author henrisilver
 */
public class SimulationController implements Initializable {
    
    private ObservableList<Instruction> instructions = FXCollections.observableArrayList();;

    @FXML
    private Label currentProcess;
    
    @FXML
    private Label criticalRegion;
    
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
        instructions.add(new Instruction("1", "while(TRUE) {"));
        instructions.add(new Instruction("2", "\tdoWhateverNonCritical();"));
        instructions.add(new Instruction("3", "}"));
        
        process_1_tableView.setMouseTransparent(true);
        process_2_tableView.setMouseTransparent(true);
        
        process_1_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        process_2_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        process_1_tableView.setItems(instructions);
        process_2_tableView.setItems(instructions);
        
        process_1_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_2_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_1_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        process_2_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
    }    
    
    @FXML
    public void simulateButtonClicked (MouseEvent event) throws Exception {
    	
    }
    
}
