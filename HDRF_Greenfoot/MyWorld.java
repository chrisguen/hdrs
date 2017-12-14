import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private static int lives = 20;
    
    private static int wave = 1;
    
    private static int money = 200;
    
    public static int t0x = 700;
    public static int t0y = 250;
    private static int t0price = 60;
    
    public static int t1x = 700;
    public static int t1y = 400;
    private static int t1price = 40;
    
    private Floor[][] array = new Floor[1000][640];
    private static  int[][] ObjectId = new  int[][]{
    {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,36,36,15,15,15,15,15,36,36,36,36,36,36},
    {0,15,15,15,36,36,36,36,36,15,36,36,36,15,36,36,36,36,36,36},
    {36,36,36,15,36,15,15,15,36,15,36,36,36,15,36,36,36,36,36,36},
    {36,36,36,15,36,15,36,15,36,15,36,36,36,15,36,36,36,36,36,36},
    {36,36,36,15,36,15,36,15,36,15,36,36,36,15,36,36,36,36,36,36},
    {36,36,36,15,36,15,36,15,36,15,36,36,36,15,15,15,15,15,15,1},
    {36,36,36,15,15,15,36,15,36,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,15,36,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,15,36,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,15,36,15,15,15,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,15,36,36,36,15,36,36,36,36,36,36,36,36},
    {36,36,15,15,15,15,15,15,36,15,15,15,36,36,36,36,36,36,36,36},
    {36,36,15,36,36,36,36,36,36,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,15,36,36,36,36,36,36,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,15,15,15,15,15,15,15,15,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
    {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36}
    };
    
    public MyWorld()
    {    
        // Create a new world with 1000x640 cells with a cell size of 1x1 pixel
        
        super(1000,640, 1);
        Tower test0 = new Tower(1);
        Tower test1 = new Tower(0);
        Money moneyTest = new Money(money);
        TowerDesc t1desc = new TowerDesc(0);
        TowerDesc t2desc = new TowerDesc(1);
        addObject(moneyTest, 700,200);
        addObject(t1desc,800,260);
        addObject(t2desc,800,410);
        newTower(0);
        newTower(1);      
        for(int y = 16;y<=640;y += 32){
            for (int x = 16; x<=640; x += 32){
                Floor temp = new Floor(ObjectId[(y-16)/32][(x-16)/32]);
                array[x][y] = temp;
                addObject(temp ,x,y);
                //ObjectId[(y-16)/32][(y-16)/32]=
                //System.out.println(x +" " + y)
            }
        }
    }
    
    public static void nextWave(){
        wave++;
    }
    public static int getWave(){
        return wave;
    }
    public static void minusLive(int l){
        lives -= l;
    }
    public static int getLives(){
        return lives;
    }
    public Floor[][] getAllFloors(){
        return array;
    }
    public static int getObjectId(int x, int y){
        return ObjectId[y][x];
    }
    public static int getMoney(){
        return money;
    }
    public static void addMoney(int amount){
        money += amount;
    }
    public void newTower(int id){
        switch(id){
            case 0:     Tower tower0 = new Tower(id);
                        addObject(tower0, t0x,t0y);
                        break;
            case 1:     Tower tower1 = new Tower(id);
                        addObject(tower1, t1x,t1y);
                        break;
        }
    }
    public static int getTowerPrice(int id){
        switch(id){
            case 0: return t0price;
            case 1: return t1price;
            default: return -1;
        }
        
    }
}
