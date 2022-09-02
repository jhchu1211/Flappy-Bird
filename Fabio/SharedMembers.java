import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SharedMembers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SharedMembers extends Actor
{
      protected int frame;
      protected int animationDelay;
      protected int xSpeed;
      
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    protected void moveLeft()
    {
        // put your code here
        setLocation(getX() - this.xSpeed, getY());
    }

}
