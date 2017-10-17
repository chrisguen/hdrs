import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    int id;
    public Floor(int idAusArray){
        id = idAusArray;
    }
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
        switch(id){
        case 36:    setImage("img/Grass.png");
                    break;
        case 15:    setImage("img/Dirt.png");
                    break;
        }       
    }    
}
