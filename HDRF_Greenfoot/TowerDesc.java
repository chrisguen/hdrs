import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class TowerDesc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerDesc extends Actor
{
    int id;
    TowerDesc(int a){
        id = a;
        //GreenfootImage background = new GreenfootImage("HELLO WORLD", 10, new Color(255,0,0), BLUE, RED);
    }
    Color RED = new Color(255,0,0);
    Color BLUE = new Color(0,0,255);
    Color GREEN = new Color(0,255,0);
    
    public void act() 
    {
        getImage().scale(119,68);
        getImage().clear();
        //getImage().drawImage(background, 0, 0);
        getImage().drawString("Tower: "+id, 10, 20);
        switch(id){
            case 0: getImage().drawString("Cost: "+MyWorld.t0price, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(0))getImage().drawString("Nicht genug Geld!",10,60);
            break;
            case 1: getImage().drawString("Cost: "+MyWorld.t1price, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(1))getImage().drawString("Nicht genug Geld!",10,60);
            break;
            case 2: getImage().drawString("Cost: "+MyWorld.t2price, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(2))getImage().drawString("Nicht genug Geld!",10,60);
            break;
        } 
    }    
}
