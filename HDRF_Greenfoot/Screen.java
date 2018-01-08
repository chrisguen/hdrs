import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    /**
     * Act - do whatever the StartScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Screen(String img){
        switch(img){
            case "title":   setImage("img/title.png");
                            
                            break;
            case "ls":      setImage("img/ls.png");
                            break;
            case "stageclear":      setImage("img/stageclear.png");
                            break;    
            case "youdied":      setImage("img/youdied.png");
                            break;
        }
    }
    public void act() 
    {
        
    }    
}
