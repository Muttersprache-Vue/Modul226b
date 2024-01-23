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
    
    private int minX = 400;
    private int maxX = 800;
    private int minY = 100;
    private int maxY = 400;
    private boolean istAngehalten = false;
    private int delayCounter = 0;
    private int zielvisierX, zielvisierY;
    
    public Zielvisier()
    {
        getImage().scale(getImage().getWidth() / 7 , getImage().getHeight() / 7 );
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("space") && !istAngehalten) {
            istAngehalten = true;
            //System.out.println("Zielvisier X: " + getX());
            //System.out.println("Zielvisier Y: " + getY());
            //zielvisierX = getX();
            //zielvisierY = getY();
            dart dart = new dart(getX(), getY());
            getWorld().addObject(dart, 500, 250);
        }
        
        if(!istAngehalten)
        {
            if(delayCounter <= 0) {
            zufaelligBewegen();
            delayCounter = 30;
        } else {
            delayCounter--;
        }
        }
    }
    
    public void zufaelligBewegen()
    {
        int zufaelligeXPosition = Greenfoot.getRandomNumber(maxX - minX) + minX;
        int zufaelligeYPosition = Greenfoot.getRandomNumber(maxY - minY) + minY;
        setLocation(zufaelligeXPosition, zufaelligeYPosition);
    }
}