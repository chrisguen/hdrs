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
    {2,2,2,0},
    {1,3,1,0},
    {2,2,2,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {0,0,0,0},
    {-1,-1,-1,-1}
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
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        if(id==0&&Starter.isStart()){
           
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
                   if(MyWorld.getWave()==i){
                        for(int j = 0;j<4;j++){
                            if(creepCount[i][j]>0){
                                Creep c = new Creep(j);
                                world.addObject(c,getX(),getY());
                                c.placeHealthBar();
                                creepCount[i][j] -= 1;
                                break;
                            }else {
                                spawned=true;
                            }
                        }
                    }
               }
           }
           List objects = world.getObjects(Creep.class);
           if((objects.isEmpty()&&spawned&&Starter.isStart())){
               MyWorld.nextWave();
               spawned = false;
               Starter.stop();
           }
            //System.out.println(System.currentTimeMillis());
        }
    }    
    public static void resetWave(){

    }
}
