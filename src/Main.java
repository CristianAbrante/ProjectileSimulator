import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import grid.DrawableGrid;
import grid.Grid;
import projectile.ProjectileMotion;
import view.DrawableProjectile;

/**
 * 
 */

/**
 * <h2>Main</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		29/04/2018
 * @version 1.0.0
 */
public class Main extends JPanel {
  
  DrawableGrid grid;
  DrawableProjectile projectile;
  
  public Main() {
    ProjectileMotion p = new ProjectileMotion(50.0, 75.0, 50.0);
    Grid infoGrid = new Grid(DrawableGrid.PADDING + DrawableGrid.LABEL_PADDING,
                    8 * 50 + DrawableGrid.PADDING,
                    50.0, 25.0, 
                    100, 50);
    
    grid = new DrawableGrid(infoGrid, 6, 8);
    projectile = new DrawableProjectile(p, grid);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    grid.draw(g);
    projectile.draw(g);
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Main mainPanel = new Main();
    mainPanel.setPreferredSize(new Dimension(1000, 600));
    
    JFrame frame = new JFrame("DrawGraph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(mainPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

}
