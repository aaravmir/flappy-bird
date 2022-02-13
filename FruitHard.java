import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FruitHard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FruitHard extends Actor
{
    int SPEED_FRUIT_HARD = 6;
    /**
     * Act - do whatever the FruitHard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - SPEED_FRUIT_HARD, getY());
    }    
}
