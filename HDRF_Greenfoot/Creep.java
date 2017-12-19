import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Creep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creep extends Actor
{
    int cId;
    int speed;
    double health;
    double vehicleResistance;
    double resistance;
    int moneyDropped;
    Bar healthBar;
    

    Creep(int i){
        cId = i;
        switch(i){
            case 0:  speed = 2;
                     vehicleResistance = 1;
                     health = MyWorld.getWave()*10+100;
                     setImage("img/soldier1.png");
                     break;
                     
            case 1:  speed = 1;
                     vehicleResistance = 0.8;
                     health = MyWorld.getWave()*10+200;
                     setImage("img/soldier2.png");
                     break;
                     
            case 2:  speed = 1;
                     health = MyWorld.getWave()*10+150;
                     setImage("img/plane.png");
                     break;
                     
            case 3:  speed = 1;
                     health = MyWorld.getWave()*10+50; 
                     setImage("img/boss.png");
                     break;
        }
        moneyDropped = (int)(50+MyWorld.getWave()*0.2);
        switch(cId){
            case 0: setImage("img/soldier1.png");
                    break;
            case 1: setImage("img/soldier2.png");
                    break;
        }
        healthBar = new Bar("","",(int)health,(int)health);
    }
    /*Creep(int i, int h, int s, float ar, float ur, int md){
        cId = i;
        health = h;
        speed = s;
        vehicleResistance = ar;
        Resistance = ur;
        moneyDropped = md;
    }*/
    public void hit(double dmg){
        switch(cId){
            case 0:     health = health - resistance*dmg;
                        healthBar.subtract((int)(resistance*dmg));
                        
            case 1:     health = health - vehicleResistance*dmg;
                        healthBar.subtract((int)(vehicleResistance*dmg));
                        
            case 2:     health = health - resistance*dmg;
                        healthBar.subtract((int)(resistance*dmg));
                        
            case 3:     health = health - resistance*dmg;
                        healthBar.subtract((int)(resistance*dmg));
        }
        if(health<1){
            MyWorld.addMoney(moneyDropped);
            World world = getWorld();
            world.removeObject(healthBar);
            world.removeObject(this);
        }
    }
    public void placeHealthBar(){
        World world = getWorld();
        world.addObject(healthBar,50,50);
        healthBar.setBarWidth(26);
        healthBar.setBarHeight(2);
        healthBar.setFontSize(0.1f);
        healthBar.setShowTextualUnits(true);
    }
    public int getId(){
        return cId;
    }
    /**
     * Act - do whatever the Creep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        healthBar.setLocation(getX(),getY()+20);
        if(cId==2){
            move(1);
            if(getX()>=630){
                World world = getWorld();
                MyWorld.minusLive(1);
                world.removeObject(this);
                world.removeObject(healthBar);
            }
        }
        else{
        switch(getRotation()){
            case 0:     if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)) == 1){
                             MyWorld.minusLive(1);
                             World world = getWorld();
                             world.removeObject(healthBar);
                             world.removeObject(this);
                             break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),(this.getY()-16)/32) == 15){
                             move(speed);
                             break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32)+1,((this.getY()-16)/32)) == 1){
                             move(speed);
                             break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)+1) == 15){
                            turn(90);
                            //System.out.println("0 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)-1) == 15){
                            turn(-90);
                            //System.out.println("0 turn -90");
                            break;
                        
                        }else{
                            //move(speed);
                            System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
            case 90:    if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32+1) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            //System.out.println("90 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            //System.out.println("90 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
                      
            case 180:   if(MyWorld.getObjectId(((this.getX()+15)/32)-1,(this.getY()-16)/32) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32-1)) == 15){
                            turn(90);
                            //System.out.println("180 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32+1)) == 15){
                            turn(-90);
                            //System.out.println("180 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
            case 270:   if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()+15)/32-1) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            //System.out.println("270 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            //System.out.println("270 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
        }}
        
        if(getWorld()!=null){
            List bulletInRange = getObjectsInRange(15,Bullet.class);
            if(bulletInRange.isEmpty()==false){
                if(bulletInRange.get(0)!=null){
                    Bullet temp = (Bullet)bulletInRange.get(0);
                    World world = getWorld();
                    hit(temp.getDmg());
                    world.removeObject(temp);
                }
            }
        }
    }
}