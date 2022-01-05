package Pedidos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Insets;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Canvas;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextField;

public class WindowPedidos {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPedidos window = new WindowPedidos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public WindowPedidos() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 1243, 682);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		table = new JTable( );
		table.setBounds(12, 42, 1205, 480);
		panel.add(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "Proveedores", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		JButton btnNewButton = new JButton(" Ultimos 30 pedidos");
		btnNewButton.setBounds(120, 591, 179, 26);
		panel.add(btnNewButton);
		//frame.getContentPane().setLayout(new MigLayout("", "[727px][][][][][][][]", "[36px][349px][26px]"));
		
		Label label = new Label("Pedidos Delivery ");
		label.setBounds(496, 0, 309, 36);
		panel.add(label);
		label.setFont(new Font("Dialog", Font.BOLD, 23));
		
		
		String[] marcaStrings = {"BK",
				"SBX", "SBXUY"};
		final JComboBox comboBox_2 = new JComboBox(marcaStrings);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marca = (String) comboBox_2.getSelectedItem();
				PedidosDeli.marcaElegido(marca);
			}
		});
		comboBox_2.setBounds(12, 554, 79, 25);
		panel.add(comboBox_2);
		
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Elegir Numero de Tienda?");
		chckbxNewCheckBox.setBounds(120, 530, 176, 24);
		panel.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox.setSelected(false);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxNewCheckBox.isSelected()) {
					PedidosDeli.esTienda(true);
				}
				else {
					PedidosDeli.esTienda(false);
				}
				
				
			}
		});
		
		String[] petStrings = {"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20",
				"21",
				"22",
				"23",
				"24",
				"25",
				"26",
				"27",
				"28",
				"29",
				"30",
				"31",
				"32",
				"33",
				"34",
				"35",
				"36",
				"37",
				"38",
				"39",
				"40",
				"41",
				"42",
				"43",
				"44",
				"45",
				"46",
				"47",
				"48",
				"49",
				"50",
				"51",
				"52",
				"53",
				"54",
				"55",
				"56",
				"57",
				"58",
				"59",
				"60",
				"61",
				"62",
				"63",
				"64",
				"65",
				"66",
				"67",
				"68",
				"69",
				"70",
				"71",
				"72",
				"73",
				"74",
				"75",
				"76",
				"77",
				"78",
				"79",
				"80",
				"81",
				"82",
				"83",
				"84",
				"85",
				"86",
				"87",
				"88",
				"89",
				"90",
				"91",
				"92",
				"93",
				"94",
				"95",
				"96",
				"97",
				"98",
				"99",
				"100",
				"101",
				"102",
				"103",
				"104",
				"105",
				"106",
				"107",
				"108",
				"109",
				"110",
				"111",
				"112",
				"113",
				"114",
				"115",
				"116",
				"117",
				"118",
				"119",
				"120",
				"121",
				"122",
				"123",
				"124",
				"125",
				"126",
				"127",
				"128",
				"129",
				"130",
				"131",
				"132",
				"133",
				"134",
				"135",
				"136",
				"137",
				"138",
				"139",
				"140",
				"141",
				"142",
				"143",
				"144",
				"145",
				"146",
				"147",
				"148",
				"149"
 };
		final JComboBox comboBox = new JComboBox(petStrings);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tienda = (String) comboBox.getSelectedItem();
				PedidosDeli.tiendaElegida(tienda);
			}
		});
		comboBox.setBounds(120, 554, 157, 25);
		panel.add(comboBox);
		
		
		
		String[] Agregadores = {
				"MAPP-CURB",
				"MAPP-RAPPI",
				"MENUAPP",
				"MOP-DELI",
				"PEDIDOSYA",
				"RAPPI",
				"ORDERING"};
		
		
		final JComboBox comboBox_1 = new JComboBox(Agregadores);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String agregador = (String) comboBox_1.getSelectedItem();
				PedidosDeli.agregadorElegido(agregador);
			}
		});
		comboBox_1.setBounds(310, 554, 131, 25);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Elegir Agregador");
		lblNewLabel.setBounds(310, 534, 119, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(514, 556, 104, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Pedido");
		lblNewLabel_1.setBounds(514, 534, 157, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Buscar pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String pedido;
					pedido = textField.getText();
					if (pedido.isEmpty()) {
						
						pedido = "111111111111";
						System.out.println(pedido);
					}
						
					table.setModel(new DefaultTableModel(PedidosDeli.PedidoEspecifico(pedido), new String[] {
							"Proveedores", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"}));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setBounds(641, 553, 145, 26);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setBounds(12, 534, 55, 16);
		panel.add(lblNewLabel_2);
		
		
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					table.setModel(new DefaultTableModel(PedidosDeli.pedidosTablaPEYA(), new String[] {
							"Proveedores", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}));
					//textArea.setText(PedidosDeli.pedidos());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
	}
}
