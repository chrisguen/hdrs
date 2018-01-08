import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String type;
        Button(String img){
        switch(img){
            case "play":    setImage("img/play.png");
                            type = "play";
                            break;
            case "s1":      setImage("img/s1.png");
                            type = "s1";
                            break;
            case "s2":      setImage("img/s2.png");
                            type = "s2";
                            break;    
            case "s3":      setImage("img/s3.png");
                            type = "s3";
                            break;
            case "cont":    setImage("img/continue.png");
                            type = "cont";
                            break;
        }
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            switch(type){
                case "play":    //buildWorld(3);
                                World world = getWorld();
                                world.removeObjects(getWorld().getObjects(Screen.class));
                                Screen ls = new Screen("ls");
                                world.addObject(ls,500,320);
                                
                                Button b1 = new Button("s1");
                                world.addObject(b1,500,250);
                                Button b2 = new Button("s2");
                                world.addObject(b2,500,350);
                                Button b3 = new Button("s3");
                                world.addObject(b3,500,450);
                                
                                world.removeObject(this);
                                break;
                
                case "s1":      buildWorld(1);
                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                getWorld().removeObjects(getWorld().getObjects(Button.class));
                                break;
               
                case "s2":      buildWorld(2);
                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                getWorld().removeObjects(getWorld().getObjects(Button.class));
                                break;
                                
                case "s3":      buildWorld(3);
                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                getWorld().removeObjects(getWorld().getObjects(Button.class));
                                break;
                                
                case "cont":    switch(MyWorld.getLevel()){
                                    case 1:     buildWorld(2);
                                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                                getWorld().removeObjects(getWorld().getObjects(Button.class));                                 
                                                break;
                                    case 2:     buildWorld(3);
                                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                                getWorld().removeObjects(getWorld().getObjects(Button.class));                                 
                                                break;
                                    case 3:     Screen s = new Screen("");
                                                getWorld().removeObjects(getWorld().getObjects(Screen.class));
                                                getWorld().removeObjects(getWorld().getObjects(Button.class));                                 
                                                break;
                                }
            }
        }
    }    
       public void buildWorld(int L){
           System.out.println("getworld: "+getWorld());
        if(getWorld()!=null){List objects = getWorld().getObjects(Floor.class);
        if (objects != null) { getWorld().removeObjects(objects); } 
        switch(L){
            case 1:    for(int y = 16;y<=640;y += 32){
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
          case 3:      for(int y = 16;y<=640;y += 32){
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
        MyWorld.level=L;
        MyWorld.money=200;
        MyWorld.lives=20;
        System.out.println("World "+L+" build");
    }}
}
