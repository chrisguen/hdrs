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
    Bullet(){
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        id = 0;
        switch(id){
            case 0: setImage("img/bullet1.png");
        }
        move(speed);
        if(this.isTouching(Creep.class)||isAtEdge()){
            World world = getWorld();
            world.removeObject(this);
        }
    }    
}
