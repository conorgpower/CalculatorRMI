/** @author 		Conor Power
 *  @date			22/11/2019
 *  @studentNumber 	20075871
 *  @description	The client class creates an instance of the ClientGUI.
 *  				The action listeners for the GUI are then applied. These
 *  				hold the logic for client side operations such as creating
 *  				the request for the server. The submit button listener 
 *  				looks up the server and calculator request method requests
 *  				the server side operation.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Client {
    /** Client variables **/
	private float result = 0;
    private String message = "";
    private String numbers = "";
    private ClientGUI clientGUI;
    private String operation[];
    
    /** Create Calculator reference **/
    private static Calculator obj = null;

    public static void main(String args[]) {
        new Client();
    }
    
    /** Client default constructor **/
    private Client() {
    	clientGUI = new ClientGUI();
        clientGUI.createInterface();
        createEventListeners();
    }
    
    /** Assign event listeners to GUI buttons **/
    private void createEventListeners() {
    	JTextArea calculationText = clientGUI.getCalculationText();
    	
    	clientGUI.getZeroButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("0");
            }
        });
    	
    	clientGUI.getOneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("1");
            }
        });
    	
    	clientGUI.getTwoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("2");
            }
        });
    	
    	clientGUI.getThreeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("3");
            }
        });
    	
    	clientGUI.getFourButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("4");
            }
        });
    	
    	clientGUI.getFiveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("5");
            }
        });
    	
    	clientGUI.getSixButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("6");
            }
        });
    	
    	clientGUI.getSevenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("7");
            }
        });
    	
    	clientGUI.getEightButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("8");
            }
        });
    	
    	clientGUI.getNineButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.append("9");
            }
        });
    	
    	clientGUI.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
        		calculationText.setText("");
        		clientGUI.getDivideButton().setEnabled(true);
        		clientGUI.getMultiplyButton().setEnabled(true);
        		clientGUI.getAddButton().setEnabled(true);
        		clientGUI.getSubtractButton().setEnabled(true);
        		clientGUI.getSubmitButton().setEnabled(false);
        		numbers = "";
            }
        });

    	clientGUI.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	if(calculationText.getText().length() > 0) {
            		try {
                		Integer.parseInt(calculationText.getText());
                		message = "Request sent to server.";
                		clientGUI.getDivideButton().setEnabled(true);
                		clientGUI.getMultiplyButton().setEnabled(true);
                		clientGUI.getAddButton().setEnabled(true);
                		clientGUI.getSubtractButton().setEnabled(true);
                		clientGUI.getSubmitButton().setEnabled(false);
                		numbers = numbers.concat(calculationText.getText());
                		clientGUI.displayResponse("Connected to Server");
                		/** Lookup Calculator Remote Object **/
                		obj = (Calculator) Naming.lookup("//"
                                + "localhost"
                                + "/Calculator");
                		operation = numbers.split(",");
                		int result = calculatorRequest(operation);
                		clientGUI.displayResponse("Response Received from Server: \n");
                        clientGUI.displayResponse("Result = " + result + "\n");
                		calculationText.setText("");
            		} catch (Exception e) {
                		message = "Invalid! Please enter a valid number.";
        		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	} else {
            		message = "Please Enter a Number!";
    		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    	
    	clientGUI.getDivideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	if(calculationText.getText().length() > 0) {
            		try {
                		Integer.parseInt(calculationText.getText());
                		message = "Will divide " + calculationText.getText() + " by next input.";
                		clientGUI.getDivideButton().setEnabled(false);
                		clientGUI.getMultiplyButton().setEnabled(false);
                		clientGUI.getAddButton().setEnabled(false);
                		clientGUI.getSubtractButton().setEnabled(false);
                		clientGUI.getSubmitButton().setEnabled(true);
                		numbers = numbers.concat(calculationText.getText() + ",/,");
                		calculationText.setText("");
            		} catch (Exception e) {
                		message = "Invalid! Please enter a valid number.";
        		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	} else {
            		message = "Please Enter a Number!";
    		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    	
    	clientGUI.getMultiplyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	if(calculationText.getText().length() > 0) {
            		try {
                		Integer.parseInt(calculationText.getText());
                		message = "Will multiply " + calculationText.getText() + " by next input.";
                		clientGUI.getDivideButton().setEnabled(false);
                		clientGUI.getMultiplyButton().setEnabled(false);
                		clientGUI.getAddButton().setEnabled(false);
                		clientGUI.getSubtractButton().setEnabled(false);
                		clientGUI.getSubmitButton().setEnabled(true);
                		numbers = numbers.concat(calculationText.getText() + ",*,");
                		calculationText.setText("");
            		} catch (Exception e) {
                		message = "Invalid! Please enter a valid number.";
        		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	} else {
            		message = "Please Enter a Number!";
    		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    	
    	clientGUI.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	if(calculationText.getText().length() > 0) {
            		try {
                		Integer.parseInt(calculationText.getText());
                		message = "Will add " + calculationText.getText() + " to next input.";
                		clientGUI.getDivideButton().setEnabled(false);
                		clientGUI.getMultiplyButton().setEnabled(false);
                		clientGUI.getAddButton().setEnabled(false);
                		clientGUI.getSubtractButton().setEnabled(false);
                		clientGUI.getSubmitButton().setEnabled(true);
                		numbers = numbers.concat(calculationText.getText() + ",+,");
                		calculationText.setText("");
            		} catch (Exception e) {
                		message = "Invalid! Please enter a valid number.";
        		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	} else {
            		message = "Please Enter a Number!";
    		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    	
    	clientGUI.getSubtractButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	if(calculationText.getText().length() > 0) {
            		try {
                		Integer.parseInt(calculationText.getText());
                		message = "Will subtract " + calculationText.getText() + " from next input.";
                		clientGUI.getDivideButton().setEnabled(false);
                		clientGUI.getMultiplyButton().setEnabled(false);
                		clientGUI.getAddButton().setEnabled(false);
                		clientGUI.getSubtractButton().setEnabled(false);
                		clientGUI.getSubmitButton().setEnabled(true);
                		numbers = numbers.concat(calculationText.getText() + ",-,");
                		calculationText.setText("");
            		} catch (Exception e) {
                		message = "Invalid! Please enter a valid number.";
        		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	} else {
            		message = "Please Enter a Number!";
    		        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    }
    
    /** Read operation string and request from Remote Interface **/
    private int calculatorRequest(String[] operation) {
    	try {
    		clientGUI.getClearButton();
    		if (operation[1].equals("+")) {
                result = obj.add(operation[0], operation[2]);
            } else if (operation[1].equals("-")) {
                result = obj.subtract(operation[0], operation[2]);
            }
            else if (operation[1].equals("/")) {
            	result = obj.divide(operation[0], operation[2]);
            } else if (operation[1].equals("*")) {
    			result = obj.multiply(operation[0], operation[2]);
            }
		} catch (RemoteException e) {
			e.printStackTrace();
        }
		clientGUI.getCalculationText().setText("");
		clientGUI.getDivideButton().setEnabled(true);
		clientGUI.getMultiplyButton().setEnabled(true);
		clientGUI.getAddButton().setEnabled(true);
		clientGUI.getSubtractButton().setEnabled(true);
		clientGUI.getSubmitButton().setEnabled(false);
		numbers = "";
    	return (int) result;
    }
	
}
