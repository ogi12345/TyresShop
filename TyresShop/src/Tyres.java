import java.awt.EventQueue;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Tyres {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tyres window = new Tyres();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textFieldManufacturer;
	private JTextField textFieldModel;
	private JLabel lblSeason;
	private JTextField textFieldSeason;
	private JLabel lblTypeOfVechile;
	private JTextField textFieldTypeOfVechile;
	private JLabel lblWidth;
	private JTextField textFieldWidth;
	private JLabel lblHeigh;
	private JTextField textFieldHeigh;
	private JLabel lblWheels;
	private JTextField textFieldWheels;
	private JLabel lblNewLabel;
	private JTextField textFieldQuantity;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField textFieldSearch;
	/**
	 * Create the application.
	 */
	public Tyres() {
		initialize();
		connection=OracleDatabaseConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 994, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from tyres";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e) {
					
				}
			}
		});
		btnLoadTable.setBounds(483, 530, 116, 46);
		frame.getContentPane().add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 13, 830, 431);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setBounds(39, 13, 89, 16);
		frame.getContentPane().add(lblManufacturer);
		
		textFieldManufacturer = new JTextField();
		textFieldManufacturer.setBounds(12, 40, 116, 22);
		frame.getContentPane().add(textFieldManufacturer);
		textFieldManufacturer.setColumns(10);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(39, 75, 56, 16);
		frame.getContentPane().add(lblModel);
		
		textFieldModel = new JTextField();
		textFieldModel.setBounds(12, 104, 116, 22);
		frame.getContentPane().add(textFieldModel);
		textFieldModel.setColumns(10);
		
		lblSeason = new JLabel("Season");
		lblSeason.setBounds(39, 139, 56, 16);
		frame.getContentPane().add(lblSeason);
		
		textFieldSeason = new JTextField();
		textFieldSeason.setBounds(12, 168, 116, 22);
		frame.getContentPane().add(textFieldSeason);
		textFieldSeason.setColumns(10);
		
		lblTypeOfVechile = new JLabel("Type of vechile");
		lblTypeOfVechile.setBounds(39, 203, 89, 16);
		frame.getContentPane().add(lblTypeOfVechile);
		
		textFieldTypeOfVechile = new JTextField();
		textFieldTypeOfVechile.setBounds(12, 232, 116, 22);
		frame.getContentPane().add(textFieldTypeOfVechile);
		textFieldTypeOfVechile.setColumns(10);
		
		lblWidth = new JLabel("Width");
		lblWidth.setBounds(39, 267, 56, 16);
		frame.getContentPane().add(lblWidth);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setBounds(12, 296, 116, 22);
		frame.getContentPane().add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		lblHeigh = new JLabel("Heigh");
		lblHeigh.setBounds(39, 331, 56, 16);
		frame.getContentPane().add(lblHeigh);
		
		textFieldHeigh = new JTextField();
		textFieldHeigh.setBounds(12, 360, 116, 22);
		frame.getContentPane().add(textFieldHeigh);
		textFieldHeigh.setColumns(10);
		
		lblWheels = new JLabel("Wheels");
		lblWheels.setBounds(39, 395, 56, 16);
		frame.getContentPane().add(lblWheels);
		
		textFieldWheels = new JTextField();
		textFieldWheels.setBounds(12, 424, 116, 22);
		frame.getContentPane().add(textFieldWheels);
		textFieldWheels.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "insert into tyres (Manufacturer, Model, Season, Typeofvechile, Width, Heigh, Wheels, Quantity) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldManufacturer.getText());
					pst.setString(2, textFieldModel.getText());
					pst.setString(3, textFieldSeason.getText());
					pst.setString(4, textFieldTypeOfVechile.getText());
					pst.setString(5, textFieldWidth.getText());
					pst.setString(6, textFieldHeigh.getText());
					pst.setString(7, textFieldWheels.getText());
					pst.setString(8, textFieldQuantity.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();

				} catch (Exception e) {
					
				}
			}
		});
		btnSave.setBounds(12, 530, 116, 46);
		frame.getContentPane().add(btnSave);
		
		lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setBounds(39, 461, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(12, 490, 116, 22);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Update Tyres set Manufacturer='"+textFieldManufacturer.getText()+"', Model='"+textFieldModel.getText()+"', Season='"+textFieldSeason.getText()+"', Typeofvechile='"+textFieldTypeOfVechile.getText()+"', Width='"+textFieldWidth.getText()+"', Heigh='"+textFieldHeigh.getText()+"', Wheels='"+textFieldWheels.getText()+"', Quantity='"+textFieldQuantity.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pst.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(12, 589, 116, 46);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbstractButton textFieldHeight;
					String query = "Delete from tyres where Model='"+textFieldModel.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(12, 648, 116, 46);
		frame.getContentPane().add(btnDelete);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query = "select * from tyres where manufacturer = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldSearch.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();

				} catch (Exception ex) {
					ex.printStackTrace(); 
				}
			}
		});
		textFieldSearch.setBounds(514, 660, 130, 22);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel lblSearchByManufacturer = new JLabel("Search by Manufacturer:");
		lblSearchByManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearchByManufacturer.setBounds(336, 663, 166, 16);
		frame.getContentPane().add(lblSearchByManufacturer);
	}
}
