import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBirdWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBirdWorld extends World
{
    int pipeCounter = 0;
    int fruitCounter = 0;
    int flappyCounter;
    int flappyFruitCounter;
    int PIPE_SPACING = 150;
    int score = 0;
    int POINT = 230;
    Score scorePic = null;
    
    GreenfootSound normalModeSong = new GreenfootSound("normalModeBackground.mp3");
    GreenfootSound dingSound = new GreenfootSound("dingSound.mp3");
    
    /**
     * Constructor for objects of class FlappyBirdWorld.
     * 
     */
    
    public FlappyBirdWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // paint order
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class, BottomPipe.class, TopPipe.class);
        
        // create object of bird
        FlappyBird flappyBirdNormal = new FlappyBird();
        
        //add flappy to world
        addObject(flappyBirdNormal, 100, getHeight() - 250);
        
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
        
        if(fruitCounter % 500 == 0)
        {
            spawnFruit();
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

        startSound2();
    }
    
    //plays sound
    public void startSound2()
    { 
        normalModeSong.setVolume(27); 
        normalModeSong.play();
    }
    
    //creates the pipes
    private void makePipes()
    {
        BottomPipe botPipe = new BottomPipe();
        TopPipe topPipe = new TopPipe();
        
        GreenfootImage botPic = botPipe.getImage();
        addObject(botPipe, getWidth(), getHeight() + Greenfoot.getRandomNumber(70) - 5);
        
        GreenfootImage topPic = topPipe.getImage();
        addObject(topPipe, getWidth(), getHeight()/2 - 200); 

    } 
    
    //spawns fruit
    private void spawnFruit()
    {
        Fruit fruit = new Fruit();
        
        GreenfootImage fruitPic = fruit.getImage();
        addObject(fruit, getWidth(), getHeight()/2 + Greenfoot.getRandomNumber(40));
    
    }
}