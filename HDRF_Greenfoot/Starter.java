import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Starter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starter extends Actor
{
    static boolean starter = false;
    /**
     * Act - do whatever the Starter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            starter = true;
        }
    }
    public static void start(){
        starter = true;
    }
    public static void stop(){
        starter = false;
    }
    public static boolean isStart(){
        return starter;
    }
}
