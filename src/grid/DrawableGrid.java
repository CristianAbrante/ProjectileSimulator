/**
 * 
 */
package grid;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.text.DecimalFormat;

import sun.font.GlyphLayout.LayoutEngineFactory;

/**
 * <h2>DrawableGrid</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		29/04/2018
 * @version 1.0.0
 */
public class DrawableGrid {
  public static final int PADDING = 25;
  public static final int LABEL_PADDING = 25;
  private final int LINE_WIDTH = 4;
  private final Color GRID_COLOR = new Color(200, 200, 200, 200);
  private final DecimalFormat formatter = new DecimalFormat("0.##");
  
  private Grid grid;
  private int numberOfColumns;
  private int numberOfRows;
  
  
  
  public DrawableGrid(Grid grid, int numberOfColumns, int numberOfRows) {
    setGrid(grid);
    setNumberOfColumns(numberOfColumns);
    setNumberOfRows(numberOfRows);
  }
  
  /**
   * @return the grid
   */
  public Grid getGrid() {
    return grid;
  }

  /**
   * @param grid the grid to set
   */
  public void setGrid(Grid grid) {
    if (grid != null) {
      this.grid = grid;      
    } else {
      throw new NullPointerException("grid can't be null");
    }
  }
  
  /**
   * @return the numberOfColumns
   */
  public int getNumberOfColumns() {
    return numberOfColumns;
  }

  /**
   * @param numberOfColumns the numberOfColumns to set
   */
  public void setNumberOfColumns(int numberOfColumns) {
    if (numberOfColumns > 0) {
      this.numberOfColumns = numberOfColumns;      
    } else {
      throw new IllegalArgumentException("number of columns can't be zero or negative.");
    }
  }

  /**
   * @return the numberOfRows
   */
  public int getNumberOfRows() {
    return numberOfRows;
  }

  /**
   * @param numberOfRows the numberOfRows to set
   */
  public void setNumberOfRows(int numberOfRows) {
    if (numberOfRows > 0) {
      this.numberOfRows = numberOfRows;      
    } else {
      throw new IllegalArgumentException("number of columns can't be zero or negative.");
    }
  }
  
  public int getWidth() {
    return getAxisWidth() + 2 * PADDING + LABEL_PADDING;
  }
  
  public int getAxisWidth() {
    return getGrid().getSeparationPixelsX() * getNumberOfColumns();
  }
  
  public int getHeight() {
    return getAxisHeight() + 2 * PADDING + LABEL_PADDING;
  }
  
  public int getAxisHeight() {
    return getGrid().getSeparationPixelsY() * getNumberOfRows();
  }
  
  public static int getFirstXPosition() {
    return PADDING + LABEL_PADDING;
  }
  
  public int getLastXPosition() {
    return getFirstXPosition() + getAxisWidth();
  }
  
  public static int getFirstYPosition() {
    return PADDING;
  }
  
  public int getLastYPosition() {
    return getFirstYPosition() + getAxisHeight();
  }
  
  public void draw(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    // draw white background
    g2.setColor(Color.WHITE);
    g2.fillRect(getFirstXPosition(), getFirstYPosition(), getAxisWidth(), getAxisHeight());
    g2.setColor(Color.BLACK);
    
    for (int i = 0; i <= getNumberOfRows(); ++i) {
      // We draw the small lines on the left.
      int x0 = getFirstXPosition();
      int x1 = x0 + LINE_WIDTH;
      int y0 = PADDING + i * getGrid().getSeparationPixelsY();
      int y1 = y0;
      g2.drawLine(x0, y0, x1, y1);
      
      // Draw grid line
      g2.setColor(GRID_COLOR);
      g2.drawLine(getFirstXPosition() + 1 + LINE_WIDTH, y0, getFirstXPosition() + getAxisWidth(), y1);
      g2.setColor(Color.BLACK);
      
      // Draw label
      String yLabel = formatter.format(getGrid().getAxisY(y0));
      FontMetrics metrics = g2.getFontMetrics();
      int labelWidth = metrics.stringWidth(yLabel);
      g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
    }
    
    g2.drawLine(getFirstXPosition(), getAxisHeight() + getFirstYPosition(), getFirstXPosition(), getFirstYPosition());
    
    for (int i = 1; i <= getNumberOfColumns(); ++i) {
      // We draw the small lines on the left.
      int x0 = getFirstXPosition() + i * getGrid().getSeparationPixelsX();
      int x1 = x0;
      int y0 = getAxisHeight() + PADDING;
      int y1 = y0 - LINE_WIDTH;
      g2.drawLine(x0, y0, x1, y1);
      
      // Draw grid line
      g2.setColor(GRID_COLOR);
      g2.drawLine(x0, y0 - 1 - LINE_WIDTH, x1, PADDING);
      g2.setColor(Color.BLACK);
      
      String xLabel = formatter.format(getGrid().getAxisX(x0));
      FontMetrics metrics = g2.getFontMetrics();
      int labelWidth = metrics.stringWidth(xLabel);
      g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
    }
    
    g2.drawLine(getFirstXPosition(), getAxisHeight() + PADDING, getAxisWidth() + getFirstXPosition(),  getAxisHeight() + getFirstYPosition());
  }
  
  
}
