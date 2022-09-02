import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    
    private int bgSelection = Greenfoot.getRandomNumber(2);
    private final String fileNamePrefix = "background";
    private final String fileNameSuffix = ".png";
    private int pipeCounter;
    
    public boolean showTitleScreen = true;
    public boolean showInstructionsScreen = false;
    public boolean showGameOverScreen = false;
    public boolean playGame = false;
    private boolean addFaby = true;
    private boolean titleObjectsAdded = false;
    private boolean instructionsObjectsAdded = false;
    private boolean playGameObjectsAdded = false;
    private boolean gameOverObjectsAdded = false;
    
    private Score scoreCounter = new Score();
    private Title logo = new Title();
    private Button startButton = new Button("start");
    private Faby gamePlayer = new Faby();
    private Instructions tap = new Instructions("tap");
    private Instructions getReady = new Instructions("getReady");
    private GameOver gameOverText = new GameOver();
    private ScoreCard card = new ScoreCard();
    private Button restartButton = new Button("restart");
    private Medal bronze = new Medal("bronze");
    private Medal silver = new Medal("silver");
    private Medal gold = new Medal("gold");
    
    public GreenfootSound introSound = new GreenfootSound("intro.mp3");
    public GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    public GreenfootSound flapSound = new GreenfootSound("flap.wav");
    public GreenfootSound collisionSound = new GreenfootSound("collision.wav");
    public GreenfootSound pingSound = new GreenfootSound("ping.wav");
    
    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        Greenfoot.start();
        Greenfoot.setSpeed(50);
        
        switch (bgSelection)
        {
            case 0: setBackground(new GreenfootImage(fileNamePrefix + 1 + fileNameSuffix));
            break;
            case 1: setBackground(new GreenfootImage(fileNamePrefix + 2 + fileNameSuffix));
        }
        
        setPaintOrder(Transition.class, Score.class, Medal.class, ScoreCard.class, GameOver.class, Button.class, Ground.class, Faby.class, Pipe.class);       
        Ground initialGround = new Ground();
        addObject(initialGround, 309, getHeight() - 25);
        
        introSound.setVolume(75);
        gameOverSound.setVolume(75);
        flapSound.setVolume(75);
        collisionSound.setVolume(75);
        pingSound.setVolume(75);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void started()
    {
        // put your code here
        introSound.playLoop();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void stopped()
    {
        // put your code here
        introSound.pause();
        gameOverSound.pause();
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void act()
    {
        // put your code here
        createGround();
        
        if (showTitleScreen && !titleObjectsAdded)
        {
            addObject(new Transition("black"), getWidth() / 2, getHeight() / 2);
            addObject(logo, getWidth() / 2, getHeight() / 2 -50);
            addObject(startButton, getWidth() /2, getHeight() / 2 + 25);
            introSound.playLoop();
            titleObjectsAdded = true;
        }
        else if (showInstructionsScreen && !instructionsObjectsAdded)
        {
            introSound.stop();
            removeObject(logo);
            removeObject(startButton);
            addObject(new Transition("black"), getWidth() / 2, getHeight() / 2);
            addObject(getReady, getWidth() / 2, getHeight() / 2 - 75);
            addObject(tap, getWidth () / 2, getHeight() / 2 + 10);
            instructionsObjectsAdded = true;
        }
        else if (playGame)
        {
            removeObject(getReady);
            removeObject(tap);
            if (!playGameObjectsAdded)
            {
                addObject(new Transition("black"), getWidth() / 2, getHeight() / 2);
                addObject(scoreCounter, getWidth() / 2 + 25, 30);
                scoreCounter.setScore(0);
                addObject(gamePlayer, 100, getHeight() / 2);
                playGameObjectsAdded = true;
            }
            createPipe();
        }
        
        if (showGameOverScreen && !gameOverObjectsAdded)
        {
            playGame = false;
            gameOverSound.play();
            addObject(new Transition("white"), getWidth() / 2, getHeight() / 2);
            addObject(gameOverText, getWidth() / 2, getHeight() / 2 - 125);
            addObject(card, getWidth() / 2, getHeight() / 2 -10);
            addObject(restartButton, getWidth() / 2, getHeight() / 2 + 100);
            
            scoreCounter.setLocation(380, 188);
            
            if (scoreCounter.getScore() >= 10)
            {
                addObject(bronze, 237, 194);
            }
            else if (scoreCounter.getScore() >= 50)
            {
                addObject(silver, 237, 194);
            }
            else if (scoreCounter.getScore() >= 100)
            {
                addObject(gold, 237, 194);
            }
            gameOverObjectsAdded = true;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void createPipe()
    {
        // put your code here
        ScoreCollider scoreCol = new ScoreCollider();
        
        Pipe topPipe = new Pipe("top");
        Pipe botPipe = new Pipe("bottom");
        
        int pipeSpacing = 150;
        
        GreenfootImage image = botPipe.getImage();
        
        int numOfPipes = Greenfoot.getRandomNumber(10) + 4;
        
        pipeCounter++;
        if (pipeCounter == 50)
        {
            if(getObjects(Pipe.class).size() < numOfPipes)
            {
                addObject(botPipe, getWidth(), getHeight() / 2 + image.getHeight() - Greenfoot.getRandomNumber(100) -10);
                addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - pipeSpacing);
                addObject(scoreCol, getWidth() + 20, getHeight() / 2);
            }
            pipeCounter = 0;
        }
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void createGround()
    {
        // put your code here
        if (getObjects(Ground.class).size() < 2)
        {
            Ground additionalGround = new Ground();
            addObject(additionalGround, 955, getHeight() - 25);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public Score getScore()
    {
        // put your code here
        return scoreCounter;
    }

}
