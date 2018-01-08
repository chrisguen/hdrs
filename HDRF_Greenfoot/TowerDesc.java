import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    }
    
    private GreenfootImage background = new GreenfootImage("img/menu.png");
    public void act() 
    {
        getImage().scale(119,68);
        getImage().clear();
        //getImage().drawImage(background, 0, 0);
        getImage().drawString("Tower: "+id, 10, 20);
        switch(id){
            case 0: getImage().drawString("Cost: "+60, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(0))getImage().drawString("Nicht genug Geld!",10,60);
            break;
            case 1: getImage().drawString("Cost: "+40, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(1))getImage().drawString("Nicht genug Geld!",10,60);
            break;
            case 2: getImage().drawString("Cost: "+100, 10, 35);
            if(MyWorld.getMoney()<MyWorld.getTowerPrice(2))getImage().drawString("Nicht genug Geld!",10,60);
            break;
        } 
    }    
}
