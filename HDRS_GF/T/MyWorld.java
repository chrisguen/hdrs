import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    private Floor[][] array = new Floor[1000][1000];
    private ObjectId [][] array = new ObjectId
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixel
        
        super(1024,640, 1);
        
        
       
        for(int y = 16;y<=640;y += 32){
            for (int x = 16; x<=640; x += 32){
                Floor temp = new Floor();
                array[x][y] = temp;
                addObject(temp ,x,y);
                System.out.println(x +" " + y);
            }
        }
    }
    
    public Floor[][] getAllFloors(){
        return array;
    }
}
