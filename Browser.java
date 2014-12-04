import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class webBrowser extends JFrame
{
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public webBrowser()
	{
		//name of browser
		super("Sailin'");
		
		//creating the address bar
		addressBar = new JTextField("Enter a URL");
		addressBar.addActionListener(
				new ActionListener()
				{
					//when they click enter it gets the string passed in 
					public void actionPerformed(ActionEvent event){
						loadStuff(event.getActionCommand());
					}
				}
			);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		//users unable to change the content
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener()
				{
					//do something only if user clicks the link
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()== HyperlinkEvent.EventType.ACTIVATED){
							loadStuff(event.getURL().toString());
						}
					}
				}
			);
		
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	//website user inputs
	private void loadStuff(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Get it together man. That was not a URL");
			System.out.println("Get it together man. That was not a valid url");
		}
	}
	
	
	public static void main (String[] args)
	{
		webBrowser one = new webBrowser();
		one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
