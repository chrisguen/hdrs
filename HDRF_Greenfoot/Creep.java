import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creep extends Actor
{
    int cId;
    Creep(int i){
        cId = i;
    }
    /**
     * Act - do whatever the Creep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        switch(cId){
            case 0: setImage("img/SoldierGrey.png");
                    break;
            case 1: setImage("img/SoldierGreen.png");
                    break;
        }
        this.setRotation(0);
        move(1);
    }
}
