import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FunkyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunkyWorld extends World
{
    int pipeCounter = 0;
    int fruitCounter = 0;
    int flappyCounter;
    int flappyFruitCounter;
    int PIPE_SPACING = 150;
    int score = 0;
    int POINT = 230;
    Score scorePic = null;
    
    GreenfootSound funkySong = new GreenfootSound("funky.mp3");
    GreenfootSound dingSound = new GreenfootSound("dingSound.mp3");
    
    /**
     * Constructor for objects of class FunkyWorld.
     * 
     */
    public FunkyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // paint order
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class, BottomPipeFunky.class, TopPipeFunky.class);
        
        // create object of bird
        FlappyBirdFunky flappyBirdFunky = new FlappyBirdFunky();
        
        //add flappy to world
        addObject(flappyBirdFunky, 100, getHeight() - 250);
        
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

        startSound4();
    }
    
    //plays sound
    public void startSound4()
    { 
        funkySong.setVolume(70); 
        funkySong.play();
    }
    
    //creates the pipes
    private void makePipes()
    {
        BottomPipeFunky botPipe = new BottomPipeFunky();
        TopPipeFunky topPipe = new TopPipeFunky();
        
        GreenfootImage botPic = botPipe.getImage();
        addObject(botPipe, getWidth(), getHeight() + Greenfoot.getRandomNumber(70) - 5);
        
        GreenfootImage topPic = topPipe.getImage();
        addObject(topPipe, getWidth(), getHeight()/2 - Greenfoot.getRandomNumber(100) - 120); 

    } 
    
    //spawns fruit
    private void spawnFruit()
    {
        FruitFunky fruit = new FruitFunky();
        
        GreenfootImage fruitPic = fruit.getImage();
        addObject(fruit, getWidth(), getHeight()/2 + Greenfoot.getRandomNumber(40));
    
    }
}