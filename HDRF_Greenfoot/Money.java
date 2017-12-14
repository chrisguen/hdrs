import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends Actor
{
    int amount;
    Money(int a){
        amount = a;
    }
    private GreenfootImage background = new GreenfootImage("img/menu.png");
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            plus200Money();
        }
        getImage().scale(119,68);
        getImage().clear();
        //getImage().drawImage(background, 0, 0);
        getImage().drawString("Wave: "+MyWorld.getWave(), 10, 20);
        getImage().drawString("Lives: "+ MyWorld.getLives(), 10, 35);
        getImage().drawString("Money: "+ MyWorld.getMoney(), 10, 50);
        getImage().drawString("start: "+ Starter.isStart(), 10, 65);
    }    
    public void plus200Money(){
        MyWorld.addMoney(200);
    }
   
}
