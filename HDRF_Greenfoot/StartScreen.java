import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Actor
{
    /**
     * Act - do whatever the StartScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    StartScreen(){
        setImage("img/startscreen.png");
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            World world = getWorld();
            world.removeObject(this);
        }
    }    
}
