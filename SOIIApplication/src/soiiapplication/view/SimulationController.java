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
 ----- CRIAR OUTROS MODOS DE EXECUÇÃO DO MOUTOR
 |-> FORÇANDO BLOQUEIO NA REGIÃO CRÍTICA, POR EXEMPLO
 ----- CRIAR BOTÃO DE AJUDA E SEÇÃO DE AJUDA NO SIMULADOR PARA INSTRUCÕES
 ----- EDITAR O DID YOU KNOW
 ----- INTERNACIONALIZAR CÓDIGO DA REGIÃO CRíTICA
 ----- FAZER BOTÃO "NEXT" APARECER COMO "INICIAR" EM UM PRIMEIRO MOMENTO
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

    public void setSimulationMode(int mode) {
        this.simulationMode = mode;
    }

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
        currentTag1 = null;
        currentTag2 = null;
        lastTag1 = null;
        lastTag2 = null;
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
        instructions.add(new Instruction("1", "void thread(){"));
        instructions.add(new Instruction("2", "\tint local_variable;"));
        instructions.add(new Instruction("3", "\tlock_critical_region();"));
        instructions.add(new Instruction("4", "\tlocal_variable = read_from_memory(address);"));
        instructions.add(new Instruction("5", "\tlocal_variable++;"));
        instructions.add(new Instruction("6", "\twrite_to_memory(address, local_variable);"));
        instructions.add(new Instruction("7", "\tunlock_critical_region();"));
        instructions.add(new Instruction("8", "}"));

    }

    private void addInstructionsNoMutualExclusion(ObservableList<Instruction> instructions) {
        instructions.add(new Instruction("1", "void thread(){"));
        instructions.add(new Instruction("2", "\tint local_variable;"));
        instructions.add(new Instruction("3", "\tlocal_variable = read_from_memory(address);"));
        instructions.add(new Instruction("4", "\tlocal_variable++;"));
        instructions.add(new Instruction("5", "\twrite_to_memory(address, local_variable);"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"), soiiapplication.SOIIApplication.BUNDLE);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
    }

    @FXML
    private void nextButtonClicked(MouseEvent event) throws Exception {
        if (listPosition > 0) {
            previousButton.setDisable(false);
            previousButton.setOpacity(1.0);
        }
        if (listPosition == generatedStates.size()) {
            currentState = simulator.simulate();

            generatedStates.add(currentState);
            listPosition++;
        } else {
            currentState = generatedStates.get(listPosition);
            listPosition++;
        }
        System.out.println("NEXT " + currentState.hashCode());
        displayState(currentState);
    }

    @FXML
    private void previousButtonClicked(MouseEvent event) throws Exception {

        currentState = generatedStates.get(--listPosition - 1);

        if (listPosition == 1) {
            previousButton.setDisable(true);
            previousButton.setOpacity(0.5);
        }

        System.out.println("PREVIOUS " + currentState.hashCode());
        displayState(currentState);
    }

    private void displayState(CurrentState cs) {

        if (cs.getCurrentProcessID() == 1) {
            currentProcess.setText(soiiapplication.SOIIApplication.BUNDLE.getString("currentprocess1"));
            if (cs.isCriticalBlock()) {
                currentTag1 = "RED";
                criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("2blocks1"));
            } else {
                currentTag1 = "GREEN";
                criticalBlock.setText(soiiapplication.SOIIApplication.BUNDLE.getString("noblocking"));
            }
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
            currentTag1 = "YELLOW";
        }

        if (cs.getWhoIsInCriticalRegion() == 0) {
            criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("nocritical"));
        } else if (cs.getWhoIsInCriticalRegion() == 1) {
            criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("critical1"));
        } else {
            criticalRegion.setText(soiiapplication.SOIIApplication.BUNDLE.getString("critical2"));
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
