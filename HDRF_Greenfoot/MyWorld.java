import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
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
    
    private static int level = 1;
    
    public static int t0x = 700;
    public static int t0y = 250;
    private static int t0price = 60;
    
    public static int t1x = 700;
    public static int t1y = 325;
    private static int t1price = 40;
    
    public static int t2x = 700;
    public static int t2y = 400;
    private static int t2price = 100;
    
    private static Floor[][] array = new Floor[1000][640];
    public static  int[][] Level1 = new  int[][]{
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
    
    public static  int[][] Level2 = new  int[][]{
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {0,15,15,15,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,15,36,36,15,15,15,15,15,15,15,36,36,36,36,36,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,36,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,36,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,15,1},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,36,36,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,15,15,15,15,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,15,36,36,36,36,15,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,15,15,15,15,15,15,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36}};
    
    public static  int[][] Level3 = new  int[][]{
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {0,15,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,15,36,36,36,36,36,36,36,15,15,15,15,15,15,15,15,36,36,36},
        {36,15,36,36,36,36,36,36,36,15,36,36,36,36,36,36,15,36,36,36},
        {36,15,36,36,36,36,36,36,36,15,36,36,36,36,36,36,15,36,36,36},
        {36,15,36,36,36,36,36,36,36,15,36,36,36,36,36,36,15,15,15,1},
        {36,15,36,36,36,36,36,36,36,15,36,36,36,36,36,36,36,36,36,36},
        {36,15,36,15,15,15,36,36,36,15,36,36,36,36,36,36,36,36,36,36},
        {36,15,36,15,36,15,36,36,36,15,36,36,36,36,36,36,36,36,36,36},
        {36,15,15,15,36,15,15,15,15,15,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36},
        {36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36}};
    
    public MyWorld()
    {    
        // Create a new world with 1000x640 cells with a cell size of 1x1 pixel
        
        super(1000,640, 1);
        //Tower test0 = new Tower(1);
        //Tower test1 = new Tower(0);
        //Tower test2 = new Tower(2);
        
        //buildWorld(Level2,2);
        buildToolbar();
        StartScreen t = new StartScreen();
        addObject(t,500,320);
        /*for(int y = 16;y<=640;y += 32){
            for (int x = 16; x<=640; x += 32){
                Floor temp = new Floor(ObjectId[(y-16)/32][(x-16)/32]);
                array[x][y] = temp;
                addObject(temp ,x,y);
                //ObjectId[(y-16)/32][(y-16)/32]=
                //System.out.println(x +" " + y)
            }
        }*/
    }
    
    public void buildWorld(int[][] a, int l){
        List objects = getObjects(Floor.class);
        if (objects != null) { removeObjects(objects); }
        for(int y = 16;y<=640;y += 32){
            for (int x = 16; x<=640; x += 32){
                Floor temp = new Floor(a[(y-16)/32][(x-16)/32]);
                array[x][y] = temp;
                addObject(temp ,x,y);
                //ObjectId[(y-16)/32][(y-16)/32];
                //System.out.println(x +" " + y);
            }
        }
        level=l;
        System.out.println("World "+l+" build");
    }
    public void buildToolbar(){
        Money moneyTest = new Money(money);
        TowerDesc t1desc = new TowerDesc(0);
        TowerDesc t2desc = new TowerDesc(1);
        TowerDesc t3desc = new TowerDesc(2);
        Starter s = new Starter();
        addObject(s,800,500);
        addObject(moneyTest, 700,200);
        addObject(t1desc,800,260);
        addObject(t2desc,800,335);
        addObject(t3desc,800,410);
        newTower(0);
        newTower(1);
        newTower(2);
    }
    public static void setLevel(int l){
        level = l;
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
        if(level==1){
            return Level1[y][x];
        }else if(level==2){
            return Level2[y][x];
        }else if(level==3){
            return Level3[y][x];
        }else{
            return Level1[y][x];
        }
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
            case 2:     Tower tower2 = new Tower(id);
                        addObject(tower2, t2x,t2y);
                        break;
        }
    }
    public static int getTowerPrice(int id){
        switch(id){
            case 0: return t0price;
            case 1: return t1price;
            case 2: return t2price;
            default: return -1;
        }
        
    }
}
