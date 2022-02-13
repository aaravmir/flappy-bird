import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FruitFunky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FruitFunky extends Actor
{
    int SPEED_FRUIT_FUNKY = Greenfoot.getRandomNumber(6);
    /**
     * Act - do whatever the FruitFunky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - SPEED_FRUIT_FUNKY, getY());
    }    
}
