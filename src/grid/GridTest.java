/**
 * 
 */
package grid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <h2>GridTest</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		29/04/2018
 * @version 1.0.0
 */
public class GridTest {
  static final double   EPSILON = 10E-6;
  Grid grid;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    grid = new Grid(100, 200, 3.0, 3.0, 25, 25);
  }
  
  @Test
  public void xCoordinateTest() {
    assertEquals(grid.getAxisX(300), 24.0, EPSILON);
    assertEquals(grid.getFrameX(56.789), 573);
    
    assertEquals(grid.getAxisX(153), 6.36, EPSILON);
    assertEquals(grid.getFrameX(57.789), 581);
  }
  
  @Test
  public void yCoordinateTest() {
    assertEquals(grid.getAxisY(50), 18.0, EPSILON);
    assertEquals(grid.getFrameY(6.75), 144);
    
    assertEquals(grid.getAxisY(153), 5.64, EPSILON);
    assertEquals(grid.getFrameY(57.789), -281);
  }
}
