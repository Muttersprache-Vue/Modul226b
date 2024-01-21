import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zielvisier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zielvisier extends Actor
{
    /**
     * Act - do whatever the Zielvisier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int minX = 100;
    private int maxX = 500;
    private int minY = 100;
    private int maxY = 400;
    
    public Zielvisier()
    {
        getImage().scale(getImage().getWidth() / 7 , getImage().getHeight() / 7 );
    }
    
    public void act()
    {
        // Add your action code here.
        zufaelligBewegen();
    }
    
    public void zufaelligBewegen()
    {
        int zufaelligeXPosition = Greenfoot.getRandomNumber(maxX - minX) + minX;
        int zufaelligeYPosition = Greenfoot.getRandomNumber(maxY - minY) + minY;
        setLocation(zufaelligeXPosition, zufaelligeYPosition);
        Greenfoot.delay(30);
    }
}
