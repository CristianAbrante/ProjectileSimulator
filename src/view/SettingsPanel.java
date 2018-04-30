/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

/**
 * <h2>SettingsPanel</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class SettingsPanel extends JPanel {
  
  private class SlidersChangeManager implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      if (e.getSource() == heightSlider) {
        setCurrentHeight();
      } else if (e.getSource() == velocitySlider) {
        setCurrentVelocity();
      } else if (e.getSource() == angleSlider) {
        setCurrentAngle();
      }
    }
  }
  
  public final static String START = "Start";
  public final static String PAUSE = "Pause";
  public final static String RESET = "Reset";
 
  private Controller controller;
  
  private JButton start = new JButton(START);
  private JButton pause = new JButton(PAUSE);
  private JButton reset = new JButton(RESET);
  
  private JLabel initialHeight = new JLabel("initial height", SwingConstants.CENTER);
  private JLabel initialVelocity = new JLabel("initial velocity", SwingConstants.CENTER);
  private JLabel initialAngle = new JLabel("initial angle", SwingConstants.CENTER);
  
  private JSlider heightSlider = new JSlider(1, Controller.MAX_HEIGHT, Controller.MAX_HEIGHT / 2);
  private JSlider velocitySlider = new JSlider(1, Controller.MAX_VELOCITY, Controller.MAX_VELOCITY / 2);
  private JSlider angleSlider = new JSlider(1, Controller.MAX_ANGLE, Controller.MAX_ANGLE / 2);
  
  private JLabel currentHeight = new JLabel("", SwingConstants.LEFT);
  private JLabel currentVelocity = new JLabel("", SwingConstants.LEFT);
  private JLabel currentAngle = new JLabel("", SwingConstants.LEFT);
  
  private JCheckBox showTrayectory = new JCheckBox("show trayectory");
  
  public SettingsPanel(Controller controller) {
    this.controller = controller;
    setLayout(new GridLayout(0, 4));
    start.addActionListener(controller);
    add(start);
    add(initialHeight);
    setSlider(heightSlider);
    add(heightSlider);
    setCurrentHeight();
    add(currentHeight);
    
    pause.addActionListener(controller);
    add(pause);
    add(initialVelocity);
    setSlider(velocitySlider);
    add(velocitySlider);
    setCurrentVelocity();
    add(currentVelocity);
    
    reset.addActionListener(controller);
    add(reset);
    add(initialAngle);
    setSlider(angleSlider);
    add(angleSlider);
    setCurrentAngle();
    add(currentAngle);
    
    add(showTrayectory);
  }
  
  public double getInitialHeight() {
    return (double) heightSlider.getValue();
  }
  
  public double getInitialVelocity() {
    return (double) velocitySlider.getValue();
  }
  
  public double getInitialAngle() {
    return (double) angleSlider.getValue();
  }
  
  public boolean isShowTrayectorySelected() {
    return showTrayectory.isSelected();
  }
  
  public int getWidth() {
    return this.controller.drawableGrid.getWidth();
  }
  
  public int getHeight() {
    return 100;
  }
  
  private void setSlider(JSlider slider) {
    slider.addChangeListener(new SlidersChangeManager());
    slider.setMajorTickSpacing(slider.getMaximum() / 4);
    slider.setPaintTicks(true);
  }
  
  private void setCurrentHeight() {
    currentHeight.setText(Integer.toString(heightSlider.getValue()) + " m");
  }
  
  private void setCurrentVelocity() {
    currentVelocity.setText(Integer.toString(velocitySlider.getValue()) + " m/s");
  }
  
  private void setCurrentAngle() {
    currentAngle.setText(Integer.toString(angleSlider.getValue()) + "º");
  }
}
