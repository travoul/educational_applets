/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import java.util.Random;
/**
 *
 * @author henrisilver
 */
public class Engine {
    
    public static void simulate(Process first, Process second) {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Process first = new Process(7, 4, 6);
        Process second = new Process(7, 4, 6);
        simulate(first, second);
        
    }
    
}
