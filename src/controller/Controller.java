/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import grid.DrawableGrid;
import grid.Grid;
import projectile.ProjectileMotion;
import view.*;

/**
 * <h2>Controller</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class Controller implements ActionListener {
  
  class TimerController implements ActionListener {
    int currentProjectile;
    int currentFrameX;
    
    /**
     * Constructor of Controller.TimerController
     * 
     */
    public TimerController(int currentProjectile) {
      this.currentProjectile = currentProjectile;
      currentFrameX = drawableGrid.getFirstXPosition();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
      ProjectileMotion projectile = projectiles.get(currentProjectile);
      double currentTime = 0.0;
      
      int lastFrameX = drawableGrid.getLastXPosition();
      
      double currentAxisX= drawableGrid.getGrid().getAxisX(currentFrameX);
      double lastAxisX = projectile.getMaxX();
      
      if (currentFrameX < lastFrameX && Double.compare(currentAxisX, lastAxisX) <= 0) {
        visualPanel.setDrawTrayectory(true);
        currentTime = projectile.getTime(currentAxisX);
        double currentAxisY = projectile.getY(currentTime);
        int currentFrameY = drawableGrid.getGrid().getFrameY(currentAxisY);
        
        visualPanel.setTrayectory(currentFrameX, currentFrameY);
        
        currentFrameX += 1;
        currentAxisX = drawableGrid.getGrid().getAxisX(currentFrameX);
        System.out.println(String.format("xf: %d xa: %.4f t:%.4f", currentFrameX, currentAxisX, currentTime));
        setInformation(currentProjectile, currentTime);
        frame.repaint();
      } else {
        visualPanel.setDrawTrayectory(false);
        actionTimer.stop();
      }
    }
  }
  
  public static final int MAX_HEIGHT = 80;
  public static final int MAX_VELOCITY = 100;
  public static final int MAX_ANGLE = 90;
  
  public Grid gridCalculator;
  public DrawableGrid drawableGrid;
  
  private ArrayList<DrawableProjectile> drawableProjectiles = new ArrayList<DrawableProjectile>();
  private ArrayList<ProjectileMotion> projectiles = new ArrayList<ProjectileMotion>();
  
  private MainFrame frame;
  private VisualPanel visualPanel;
  private SettingsPanel settingsPanel;
  private InformationPanel informationPanel = new InformationPanel();
  
  private final int DELAY = 5;
  private Timer actionTimer;
  
  public Controller() {
    setGrid();
    settingsPanel = new SettingsPanel(this);
    visualPanel = new VisualPanel(drawableGrid, drawableProjectiles);
    frame = new MainFrame(visualPanel, settingsPanel, informationPanel);
    actionTimer = new Timer(DELAY, new TimerController(0));
  }
  
  private void addNewTrayectory(int initialHeight, int initialVelocity, int initialAngle, boolean draw) {
    ProjectileMotion projectile = new ProjectileMotion(initialVelocity, initialAngle, initialHeight);
    if (draw) {
      DrawableProjectile drawableProjectile = new DrawableProjectile(projectile, drawableGrid);
      drawableProjectiles.add(drawableProjectile);
    }
   projectiles.add(projectile);
  }
  
  public void setInformation(int projectileIndex, double currentTime) {
    ProjectileMotion projectile = projectiles.get(projectileIndex);
    informationPanel.setTime(currentTime);
    informationPanel.setX(projectile.getX(currentTime));
    informationPanel.setY(projectile.getY(currentTime));
    informationPanel.setVx(projectile.getXVelocity(currentTime));
    informationPanel.setVy(projectile.getYVelocity(currentTime));
    informationPanel.setV(projectile.getVelocity(currentTime));
    informationPanel.setXMax(projectile.getMaxX());
    informationPanel.setYMax(projectile.getMaxY());
  }
  
  private void setGrid() {
    final double xAxisValue = 50.0;
    final double yAxisValue = 25.0;
    final int xAxisPixels = 50;
    final int yAxisPixels = 25;
    final int numberOfColumns = 16;
    final int numberOfRows = 15;
    
    gridCalculator = new Grid(DrawableGrid.getFirstXPosition(), 
                              numberOfRows * yAxisPixels + DrawableGrid.PADDING, 
                              xAxisValue, yAxisValue, 
                              xAxisPixels, yAxisPixels);
    drawableGrid = new DrawableGrid(gridCalculator, numberOfColumns, numberOfRows);
  }

  /**
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
    case SettingsPanel.START:
      if (!actionTimer.isRunning()) {
        addNewTrayectory((int) settingsPanel.getInitialHeight(), 
            (int) settingsPanel.getInitialVelocity(), 
            (int) settingsPanel.getInitialAngle(), 
            settingsPanel.isShowTrayectorySelected());
        
        actionTimer = new Timer(DELAY, new TimerController(projectiles.size() - 1));
        actionTimer.start();
        frame.repaint();        
      }
      break;
    case SettingsPanel.PAUSE:
      if (actionTimer.isRunning()) {
        actionTimer.stop();
      } else {
        actionTimer.start();
      }
      System.out.println("pause");
      break;
    case SettingsPanel.RESET:
      if (actionTimer.isRunning()) {
        actionTimer.stop();
        visualPanel.setDrawTrayectory(false);
      }
      projectiles.clear();
      drawableProjectiles.clear();
      frame.repaint();
      System.out.println("reset");
      break;
    default:
        break;
    }
  }
}
