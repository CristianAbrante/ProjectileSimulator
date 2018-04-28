package projectile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectileTest {
  
  ProjectileMotion projectile;
  
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void firstExampleTest() {
    projectile = new ProjectileMotion(10.0, 30.0, 0.0);
    assertTrue(projectile.getMaxXSecond() == 1.0204);
  }

}
