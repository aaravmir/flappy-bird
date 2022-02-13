import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBirdWorldHard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBirdWorldHard extends World
{
    int pipeCounter = 0;
    int fruitCounter = 0;
    int flappyCounter;
    int PIPE_SPACING_HARD = 175;
    int score = 0;
    int POINT = 240;
    Score scorePic = null;
    GreenfootSound hardModeSong = new GreenfootSound("hardModeBackground.mp3");
    GreenfootSound dingSound = new GreenfootSound("dingSound.mp3");
    
    /**
     * Constructor for objects of class FlappyBirdWorldHard.
     * 
     */
    public FlappyBirdWorldHard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // paint order
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class, BottomPipe.class, TopPipe.class);
        
        // create object of bird
        FlappyBirdHard flappyBirdHard = new FlappyBirdHard();
        
        //add flappy to world
        addObject(flappyBirdHard, 100, getHeight() - 250);
        
        // Create score
        
        scorePic = new Score();
        scorePic.setScore(0);
        
        // Show score
        addObject(scorePic, 538, 365);
    }
    
    public void act()
    {
        pipeCounter++;
        fruitCounter++;
        
        if(pipeCounter % 100 == 0)
        {
            makePipes();
        }    
        
        if(fruitCounter % 800 == 0)
        {
            spawnFruitHard();
        }   
        
        if(pipeCounter >= POINT)
        {
            if(flappyCounter % 100 == 0)
            {
                score++;
                scorePic.setScore(score);
                dingSound.play();
            }
            flappyCounter++;
        }
        startSound3();
    }
    
    //plays sound
    public void startSound3()
    { 
        hardModeSong.setVolume(50); 
        hardModeSong.play();
    }
    

    //creates the pipes
    private void makePipes()
    {
        BottomPipeHard botPipe = new BottomPipeHard();
        TopPipeHard topPipe = new TopPipeHard();
        
        GreenfootImage botPic = botPipe.getImage();
        addObject(botPipe, getWidth(), getHeight() + Greenfoot.getRandomNumber(55) - 5);
        
        GreenfootImage topPic = topPipe.getImage();
        addObject(topPipe, getWidth(), getHeight()/2 - Greenfoot.getRandomNumber(30) - PIPE_SPACING_HARD); 

    }
    
    //spawns fruit
    private void spawnFruitHard()
    {
        FruitHard fruit = new FruitHard();
        
        GreenfootImage fruitPic = fruit.getImage();
        addObject(fruit, getWidth(), getHeight()/2 + Greenfoot.getRandomNumber(40));
    }
}
