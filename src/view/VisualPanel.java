/**
 * 
 */
package view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import grid.DrawableGrid;

/**
 * <h2>VisualPanel</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class VisualPanel extends JPanel {
  private DrawableGrid grid;
  private ArrayList<DrawableProjectile> trayectories;
  
  boolean drawTrayectory = false;
  private int CIRCLE_RADIUS = 5;
  public int trayectoryX = 0;
  public int trayectoryY = 0;
  
  /**
   * Constructor of VisualPanel
   * 
   * @param grid
   * @param trayectories
   */
  public VisualPanel(DrawableGrid grid, ArrayList<DrawableProjectile> trayectories) {
    super();
    setGrid(grid);
    setTrayectories(trayectories);
  }

  /**
   * @return the grid
   */
  public DrawableGrid getGrid() {
    return grid;
  }
  
  /**
   * @param grid the grid to set
   */
  public void setGrid(DrawableGrid grid) {
    this.grid = grid;
  }
  
  /**
   * @return the trayectories
   */
  public ArrayList<DrawableProjectile> getTrayectories() {
    return trayectories;
  }
  
  /**
   * @param trayectories the trayectories to set
   */
  public void setTrayectories(ArrayList<DrawableProjectile> trayectories) {
    this.trayectories = trayectories;
  }
  
  public int getWidth() {
    return getGrid().getWidth();
  }
  
  public int getHeight() {
    return getGrid().getHeight();
  }
  
  /**
   * @param drawTrayectory the drawTrayectory to set
   */
  public void setDrawTrayectory(boolean drawTrayectory) {
    this.drawTrayectory = drawTrayectory;
  }
  
  public void setTrayectory(int x, int y) {
    this.trayectoryX = x;
    this.trayectoryY = y;
  }
  
  /**
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  protected void paintComponent(Graphics g) {    
    super.paintComponent(g);
    getGrid().draw(g);
    for (DrawableProjectile projectile : getTrayectories()) {
      projectile.draw(g);
    }
    
    if (drawTrayectory) {
      g.fillOval(trayectoryX - CIRCLE_RADIUS, trayectoryY - CIRCLE_RADIUS, 2 * CIRCLE_RADIUS, 2 * CIRCLE_RADIUS);
    }
  }
}
