import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class ScoreCollider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCollider extends SharedMembers
{
    GreenfootImage image = new GreenfootImage(10, 400);
    
    public ScoreCollider()
    {
        this.xSpeed = 4;
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        image.setTransparency(0);
    }
    
    /**
     * Act - do whatever the ScoreCollider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        this.moveLeft();
        checkCollision();
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
        Actor Faby = getOneIntersectingObject(Faby.class);
        if (Faby != null)
        {
            Game level = (Game) getWorld();
            level.pingSound.play();
            Score addPoints = level.getScore();
            addPoints.setScore(1);
            getWorld().removeObject(this);
        }
        else if (getX() <- getImage().getWidth())
        {
            getWorld().removeObject(this);
        }
    }

}
