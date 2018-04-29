package projectile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectileTest {
  
  static final double   EPSILON = 10E-6;
  ProjectileMotion projectile;
  
  @Before
  public void setUp() throws Exception {
    projectile = new ProjectileMotion(10.0, 30.0, 0.0); 
  }
  
  @Test
  public void gettersTest() {
    assertEquals(projectile.getInitialVelocity(), 10.0, EPSILON);
    assertEquals(projectile.getInitialAngle(), 30.0, EPSILON);
    assertEquals(projectile.getInitialHeight(), 0.0, EPSILON);
  }
  
  @Test
  public void settersTest() {
    assertEquals(projectile.getInitialVelocity(), 10.0, EPSILON);
    assertEquals(projectile.getInitialAngle(), 30.0, EPSILON);
    assertEquals(projectile.getInitialHeight(), 0.0, EPSILON);
    
    projectile.setInitialVelocity(40.0);
    projectile.setInitialAngle(20.0);
    projectile.setInitialHeight(5.0);
    
    assertEquals(projectile.getInitialVelocity(), 40.0, EPSILON);
    assertEquals(projectile.getInitialAngle(), 20.0, EPSILON);
    assertEquals(projectile.getInitialHeight(), 5.0, EPSILON);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void initialVelocityErrorTest() {
    projectile.setInitialVelocity(-1.0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void initialAngleErrorTest() {
    projectile.setInitialAngle(-1.0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void initialHeightErrorTest() {
    projectile.setInitialVelocity(-1.0);
  }
  
  @Test
  public void getXTest() {
    for (double t = 0.0; Double.compare(t, 1.0) < 0; t += 0.2) {
      double predictedX = projectile.getInitialVelocity() 
                        * Math.cos(Math.toRadians(projectile.getInitialAngle())) 
                        * t;
      assertEquals(projectile.getX(t), predictedX, EPSILON);
    }
    
    assertEquals(projectile.getX(50.0), projectile.getMaxX(), EPSILON);
    assertEquals(projectile.getX(60.0), projectile.getMaxX(), EPSILON);
    assertEquals(projectile.getX(70.0), projectile.getMaxX(), EPSILON);
    assertEquals(projectile.getX(80.0), projectile.getMaxX(), EPSILON);
    assertEquals(projectile.getX(90.0), projectile.getMaxX(), EPSILON);
  }
  
  @Test
  public void getYTest() {
    for (double t = 0.0; Double.compare(t, 1.0) < 0; t += 0.2) {
      double predictedY = projectile.getInitialHeight()
                        + projectile.getInitialVelocity() * Math.sin(Math.toRadians(projectile.getInitialAngle())) * t
                        - 0.5 * ProjectileMotion.GRAVITY_ACELERATION * Math.pow(t, 2.0);
      assertEquals(projectile.getY(t), predictedY, EPSILON);
    }
    
    assertEquals(projectile.getY(50.0), 0.0, EPSILON);
    assertEquals(projectile.getY(60.0), 0.0, EPSILON);
    assertEquals(projectile.getY(70.0), 0.0, EPSILON);
    assertEquals(projectile.getY(80.0), 0.0, EPSILON);
    assertEquals(projectile.getY(90.0), 0.0, EPSILON);
  }
  
  @Test
  public void getVxTest() {
    for (double t = 0.0; Double.compare(t, 1.0) < 0; t += 0.2) {
      double predictedVx = projectile.getInitialVelocity()
                        * Math.cos(Math.toRadians(projectile.getInitialAngle()));
      assertEquals(projectile.getXVelocity(t), predictedVx, EPSILON);
    }
    
    assertEquals(projectile.getXVelocity(50.0), 0.0, EPSILON);
    assertEquals(projectile.getXVelocity(60.0), 0.0, EPSILON);
    assertEquals(projectile.getXVelocity(70.0), 0.0, EPSILON);
    assertEquals(projectile.getXVelocity(80.0), 0.0, EPSILON);
    assertEquals(projectile.getXVelocity(90.0), 0.0, EPSILON);
  }
  
  public void getVyTest() {
    for (double t = 0.0; Double.compare(t, 1.0) < 0; t += 0.2) {
      double predictedVy = projectile.getInitialVelocity()
                        * Math.sin(Math.toRadians(projectile.getInitialAngle()))
                        - ProjectileMotion.GRAVITY_ACELERATION * t;
      assertEquals(projectile.getYVelocity(t), predictedVy, EPSILON);
    }
    
    assertEquals(projectile.getYVelocity(50.0), 0.0, EPSILON);
    assertEquals(projectile.getYVelocity(60.0), 0.0, EPSILON);
    assertEquals(projectile.getYVelocity(70.0), 0.0, EPSILON);
    assertEquals(projectile.getYVelocity(80.0), 0.0, EPSILON);
    assertEquals(projectile.getYVelocity(90.0), 0.0, EPSILON);
  }
}
