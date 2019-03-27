package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainMenu extends JFrame{
	final String [] timing = {"1100", "1300", "1500", "1900", "2200"};
	final String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	
	//Declare for confirmation
	protected JTextField txt11 = new JTextField();
	
	protected JTextField txt22 = new JTextField();
	
	protected JTextField txt33 = new JTextField();
	
	protected JTextField txt44 = new JTextField();
	
	protected JTextField txt55 = new JTextField();
	
	
	//Declare for food number
	
	protected JComboBox<String> fbNum1 = new JComboBox<String>(number);
	protected JComboBox<String> fbNum2 = new JComboBox<String>(number);
	protected JComboBox<String> fbNum3 = new JComboBox<String>(number);
	
	//Declare the JPanels
	protected JPanel loginPane = new JPanel();
	protected JPanel registerPane = new JPanel();
	protected JPanel moviePane = new JPanel();
	protected JPanel selectionPane = new JPanel();
	protected JPanel timePane = new JPanel();
	protected JPanel seatPane = new JPanel();
	protected JPanel confirmPane = new JPanel();
	protected JPanel fnbPane = new JPanel();
	protected JPanel fnbConfirmationPane = new JPanel();
	protected JPanel ccPaymentPane = new JPanel();
	protected JPanel ccPaymentConfirmPane = new JPanel();
	protected JPanel preccPaymentPane = new JPanel();
	protected JPanel receiptPane = new JPanel();
	
	//Variables for bookings
	protected JLabel selectedMovie = new JLabel();
	protected JLabel selectedCinema = new JLabel();
	protected JComboBox<String> pricing;
	protected JComboBox<String> location;
	protected JComboBox<String> timings;
	
	//UI variables
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JLabel error = new JLabel(); //Error Message Label
	private JRadioButton []  btns = new JRadioButton[30];
	private ImageIcon [] icons = new ImageIcon[30];
	private String time;
	private String loc;
	private String seatType;
	private String name;
	private String ccno;
	private String contact;
	private String email;
	private int seatAmount;
	private double foodPrice;
	private double food1;
	private double food2;
	private double food3;
	private ArrayList<String> chosenSeat = new ArrayList<>();
	
	//constructor put the first panel in
	public MainMenu(){
		setLayout(new BorderLayout());
		
		//Clean Panes
		loginPane.removeAll();
		registerPane.removeAll();
		moviePane.removeAll();
		selectionPane.removeAll();
		fnbPane.removeAll();
		ccPaymentPane.removeAll();
		receiptPane.removeAll();
		
		//Build All the other Panes by calling method
		initLoginPane();
		initRegisterPane();
		initMoviePane();
		initSelectionPane();
		initfnbPane();
		initccPaymentPane();
		initReceiptPane();
	
		
		//Set Error Font
		error.setFont(new Font("Times New Roman", Font.BOLD, 20));
		error.setForeground(Color.RED);
		
		//First Pane
		add(loginPane, BorderLayout.CENTER);
	}
	
	//build loginPane
	public void initLoginPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Welcome to Moviago!");
		title.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(8,8,3,2));
		p1.setBorder(new EmptyBorder(30, 30, 10, 30));
		JLabel uname = new JLabel("Username : ");
		uname.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel pwd = new JLabel("Password : ");
		pwd.setFont(new Font("Arial", Font.PLAIN, 18));
		
		RegisterButton event1 = new RegisterButton();
		JButton register = new JButton("Register");
		register.addActionListener(event1);
		register.setFont(new Font("Arial", Font.BOLD, 18));
		
		LoginButton event2 = new LoginButton();
		JButton login = new JButton("Login");
		login.addActionListener(event2);
		login.setFont(new Font("Arial", Font.BOLD, 18));
		
		p1.add(uname);
		p1.add(username);
		p1.add(pwd);
		p1.add(password);
		p1.add(register);
		p1.add(login);
		p1.setBackground(Color.CYAN);
		
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(error, BorderLayout.SOUTH);
		mainPane.setBackground(Color.CYAN);
		
		loginPane.setLayout(new GridBagLayout());
		loginPane.add(mainPane, new GridBagConstraints());
		loginPane.setBackground(Color.CYAN);
	}
	
	//build register Pane
	public void initRegisterPane(){
		//Create Date picker
		int curYear = 2017;
		String [] day = new String [31];
		String [] month = {"January", "February", "March","April","May",
				"June", "July", "August", "September", "October",
				"November", "December"
		};
		String [] year = new String[100];
		
		for(int i=0;i<31;i++){
			day[i] = Integer.toString(i+1);
		}
		
		for(int i=0;i<100;i++){
			year[i] = Integer.toString(curYear);
			curYear = curYear - 1;
		}
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Register Moviago! Account");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		p1.setBorder(new EmptyBorder(30, 30, 10, 30));
		p1.setBackground(Color.CYAN);
		
		JLabel uname = new JLabel("Username : ");
		uname.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel pwd = new JLabel("Password : ");
		pwd.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel pwdC = new JLabel("Confirm Password : ");
		pwdC.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel email = new JLabel("Email : ");
		email.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel conNum = new JLabel("Contact Number : ");
		conNum.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel dob = new JLabel("Date of Birth : ");
		dob.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JTextField txt1 = new JTextField();
		txt1.setToolTipText("Enter Username");
		JPasswordField txt2 = new JPasswordField();
		txt2.setToolTipText("Enter Password");
		JPasswordField txt3 = new JPasswordField();
		txt3.setToolTipText("Confirm Password");
		JTextField txt4 = new JTextField();
		txt4.setToolTipText("Enter Email");
		JTextField txt5 = new JTextField();
		txt5.setToolTipText("Enter Contact Number");
		
		JPanel datePicker = new JPanel();
		datePicker.setBackground(Color.CYAN);
		datePicker.add(new JComboBox<String>(day));
		datePicker.add(new JComboBox<String>(month));
		datePicker.add(new JComboBox<String>(year));
		
		p1.add(uname);
		p1.add(txt1);
		p1.add(pwd);
		p1.add(txt2);
		p1.add(pwdC);
		p1.add(txt3);
		p1.add(email);
		p1.add(txt4);
		p1.add(conNum);
		p1.add(txt5);
		p1.add(dob);
		p1.add(datePicker);
		
		
		
		RegisterButton2 event = new RegisterButton2();
		JButton register = new JButton("Register");
		register.addActionListener(event);
		register.setFont(new Font("Arial", Font.BOLD, 18));
		
		RegisterButton2 event2 = new RegisterButton2();
		JButton register2 = new JButton("Cancel");
		register2.addActionListener(event2);
		register2.setFont(new Font("Arial", Font.BOLD, 18));
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(register);
		flow.add(register2);
		flow.setBackground(Color.cyan);
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(flow, BorderLayout.SOUTH);
		
		registerPane.setLayout(new GridBagLayout());
		registerPane.add(mainPane, new GridBagConstraints());
		registerPane.setBackground(Color.CYAN);
	}
	
	//build moviePane
	public void initMoviePane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Select a Movie");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		//Declare all the image Icons
		ImageIcon icon1 = new ImageIcon("src/Project/movie1.jpg"); // load the image to a imageIcon
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon1 = new ImageIcon(newimg);
		ImageIcon icon2 = new ImageIcon("src/Project/movie2.jpg");
		image = icon2.getImage();
		newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg);
		ImageIcon icon3 = new ImageIcon("src/Project/movie3.jpg");
		image = icon3.getImage();
		newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg);
		ImageIcon icon4 = new ImageIcon("src/Project/movie4.jpg");
		image = icon4.getImage();
		newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
		icon4 = new ImageIcon(newimg);
		ImageIcon icon5 = new ImageIcon("src/Project/movie5.jpg");
		image = icon5.getImage();
		newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
		icon5 = new ImageIcon(newimg);
		ImageIcon icon6 = new ImageIcon("src/Project/movie6.jpg");
		image = icon6.getImage();
		newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
		icon6 = new ImageIcon(newimg);
		
		//Declare Buttons
		JButton btn1 = new JButton(icon1);
		MovieButton1 event1 = new MovieButton1();
		btn1.addActionListener(event1);
		JButton btn2 = new JButton(icon2);
		MovieButton2 event2 = new MovieButton2();
		btn2.addActionListener(event2);
		JButton btn3 = new JButton(icon3);
		MovieButton3 event3 = new MovieButton3();
		btn3.addActionListener(event3);
		JButton btn4 = new JButton(icon4);
		MovieButton4 event4 = new MovieButton4();
		btn4.addActionListener(event4);
		JButton btn5 = new JButton(icon5);
		MovieButton5 event5 = new MovieButton5();
		btn5.addActionListener(event5);
		JButton btn6 = new JButton(icon6);
		MovieButton6 event6 = new MovieButton6();
		btn6.addActionListener(event6);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,3));
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.add(btn4);
		p1.add(btn5);
		p1.add(btn6);
		
		JButton logout = new JButton("Log Out");
		LogoutButton1 event7 = new LogoutButton1();
		logout.addActionListener(event7);
		logout.setFont(new Font("Arial", Font.BOLD, 18));
		logout.setForeground(Color.RED);
		
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(logout, BorderLayout.SOUTH);
		
		moviePane.setLayout(new GridBagLayout());
		moviePane.add(mainPane, new GridBagConstraints());
		moviePane.setBackground(Color.CYAN);
	}
	
	//Build Selection Pane
	public void initSelectionPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JPanel header = new JPanel();
		header.setLayout(new FlowLayout());
		header.setBackground(Color.CYAN);
		JLabel title = new JLabel("Selected Movie : ");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		selectedMovie.setFont(new Font("Arial", Font.BOLD, 30));
		header.add(title);
		header.add(selectedMovie);	
		
		selectedMovie.setFont(new Font("Arial", Font.BOLD, 30));
		mainPane.add(header, BorderLayout.NORTH);
		
		//Declare all the image Icons
		ImageIcon icon1 = new ImageIcon("src/Project/GSC.png"); // load the image to a imageIcon
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon1 = new ImageIcon(newimg);
		ImageIcon icon2 = new ImageIcon("src/Project/MBO.png");
		image = icon2.getImage();
		newimg = image.getScaledInstance(300, 150,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg);
		ImageIcon icon3 = new ImageIcon("src/Project/TGV.png");
		image = icon3.getImage();
		newimg = image.getScaledInstance(300, 150,  java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg);
		
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,3));
		p1.setBackground(Color.CYAN);
		JLabel lb1 = new JLabel("Student Price: RM11.50");
		lb1.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb1);
		JLabel lb2 = new JLabel("Student Price: RM10.50");
		lb2.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb2);
		JLabel lb3 = new JLabel("Student Price: RM9.50");
		lb3.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb3);
		JLabel lb4 = new JLabel("Normal Price: RM16.50");
		lb4.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb4);
		JLabel lb5 = new JLabel("Normal Price: RM18.50");
		lb5.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb5);
		JLabel lb6 = new JLabel("Normal Price: RM15.00");
		lb6.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb6);
		JLabel lb7 = new JLabel("Twin Seat Price: RM20.50");
		lb7.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb7);
		JLabel lb8 = new JLabel("Twin Seat Price: RM23.50");
		lb8.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb8);
		JLabel lb9 = new JLabel("Twin Seat Price: RM24.00");
		lb9.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb9);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,3));
		p2.setBackground(Color.CYAN);
		JButton btn1 = new JButton(icon1);
		CinemaButton1 event1 = new CinemaButton1();
		btn1.addActionListener(event1);
		JButton btn2 = new JButton(icon2);
		CinemaButton2 event2 = new CinemaButton2();
		btn2.addActionListener(event2);
		JButton btn3 = new JButton(icon3);
		CinemaButton3 event3 = new CinemaButton3();
		btn3.addActionListener(event3);
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.CYAN);
		p3.add(p2, BorderLayout.NORTH);
		p3.add(p1, BorderLayout.CENTER);
		
		mainPane.add(p3, BorderLayout.CENTER);
		
		JButton back = new JButton("Back to Selection");
		BackButton1 event4 = new BackButton1();
		back.addActionListener(event4);
		back.setFont(new Font("Arial", Font.BOLD, 18));
		back.setForeground(Color.RED);
		mainPane.add(back, BorderLayout.SOUTH);
		
		selectionPane.setLayout(new GridBagLayout());
		selectionPane.add(mainPane, new GridBagConstraints());
		selectionPane.setBackground(Color.CYAN);
	}
	
	public void initTimePane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(2,3));
		header.setBorder(new EmptyBorder(30,30,30,30));
		header.setBackground(Color.CYAN);
		JLabel title1 = new JLabel("Selected Cinema : ");
		title1.setFont(new Font("Arial", Font.PLAIN, 18));
		selectedCinema.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel title2 = new JLabel("Selected Movie : ");
		title2.setFont(new Font("Arial", Font.PLAIN, 18));
		selectedMovie.setFont(new Font("Arial", Font.BOLD, 18));
				
		header.add(title1);
		header.add(selectedCinema);
		header.add(title2);
		header.add(selectedMovie);
	
		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(30,30,30,30));
		p1.setLayout(new GridLayout(3,2));
		p1.setBackground(Color.CYAN);
		JLabel lb1 = new JLabel("Select Location : ");
		lb1.setFont(new Font("Arial", Font.ITALIC, 20));
		JLabel lb2 = new JLabel("Select Time : ");
		lb2.setFont(new Font("Arial", Font.ITALIC, 20));
		JLabel lb3 = new JLabel("Select Pricing : ");
		lb3.setFont(new Font("Arial", Font.ITALIC, 20));
		
		p1.add(lb1);
		p1.add(location);
		p1.add(lb2);
		timings = new JComboBox<String>(timing);
		p1.add(timings);
		p1.add(lb3);
		p1.add(pricing);
		
		
		JButton confirm = new JButton("Confirm");
		ConfirmButton1 event1 = new ConfirmButton1();
		confirm.addActionListener(event1);
		confirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		confirm.setForeground(Color.RED);
		
		JButton back = new JButton("Back");
		BackBtn1 event2 = new BackBtn1();
		back.addActionListener(event2);
		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setForeground(Color.RED);
		
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(confirm);
		flow.add(back);
		flow.setBackground(Color.cyan);
		
		mainPane.add(header, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(flow, BorderLayout.SOUTH);
		
		timePane.setLayout(new GridBagLayout());
		timePane.add(mainPane, new GridBagConstraints());
		timePane.setBackground(Color.CYAN);
	}
	
	//Build Seat Pane
	public void initSeatPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(Color.CYAN);
		JLabel title = new JLabel("Choose Seats : ");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		JLabel screen = new JLabel("============================SCREEN============================");
		screen.setFont(new Font("Arial", Font.BOLD, 20));
		header.add(title, BorderLayout.NORTH);
		header.add(screen, BorderLayout.CENTER);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.setLayout(new GridLayout(5,6));
	
		Image image; 
		Image newimg;
		SeatButton event1 = new SeatButton();
		for(int i=0;i<30;i++){
			icons[i] = new ImageIcon("src/Project/Chair.png");
			image = icons[i].getImage();
			newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(newimg);
			btns[i] = new JRadioButton("SeatNo "+(i+1),icons[i]);
			btns[i].addActionListener(event1);
			p1.add(btns[i]);
		}
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.CYAN);
		p2.setLayout(new BorderLayout());
		ConfirmButton2 event2 = new ConfirmButton2();
		JButton confirm = new JButton("Confirm");
		confirm.setFont(new Font("Arial", Font.BOLD, 18));
		confirm.setForeground(Color.RED);
		confirm.addActionListener(event2);
		
		JButton back = new JButton("Back");
		BackBtn2 event3 = new BackBtn2();
		back.addActionListener(event3);
		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setForeground(Color.RED);
		
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(confirm);
		flow.add(back);
		flow.setBackground(Color.cyan);
		
		p2.add(flow, BorderLayout.CENTER);
		p2.add(error, BorderLayout.SOUTH);
		
		mainPane.add(header, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(p2, BorderLayout.SOUTH);
		
		seatPane.setLayout(new GridBagLayout());
		seatPane.add(mainPane, new GridBagConstraints());
		seatPane.setBackground(Color.CYAN);
	}
	
	public void initfnbPane(){
		
		
		JPanel mainPane = new JPanel();
		JPanel secPane = new JPanel();
		
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		secPane.setLayout(new GridLayout(3,3));
		
		ImageIcon icon1 = new ImageIcon("src/Project/Cineplex-Combo-0.jpg"); // load the image to a imageIcon
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(306,223,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		
		ImageIcon icon2 = new ImageIcon("src/Project/Cineplex-Combo-1.jpg");
		image = icon2.getImage();
		newimg = image.getScaledInstance(306,223,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg);
		
		ImageIcon icon3 = new ImageIcon("src/Project/Cineplex-Combo-2.jpg");
		image = icon3.getImage();
		newimg = image.getScaledInstance(306,223,  java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg);
		
		JButton btn7 = new JButton(icon1);
		JButton btn8 = new JButton(icon2);
		JButton btn9 = new JButton(icon3);
		
		JLabel price1 = new JLabel("RM 10.00");
		price1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		JLabel price2 = new JLabel("RM 18.00");
		price2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		JLabel price3 = new JLabel("RM 25.00");
		price3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton finalize = new JButton("Proceed");
		finalize.setFont(new Font("Times New Roman", Font.BOLD, 20));
		finalize.setForeground(Color.RED);
		FnBButton event1 = new FnBButton();
		finalize.addActionListener(event1);
		
		JButton back = new JButton("Back");
		BackBtn3 event2 = new BackBtn3();
		back.addActionListener(event2);
		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setForeground(Color.RED);
		
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(finalize);
		flow.add(back);
		flow.setBackground(Color.cyan);
		
		secPane.add(btn7);
		secPane.add(price1);
		secPane.add(fbNum1);
		secPane.add(btn8);
		secPane.add(price2);
		secPane.add(fbNum2);
		secPane.add(btn9);
		secPane.add(price3);
		secPane.add(fbNum3);
		
		secPane.setBackground(Color.CYAN);
		JLabel title = new JLabel("Select Foods");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(secPane, BorderLayout.CENTER);
		mainPane.add(flow, BorderLayout.SOUTH);
		fnbPane.setLayout(new GridBagLayout());
		fnbPane.add(mainPane, new GridBagConstraints());
		fnbPane.setBackground(Color.CYAN);
	}
	
	public void initfnbConfirmPane(){
		
		
		JPanel mainPane = new JPanel();
		JPanel secPane = new JPanel();
		
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		ImageIcon icon1 = new ImageIcon("src/Project/Cineplex-Combo-0.jpg"); // load the image to a imageIcon
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300,160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon1 = new ImageIcon(newimg);
		
		ImageIcon icon2 = new ImageIcon("src/Project/Cineplex-Combo-1.jpg");
		image = icon2.getImage();
		newimg = image.getScaledInstance(300,160,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg);
		
		ImageIcon icon3 = new ImageIcon("src/Project/Cineplex-Combo-2.jpg");
		image = icon3.getImage();
		newimg = image.getScaledInstance(300,160,  java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newimg);
		
		JButton btn7 = new JButton(icon1);
		JButton btn8 = new JButton(icon2);
		JButton btn9 = new JButton(icon3);
		
		secPane.setLayout(new GridLayout(4,2));
		JLabel label1 = new JLabel("Set 1 : " + fbNum1.getSelectedItem() + " * RM 10 = RM " + Double.toString(food1));
		JLabel label2 = new JLabel("Set 2 : " + fbNum2.getSelectedItem() + " * RM 18 = RM " + Double.toString(food2));
		JLabel label3 = new JLabel("Set 3 : " + fbNum3.getSelectedItem() + " * RM 25 = RM " + Double.toString(food3));
		JLabel label4 = new JLabel("Total : " + " =  RM " + Double.toString(foodPrice));
		
		JLabel title = new JLabel("Confirmation");
		title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		mainPane.add(title, BorderLayout.NORTH);
		
		JButton finalize = new JButton("Proceed");
		finalize.setFont(new Font("Times New Roman", Font.BOLD, 20));
		finalize.setForeground(Color.RED);
		FnBConfirmButton event1 = new FnBConfirmButton();
		finalize.addActionListener(event1);
		
		JButton back = new JButton("Back");
		BackBtn4 event2 = new BackBtn4();
		back.addActionListener(event2);
		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setForeground(Color.RED);
		
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(finalize);
		flow.add(back);
		flow.setBackground(Color.CYAN);
		secPane.add(btn7);
		secPane.add(label1);
		secPane.add(btn8);
		secPane.add(label2);
		secPane.add(btn9);
		secPane.add(label3);
		secPane.add(new JLabel());
		secPane.add(label4);
		mainPane.add(secPane, BorderLayout.CENTER);
		mainPane.add(flow, BorderLayout.SOUTH);
		secPane.setBackground(Color.CYAN);
		fnbConfirmationPane.setLayout(new GridBagLayout());
		fnbConfirmationPane.add(mainPane, new GridBagConstraints());
		fnbConfirmationPane.setBackground(Color.CYAN);
	}
	
	public void initpreccPaymentPane() {
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Confirm Movie Details");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel p1 = new JPanel();
		
		p1.setBackground(Color.CYAN);
		p1.setLayout(new GridLayout(11,2));
	
		double total, chosen;
		String [] temp =  seatType.split(" ");
		chosen = Double.parseDouble(temp[3]);
		total = seatAmount * chosen;
		
		String totalSeat="";
		for(int i=0;i<chosenSeat.size();i++){
			totalSeat = totalSeat+chosenSeat.get(i)+",";
		}
		
		JLabel lb1 = new JLabel("Selected Movie : ");
		lb1.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb2 = new JLabel("Selected Cinema : ");
		lb2.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb3 = new JLabel("Location : ");
		lb3.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb4 = new JLabel(loc);
		lb4.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb5 = new JLabel("Time Slot : ");
		lb5.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb6 = new JLabel(time);
		lb6.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb7 = new JLabel("Seat Type : ");
		lb7.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb8 = new JLabel(temp[0]);
		lb8.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb9 = new JLabel("Subtotal : ");
		lb9.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb10 = new JLabel("RM "+Double.toString(total+foodPrice));
		lb10.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb11 = new JLabel("Seat Numbers : ");
		lb11.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb12 = new JLabel(totalSeat);
		lb12.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb13 = new JLabel("Food Set 1 : ");
		lb13.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb14 = new JLabel(number[fbNum1.getSelectedIndex()] + " = RM" + food1);
		lb14.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb15 = new JLabel("Food Set 2 : ");
		lb15.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb16 = new JLabel(number[fbNum2.getSelectedIndex()] + " = RM" + food2);
		lb16.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb17 = new JLabel("Food Set 3 : ");
		lb17.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb18 = new JLabel(number[fbNum3.getSelectedIndex()] + " = RM" + food3);
		lb18.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb19 = new JLabel("Ticket : " );
		lb19.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb20 = new JLabel( seatAmount + " = RM" + Double.toString(total));
		lb20.setFont(new Font("Arial", Font.PLAIN, 18));
		
		p1.add(lb1);
		p1.add(selectedMovie);
		p1.add(lb2);
		p1.add(selectedCinema);
		p1.add(lb3);
		p1.add(lb4);
		p1.add(lb5);
		p1.add(lb6);
		p1.add(lb7);
		p1.add(lb8);
		p1.add(lb11);
		p1.add(lb12);
		p1.add(lb13);
		p1.add(lb14);
		p1.add(lb15);
		p1.add(lb16);
		p1.add(lb17);
		p1.add(lb18);
		p1.add(lb19);
		p1.add(lb20);
		p1.add(lb9);
		p1.add(lb10);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.CYAN);
		JButton cancel = new JButton("Back");
		BackBtn6 event1 = new BackBtn6();
		cancel.addActionListener(event1);
		cancel.setFont(new Font("Arial", Font.BOLD, 20));
		cancel.setForeground(Color.RED);
		JButton next = new JButton("Proceed");
		PreccPaymentButton event2 = new PreccPaymentButton();
		next.addActionListener(event2);
		next.setFont(new Font("Arial", Font.BOLD, 20));
		
		p2.add(next, BorderLayout.CENTER);
		p2.add(cancel, BorderLayout.SOUTH);
		
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(p2, BorderLayout.SOUTH);
		
		preccPaymentPane.setLayout(new GridBagLayout());
		preccPaymentPane.add(mainPane, new GridBagConstraints());
		preccPaymentPane.setBackground(Color.CYAN);
	}
	
	public void initConfirmPane(){
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Confirm Movie Details");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.setLayout(new GridLayout(7,2));
	
		double total, chosen;
		String [] temp =  seatType.split(" ");
		chosen = Double.parseDouble(temp[3]);
		total = seatAmount * chosen;
		
		String totalSeat="";
		for(int i=0;i<chosenSeat.size();i++){
			totalSeat = totalSeat+chosenSeat.get(i)+",";
		}
		
		JLabel lb1 = new JLabel("Selected Movie : ");
		lb1.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb2 = new JLabel("Selected Cinema : ");
		lb2.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb3 = new JLabel("Location : ");
		lb3.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb4 = new JLabel(loc);
		lb4.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb5 = new JLabel("Time Slot : ");
		lb5.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb6 = new JLabel(time);
		lb6.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb7 = new JLabel("Seat Type : ");
		lb7.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb8 = new JLabel(temp[0]);
		lb8.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb9 = new JLabel("Subtotal : ");
		lb9.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb10 = new JLabel("RM "+Double.toString(total));
		lb10.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb11 = new JLabel("Seat Numbers : ");
		lb11.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb12 = new JLabel(totalSeat);
		lb12.setFont(new Font("Arial", Font.PLAIN, 18));
		
		p1.add(lb1);
		p1.add(selectedMovie);
		p1.add(lb2);
		p1.add(selectedCinema);
		p1.add(lb3);
		p1.add(lb4);
		p1.add(lb5);
		p1.add(lb6);
		p1.add(lb7);
		p1.add(lb8);
		p1.add(lb9);
		p1.add(lb10);
		p1.add(lb11);
		p1.add(lb12);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.CYAN);
		JButton cancel = new JButton("Back");
		CancelButton event1 = new CancelButton();
		cancel.addActionListener(event1);
		cancel.setFont(new Font("Arial", Font.BOLD, 20));
		cancel.setForeground(Color.RED);
		JButton next = new JButton("Proceed");
		ConfirmButton3 event2 = new ConfirmButton3();
		next.addActionListener(event2);
		next.setFont(new Font("Arial", Font.BOLD, 20));
		
		p2.add(next, BorderLayout.CENTER);
		p2.add(cancel, BorderLayout.SOUTH);
		
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(p2, BorderLayout.SOUTH);
		
		confirmPane.setLayout(new GridBagLayout());
		confirmPane.add(mainPane, new GridBagConstraints());
		confirmPane.setBackground(Color.CYAN);
	}
	
	public void initccPaymentPane(){
		//Create Date picker
		int curYear = 2017;
		String [] day = new String [31];
		String [] month = {"January", "February", "March","April","May",
				"June", "July", "August", "September", "October",
				"November", "December"
		};
		String [] year = new String[100];
		
		for(int i=0;i<31;i++){
			day[i] = Integer.toString(i+1);
		}
		
		for(int i=0;i<100;i++){
			year[i] = Integer.toString(curYear+20);
			curYear = curYear - 1;
		}
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Payment Details");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		p1.setBorder(new EmptyBorder(30, 30, 10, 30));
		p1.setBackground(Color.CYAN);
		
		JLabel uname = new JLabel("Name : ");
		uname.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel pwd = new JLabel("Credit Card Number : ");
		pwd.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel pwdC = new JLabel("Pin : ");
		pwdC.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel email = new JLabel("Email : ");
		email.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel conNum = new JLabel("Contact Number : ");
		conNum.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel dob = new JLabel("Date of Expired : ");
		dob.setFont(new Font("Arial", Font.PLAIN, 18));
		
		
		txt11.setToolTipText("Enter Name");
		
		txt22.setToolTipText("Enter Credit Card No");
		
		txt33.setToolTipText("Enter Pin");
		
		txt44.setToolTipText("Enter Email");

		txt55.setToolTipText("Enter Contact Number");
		
		JPanel datePicker = new JPanel();
		datePicker.setBackground(Color.CYAN);
		datePicker.add(new JComboBox<String>(month));
		datePicker.add(new JComboBox<String>(year));
		
		p1.add(uname);
		p1.add(txt11);
		p1.add(pwd);
		p1.add(txt22);
		p1.add(pwdC);
		p1.add(txt33);
		p1.add(email);
		p1.add(txt44);
		p1.add(conNum);
		p1.add(txt55);
		p1.add(dob);
		p1.add(datePicker);
		
		
		
		ccPaymentButton event = new ccPaymentButton();
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(event);
		confirm.setFont(new Font("Arial", Font.BOLD, 18));
		
		
		JButton back = new JButton("Back");
		BackBtn5 event2 =  new BackBtn5();
		back.addActionListener(event2);
		back.setFont(new Font("Arial", Font.BOLD, 18));
		JPanel flow = new JPanel();
		flow.setLayout(new GridLayout(2,1));
		flow.add(confirm);
		flow.add(back);
		flow.setBackground(Color.cyan);
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(flow, BorderLayout.SOUTH);
		
		ccPaymentPane.setLayout(new GridBagLayout());
		ccPaymentPane.add(mainPane, new GridBagConstraints());
		ccPaymentPane.setBackground(Color.CYAN);
	}
	
	public void initccPaymentConfirmPane() {
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		JLabel title = new JLabel("Confirm Payment Details");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		p1.setLayout(new GridLayout(14,2));
	
		double total, chosen;
		String [] temp =  seatType.split(" ");
		chosen = Double.parseDouble(temp[3]);
		total = seatAmount * chosen;
		
		String totalSeat="";
		for(int i=0;i<chosenSeat.size();i++){
			totalSeat = totalSeat+chosenSeat.get(i)+",";
		}
		
		JLabel lb1 = new JLabel("Selected Movie : ");
		lb1.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb2 = new JLabel("Selected Cinema : ");
		lb2.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb3 = new JLabel("Location : ");
		lb3.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb4 = new JLabel(loc);
		lb4.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb5 = new JLabel("Time Slot : ");
		lb5.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb6 = new JLabel(time);
		lb6.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb7 = new JLabel("Seat Type : ");
		lb7.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb8 = new JLabel(temp[0]);
		lb8.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb9 = new JLabel("Subtotal : ");
		lb9.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb10 = new JLabel("RM "+Double.toString(total+foodPrice));
		lb10.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb11 = new JLabel("Seat Numbers : ");
		lb11.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb12 = new JLabel(totalSeat);
		lb12.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb13 = new JLabel("Food Set 1 : ");
		lb13.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb14 = new JLabel(number[fbNum1.getSelectedIndex()] + " = RM" + food1);
		lb14.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb15 = new JLabel("Food Set 2 : ");
		lb15.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb16 = new JLabel(number[fbNum2.getSelectedIndex()] + " = RM" + food2);
		lb16.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb17 = new JLabel("Food Set 3 : ");
		lb17.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb18 = new JLabel(number[fbNum3.getSelectedIndex()] + " = RM" + food3);
		lb18.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb19 = new JLabel("Ticket : " );
		lb19.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb20 = new JLabel( seatAmount + " = RM" + Double.toString(total));
		lb20.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb21 = new JLabel("Name : " );
		lb21.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb22 = new JLabel(name);
		lb22.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb23 = new JLabel("Credit Card No : " );
		lb23.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb24 = new JLabel(ccno);
		lb24.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb25 = new JLabel("Contact : " );
		lb25.setFont(new Font("Arial", Font.PLAIN, 18));
		JLabel lb26 = new JLabel(contact);
		lb26.setFont(new Font("Arial", Font.PLAIN, 18));
		p1.add(lb21);
		p1.add(lb22);
		p1.add(lb23);
		p1.add(lb24);
		p1.add(lb25);
		p1.add(lb26);
		p1.add(lb1);
		p1.add(selectedMovie);
		p1.add(lb2);
		p1.add(selectedCinema);
		p1.add(lb3);
		p1.add(lb4);
		p1.add(lb5);
		p1.add(lb6);
		p1.add(lb7);
		p1.add(lb8);
		p1.add(lb11);
		p1.add(lb12);
		p1.add(lb13);
		p1.add(lb14);
		p1.add(lb15);
		p1.add(lb16);
		p1.add(lb17);
		p1.add(lb18);
		p1.add(lb19);
		p1.add(lb20);
		p1.add(lb9);
		p1.add(lb10);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.CYAN);
		JButton cancel = new JButton("Back");
		BackBtn7 event1 = new BackBtn7();
		cancel.addActionListener(event1);
		cancel.setFont(new Font("Arial", Font.BOLD, 20));
		cancel.setForeground(Color.RED);
		JButton next = new JButton("Proceed");
		ccPaymentConfirmBtn event2 = new ccPaymentConfirmBtn();
		next.addActionListener(event2);
		next.setFont(new Font("Arial", Font.BOLD, 20));
		
		p2.add(next, BorderLayout.CENTER);
		p2.add(cancel, BorderLayout.SOUTH);
		
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(p1, BorderLayout.CENTER);
		mainPane.add(p2, BorderLayout.SOUTH);
		
		ccPaymentConfirmPane.setLayout(new GridBagLayout());
		ccPaymentConfirmPane.add(mainPane, new GridBagConstraints());
		ccPaymentConfirmPane.setBackground(Color.CYAN);
	}
	
	public void initReceiptPane() {
		JPanel mainPane = new JPanel();
		JPanel secPane = new JPanel();
		
		mainPane.setLayout(new BorderLayout());
		mainPane.setBackground(Color.CYAN);
		
		
		ImageIcon icon1 = new ImageIcon("src/Project/qr.jpg"); // load the image to a imageIcon
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(300,300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon1 = new ImageIcon(newimg);
		
		JButton btn1 = new JButton(icon1);
		
		
		
		JButton finalize = new JButton("Home");
		finalize.setFont(new Font("Times New Roman", Font.BOLD, 20));
		finalize.setForeground(Color.RED);
		homeBtn event1 = new homeBtn();
		finalize.addActionListener(event1);
		
		
		
		secPane.setBackground(Color.CYAN);
		JLabel title = new JLabel("Purchased Tickets. TQ");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		mainPane.add(title, BorderLayout.NORTH);
		mainPane.add(btn1, BorderLayout.CENTER);
		mainPane.add(finalize, BorderLayout.SOUTH);
		receiptPane.setLayout(new GridBagLayout());
		receiptPane.add(mainPane, new GridBagConstraints());
		receiptPane.setBackground(Color.CYAN);
	}
	
	class LoginButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			error.setText("");
			String passText = new String(password.getPassword());
			if(username.getText().equals("Jack") && passText.equals("1234")){
				remove(loginPane);
				add(moviePane);
				username.setText("");
				password.setText("");
				repaint();
		        revalidate();
			}else {
				error.setText("Invalid Login Details");
			}
		}
	}
	
	class RegisterButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(loginPane);
			add(registerPane);
			repaint();
	        revalidate();
		}
	}
	
	class RegisterButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(registerPane);
			add(loginPane);
			repaint();
	        revalidate();
		}
	}
	
	class LogoutButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(moviePane);
			add(loginPane);
			repaint();
			revalidate();
		}
	}
	
	class BackButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(selectionPane);
			add(moviePane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Thor"); 
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Dredo"); 
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Dracula"); 
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton4 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Dawn of the Planet of Apes");
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Point Blank");
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class MovieButton6 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedMovie.setText("Wolverine");
			remove(moviePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class CinemaButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//GSC
			selectedCinema.setText("GSC");
			String [] prices = {"Student : RM 11.50", "Normal : RM 16.50"};
			pricing = new JComboBox<String>(prices);
			String [] locations = {"IOI Mall-Puchong", "Mid Valley Megamall", "Paradigm Mall"};
			location = new JComboBox<String>(locations);
			timePane.removeAll();
			initTimePane();
			remove(selectionPane);
			add(timePane);
			repaint();
			revalidate();
		}
	}
	
	class CinemaButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//MBO
			selectedCinema.setText("MBO");
			String [] prices = {"Student : RM 10.50", "Normal : RM 18.50"};
			pricing = new JComboBox<String>(prices);
			String [] locations = {"SPARK - Desa Petaling", "Viva Mall", "Citta Mall"};
			location = new JComboBox<String>(locations);
			timePane.removeAll();
			initTimePane();
			remove(selectionPane);
			add(timePane);
			repaint();
			revalidate();
		}
	}
	
	class CinemaButton3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TGV
			selectedCinema.setText("TGV");
			String [] prices = {"Student : RM 9.00", "Normal : RM 15.00"};
			pricing = new JComboBox<String>(prices);
			String [] locations = {"The Mines", "SetiaWalk", "Sunway Pyramid"};
			location = new JComboBox<String>(locations);
			timePane.removeAll();
			initTimePane();
			remove(selectionPane);
			add(timePane);
			repaint();
			revalidate();
		}
	}
	
	class ConfirmButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			loc = location.getSelectedItem().toString();
			time = timings.getSelectedItem().toString();
			seatType =  pricing.getSelectedItem().toString();
			seatPane.removeAll();
			initSeatPane();
			remove(timePane);
			add(seatPane);
			repaint();
			revalidate();
		}
	}
	
	class ConfirmButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			error.setText("");
			chosenSeat.clear();
			seatAmount=0;
			for(int i=0;i<30;i++){
				if(btns[i].isSelected() == true){
					chosenSeat.add("SeatNo "+(i+1));
					seatAmount++;
				}
			}
			if(seatAmount>0 && seatAmount<6){
				confirmPane.removeAll();
				initConfirmPane();	
				remove(seatPane);
				add(confirmPane);
				repaint();
				revalidate();
			}else if(seatAmount>5){
				error.setText("Please do NOT book more than 5 seats at once");
			}else{
				error.setText("Please Choose a Seat");
			}
		}
	}
	
	class ConfirmButton3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(confirmPane);
			add(fnbPane);
			repaint();
			revalidate();
		}
	}
	
	class SeatButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for(int i=0;i<30;i++){
				if(btns[i].isSelected() == true){
					btns[i].setText("Selected");
					btns[i].setForeground(Color.RED);
				}else {
					btns[i].setText("SeatNo "+(i+1));
					btns[i].setForeground(Color.BLACK);
				}
			}
			seatPane.updateUI();
		}
	}
	
	class CancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(confirmPane);
			add(seatPane);
			repaint();
			revalidate();
		}
	}
	
	class FnBButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			food1 = Double.parseDouble(number[fbNum1.getSelectedIndex()]) * 10;
			food2 = Double.parseDouble(number[fbNum2.getSelectedIndex()]) * 18;
			food3 = Double.parseDouble(number[fbNum3.getSelectedIndex()]) * 25;
			foodPrice = food1 + food2 + food3;
			fnbConfirmationPane.removeAll();
			preccPaymentPane.removeAll();
			initfnbConfirmPane();
			initpreccPaymentPane();	
			remove(fnbPane);
			add(fnbConfirmationPane);
			repaint();
			revalidate();
		}
	}
	
	class FnBConfirmButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
					
			remove(fnbConfirmationPane);
			add(preccPaymentPane);
			repaint();
			revalidate();
		}
	}
	
	class PreccPaymentButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(preccPaymentPane);
			add(ccPaymentPane);
			repaint();
			revalidate();
		}
	}
	
	class ccPaymentButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			name = txt11.getText();
			contact = txt55.getText();
			email = txt44.getText();
			ccno = txt22.getText();
			
			ccPaymentConfirmPane.removeAll();
			initccPaymentConfirmPane();		
			remove(ccPaymentPane);
			add(ccPaymentConfirmPane);
			repaint();
			revalidate();
		}
	}
	
	class ccPaymentConfirmBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			remove(ccPaymentConfirmPane);
			add(receiptPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(timePane);
			add(selectionPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(seatPane);
			add(timePane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(fnbPane);
			add(confirmPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn4 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(fnbConfirmationPane);
			add(fnbPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(ccPaymentPane);
			add(preccPaymentPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn6 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(preccPaymentPane);
			add(fnbPane);
			repaint();
			revalidate();
		}
	}
	
	class BackBtn7 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove(ccPaymentConfirmPane);
			add(ccPaymentPane);
			repaint();
			revalidate();
		}
	}
	
	class homeBtn implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Clean Panes
			loginPane.removeAll();
			registerPane.removeAll();
			moviePane.removeAll();
			selectionPane.removeAll();
			fnbPane.removeAll();
			ccPaymentPane.removeAll();
			receiptPane.removeAll();
			
			//Build All the other Panes by calling method
			initLoginPane();
			initRegisterPane();
			initMoviePane();
			initSelectionPane();
			initfnbPane();
			initccPaymentPane();
			initReceiptPane();
			
			fbNum1.setSelectedIndex(0);
			fbNum2.setSelectedIndex(0);
			fbNum3.setSelectedIndex(0);
			
			txt11.setText("");
			txt22.setText("");
			txt33.setText("");
			txt44.setText("");
			txt55.setText("");
			
			remove(receiptPane);
			add(loginPane);
			repaint();
			revalidate();
		}
	}
	
	
	//Set the Frame
	public static void main (String [] args){
		MainMenu menu = new MainMenu();
		menu.setTitle("UIPG");
		menu.setSize(1200,800);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
	}
}
