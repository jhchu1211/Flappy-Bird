import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends SharedMembers
{
    private static final GreenfootImage ground = new GreenfootImage("ground.png");
    
    public Ground()
    {
        setImage(ground);
        this.xSpeed = 4;
    }
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        this.moveLeft();
        removeGround();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void removeGround()
    {
        // put your code here
        if (getX() < - getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
    }

}
