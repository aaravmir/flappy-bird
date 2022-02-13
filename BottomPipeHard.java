import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottomPipeHard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomPipeHard extends Actor
{
    int SPEED_PIPE_HARD = 6;
    /**
     * Act - do whatever the BottomPipeHard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage pic = getImage();
        setLocation(getX() - SPEED_PIPE_HARD, getY());
    }    
}
