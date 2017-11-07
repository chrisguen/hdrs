import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    Tower(int id){
        switch(id){
            case 0: setImage("img/TowerRed.png");
            break;
   
            case 1: setImage("img/TowerGreen.png");
            break;
        }
    }
    
    private boolean isGrabbed, dragAllowed = true;
    private void getFloorId(int x, int y){
        if(true){
            System.out.println(MyWorld.getObjectId((x-16)/32,(y-16)/32));
            //System.out.println((x-16)/32+" "+(y-16)/32);
            return; //temp.getObjectId((x-16)/32,(y-16)/32);
        }
    }
    public void act() 
    {
            // check for initial pressing down of mouse button
        if (Greenfoot.mousePressed(this) && !isGrabbed && dragAllowed)
        {
            // grab the object
            isGrabbed = true;
            // the rest of this block will avoid this object being dragged UNDER other objects
            World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            world.removeObject(this);
            world.addObject(this, mi.getX(), mi.getY());
            return;
        }
        // check for actual dragging of the object
        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
        {
            // follow the mouse
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX()-(mi.getX()%32)-16,mi.getY()-(mi.getY()%32)-16);
            //System.out.println(mi.getX()/32 + " "+ mi.getY()/32);
            return;
        }
        // check for mouse button release
        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            // release the object
            MouseInfo mi = Greenfoot.getMouseInfo();
            if(mi.getX()<608){
                getFloorId(mi.getX(),mi.getY());
            }
            isGrabbed = false;
            return;
        }
    }    
}
