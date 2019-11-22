/** @author 		Conor Power
 *  @date			22/11/2019
 *  @studentNumber 	20075871
 *  @description	The server GUI class contains all of the components for the 
 *  				server. The client must create an instance of the GUI and 
 *  				call ServerGUI() the default constructor to run it.
 */

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerGUI {
	
    /** UI for display panel **/
    private static JTextArea display = new JTextArea();
    private static JScrollPane displayPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    /** Server GUI default constructor **/
    public ServerGUI() {
        JFrame frame = new JFrame("Server");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayPane.setSize(400,260);
        display.setSize(390, 250);

        frame.add(displayPane);
        frame.setVisible(true);
    }

    /** Getter **/
    public JTextArea getDisplay() {
        return display;
    }
}
