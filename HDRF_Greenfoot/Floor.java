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
    static boolean spawned = false;
    static boolean start = false;
    static long tempTime;
    static long cd = 0;
    static boolean cd5s = false;
    static boolean cd5ss = false;
    static  int[][] creepCount = new  int[][]{
    {3,0,0},
    {10,2,3},
    {0,3,0},
    {0,6,0},
    {3,3,0},
    {6,6,0},
    {0,0,3},
    {3,3,3},
    {6,3,3},
    {6,6,6}
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
    public static void timer(){
        cd5s=false;
    }
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment
     */
    public void act() 
    { 
        if(id==0&&Button.isStart()){
           /*if((Starter.isStart()==false) && !cd5s){
                cd = System.currentTimeMillis();
                cd5s = true;
           }else if((cd - System.currentTimeMillis())>5000){
                cd5s = false;
           }*/
           timer ++;
           World world = getWorld();
            //List creepInRange = getObjectsInRange(100,Creep.class);
           if(timer%60==0){
               for(int i = 0;i<10;i++){
                   if((MyWorld.getWave())==i){
                        for(int j = 0;j<3;j++){
                            if(creepCount[i-1][j]>0){
                                Creep c = new Creep(j);
                                world.addObject(c,getX(),getY());
                                c.placeHealthBar();
                                creepCount[i-1][j] -= 1;
                                //System.out.println("crep spawned, id: "+j+"i: "+i);
                                break;
                            }else {
                                spawned=true;
                            }
                        }
                    }
               }
           }
           List objects = world.getObjects(Creep.class);
           if((objects.isEmpty()&&spawned&&Button.isStart())){
               MyWorld.nextWave();
               spawned = false;
               Button.stop();
               Stats.t = 50*10;
           }
            //System.out.println(System.currentTimeMillis());
        }
    }    
    public static void resetWavex(){
        creepCount = new int[][]{
            {3,0,0},
            {10,2,3},
            {0,3,0},
            {0,6,0},
            {3,3,0},
            {6,6,0},
            {0,0,3},
            {3,3,3},
            {6,3,3},
            {6,6,6}
        };
    }
}
