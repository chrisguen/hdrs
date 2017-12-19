import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int dmg, speed, ttl, id, delay;
    Bullet(int i, int d, int s, int dl){
        id = i;
        dmg = d;
        speed = s;
        delay = dl;
    }
    Bullet(int tx, int ty, int rot){
        speed = 7;
        id = 0;
        int x = tx;
        int y = ty;

        setRotation(rot);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        switch(id){
            case 0: setImage("img/bullet1.png");
        }
        move(speed);
        if(isAtEdge()||getX()>=640){
            World world = getWorld();
            world.removeObject(this);
            //Creep temp = (Creep)
            //System.out.println(getRotation());
        }
    }    
}
