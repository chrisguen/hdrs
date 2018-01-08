import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    /**
     * Act - do whatever the StartScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Screen(String img){
        switch(img){
            case "title":   setImage("img/title.png");
                            
                            break;
            case "ls":      setImage("img/ls.png");
                            break;
            case "stageclear":      setImage("img/stageclear.png");
                            break;    
            case "youdied":      setImage("img/youdied.png");
                            break;
        }
    }
    public void act() 
    {
        
    }    
       public void buildWorld(int L){
        //List objects = getObjects(Floor.class);
        //if (objects != null) { removeObjects(objects); }
        switch(L){
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
        MyWorld.level=L;
        System.out.println("World "+L+" build");
    }
}
