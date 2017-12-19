import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int tId, price, tmpCreepX, tmpCreepY, x , y;
    int timer=0;
    Tower(int id){
        switch(id){
            case 0: setImage("img/TowerRed.png");   
            break;
   
            case 1: setImage("img/TowerGreen.png");
            break;
        }
        tId = id;
    }
    private boolean isGrabbed, dragAllowed, buyAllowed, placed, timer0, timer1;
   
    public void act() 
      {
        boolean d = false;
        timer = timer + 2;
        if (timer % 100 == 0){
            timer0 = true;
        }else{
            timer0 =false;
        }
        if (timer % 50 == 0){
            timer1 = true;
        }else{
            timer1 =false;
        }
        List creepsInRange = getObjectsInRange(100,Creep.class);
        switch(tId){
            case 0:     creepsInRange = getObjectsInRange(120,Creep.class);
                        if(placed && creepsInRange.isEmpty()==false){
                            if(placed && creepsInRange.get(0)!=null){
                                Creep temp = (Creep)creepsInRange.get(0);
                                Creep temp1 = (Creep)creepsInRange.get(1);
                                if(temp.getId()!=2){
                                    tmpCreepX = temp1.getX();
                                    tmpCreepY = temp1.getY();
                                    turnTowards(tmpCreepX,tmpCreepY);
                                }
                            }
                        }
                        if(placed && creepsInRange.isEmpty()==false){
                            if(timer0 && placed && creepsInRange.get(0)!=null){
                                Creep temp = (Creep)creepsInRange.get(0);
                                Creep temp1 = (Creep)creepsInRange.get(1);
                                if(temp.getId()!=2){
                                    tmpCreepX = temp1.getX();
                                    tmpCreepY = temp1.getY();
                                    Bullet b = new Bullet(tId,tmpCreepX, tmpCreepY, getRotation(),25.0);
                                    World world = getWorld();
                                    world.addObject(b,this.getX(),this.getY());
                                    System.out.println("NEW BULLET0 at: "+tmpCreepX +" "+ tmpCreepY);
                                    break;
                                }
                            }
                        }
                        break;

             case 1:    creepsInRange = getObjectsInRange(200,Creep.class);
                        if(placed && creepsInRange.isEmpty()==false){
                            if(placed && creepsInRange.get(0)!=null){
                                Creep temp = (Creep)creepsInRange.get(0); 
                                if(temp.getId()==2){
                                    tmpCreepX = temp.getX();
                                    tmpCreepY = temp.getY();
                                    turnTowards(tmpCreepX,tmpCreepY);
                                }
                            }
                        }
                        if(placed && creepsInRange.isEmpty()==false){
                            if(timer1 && placed && creepsInRange.get(0)!=null){
                                Creep temp = (Creep)creepsInRange.get(0);
                                if(temp.getId()==2){
                                    tmpCreepX = temp.getX();
                                    tmpCreepY = temp.getY();
                                    Bullet b = new Bullet(tId,tmpCreepX, tmpCreepY, getRotation(),20);
                                    World world = getWorld();
                                    world.addObject(b,this.getX(),this.getY());
                                    System.out.println("NEW BULLET1 at: "+tmpCreepX +" "+ tmpCreepY);
                                    break;
                                }
                            }
                        }
                        break;
        }
        // check for initial pressing down of mouse button
        if(MyWorld.getMoney()>=MyWorld.getTowerPrice(tId)){
            dragAllowed = true;
        }else{
            dragAllowed = false;
        }

        if (Greenfoot.mousePressed(this) && !isGrabbed && dragAllowed && !placed)
        {
            // grab the object
            isGrabbed = true;
            // the rest of this block will avoid this object being dragged UNDER other objects
            World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            x = mi.getX();
            y = mi.getY();
            world.removeObject(this);
            world.addObject(this, mi.getX(), mi.getY());
            switch(tId){
                
                case 0: Tower tower0 = new Tower(tId);
                        world.addObject(tower0, MyWorld.t0x,MyWorld.t0y);
                        break;
                case 1: Tower tower1 = new Tower(tId);
                        world.addObject(tower1, MyWorld.t1x,MyWorld.t1y);
                        break;
            }
            return;
        }
        // check for actual dragging of the object
        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
         {
            // follow the mouse
            MouseInfo mi = Greenfoot.getMouseInfo();
            int xCoordinate = mi.getX()-(mi.getX()%32)-16;
            int yCoordinate = mi.getY()-(mi.getY()%32)-16;
                if ((xCoordinate>0 && yCoordinate >0) && (yCoordinate<640)){
                    setLocation(xCoordinate,yCoordinate);
                    if((mi.getX()<608)){
                        int floorId = MyWorld.getObjectId((this.getX()-16)/32,(this.getY()-16)/32);
                        if(floorId == 15){
                            getImage().setTransparency(100);
                        }else getImage().setTransparency(255);
                    }
                }
        }
        // check for mouse button release
        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            // release the object
            MouseInfo mi = Greenfoot.getMouseInfo();
            if(mi.getX()<608){
                int floorId = MyWorld.getObjectId((this.getX()-16)/32,(this.getY()-16)/32);
                //System.out.println(((this.getX()-16)/32));
                //System.out.println(((this.getY()-16)/32));
                if(floorId == 15){
                    World world = getWorld();
                    world.removeObject(this);
                    Tower tower = new Tower(tId);
                    //MyWorld.newTower(tId);
                }else{
                    MyWorld.addMoney(-60);
                }
                //System.out.println("tID: " + tId + " | x,y: " + x + "-" + y + " | floortype2: " + floorId);
            } 
            isGrabbed = false;
            placed = true;
        }
    }
}
