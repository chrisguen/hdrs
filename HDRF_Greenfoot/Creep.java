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
    int speed=1;
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
        System.out.println(((this.getX()-16)/32)+" "+((this.getY()-16)/32));
        System.out.println("Rotation: "+getRotation());
        switch(getRotation()){
            case 0:     if(MyWorld.getObjectId(((this.getX()-16)/32)+1,(this.getY()-16)/32) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)+1) == 15){
                            turn(90);
                            System.out.println("0 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32)-1) == 15){
                            turn(-90);
                            System.out.println("0 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
            case 90:    if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32+1) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            System.out.println("90 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            System.out.println("90 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
                      
            case 180:   if(MyWorld.getObjectId(((this.getX()-16)/32)-1,(this.getY()-16)/32) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32-1)) == 15){
                            turn(90);
                            System.out.println("180 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32),((this.getY()-16)/32+1)) == 15){
                            turn(-90);
                            System.out.println("180 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
            case 270:   if(MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32) == 15){
                            move(speed);
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32+1),((this.getY()-16)/32)) == 15){
                            turn(90);
                            System.out.println("270 turn 90");
                            break;
                        }else if(MyWorld.getObjectId(((this.getX()-16)/32-1),((this.getY()-16)/32)) == 15){
                            turn(-90);
                            System.out.println("270 turn -90");
                            break;
                        }else{System.out.println("Unzulaessiger pfad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
        }
        //System.out.println("x y-1 "+MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32-1));
        //System.out.println("x+1 y "+MyWorld.getObjectId(((this.getX()-16)/32+1),(this.getY()-16)/32));
        //System.out.println("x y+1 "+MyWorld.getObjectId(((this.getX()-16)/32),(this.getY()-16)/32+1));
        //System.out.println("x-1 y "+MyWorld.getObjectId(((this.getX()-16)/32-1),(this.getY()-16)/32));
        System.out.println(((this.getX()-16)/32)+" "+((this.getY()-16)/32));
        System.out.println("Rotation: "+getRotation());
    }
}