/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * <h2>InformationPanel</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class InformationPanel extends JPanel {
  JPanel pane = new JPanel();
  
  private JButton information = new JButton("Information");
  
  private JLabel time = new JLabel("time = ", SwingConstants.CENTER);
  private JLabel timeValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel x = new JLabel("x = ", SwingConstants.CENTER);
  private JLabel xValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel y = new JLabel("y = ", SwingConstants.CENTER);
  private JLabel yValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel vx = new JLabel("Vx = ", SwingConstants.CENTER);
  private JLabel vxValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel vy = new JLabel("Vx = ", SwingConstants.CENTER);
  private JLabel vyValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel v = new JLabel("V = ", SwingConstants.CENTER);
  private JLabel vValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel xMax = new JLabel("x-max = ", SwingConstants.CENTER);
  private JLabel xMaxValue = new JLabel(new String(), SwingConstants.CENTER);
  private JLabel yMax = new JLabel("y-max = ", SwingConstants.CENTER);
  private JLabel yMaxValue = new JLabel(new String(), SwingConstants.CENTER);
  
  private final DecimalFormat formatter = new DecimalFormat("0.##");
  
  public InformationPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    //setLayout(new GridLayout(0, 1));
    add(information);
    pane.setLayout(new GridLayout(0, 2));
    pane.add(time);
    pane.add(timeValue);
    pane.add(x);
    pane.add(xValue);
    pane.add(y);
    pane.add(yValue);
    pane.add(vx);
    pane.add(vxValue);
    pane.add(vy);
    pane.add(vyValue);
    pane.add(v);
    pane.add(vValue);
    pane.add(xMax);
    pane.add(xMaxValue);
    pane.add(yMax);
    pane.add(yMaxValue);
    add(pane);
  }
  
  public int getWidth() {
    return 160;
  }
 
  public void setTime(double second) {
    timeValue.setText(formatter.format(second));
  }
  
  public void setX(double x) {
    xValue.setText(formatter.format(x));
  }
  
  public void setY(double y) {
    yValue.setText(formatter.format(y));
  }
  
  public void setVx(double vx) {
    vxValue.setText(formatter.format(vx));
  }
  
  public void setVy(double vy) {
    vyValue.setText(formatter.format(vy));
  }
  
  public void setV(double v) {
    vValue.setText(formatter.format(v));
  }
  
  public void setXMax(double xMax) {
    xMaxValue.setText(formatter.format(xMax));
  }
  
  public void setYMax(double yMax) {
    yMaxValue.setText(formatter.format(yMax));
  }
}
