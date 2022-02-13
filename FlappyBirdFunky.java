import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Object;
import greenfoot.GreenfootSound;
/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBirdFunky extends Actor
{
    // his speed doubles
    double dy = 0;
    double g = 0.8;
    double JUMP_SPEED = -8;
    
    GreenfootSound explosionSound = new GreenfootSound("explosion.wav");
    /**
     * Act - do whatever the FlappyBirdFunky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // if touching pipe show Game Over!!
        if(getOneIntersectingObject(BottomPipeFunky.class) != null || getOneIntersectingObject(TopPipeFunky.class) != null)
        {
            showGameOver();
        }
        
        rotateFlappyBirdFunky();
        setLocation(getX(), (int)(getY() + dy));
        
        // if going bottom of world show Game Over!
        if(getY() > getWorld().getHeight() || getY() < getWorld().getHeight() - 450)
        {
            showGameOver();
        }
        
        //makes flappy go up
        if(Greenfoot.isKeyDown("up") == true)
        {
            dy = JUMP_SPEED;
        }           
        
        //eats fruit
        if(isTouching(FruitFunky.class))
        {
            removeTouching(FruitFunky.class);
            showGameOver();
            explosionSound.setVolume(80); 
            explosionSound.play();
        }
     
        dy = dy + g;
    }  
    
    //shows game over
    private void showGameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2); 
        Greenfoot.stop();
    }
    
    private void rotateFlappyBirdFunky()
    {
        if(dy < 1)
        {
            setRotation(-30);
        }
        else if(dy < 8)
        {
            setRotation(0);
        }
        else if (dy < 12)
        {
            setRotation(50);
        }
    }    
}
