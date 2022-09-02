import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Faby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Faby extends SharedMembers
{
    private int birdSelection = Greenfoot.getRandomNumber(2);
    private final String fileNamePrefix = "flappybird_";
    private final String fileNameSuffix = ".png";
    private String colour;

    private double velocity = 0;
    private static final double gravity = 0.5;
    private static final double boostSpeed = -6;
    private int initialDelay;

    public Faby()
    {
        switch (birdSelection)
        {
            case 0: colour = "red";
            break;
            case 1: colour = "yellow";
        }
        this.animationDelay = 4;
    }

    /**
     * Act - do whatever the Faby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        initialDelay++;
        animateFaby();
        if (initialDelay >= 50)
        {
            applyGravity();
            checkKeys();
            rotateFaby();
            upperBoundary();
            checkCollision();
        }
    }

    private void applyGravity()
    {
        setLocation(getX(), (int)(getY() + velocity));
        velocity = velocity + gravity;
    }

    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("space") == true || Greenfoot.mouseClicked(null) == true)
        {
            velocity = boostSpeed;
            Game level = (Game)getWorld();
            level.flapSound.play();
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void animateFaby()
    {
        // put your code here
        this.frame++;
        if (this.frame < 1 * this.animationDelay)
        {
            setImage (fileNamePrefix + colour + 1 + fileNameSuffix);
        }
        else if (this.frame < 2 * this.animationDelay)
        {
            setImage(fileNamePrefix + colour + 2 + fileNameSuffix);
        }
        else if (this.frame < 3 * this.animationDelay)
        {
            setImage(fileNamePrefix + colour + 3 + fileNameSuffix);
            this.frame = 0;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void rotateFaby()
    {
        // put your code here
        if (velocity < 1)
        {
            setRotation(-30);
        }
        else if (velocity < 8)
        {
            setRotation(0);
        }
        else if (velocity < 12)
        {
            setRotation(30);
        }
        else if (velocity < 30)
        {
            setRotation(90);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void checkCollision()
    {
        // put your code here
        Actor Ground = getOneIntersectingObject(Ground.class);
        Actor Pipe = getOneIntersectingObject(Pipe.class);
        if (Pipe != null || Ground != null)
        {
            Game level = (Game)getWorld();
            level.collisionSound.play();
            level.showGameOverScreen = true;
            getWorld().removeObject(this);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void upperBoundary()
    {
        // put your code here
        if (getY() <= 14)
        {
            setLocation(getX(), 14);
        }
    }

}

