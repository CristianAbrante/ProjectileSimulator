/**
 * 
 */
package grid;

import java.awt.geom.Point2D;

/**
 * <h2>Grid</h2>
 * The grid class is used to perform 
 * a conversion between screen frame 
 * and any other grid with axis and 
 * separation.
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		29/04/2018
 * @version 1.0.0
 */
public class Grid {
  // axis coordinates
  private double separationValueX;
  private double separationValueY;
  
  // frame coordinates
  private int originX;
  private int originY;
  private int separationPixelsX;
  private int separationPixelsY;
  
  

  /**
   * Constructor of Grid
   * 
   * @param originX
   * @param originY
   * @param separationValueX
   * @param separationValueY
   * @param separationPixelsX
   * @param separationPixelsY
   */
  public Grid(int originX, int originY, 
              double separationValueX, double separationValueY, 
              int separationPixelsX, int separationPixelsY) {
    super();
    setOriginX(originX);
    setOriginY(originY);
    setSeparationValueX(separationValueX);
    setSeparationValueY(separationValueY);
    setSeparationPixelsX(separationPixelsX);
    setSeparationPixelsY(separationPixelsY);
  }

  /**
   * @return the originX
   */
  public int getOriginX() {
    return originX;
  }
  
  /**
   * @param originX the originX to set
   */
  public void setOriginX(int originX) {
    this.originX = originX;
  }
  
  /**
   * @return the originY
   */
  public int getOriginY() {
    return originY;
  }
  
  /**
   * @param originY the originY to set
   */
  public void setOriginY(int originY) {
    this.originY = originY;
  }
  
  /**
   * @return the separationValueX
   */
  public double getSeparationValueX() {
    return separationValueX;
  }
  
  /**
   * @param separationValueX the separationValueX to set
   */
  public void setSeparationValueX(double separationValueX) {
    if (Double.compare(separationValueX, 0.0) > 0) {
      this.separationValueX = separationValueX;      
    } else {
      throw new IllegalArgumentException("separation value x must be double greater than zero.");
    }
  }
  
  /**
   * @return the separationValueY
   */
  public double getSeparationValueY() {
    return separationValueY;
  }
  
  /**
   * @param separationValueY the separationValueY to set
   */
  public void setSeparationValueY(double separationValueY) {
    if (Double.compare(separationValueY, 0.0) > 0) {
      this.separationValueY = separationValueY;      
    } else {
      throw new IllegalArgumentException("separation value y must be double greater than zero.");
    }
  }
  
  /**
   * @return the separationPixelsX
   */
  public int getSeparationPixelsX() {
    return separationPixelsX;
  }
  
  /**
   * @param separationPixelsX the separationPixelsX to set
   */
  public void setSeparationPixelsX(int separationPixelsX) {
    if (separationPixelsX > 0) {
      this.separationPixelsX = separationPixelsX;      
    } else {
      throw new IllegalArgumentException("separation pixel x must be an integer grater than zero.");
    }
  }
  
  /**
   * @return the separationPixelsY
   */
  public int getSeparationPixelsY() {
    return separationPixelsY;
  }
  
  /**
   * @param separationPixelsY the separationPixelsY to set
   */
  public void setSeparationPixelsY(int separationPixelsY) {
    if (separationPixelsY > 0) {
      this.separationPixelsY = separationPixelsY;      
    } else {
      throw new IllegalArgumentException("separation pixel y must be an integer grater than zero.");
    }
  }
  
  /**
   * Method that returns the equivalence of the 
   * x component in grid coordinates into 
   * axis coordinates.
   * 
   * @param frameX the frame x position
   * @return  the correspondent axis x position
   */
  public double getAxisX(int frameX) {
    return (((double) (frameX - getOriginX())) * getSeparationValueX()) / (double) (getSeparationPixelsX());
  }
  
  /**
   * Method that returns the equivalence of the 
   * y component in grid coordinates into 
   * axis coordinates.
   * 
   * @param frameY the frame y position
   * @return  the correspondent axis y position
   */
  public double getAxisY(int frameY) {
    return (((double) (getOriginY() - frameY)) * getSeparationValueY()) / (double) (getSeparationPixelsY());
  }
  
  /**
   * Method that returns the equivalence of the 
   * x component in grid coordinates into 
   * axis coordinates.
   * 
   * @param gridX the grid x position
   * @return  the correspondent frame position
   */
  public int getFrameX(double gridX) {
    return ((int) ((gridX * ((double) (getSeparationPixelsX()))) / getSeparationValueX())) + getOriginX();
  }
  
  /**
   * Method that returns the equivalence of the 
   * y component in grid coordinates into 
   * axis coordinates.
   * 
   * @param gridY the grid y position
   * @return  the correspondent frame position
   */
  public int getFrameY(double gridY) {
    return -((int) ((gridY * ((double) (getSeparationPixelsY()))) / getSeparationValueY())) + getOriginY();
  }
}
