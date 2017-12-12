import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    static int timer = 0;
    static int waves = 20;
    static  int[][] creepCount = new  int[][]{
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0}
    };
    int id;
    public Floor(int idAusArray){
        id = idAusArray;
        switch(id){
        case 36:   setImage("img/Grass.png"); //Grass
                   break;
        case 15:   setImage("img/Dirt.png"); //Weg
                   break;
        case 0:    setImage("img/Dirt.png"); //Creep Spawner
                   break;
        case 1:    setImage("img/Dirt.png"); //End Stück
                   break;
        }
    }
    /*private int getId(){
        return id;
    }*/
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        if(id==0){
            timer ++;
            World world = getWorld();
            //List creepInRange = getObjectsInRange(100,Creep.class);
            switch(MyWorld.getWave()){
                case 1: if(timer%60==0){
                            if(true){
                                Creep c1 = new Creep(0);
                                world.addObject(c1,getX(),getY());
                            }
                        }
                case 2: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
                case 3: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
                case 4: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
                case 5: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
                case 6: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
                case 7: if(timer%60==0){
                            Creep c1 = new Creep(0);
                            world.addObject(c1,getX(),getY());
                        }
            }
        }
    }    
}
