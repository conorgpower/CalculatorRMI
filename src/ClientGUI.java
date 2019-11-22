/** @author 		Conor Power
 *  @date			22/11/2019
 *  @studentNumber 	20075871
 *  @description	The client GUI class contains all of the components for the 
 *  				client calculator. The client must create an instance of the 
 *  				GUI and call createInterface() to run it.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientGUI {
	/** Panels for each UI component **/
    private static JPanel calculationPanel = new JPanel();
    private static JPanel controlPanel = new JPanel();
    private static JPanel serverPanel = new JPanel();
    
    /** UI for calculation panel **/
    private static JTextArea calculationText = new JTextArea();
    
    /** UI for control panel **/
    private JButton divideButton = new JButton("/");
    private JButton multiplyButton = new JButton("*");
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton zeroButton = new JButton("0");
    private JButton oneButton = new JButton("1");
    private JButton twoButton = new JButton("2");
    private JButton threeButton = new JButton("3");
    private JButton fourButton = new JButton("4");
    private JButton fiveButton = new JButton("5");
    private JButton sixButton = new JButton("6");
    private JButton sevenButton = new JButton("7");
    private JButton eightButton = new JButton("8");
    private JButton nineButton = new JButton("9");
    private JButton submitButton = new JButton("Submit");
    private JButton clearButton = new JButton("Clear");

    /** UI for server response panel **/
    private static JTextArea serverResponse = new JTextArea();
    private static JScrollPane displayPane = new JScrollPane(serverResponse, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    /** Method to create the calculator GUI **/
    public void createInterface() {
    	JFrame frame = new JFrame("Calculator Client");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(350, 350);
    	
    	calculationPanel.setSize(350, 100);
    	calculationPanel.setLayout(new FlowLayout());
    	controlPanel.setSize(350, 320);
    	controlPanel.setLayout(new GridLayout(4,4));
    	serverPanel.setSize(350, 80);
    	serverPanel.setLayout(new FlowLayout());
    	
    	calculationPanel.add(calculationText);
    	controlPanel.add(divideButton);
      	controlPanel.add(sevenButton);
    	controlPanel.add(eightButton);
    	controlPanel.add(nineButton);
    	controlPanel.add(multiplyButton);
    	controlPanel.add(fourButton);
    	controlPanel.add(fiveButton);
    	controlPanel.add(sixButton);
    	controlPanel.add(subtractButton);
    	controlPanel.add(oneButton);
    	controlPanel.add(twoButton);
    	controlPanel.add(threeButton);
    	controlPanel.add(addButton);
    	controlPanel.add(zeroButton);  
    	controlPanel.add(submitButton);
    	controlPanel.add(clearButton);
    	serverPanel.add(displayPane);
    	
    	calculationText.setPreferredSize(new Dimension(340,90));
    	displayPane.setPreferredSize(new Dimension(340,90));
    	
    	frame.add(calculationPanel, BorderLayout.NORTH);
    	frame.add(controlPanel, BorderLayout.CENTER);
    	frame.add(serverPanel, BorderLayout.SOUTH);
    	frame.setLayout(new GridLayout(3,1));
    	frame.setVisible(true);
    	
    	calculationText.setEditable(false);
    	serverResponse.setEditable(false);
    	
		submitButton.setEnabled(false);
    }
    
	/** Method to write response to display **/
    public void displayResponse(String response) {
        serverResponse.append(response + "\n");
    }
    
    /** Getters **/
    public JPanel getCalculationPanel() {
		return calculationPanel;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public JPanel getServerPanel() {
		return serverPanel;
	}

	public JTextArea getCalculationText() {
		return calculationText;
	}

	public JButton getDivideButton() {
		return divideButton;
	}

	public JButton getMultiplyButton() {
		return multiplyButton;
	}

	public JButton getSubtractButton() {
		return subtractButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getZeroButton() {
		return zeroButton;
	}

	public JButton getOneButton() {
		return oneButton;
	}

	public JButton getTwoButton() {
		return twoButton;
	}

	public JButton getThreeButton() {
		return threeButton;
	}

	public JButton getFourButton() {
		return fourButton;
	}

	public JButton getFiveButton() {
		return fiveButton;
	}

	public JButton getSixButton() {
		return sixButton;
	}

	public JButton getSevenButton() {
		return sevenButton;
	}

	public JButton getEightButton() {
		return eightButton;
	}

	public JButton getNineButton() {
		return nineButton;
	}

	public JButton getSubmitButton() {
		return submitButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JTextArea getServerResponse() {
		return serverResponse;
	}

	public JScrollPane getDisplayPane() {
		return displayPane;
	}
}
