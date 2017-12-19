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
    static  int[][] creepCount = new  int[][]{
    {1,2,3,0},
    {1,3,4,0},
    {2,2,2,0},
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

    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        if(id==0&&Starter.isStart()){
            timer ++;
            World world = getWorld();
            //List creepInRange = getObjectsInRange(100,Creep.class);
           if(timer%60==0){
               for(int i = 0;i<5;i++){
                   if(MyWorld.getWave()==i){
                        for(int j = 0;j<4;j++){
                            if(creepCount[i][j]>0){
                                Creep c = new Creep(j);
                                world.addObject(c,getX(),getY());
                                creepCount[i][j] -= 1;
                                break;
                            }else {
                                spawned=true;
                            }
                        }
                    }
               }
           }
           /*switch(MyWorld.getWave()){
                case 1: if(timer%60==0){
                            if(creepCount[0][0]>0){
                                Creep c1 = new Creep(0);
                                world.addObject(c1,getX(),getY());
                                creepCount[0][0] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[0][1]>0){
                                Creep c1 = new Creep(1);
                                world.addObject(c1,getX(),getY());
                                creepCount[0][1] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[0][2]>0){
                                Creep c1 = new Creep(2);
                                world.addObject(c1,getX(),getY());
                                creepCount[0][2] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[0][3]>0){
                                Creep c1 = new Creep(3);
                                world.addObject(c1,getX(),getY());
                                creepCount[0][3] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }else{
                                spawned = true;
                                break;
                            }
                        }
               case 2: if(timer%60==0){
                            if(creepCount[1][0]>0){
                                Creep c1 = new Creep(0);
                                world.addObject(c1,getX(),getY());
                                creepCount[1][0] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[1][1]>0){
                                Creep c1 = new Creep(1);
                                world.addObject(c1,getX(),getY());
                                creepCount[1][1] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[1][2]>0){
                                Creep c1 = new Creep(2);
                                world.addObject(c1,getX(),getY());
                                creepCount[1][2] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }
                            else if(creepCount[1][3]>0){
                                Creep c1 = new Creep(3);
                                world.addObject(c1,getX(),getY());
                                creepCount[1][3] -= 1;
                                System.out.println("Wave: "+MyWorld.getWave()+", crep 0");
                                break;
                            }else{
                                spawned = false;
                                break;
                            }
                        }
               case 3: if(timer%60==0){
                            if(creepCount[2][0]>0){
                                Creep c1 = new Creep(0);
                                world.addObject(c1,getX(),getY());
                            }
                            if(creepCount[2][1]>0){
                                Creep c1 = new Creep(1);
                                world.addObject(c1,getX(),getY());
                            }
                            if(creepCount[2][2]>0){
                                Creep c1 = new Creep(2);
                                world.addObject(c1,getX(),getY());
                            }
                            if(creepCount[2][3]>0){
                                Creep c1 = new Creep(3);
                                world.addObject(c1,getX(),getY());
                            }
                        }

           }*/
            List objects = world.getObjects(Creep.class);
            if(objects.isEmpty()&&spawned&&Starter.isStart()){
                MyWorld.nextWave();
                spawned = false;
                Starter.stop();
            }
            //System.out.println(System.currentTimeMillis());
            
        }
    }    
}
