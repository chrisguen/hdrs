import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creep extends Actor
{
    int cId;
    Creep(int i){
        cId = i;
        switch(cId){
            case 0: setImage("img/SoldierGrey.png");
                    break;
            case 1: setImage("img/SoldierGreen.png");
                    break;
        }
    }
    /**
     * Act - do whatever the Creep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        switch(getRotation()){
            case 0:     if(MyWorld.getObjectId(((this.getX()-16)/32)+1,(this.getY()-16)/32) == 15){
                            move(1);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)+1) == 15){
                            turn(90);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)-1) == 15){
                            turn(-90);
                            break;
                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
            case 90:    if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32+1) == 15){
                            move(1);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            break;
                        }
                      
            case 180:   if(MyWorld.getObjectId(((this.getX()-16)/32)-1,(this.getY()-16)/32) == 15){
                            move(1);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)+1) == 15){
                            turn(90);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)-1) == 15){
                            turn(-90);
                            break;
                        }
            case 270:   if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32-1) == 15){
                            move(1);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            break;
                        }
        }
        //System.out.println("x y-1 "+MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32-1));
        //System.out.println("x+1 y "+MyWorld.getObjectId(((this.getX()-16)/32+1),(this.getY()-16)/32));
        //System.out.println("x y+1 "+MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32+1));
        //System.out.println("x-1 y "+MyWorld.getObjectId(((this.getX()-16)/32-1),(this.getY()-16)/32));
    }
}