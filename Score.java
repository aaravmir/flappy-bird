import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Object;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newPic = new GreenfootImage(100, 50);
        setImage(newPic);
    }    
    
    public void setScore(int score)
    {
        GreenfootImage newPic = getImage();
        newPic.clear();
        
        //Choose and set font
        Font font = new Font("Comic Sans MS", 36);
        newPic.setFont(font);
        
        //set background color and transparency
        Color color = new Color(120, 120, 120, 120);
        newPic.setColor(color);
        newPic.fill();
        newPic.setColor(Color.BLACK);
        newPic.drawString(score + "", 38, 40);
        setImage(newPic);
    }
}
