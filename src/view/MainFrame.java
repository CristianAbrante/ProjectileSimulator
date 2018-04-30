/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * <h2>MainFrame</h2>
 * 
 * @author	Cristian Abrante Dorta
 * @company	University Of La Laguna
 * @date 		30/04/2018
 * @version 1.0.0
 */
public class MainFrame {
  private JFrame frame = new JFrame();
  private int width;
  private int height;
  private SettingsPanel settingsPanel;
  private VisualPanel visualPanel;
  private InformationPanel informationPanel;
  
  /**
   * Constructor of MainFrame
   * 
   * @param visualPanel the visual panel to set.
   */
  public MainFrame(VisualPanel visualPanel) {
    setVisualPanel(visualPanel);
    setWidth();
    setHeight();
    initializeFrame();
  }
  
  /**
   * Constructor of MainFrame
   * 
   * @param visualPanel the visual panel to set.
   * @param settingsPanel the settings panel to set.
   */
  public MainFrame(VisualPanel visualPanel, SettingsPanel settingsPanel, InformationPanel informationPanel) {
    setVisualPanel(visualPanel);
    setSettingsPanel(settingsPanel);
    setInformationPanel(informationPanel);
    setWidth();
    setHeight();
    initializeFrame();
  }
  
  /**
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * @return the settingsPanel
   */
  public SettingsPanel getSettingsPanel() {
    return settingsPanel;
  }

  /**
   * @return the visualPanel
   */
  public VisualPanel getVisualPanel() {
    return visualPanel;
  }
  
  public InformationPanel getInformationPanel() {
    return informationPanel;
  }
    
  public void repaint() {
    this.getVisualPanel().repaint();
  }
  
  /**
   * Method used to initialize the frame.
   */
  private void initializeFrame() {
    frame.setLayout(new BorderLayout());
    frame.add(getInformationPanel(), BorderLayout.EAST);
    if (getVisualPanel() != null)
      frame.add(getVisualPanel(), BorderLayout.CENTER);
    if (getSettingsPanel() != null)
      frame.add(getSettingsPanel(), BorderLayout.SOUTH);
    frame.setSize(getWidth(), getHeight());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
  }
  
  /**
   * Setter of the width.
   * @throws NullPointerException if visual panel is null.
   */
  private void setWidth() 
      throws NullPointerException {
    int osXFrameWidth = 1;
    if (getVisualPanel() != null) {
      this.width = getVisualPanel().getWidth() + getInformationPanel().getWidth();
    } else {
      throw new NullPointerException("visual panel can't be null");
    }
  }
  
  /**
   * Setter of the height.
   * @throws NullPointerException
   */
  private void setHeight() 
      throws NullPointerException {
    int osXFrameHeight = 23;
    if (getVisualPanel() != null) {
      if (getSettingsPanel() != null) {
          this.height = getSettingsPanel().getHeight() + getVisualPanel().getHeight() + osXFrameHeight;
      } else {
        this.height = getVisualPanel().getHeight() + osXFrameHeight;
      }
    } else {
      throw new NullPointerException("visual panel can't be null");
    }
  }
  
  /**
   * @param settingsPanel the settingsPanel to set
   * @throws NullPointerException if settings panel is null.
   */
  private void setSettingsPanel(SettingsPanel settingsPanel) 
      throws NullPointerException {
    if (settingsPanel != null) {
      this.settingsPanel = settingsPanel;      
    } else {
      throw new NullPointerException("settings panel can't be null");
    }
  }
  
  /**
   * @param visualPanel the visualPanel to set
   * @throws NullPointerException if visual panel is null.
   */
  private void setVisualPanel(VisualPanel visualPanel) 
      throws NullPointerException {
    if (visualPanel != null) {
      this.visualPanel = visualPanel;      
    } else {
      throw new NullPointerException("Visual panel can't be null");
    }
  }
  
  private void setInformationPanel(InformationPanel informationPanel) {
    if (informationPanel != null) {
      this.informationPanel = informationPanel;      
    } else {
      throw new NullPointerException("Visual panel can't be null");
    }
  }
}
