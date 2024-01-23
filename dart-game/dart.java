import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dart extends Actor
{
    /**
     * Act - do whatever the dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int zielX;
    private int zielY;
    private boolean gestartet = false;
    
    public dart(int zielX, int zielY)
    {
        getImage().scale(getImage().getWidth() / 3 , getImage().getHeight() / 3 );
        this.zielX = zielX;
        this.zielY = zielY;
        //System.out.println("Zielvisier X: " + getX());
        //System.out.println("Zielvisier Y: " + getY());

    }
    
    public void act() 
    {
        // Add your action code here.
        if(!gestartet)
        {
            bewegeZuZiel();
            gestartet = true;
        }
    }
    
    private void bewegeZuZiel()
    {
        turnTowards(zielX, zielY);
        move(3);
        if(Math.abs(getX() - zielX) < 2 && Math.abs(getY() - zielY) < 2)
        {
            setLocation(zielX, zielY);
            getWorld().removeObject(this);
        }
    }
}