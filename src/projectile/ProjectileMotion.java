package projectile;

/**
 * <h2>ProjectileMotion</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 	28 abr. 2018
 * @version 	1.0.0
 */
public class ProjectileMotion {

  private final double GRAVITY_ACELERATION = 9.8;
  
  private double initialVelocity;
  private double initialAngle;
  private double initialHeight;
  
  /**
   * Constructor of ProjectileMotion
   *
   * @param initialVelocity of the projectile, expressed in m/s
   * @param initialAngle    of the projectile, expresed in degrees. 
   * @param initialHeight   where the projectile is going to be thrown, expresed in m.
   */
  public ProjectileMotion(double initialVelocity, double initialAngle, double initialHeight) {
    super();
    setInitialVelocity(initialVelocity);
    setInitialAngle(initialAngle);
    setInitialHeight(initialHeight);
  }

  /**
   * @return the initialVelocity
   */
  public double getInitialVelocity() {
    return initialVelocity;
  }
  
  /**
   * @param initialVelocity the initial velocity to set
   * @throws IllegalArgumentException if initial velocity is lower or equal to zero
   */
  public void setInitialVelocity(double initialVelocity) 
      throws IllegalArgumentException {
    if (initialVelocity >= 1.0) {
      this.initialVelocity = initialVelocity;      
    } else {
      throw new IllegalArgumentException("initial velocity must be greater than zero");
    }
  }

  /**
   * @return the initialAngle
   */
  public double getInitialAngle() {
    return initialAngle;
  }
  
  /**
   * @param initialAngle the initial angle to set
   * @throws IllegalArgumentException if initial angle is lower or equal to zero
   */
  public void setInitialAngle(double initialAngle) 
      throws IllegalArgumentException {
    if (initialAngle > 0.0) {
      this.initialAngle = initialAngle;      
    } else {
      throw new IllegalArgumentException("initial angle must be greater than zero");
    }
  }

  /**
   * @return the initialHeight
   */
  public double getInitialHeight() {
    return initialHeight;
  }

  /**
   * @param initialHeight the initialHeight to set
   */
  /**
   * @param initialHeight the initial height to set
   * @throws IllegalArgumentException
   */
  public void setInitialHeight(double initialHeight) 
      throws IllegalArgumentException {
    if (initialHeight >= 0.0) {
      this.initialHeight = initialHeight;      
    } else {
      throw new IllegalArgumentException("initial height must be greater than zero");
    }
  }
  
  /**
   * Method that return the x position of
   * the projectile at the specified instant 
   * of time.
   * <p>
   * x = V0 * cos(a) * t
   *  
   * @param second  instant of time in seconds
   * @return        the position in the x axis
   * @throws IllegalArgumentException if the second is lower than zero
   */
  public double getX(double second) 
      throws IllegalArgumentException {
    if (second >= 0) {
      if (second < getMaxXSecond()) {
        return getInitialVelocity() * Math.cos(getInitialAngle()) * second;              
      } else {
        return getMaxX();
      }
    } else {
      throw new IllegalArgumentException("second must be greater than zero");
    }
  }
  
  /**
   * Method that return the x position of
   * the projectile at the specified instant 
   * of time.
   * <p>
   * x = V0 * cos(a) * t
   *  
   * @param second  instant of time in seconds
   * @return        the position in the x axis
   * @throws IllegalArgumentException if the second is lower than zero
   */
  public int getX(int second) {
    return (int) (getX((double) (second)));
  }
  
  /**
   * Method that return the y position of
   * the projectile at the specified instant 
   * of time.
   * <p>
   * y = n0 + V0 * sin(a) * t - 0.5 * g * t^2
   *  
   * @param second  instant of time in seconds
   * @return        the position in the y axis
   * @throws IllegalArgumentException if the second is lower than zero
   */
  public double getY(double second) {
    if (second >= 0) {
      if (second < getMaxXSecond()) {
        return getInitialHeight() 
            + getInitialVelocity() * Math.sin(getInitialAngle()) * second
            + 0.5 * GRAVITY_ACELERATION * Math.pow(second, 2);              
      } else {
        return 0.0;
      }
    } else {
      throw new IllegalArgumentException("second must be greater than zero");
    }
  }
  
  /**
   * Method that return the y position of
   * the projectile at the specified instant 
   * of time.
   * <p>
   * y = n0 + V0 * sin(a) * t - 0.5 * g * t^2
   *  
   * @param second  instant of time in seconds
   * @return        the position in the y axis
   * @throws IllegalArgumentException if the second is lower than zero
   */
  public int getY(int second) {
    return (int) (getY((double) (second)));
  }
  
  /**
   * Method that return x axis velocity
   * at a certain instant of time.
   * <p>
   * Vx = V0 * cos(a)
   * 
   * @param second
   * @return
   * @throws IllegalArgumentException
   */
  public double getXVelocity(double second) 
      throws IllegalArgumentException {
    if (second >= 0) {
      if (second < getMaxXSecond()) {
        return getInitialVelocity() * Math.cos(getInitialAngle());        
      } else {
        return 0.0;
      }
    } else {
      throw new IllegalArgumentException("second must be greater than zero");
    }
  }
  
  /**
   * Method that return y axis velocity
   * at a certain instant of time.
   * <p>
   * Vx = V0 * sin(a)
   * 
   * @param second
   * @return
   * @throws IllegalArgumentException
   */
  public double getYVelocity(double second) {
    if (second >= 0) {
      if (second < getMaxXSecond()) {
        return getInitialVelocity() * Math.sin(getInitialAngle())
            - GRAVITY_ACELERATION * second;        
      } else {
        return 0.0;
      }
    } else {
      throw new IllegalArgumentException("second must be greater than zero");
    }
  }
  
  /**
   * Method that returns the max y value
   * that the projectile is going to
   * reach
   * 
   * @return the max y value in meters
   */
  public double getMaxY() {
    return getY(getMaxYSecond());
  }
  
  /**
   * Method that return the maximum value
   * that x going to take until the projectile
   * falls
   * 
   * @return the maximum x distance
   */
  public double getMaxX() {
    return getX(getMaxXSecond());
  }
  
  /**
   * @return the second where the max y is going
   *         to be reached
   */
  public double getMaxYSecond() {
    return (getInitialVelocity() * Math.sin(getInitialAngle())) / GRAVITY_ACELERATION;
  }
  
  /**
   * @return the second where the max x is going
   *         to be reached
   */
  public double getMaxXSecond() {
    double root = Math.pow(getInitialVelocity(), 2.0) * Math.pow(Math.sin(initialAngle), 2.0)
                + 2.0 *  GRAVITY_ACELERATION * getInitialHeight();
    double firstTerm = -getInitialVelocity() * Math.sin(getInitialAngle());
    
    double firstSolution = (firstTerm + Math.sqrt(root)) / -GRAVITY_ACELERATION;
    double secondSolution = (firstTerm - Math.sqrt(root)) / -GRAVITY_ACELERATION;
    return Math.max(firstSolution, secondSolution);
  }
  
  /**
   * Method that solves a quadratic
   * equation and returns the bigger value.
   * <p>
   * ax^2 + bx + c = 0
   * 
   * @param a the x^2 coeficient
   * @param b the x coefficient
   * @param c the independent term
   * @return the bigger solution after solving the equation
   */
  private double getMaxQuadraticSolution(double a, double b, double c) {
    double root = Math.pow(b, 2) - 4 * a * c;
    double firstSolution = (-b + Math.sqrt(root)) / (2 * a);
    double secondSolution = (-b - Math.sqrt(root)) / (2 * a);
    return Math.max(firstSolution, secondSolution);
  }
}
