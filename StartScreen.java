import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    
    Label title = new Label("Welcome to Flappy Bird!", 40);
    Label instruction = new Label("Press the up arrow to fly!", 40);
    Label instructionLevelNormal = new Label("Press 1 to enter normal mode!", 30);
    Label instructionLevelHard = new Label("Press 2 to enter hard mode!", 30);
    Label instructionLevelFunky = new Label("Press 3 to enter funky mode!", 30);
    GreenfootSound themeSong = new GreenfootSound("themeSong.mp3");
    


    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
    }
    
    public void prepare()
    {
        addObject(title, getWidth()/2, getHeight()/2 - 100);
        addObject(instruction, getWidth()/2, getHeight()/2 - 33);
        addObject(instructionLevelNormal, getWidth()/2, getHeight()/2 + 25);
        addObject(instructionLevelHard, getWidth()/2, getHeight()/2 + 75);
        addObject(instructionLevelFunky, getWidth()/2, getHeight()/2 + 125);
        Greenfoot.setSpeed(50);
        startSound();
    }
    
    //plays sound
    public void startSound()
    { 
        themeSong.setVolume(50); 
        themeSong.play();
    }
    
    public void act()
    {
       prepare();
       while(Greenfoot.isKeyDown("1"))
       {
           if(Greenfoot.getKey() == null)
           {
               Greenfoot.setWorld(new FlappyBirdWorld());     
               themeSong.stop();
           }
       }
       
       while(Greenfoot.isKeyDown("2"))
       {
           if(Greenfoot.getKey() == null)
           {
               Greenfoot.setWorld(new FlappyBirdWorldHard());
               themeSong.stop();
           }
       }
       
       while(Greenfoot.isKeyDown("3"))
       {
           if(Greenfoot.getKey() == null)
           {
               Greenfoot.setWorld(new FunkyWorld());
               themeSong.stop();
           }
       }
    }
}
