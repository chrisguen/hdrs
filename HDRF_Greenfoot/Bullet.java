import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int dmg, speed, ttl, id, delay;
    Bullet(int i, int tx, int ty, int rot, double d){
        switch(i){
                case 0:    speed = 9;
                           setImage("img/bullet1.png");
                           break;
                case 1:    speed = 11;
                           setImage("img/bullet1.png");
                           break;
                case 2:    speed = 4;
                           setImage("img/RocketRed.png");
                           break;
        }
        id = i;
        int x = tx;
        int y = ty;
        dmg = (int)d;
        setRotation(rot);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isAtEdge()||getX()>=640){
                World world = getWorld();
                world.removeObject(this);
                //Creep temp = (Creep)
                //System.out.println(getRotation());
        }
        if(id != 2){
            move(speed);
        }else if(id ==2&&getWorld()!=null){
            List creepsInRange = getObjectsInRange(350,Creep.class);
                        if(creepsInRange.isEmpty()==false){
                            if(creepsInRange.get(0)!=null){
                                for(int i = 0;creepsInRange.size()>i;i++){
                                    Creep temp = (Creep)creepsInRange.get(i);
                                    if(temp.getId()==1||temp.getId()==0){
                                        int tmpCreepX = temp.getX();
                                        int tmpCreepY = temp.getY();
                                        turnTowards(tmpCreepX,tmpCreepY);
                                        //System.out.println("turnTowards: "+tmpCreepX+" "+tmpCreepY);
                                    }else{
                                        continue;
                                    }
                                }
                            }
                        }
           move(speed);
        }
    }    
    public double getDmg(){
        return dmg;
    }
}
