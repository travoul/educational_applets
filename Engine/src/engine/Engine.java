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
public class Engine {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimulatOS simul = new SimulatOS(7, 4, 6, 2, 7, 4, 6, 2, 3);  
        simul.simulate();
    }
    
}
