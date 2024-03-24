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
    
    //Konstruktor
    public Zielvisier()
    {
        getImage().scale(getImage().getWidth() / 6 , getImage().getHeight() / 6 );
    }
    
    public void act()
    {
        // wenn Leertaste gedrückt wird und Spiel wurde noch nicht angehalten
        if(Greenfoot.isKeyDown("space") && !istAngehalten) {
            //boolean istAngehalten wird auf true gesetzt, Spiel wird angehalten
            istAngehalten = true;
            
            //bei Leertasten-Druck wird ein Dart-Objekt erzeugt und die Koordinaten des Zielvisiers werden mitgegeben
            Dart dart = new Dart(getX(), getY());
            //das erzeugte Dart-Objekt wird der Welt hinzugefügt mit einer Startposition
            getWorld().addObject(dart, 800, 500);
            
            //bei jedem Wurf wird ein Versuchs-Pfeil entfernt
            ((MyWorld) getWorld()).entferneVersuch();
            
            //Verzögerung
            Greenfoot.delay(50);
            //boolean istAngehalten wieder zurücksetzen, für den nächsten Wurfversuch
            istAngehalten = false;
        }
        
        if(!istAngehalten)
        {
            if(delayCounter <= 0) {
            //Methode zufaelligBewegen() in act aufrufen um zufälliges Springen des Zielvisiers zu simulieren
            zufaelligBewegen();
            //Wert 30 wird 30 mal heruntergezählt um eine Verzögerung einzubauen, bei jedem 30. mal wird zufaelligBewegen() ausgeführt
            delayCounter = 30;
        } else {
            delayCounter--;
        }
        }
    }
    
    //Methode zufaelligBewegen() erzeugt Zufallskoordinaten für das Zielvisier um zufällige Bewegung zu simulieren
    public void zufaelligBewegen()
    {
        //für X-Position einen Zufallswert erzeugen
        int zufaelligeXPosition = Greenfoot.getRandomNumber(maxX - minX) + minX;
        //für Y-Position einen Zufallswert erzeugen
        int zufaelligeYPosition = Greenfoot.getRandomNumber(maxY - minY) + minY;
        //Zufallskoordinaten für Zielvisier-Objekt setzen
        setLocation(zufaelligeXPosition, zufaelligeYPosition);
    }
}