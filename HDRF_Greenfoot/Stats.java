import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats extends Actor
{
    private GreenfootImage background = new GreenfootImage("img/menu.png");
    long t = 5*60;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            //plus200Money();
            System.out.println("click"+getWorld());
        }
        getImage().scale(119,90);
        getImage().clear();
        //getImage().drawImage(background, 0, 0);
        getImage().drawString("Level: "+MyWorld.level, 10, 10);
        getImage().drawString("Wave: "+MyWorld.getWave(), 10, 25);
        getImage().drawString("Lives: "+ MyWorld.getLives(), 10, 40);
        getImage().drawString("Money: "+ MyWorld.getMoney(), 10, 55);
        getImage().drawString("start: "+ Starter.isStart(), 10, 70);
        /*getImage().drawString("start: "+ t/50, 10, 80);
        if(Starter.isStart()){
            t--;
        }*/
        //getWorld().getObjects(Screen.class)
        if(MyWorld.getWave()==10){
            Screen sc = new Screen("stageclear");
            getWorld().addObject(sc,500,320);
            Button b = new Button("cont");
            getWorld().addObject(b,500, 450);
            MyWorld.setWave(1);
        }
     }    
    public void plus200Money(){
        MyWorld.addMoney(200);
    }
    public void removeFloor(){
        List objects = getWorld().getObjects(Floor.class);
        if (objects != null) { getWorld().removeObjects(objects); }
    }
    public void buildWorld(int l){
        //List objects = getWorld().getObjects(Floor.class);
        //if (objects != null) { getWorld().removeObjects(objects); }
        removeFloor();
        switch(l){
            case 1:     for(int y = 16;y<=640;y += 32){
                            for (int x = 16; x<=640; x += 32){
                                    Floor temp = new Floor(MyWorld.Level1[(y-16)/32][(x-16)/32]);
                                    MyWorld.array[x][y] = temp;
                                    getWorld().addObject(temp ,x,y);
                                    //ObjectId[(y-16)/32][(y-16)/32];
                                    //System.out.println(x +" " + y);
                                }
                            }
                        break;
           case 2:     for(int y = 16;y<=640;y += 32){
                            for (int x = 16; x<=640; x += 32){
                                    Floor temp = new Floor(MyWorld.Level2[(y-16)/32][(x-16)/32]);
                                    MyWorld.array[x][y] = temp;
                                    getWorld().addObject(temp ,x,y);
                                    //ObjectId[(y-16)/32][(y-16)/32];
                                    //System.out.println(x +" " + y);
                                }
                            }
                       break;
          case 3:     for(int y = 16;y<=640;y += 32){
                            for (int x = 16; x<=640; x += 32){
                                    Floor temp = new Floor(MyWorld.Level3[(y-16)/32][(x-16)/32]);
                                    MyWorld.array[x][y] = temp;
                                    getWorld().addObject(temp ,x,y);
                                    //ObjectId[(y-16)/32][(y-16)/32];
                                    //System.out.println(x +" " + y);
                                }
                            }
                      break;
        }
        MyWorld.level=l;
        System.out.println("World "+l+" build");
    }
}
