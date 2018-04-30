/**
 * 
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Random;

import grid.DrawableGrid;
import grid.Grid;
import projectile.ProjectileMotion;

/**
 * <h2>DrawableProjectile</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class DrawableProjectile {
  
  private final Stroke STROKE = new BasicStroke(2f);
  
  private ProjectileMotion projectile;
  private DrawableGrid referenceGrid;
  private Color color;
  
  /**
   * Constructor of DrawableProjectile
   * 
   * @param projectile
   * @param referenceGrid
   * @param color
   */
  public DrawableProjectile(ProjectileMotion projectile, DrawableGrid referenceGrid, Color color) {
    super();
    setProjectile(projectile);
    setReferenceGrid(referenceGrid);
    setColor(color);
  }

  /**
   * Constructor of DrawableProjectile
   * 
   * @param projectile
   * @param referenceGrid
   */
  public DrawableProjectile(ProjectileMotion projectile, DrawableGrid referenceGrid) {
    super();
    setProjectile(projectile);
    setReferenceGrid(referenceGrid);
    setRandomColor();
  }

  /**
   * @return the projectile
   */
  public ProjectileMotion getProjectile() {
    return projectile;
  }
  
  /**
   * @param projectile the projectile to set
   */
  public void setProjectile(ProjectileMotion projectile) {
    if (projectile != null) {
      this.projectile = projectile;      
    } else {
      throw new NullPointerException("projectile can't be null");
    }
  }
  
  /**
   * @return the referenceGrid
   */
  public DrawableGrid getReferenceGrid() {
    return referenceGrid;
  }
  
  /**
   * @param referenceGrid the referenceGrid to set
   */
  public void setReferenceGrid(DrawableGrid referenceGrid) {
    if (referenceGrid != null) {
      this.referenceGrid = referenceGrid;      
    } else {
      throw new NullPointerException("reference grid can't be null");
    }
  }
  
  /**
   * @return the color
   */
  public Color getColor() {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(Color color) {
    if (color != null) {
      this.color = color;      
    } else {
      throw new NullPointerException("color can't be null");
    }
  }
  
  /**
   * Sets the color of the projectile to a random color;
   */
  public void setRandomColor() {
    Random r = new Random();
    setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
  }
  
  public void draw(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(STROKE);
    g2d.setColor(getColor());
    
    ArrayList<Integer> xPositions = new ArrayList<Integer>();
    ArrayList<Integer> yPositions = new ArrayList<Integer>();
    
    double currentTime = 0.0;
    
    int currentFrameX = getReferenceGrid().getFirstXPosition();
    int lastFrameX = getReferenceGrid().getLastXPosition();
    
    double currentAxisX= getReferenceGrid().getGrid().getAxisX(currentFrameX);
    double lastAxisX = getProjectile().getMaxX();
    
    while(currentFrameX < lastFrameX && Double.compare(currentAxisX, lastAxisX) <= 0) {
      
      currentTime = getProjectile().getTime(currentAxisX);
      double currentAxisY = getProjectile().getY(currentTime);
      int currentFrameY = getReferenceGrid().getGrid().getFrameY(currentAxisY);
      
      xPositions.add(currentFrameX);
      yPositions.add(currentFrameY);
      
      currentFrameX += 1;
      currentAxisX = getReferenceGrid().getGrid().getAxisX(currentFrameX);
      //System.out.println(String.format("xf: %d xa: %.4f t:%.4f", currentFrameX, currentAxisX, currentTime));
    }
    
    g2d.drawPolyline(getArray(xPositions), getArray(yPositions), xPositions.size());
    
    g2d.setColor(Color.BLACK);
  }
  
  private int[] getArray(ArrayList<Integer> array) {
    int[] result = new int[array.size()];
    int i = 0;
    for (Integer element : array) {
      result[i] = element;
      i += 1;
    }
    return result;
  }
}
