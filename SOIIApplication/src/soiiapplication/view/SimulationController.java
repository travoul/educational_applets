// 	BEM VINDOS DE VOLTA
// 	SENTI SUA FALTA
//     VOCÊS SÃO OS CARAS
// 	ESTAVA ESPERANDO VOCÊS! :D
//   #define NOTA 10 // De novo ;)
//       #cortesia bjm 20/4/2015
//       kkkk
//       #cortesia v2.0 bjm 28/05/2015 YEAH
//       Shina mandou beijo. Raul
// TODO:
/*
 ----- CRIAR BOTÃO DE AJUDA E SEÇÃO DE AJUDA NO SIMULADOR PARA INSTRUCÕES
 ----- EDITAR O DID YOU KNOW
 ----- INTERNACIONALIZAR CÓDIGO DA REGIÃO CRíTICA
 ----- BOTÃO "PRÓXIMO PASSO" ESTA "PRÓXIMO PA..." E OUTROS BOTÕES TAMBÉM
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    private String currentTag1, currentTag2, lastTag1, lastTag2;
    private int simulationMode;
    
    public void setupSimulationMode(int mode) {
        this.simulationMode = mode;
        
        addInstructions();
        process_1_tableView.setItems(instructions_1);
        process_2_tableView.setItems(instructions_2);
        
        process_1_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_2_tableColumn_instr.setCellValueFactory(cellData -> cellData.getValue().instrProperty());
        process_1_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        process_2_tableColumn_num.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        
        if (simulationMode == 1) {
            simulator = new SimulatOS(6, 2, 6, -1, 6, 2, 6, -1, 1);
        } else if (simulationMode == 2) {
            simulator = new SimulatOS(4, 2, 4, -1, 4, 2, 4, -1, 2);
        } else if (simulationMode == 3) {
            simulator = new SimulatOS(7, 4, 6, 2, 7, 4, 6, 2, 3);
        }
        displayState(currentState);
    }
    
    @FXML
    private Label currentProcess;
    
    @FXML
    private Label criticalRegion;
    
    @FXML
    private Label criticalBlock;
    
    @FXML
    private Label instructionalLabel;
    
    @FXML
    private Label colorLabel1;
        
    @FXML
    private Label colorLabel2;
        
    @FXML
    private Label colorLabel3;
    
    @FXML
    private Label textColorLabel1;
        
    @FXML
    private Label textColorLabel2;
        
    @FXML
    private Label textColorLabel3;
    
    @FXML
    private Label title;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button previousButton;
    
    @FXML
    private Button nextButton;
    
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
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listPosition = 0;
        firstLastLine = 0;
        secondLastLine = 0;
        currentTag1 = null;
        currentTag2 = null;
        lastTag1 = null;
        lastTag2 = null;
        previousButton.setDisable(true);
        previousButton.setOpacity(0.5);
        
        generatedStates = new ArrayList<>();
        
        process_1_tableView.setMouseTransparent(true);
        process_2_tableView.setMouseTransparent(true);
        
        process_1_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        process_2_tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        nextButton.setText(soiiapplication.SOIIApplication.BUNDLE.getString("Init"));
    }
    
    private void addInstructions() {
        
        if (simulationMode == 1) {
            addInstructionsMutualExclusion(instructions_1);
            addInstructionsMutualExclusion(instructions_2);
        } else if (simulationMode == 2) {
            addInstructionsNoMutualExclusion(instructions_1);
            addInstructionsNoMutualExclusion(instructions_2);
        } else if (simulationMode == 3) {
            addInstructionsRandom(instructions_1);
            addInstructionsRandom(instructions_2);
        }
    }
    
    private void addInstructionsMutualExclusion(ObservableList<Instruction> instructions) {
        instructions.add(new Instruction("1", "void thread() {"));
        instructions.add(new Instruction("2", "\tint local_variable;"));
        instructions.add(new Instruction("3", "\tlock_critical_region();"));
        instructions.add(new Instruction("4", "\tlocal_variable = read_from_memory(0xF4D9012C);"));
        instructions.add(new Instruction("5", "\tlocal_variable++;"));
        instructions.add(new Instruction("6", "\twrite_to_memory(0xF4D9012C, local_variable);"));
        instructions.add(new Instruction("7", "\tunlock_critical_region();"));
        instructions.add(new Instruction("8", "}"));
        
    }
    
    private void addInstructionsNoMutualExclusion(ObservableList<Instruction> instructions) {
        instructions.add(new Instruction("1", "void thread() {"));
        instructions.add(new Instruction("2", "\tint local_variable;"));
        instructions.add(new Instruction("3", "\tlocal_variable = read_from_memory(0xF4D9012C);"));
        instructions.add(new Instruction("4", "\tlocal_variable++;"));
        instructions.add(new Instruction("5", "\twrite_to_memory(0xF4D9012C, local_variable);"));
        instructions.add(new Instruction("6", "}"));
        
    }
    
    private void addInstructionsRandom(ObservableList<Instruction> instructions) {
        instructions.add(new Instruction("1", "void thread(){"));
        instructions.add(new Instruction("2", "\ttype variables;"));
        instructions.add(new Instruction("3", "\twhile(TRUE) {"));
        instructions.add(new Instruction("4", "\t\tdoWhateverNonCritical();"));
        instructions.add(new Instruction("5", "\t\tenterCriticalRegion();"));
        instructions.add(new Instruction("6", "\t\tdoWhateverCritical();"));
        instructions.add(new Instruction("7", "\t\tleaveCriticalRegion();"));
        instructions.add(new Instruction("8", "\t\tdoWhateverNonCritical();"));
        instructions.add(new Instruction("9", "\t}"));
        instructions.add(new Instruction("10", "}"));
    }
    
    @FXML
    private void backButtonClicked(MouseEvent event) throws Exception {
        Scene currentScene = ((Node) event.getSource()).getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseSimulationMenu.fxml"), soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root, currentStage.getScene().getWidth(),currentStage.getScene().getHeight());
        currentStage.setScene(scene);
    }
    
    @FXML
    private void nextButtonClicked(MouseEvent event) throws Exception {
        nextButton.setText(soiiapplication.SOIIApplication.BUNDLE.getString("next"));
        
        if (listPosition >= 0) {
            previousButton.setDisable(false);
            previousButton.setOpacity(1.0);
        }
        if (listPosition == generatedStates.size()) {
            currentState = simulator.simulate();
            if ((simulationMode == 1 && simulator.getCurrentStep() > 16) || (simulationMode == 2 && simulator.getCurrentStep() > 8)) {
                nextButton.setDisable(true);
                nextButton.setOpacity(0.5);
            }
            generatedStates.add(currentState);
            listPosition++;
        } else {
            currentState = generatedStates.get(listPosition);
            listPosition++;
            if (listPosition == generatedStates.size() && ((simulationMode == 1 && simulator.getCurrentStep() > 16) || (simulationMode == 2 && simulator.getCurrentStep() > 8)))//cerificacao para caso de simulacao com passos definidos
            {
                nextButton.setDisable(true);
                nextButton.setOpacity(0.5);
            }
        }
        //System.out.println("Mode:"+simulationMode);
        //System.out.println("NEXT " + currentState.hashCode());
        displayState(currentState);
    }
    
    @FXML
    private void previousButtonClicked(MouseEvent event) throws Exception {
        listPosition--;
        
        if(listPosition > 0)
            currentState = generatedStates.get(listPosition - 1);
        else {
            previousButton.setDisable(true);
            previousButton.setOpacity(0.5);
        }
        
        nextButton.setDisable(false);
        nextButton.setOpacity(1.0);
        
        //System.out.println("PREVIOUS " + currentState.hashCode());
        displayState(currentState);
    }
    
    private void printInformation() {
        
        if(simulationMode == 1) {
            title.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withsimulationMenuTitle"));
            if(listPosition == 0)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep0"));
            else if(listPosition == 1)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep1"));
            else if(listPosition == 2)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep2"));
            else if(listPosition == 3)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep3"));
            else if(listPosition == 4)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep4"));
            else if(listPosition == 5)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep5"));
            else if(listPosition == 6)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep6"));
            else if(listPosition == 7)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep7"));
            else if(listPosition == 8)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep8"));
            else if(listPosition == 9)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep9"));
            else if(listPosition == 10)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep10"));
            else if(listPosition == 11)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep11"));
            else if(listPosition == 12)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep12"));
            else if(listPosition == 13)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep13"));
            else if(listPosition == 14)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep14"));
            else if(listPosition == 15)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep15"));
            else if(listPosition == 16)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep16"));
            else if(listPosition == 17)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withstep17"));
        }
        /*generate step by step text for non mutual exclusion simulation*/
        else if(simulationMode == 2)
        { 
            title.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutsimulationMenuTitle"));
            if(listPosition == 0)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep0"));
            else if(listPosition == 1)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep1"));
            else if(listPosition == 2)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep2"));
            else if(listPosition == 3)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep3"));
            else if(listPosition == 4)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep4"));
            else if(listPosition == 5)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep5"));
            else if(listPosition == 6)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep6"));
            else if(listPosition == 7)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep7"));
            else if(listPosition == 8)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep8"));
            else if(listPosition == 9)
                instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("withoutstep9"));
            
        }
        else {
            title.setText(soiiapplication.SOIIApplication.BUNDLE.getString("randomsimulationMenuTitle"));
            instructionalLabel.setText(soiiapplication.SOIIApplication.BUNDLE.getString("randomstep"));
        }
    }
    
    private void displayState(CurrentState cs) {
        
       printInformation();
       if (listPosition != 0 && listPosition == generatedStates.size() && ((simulationMode == 1 && simulator.getCurrentStep() > 16) || (simulationMode == 2 && simulator.getCurrentStep() > 8))) {
            updateTable(process_1_tableColumn_instr, instructions_1, firstLastLine, 0, "NOTHING", lastTag1);
            updateTable(process_2_tableColumn_instr, instructions_2, secondLastLine, 0, "NOTHING", lastTag2);
            currentProcess.setText(soiiapplication.SOIIApplication.BUNDLE.getString("noprocess"));
        } else if(listPosition != 0) {
            if (cs.getCurrentProcessID() == 1) {
                currentProcess.setText(soiiapplication.SOIIApplication.BUNDLE.getString("currentprocess1"));
                if (cs.isCriticalBlock()) {
                    currentTag1 = "RED";
                    criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("2blocks1"));
                } else {
                    currentTag1 = "GREEN";
                    criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("noblocking"));
                }
                if(simulationMode == 2 && cs.getProcess1CurrentLine() >= 2  && cs.getProcess2CurrentLine() >= 4)
                    currentTag2 = "NOTHING";
                else
                    currentTag2 = "YELLOW";
            }
            
            if (cs.getCurrentProcessID() == 2) {
                currentProcess.setText(soiiapplication.SOIIApplication.BUNDLE.getString("currentprocess2"));
                if (cs.isCriticalBlock()) {
                    criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("1blocks2"));
                    currentTag2 = "RED";
                } else {
                    currentTag2 = "GREEN";
                    criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("noblocking"));
                }
                if(simulationMode == 1 && cs.getProcess1CurrentLine() >= 6 && cs.getProcess2CurrentLine() >= 2)
                    currentTag1 = "NOTHING";
                else
                    currentTag1 = "YELLOW";
            }
            if (cs.getWhoIsInCriticalRegion() == 0) {
                criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("nocritical"));
            } else if (cs.getWhoIsInCriticalRegion() == 1) {
                criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("critical1"));
            } else if(cs.getWhoIsInCriticalRegion() == 2){
                criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("critical2"));
            } else {
                criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("critical1and2"));
            }
            
            updateTable(process_1_tableColumn_instr, instructions_1, firstLastLine, cs.getProcess1CurrentLine(), currentTag1, lastTag1);
            if (firstLastLine != cs.getProcess1CurrentLine()) {
                firstLastLine = cs.getProcess1CurrentLine();
            }
            
            updateTable(process_2_tableColumn_instr, instructions_2, secondLastLine, cs.getProcess2CurrentLine(), currentTag2, lastTag2);
            if (secondLastLine != cs.getProcess2CurrentLine()) {
                secondLastLine = cs.getProcess2CurrentLine();
            }
            
            lastTag1 = currentTag1;
            lastTag2 = currentTag2;
        }
        
    }
    
    private void updateTable(TableColumn<Instruction, String> process, ObservableList<Instruction> inst, int lastLine, int currentLine, String currentTag, String lastTag) {
        Instruction x;
        if (lastLine != 0) {
            x = inst.get(lastLine);
            if (x.getInstr().contains(lastTag)) {
                x.setInstr(x.getInstr().substring(0, x.getInstr().indexOf(lastTag)));
                inst.set(lastLine, x);
            }
        }
        
        if (currentLine != 0) {
            x = inst.get(currentLine);
            x.setInstr(x.getInstr() + currentTag);
            inst.set(currentLine, x);
        }
        
        process.setCellFactory(column -> {
            return new TableCell<Instruction, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        if (item.contains(currentTag)) {
                            setText(item.substring(0, item.indexOf(currentTag)));
                        } else {
                            setText(item);
                        }
                        
                        // Style all dates in March with a different color.
                        if (item.contains(currentTag) && currentTag.equals("GREEN")) {
                            setTextFill(Color.WHITE);
                            setStyle("-fx-background-color: green");
                        } else if (item.contains(currentTag) && currentTag.equals("YELLOW")) {
                            setTextFill(Color.BLACK);
                            setStyle("-fx-background-color: yellow");
                        } else if (item.contains(currentTag) && currentTag.equals("RED")) {
                            setTextFill(Color.WHITE);
                            setStyle("-fx-background-color: red");
                        } else {
                            setTextFill(Color.BLACK);
                            setStyle("");
                        }
                    }
                }
            };
        });
    }
}
