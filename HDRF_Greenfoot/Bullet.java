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
    Bullet(int i, int tx, int ty, int rot, double d){
        switch(i){
                case 0:    speed = 9;
                           break;
                case 1:    speed = 11;
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
        switch(id){
            case 0: setImage("img/bullet1.png");
            case 1: setImage("img/bullet1.png");
        }
        move(speed);
        if(isAtEdge()||getX()>=640){
            World world = getWorld();
            world.removeObject(this);
            //Creep temp = (Creep)
            //System.out.println(getRotation());
        }
    }    
    public double getDmg(){
        return dmg;
    }
}
