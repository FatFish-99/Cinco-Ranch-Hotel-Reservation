import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CincoRanchHotelReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textNights;
	private JTextField textRate;
	private JTextField textSubTotal;
	private JTextField textTax;
	private JTextField textTotal;
	private static ArrayList <Reservation> list = new ArrayList<Reservation>();
	private static int index=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CincoRanchHotelReservation frame = new CincoRanchHotelReservation();
					frame.setVisible(true);
					Scanner scan = new Scanner(new File("reservations"));
					while (scan.hasNextLine()){
						String line = scan.nextLine();
						String [] arr = line.split(" ");
						String id = arr[0];
						String name = arr[1]+" "+arr[2];
						int nights = Integer.parseInt(arr[3]);
						int rate = Integer.parseInt(arr[4]);
						Reservation r = new Reservation(id, name, nights, rate);
						list.add(r);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CincoRanchHotelReservation() {
		setTitle("Cinco Ranch Hotel Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Cinco Ranch Hotel Reservation");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(49, 11, 430, 30);
		contentPane.add(lblTitle);
		
		JLabel lblReservationID = new JLabel("ReservationID");
		lblReservationID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReservationID.setBounds(25, 52, 110, 25);
		contentPane.add(lblReservationID);
		
		JLabel lblGuestname = new JLabel("GuestName");
		lblGuestname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGuestname.setBounds(25, 89, 110, 25);
		contentPane.add(lblGuestname);
		
		JLabel lblNumberOfNights = new JLabel("Number of nights");
		lblNumberOfNights.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfNights.setBounds(25, 125, 110, 25);
		contentPane.add(lblNumberOfNights);
		
		JLabel lblRatePerNight = new JLabel("Rate per night");
		lblRatePerNight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRatePerNight.setBounds(25, 161, 110, 25);
		contentPane.add(lblRatePerNight);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textID.setBounds(145, 53, 110, 25);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textName.setColumns(10);
		textName.setBounds(145, 90, 110, 25);
		contentPane.add(textName);
		
		textNights = new JTextField();
		textNights.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNights.setColumns(10);
		textNights.setBounds(145, 126, 110, 25);
		contentPane.add(textNights);
		
		textRate = new JTextField();
		textRate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRate.setColumns(10);
		textRate.setBounds(145, 162, 110, 25);
		contentPane.add(textRate);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubtotal.setBounds(285, 52, 80, 25);
		contentPane.add(lblSubtotal);
		
		JLabel lblTax = new JLabel("Tax (6%)");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTax.setBounds(285, 89, 80, 25);
		contentPane.add(lblTax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(285, 125, 80, 25);
		contentPane.add(lblTotal);
		
		textSubTotal = new JTextField();
		textSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSubTotal.setColumns(10);
		textSubTotal.setBounds(369, 55, 110, 25);
		contentPane.add(textSubTotal);
		
		textTax = new JTextField();
		textTax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTax.setColumns(10);
		textTax.setBounds(369, 92, 110, 25);
		contentPane.add(textTax);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTotal.setColumns(10);
		textTotal.setBounds(369, 128, 110, 25);
		contentPane.add(textTotal);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;
				String id = list.get(index).getId();
				String name = list.get(index).getName();
				int nights = list.get(index).getNights();
				int rate = list.get(index).getRate();
				textID.setText(id);
				textName.setText(name);
				textNights.setText(""+nights);
				textRate.setText("$"+rate);
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFirst.setBounds(10, 210, 90, 30);
		contentPane.add(btnFirst);
		
		JButton btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index+=1;
				if (index>list.size()-1)
					index= list.size()-1;
				String id = list.get(index).getId();
				String name = list.get(index).getName();
				int nights = list.get(index).getNights();
				int rate = list.get(index).getRate();
				textID.setText(id);
				textName.setText(name);
				textNights.setText(""+nights);
				textRate.setText("$"+rate);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNext.setBounds(110, 210, 90, 30);
		contentPane.add(btnNext);
		
		JButton btnPrevious = new JButton("<<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index-=1;
				if (index<0)
					index=0;
				String id = list.get(index).getId();
				String name = list.get(index).getName();
				int nights = list.get(index).getNights();
				int rate = list.get(index).getRate();
				textID.setText(id);
				textName.setText(name);
				textNights.setText(""+nights);
				textRate.setText("$"+rate);
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPrevious.setBounds(210, 210, 90, 30);
		contentPane.add(btnPrevious);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=list.size()-1;
				String id = list.get(index).getId();
				String name = list.get(index).getName();
				int nights = list.get(index).getNights();
				int rate = list.get(index).getRate();
				textID.setText(id);
				textName.setText(name);
				textNights.setText(""+nights);
				textRate.setText("$"+rate);
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLast.setBounds(310, 210, 90, 30);
		contentPane.add(btnLast);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				String name = textName.getText();
				int nights = Integer.parseInt(textNights.getText());
				int rate = Integer.parseInt(textRate.getText().replace("$", ""));
				Reservation newReserv = new Reservation(id, name, nights, rate);
				list.add(newReserv);
				try (FileWriter fw = new FileWriter("reservations", true);
						 BufferedWriter bw = new BufferedWriter(fw)) {
					bw.newLine();
					bw.write(""+newReserv.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBounds(410, 210, 90, 30);
		contentPane.add(btnSave);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nights = Integer.parseInt(textNights.getText());
				int rate = Integer.parseInt(textRate.getText().replace("$", ""));
				double subTotal = nights*rate;
				double tax = subTotal*6/100;
				double total = subTotal + tax;
				textSubTotal.setText(""+subTotal);
				textTax.setText(""+tax);
				textTotal.setText("$"+total);
			}
		});
		btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTotal.setBounds(210, 260, 90, 30);
		contentPane.add(btnTotal);
	}
}
