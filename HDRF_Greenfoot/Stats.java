import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats extends Actor
{
    private GreenfootImage background = new GreenfootImage("img/menu.png");
    static long t = 10*60;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            plus200Money();
        }
        getImage().scale(119,90);
        getImage().clear();
        //getImage().drawImage(background, 0, 0);
        getImage().drawString("Level: "+MyWorld.level, 10, 10);
        getImage().drawString("Wave: "+MyWorld.getWave(), 10, 25);
        getImage().drawString("Lives: "+ MyWorld.getLives(), 10, 40);
        getImage().drawString("Money: "+ MyWorld.getMoney(), 10, 55);
        //getImage().drawString("start: "+ Button.isStart(), 10, 70);
        getImage().drawString("Next Wave in: "+ t/60+"s", 10, 80);
        if(!Button.isStart()&&t>0&&!MyWorld.init){
            t--;
        }
        if(t == 0){
            Button.starter= true;
        }
        //getWorld().getObjects(Screen.class)
        if(MyWorld.getWave()==10){
            Screen sc = new Screen("stageclear");
            getWorld().addObject(sc,500,320);
            Button b = new Button("cont");
            getWorld().addObject(b,500, 450);
            MyWorld.setWave(1);
        }
        if(MyWorld.getLives()==0){
            Screen sc = new Screen("rip");
            getWorld().addObject(sc,500,320);
            Button b = new Button("goback");
            getWorld().addObject(b,500, 450);
            System.out.println("rips");
            MyWorld.setWave(1);
            MyWorld.lives=1;
        }
     }    
    public void plus200Money(){
        MyWorld.addMoney(200);
    }
}
