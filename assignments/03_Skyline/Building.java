/**
  Creates a building object of
  specified size, position, and color
  with random windows generated within
#########################################
  @author: E. Jo Zimmerman
  @version: 1.0
  @since: 2015-02-04
*/

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Building
{
  private int width;
  private int height;
  private int x;
  private int y;
  private Color color;
  
  // Building constructor 
  public Building(int w, int h, int leftX, int ground, Color tint)
  {
    width = w;
    height = h;
    x = leftX;
    y = ground - height;
    color = tint;
    
  }
  
  public void draw(Graphics g)
  {
    g.setColor(color);
    g.fillRect(x, y, width, height);
    
    makeWindows(g);
  }
  
  public void setHeight(int tall)
  {
    height = tall;
  }
  
  public void setWidth(int wide)
  {
    width = wide;
  }
  
  public void setColor(Color tint)
  {
    color = tint;
  }
  
  public void setX(int leftX)
  {
    x = leftX;
  }
  
  public void setY(int topY)
  {
    y = topY;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public Color getColor()
  {
    return color;
  }
  
  // create a series of windows fitting the building size
  private void makeWindows(Graphics wind)
  {
    final int WIN_WIDTH = 3;
    final int WIN_HEIGHT = 3;
    // random chances windows are not visible
    Random rand = new Random();
    int windowOut, floorOut;
    
    // determine number of windows by building size
    int windowsAcross = width/(WIN_WIDTH+2);
    int floors = height/(WIN_HEIGHT+2);
    
    // window positioners
    int windowX, windowY;
    
    // prep & draw
    Color windowColor = Color.yellow;
    wind.setColor(windowColor);

    // nest loop: i = y axis, j = x axis;
    for (int i = 0; i < floors; i++)
    {
      // the occasional "missing" floor looks more realistic
      floorOut = rand.nextInt(4);
      if (floorOut > 0)
      {
        windowY = y + (i * (WIN_HEIGHT+2)) + 1;
      
        for (int j = 0; j < windowsAcross; j++)
        {
          windowOut = rand.nextInt(10);

          if (windowOut > 7)
          {
            windowX = x + (j * (WIN_WIDTH+2)) + 1;
            wind.fillRect(windowX, windowY, WIN_WIDTH, WIN_HEIGHT);
          } // end if window chance
        } // end for j/x coord loop
        
      } // end if floorOut
    } // end for i/y coord loop
    
  }
}