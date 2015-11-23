/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pm
 */
public class RockPaperScissors extends JPanel implements ActionListener {
    // Buttons
    JButton rock = null;
    JButton paper = null;
    JButton scissors = null;
    JButton reset = null;
    
    // Bilder
    Image imgPlayer = null;
    Image imgPc = null;
    
    // Random - für PC-Auswahl
    Random rand = null;
    String arrayRandPc[] = {"rock",
                            "paper",
                            "scissors"};
    
    // Merken welches Bild angezeigt wird
    boolean isRockPlayer = false;
    boolean isPaperPlayer = false;
    boolean isScissorsPlayer = false;
    boolean isRockPc = false;
    boolean isPaperPc = false;
    boolean isScissorsPc = false;
    
    // Siege merken
    Integer winsPlayer = 0;
    Integer winsPc = 0;
    
    public RockPaperScissors() {
        init();
    }
    
    public void init() {
        // Hintergrundfarbe ändern
        setBackground(Color.white);
        
        // Buttons erzeugen
        rock = new JButton("rock");
        paper = new JButton("paper");
        scissors = new JButton("scissors");
        reset = new JButton("reset");
        
        // Buttons zum Panel hinzufügen
        // Buttons sichtbar machen
        add(rock);
        add(paper);
        add(scissors);
        add(reset);
        
        // Random Objekt erzeugen
        rand = new Random();
        
        // ActionListener auf die Buttons
        rock.addActionListener(this);
        paper.addActionListener(this);
        scissors.addActionListener(this);
        reset.addActionListener(this);
        
        // Startbilder laden
        imgPlayer = Toolkit.getDefaultToolkit().getImage("img/play.png");
        imgPc = Toolkit.getDefaultToolkit().getImage("img/play.png");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // je nachdem welcher Button gedrückt wurde (e.getSource()), das Bild laden
        // und merken was der Spieler gewählt hat
        // TODO
        
        // Methode zur Gewinnermittlung whoWon aufrufen
        if(e.getSource() == reset) {
            whoWon();
        }else if(e.getSource() == paper){
            setImage("paper", true);
            System.out.println("sup");
        }else if(e.getSource() == rock){
            setImage("rock", true);
        }else if(e.getSource() == scissors){
            setImage("scissors", true);
        }
        randPc();
        repaint();
        // Panel neu zeichnen, damit Ansicht aktuell dargestellt wird, da sich Bilder geändert haben
        // TODO
    }
    
    public void whoWon() {
        // Regeln
        // Spieler hat gewonnen
        // TODO
        
        // Pc hat gewonnen
        // TODO
        
    }
    
    public Image randPc() {
        Image img;
        int index;
        // Anzahl der Elemente im Array 3
        index = rand.nextInt(3);
        
        // prüfen, welches Zeichen PC zeigt und merken
        // TODO
        
        // Zufallsbild laden
        System.out.println(index);
        img = Toolkit.getDefaultToolkit().getImage(arrayRandPc[index]);
        setImage(getImage(arrayRandPc[index]))
        return img;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Typecast auf Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        
        // Beschriftung
        g2d.setColor(Color.blue);
        g2d.drawString("Player", 10, 90);
        g2d.setColor(Color.red);
        g2d.drawString("PC", 250, 90);
        // Trennlinie
        g2d.setColor(Color.black);
        g2d.drawLine(10, 100, 490, 100);
        // Bilder zeichnen
        g2d.drawImage(imgPlayer, 10, 120, this);
        g2d.drawImage(imgPc, 250, 120, this);
        // Siege anzeigen
        g2d.drawString(winsPlayer.toString(), 10, 300);
        g2d.drawString(winsPc.toString(), 250, 300);
    }

    private void setImage(String move, boolean b) {
        //To change body of generated methods, choose Tools | Templates.
        if(b){move+="Right";}
        imgPlayer = Toolkit.getDefaultToolkit().getImage("img/"+move+".jpg");
        System.out.println("img/"+move+".jpg");
    }
}
