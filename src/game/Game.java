/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;

/**
 *
 * @author pm
 */
public class Game extends JFrame {
    public Game() {
        init();
    }
    
    public void init() {
        // Fenstergröße
        setSize(500,350);
        // Programm schliessen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fenster in der Mitte positionieren
        setLocationRelativeTo(null);
        // Fenstergrösse nicht veränderbar
        setResizable(false);
        // JPanel zum Fenster hinzufügen
        add(new RockPaperScissors());
    }
    
    public static void main(String args[]) {
        new Game().setVisible(true);
    }
}
