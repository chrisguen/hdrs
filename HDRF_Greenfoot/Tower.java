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
    public int tId, price;
    Tower(int id){
        switch(id){
            case 0: setImage("img/TowerRed.png");   
            break;
   
            case 1: setImage("img/TowerGreen.png");
            break;
        }
        tId = id;
    }
    int x, y;
    private boolean isGrabbed, dragAllowed, buyAllowed;
   
   public void act() 
    {
        System.out.println(MyWorld.getMoney());
        // check for initial pressing down of mouse button
        if(MyWorld.getMoney()>=MyWorld.getTowerPrice(tId)){
            dragAllowed = true;
        }else{
            dragAllowed = false;
        }
        
        if (Greenfoot.mousePressed(this) && !isGrabbed && dragAllowed)
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
                case 1: Tower tower1 = new Tower(tId);
                        world.addObject(tower1, MyWorld.t1x,MyWorld.t1y);
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
                    MyWorld.addMoney(-60);
                    //System.out.println("Deleted: tID: " + tId + " | x,y: " + x + "-" + y + " | floortype: " + floorId);
                }
                //System.out.println("tID: " + tId + " | x,y: " + x + "-" + y + " | floortype2: " + floorId);
            } 
            isGrabbed = false;

        }
    }    
}
