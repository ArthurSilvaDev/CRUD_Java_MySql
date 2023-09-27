package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.IdeiaDAO;
import DTO.IdeiaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class frmIdeiaVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Titulo;
	private JTextField textField_descricao;
	private JTextField textField_urgencia;
	private final Action action = new SwingAction();
	private JTable tabelaIdeia;
	private JTextField textField_Id;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					frmIdeiaVIEW frame = new frmIdeiaVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmIdeiaVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Titulo = new JTextField();
		textField_Titulo.setBounds(29, 45, 368, 20);
		contentPane.add(textField_Titulo);
		textField_Titulo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ideia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(29, 0, 384, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(29, 22, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setBounds(29, 76, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_descricao = new JTextField();
		textField_descricao.setBounds(29, 90, 368, 34);
		contentPane.add(textField_descricao);
		textField_descricao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Urgência");
		lblNewLabel_3.setBounds(29, 128, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_urgencia = new JTextField();
		textField_urgencia.setBounds(29, 146, 91, 20);
		contentPane.add(textField_urgencia);
		textField_urgencia.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarIdeia();
				listarValores(); //lista já cadastrado
				limparCampos(); //limpa pra começar de novo o preenchimento
				
				}
		});
		btnEnviar.setBounds(29, 177, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnListar.setBounds(32, 319, 89, 23);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 233, 283, 133);
		contentPane.add(scrollPane);
		
		tabelaIdeia = new JTable();
		scrollPane.setViewportView(tabelaIdeia);
		tabelaIdeia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EDtulo", "Descri\u00E7\u00E3o", "Urg\u00EAncia"
			}
		));
		
		JLabel lblNewLabel_4 = new JLabel("Dados cadastrados");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(141, 215, 283, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(311, 128, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_Id = new JTextField();
		textField_Id.setEnabled(false);
		textField_Id.setBounds(311, 146, 86, 20);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);
		
		JButton btnCarregarCampos = new JButton("Carregar");
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnCarregarCampos.setBounds(32, 343, 89, 23);
		contentPane.add(btnCarregarCampos);
		
		JButton btnLimparCampos = new JButton("Limpar");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimparCampos.setBounds(29, 224, 89, 23);
		contentPane.add(btnLimparCampos);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarIdeia();
				listarValores();
				limparCampos();
			}
		});
		btnAlterar.setBounds(29, 199, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirIdeia();
				listarValores();
				limparCampos();
			}
		});
		btnExcluir.setBounds(29, 247, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_6 = new JLabel("Arthur Felipe da Silva");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(141, 149, 160, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Programação Orientada a Objetos II");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(124, 164, 196, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ADS / IFRS - Campus Osório");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(141, 181, 160, 14);
		contentPane.add(lblNewLabel_8);
		
		//Inicializar a tabela já preenchida com dados:
		listarValores();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	
	//MÉTODOS 
	
		private void cadastrarIdeia() {
			
			String titulo, descricao, urgencia;
			
			titulo = textField_Titulo.getText();
			descricao = textField_descricao.getText();
			urgencia = textField_urgencia.getText();
			
			IdeiaDTO objideiadto =  new IdeiaDTO();
			
			objideiadto.setTitulo_ideia(titulo);
			objideiadto.setDescricao_ideia(descricao);
			objideiadto.setUrgencia_ideia(urgencia);
			
			IdeiaDAO objideiadao = new IdeiaDAO();
			objideiadao.cadastrarIdeia(objideiadto);
		}
	
	
		private void listarValores() {
			try {
				
				IdeiaDAO objideiadao = new IdeiaDAO();
				
				DefaultTableModel model = (DefaultTableModel) tabelaIdeia.getModel();
				model.setNumRows(0);
				
				ArrayList<IdeiaDTO> lista = objideiadao.PesquisarIdeia();
				
				for (int num = 0; num < lista.size(); num ++) {
					model.addRow(new Object[] {
							lista.get(num).getId_ideia(),
							lista.get(num).getTitulo_ideia(),
							lista.get(num).getDescricao_ideia(),
							lista.get(num).getUrgencia_ideia()
					});
				}
			
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "ListarValores View: " +  erro);
			}
		}
		
		private void CarregarCampos() {
			
			int setar = tabelaIdeia.getSelectedRow();
			
			textField_Id.setText(tabelaIdeia.getModel().getValueAt(setar, 0).toString());
			textField_Titulo.setText(tabelaIdeia.getModel().getValueAt(setar, 1).toString());
			textField_descricao.setText(tabelaIdeia.getModel().getValueAt(setar, 2). toString());
			textField_urgencia.setText(tabelaIdeia.getModel().getValueAt(setar, 3).toString());
					
		}
		
		private void limparCampos() {
			
			textField_Id.setText("");
			textField_Titulo.setText("");
			textField_descricao.setText("");
			textField_urgencia.setText("");
			textField_Titulo.requestFocus();
			
		}
		
		private void alterarIdeia() {
			
			try {
				String titulo, descricao, urgencia;
				int id;
				
				id = Integer.parseInt(textField_Id.getText());
				titulo = textField_Titulo.getText();
				descricao = textField_descricao.getText();
				urgencia = textField_urgencia.getText();
				
				IdeiaDTO objideiadto = new IdeiaDTO();
				
				objideiadto.setId_ideia(id);
				objideiadto.setTitulo_ideia(titulo);
				objideiadto.setDescricao_ideia(descricao);
				objideiadto.setUrgencia_ideia(urgencia);
				
				IdeiaDAO objideiadao = new IdeiaDAO();
				
				objideiadao.alterarIdeia(objideiadto);
			} catch (NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "Favor carregar algum campo através do comando 'Carregar' ");
			}catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "ERRO Alterar" + erro);
			}
			
			
		}
		
		private void excluirIdeia() {
			
			int id;
			
			id =  Integer.parseInt(textField_Id.getText());
			
			IdeiaDTO objideiadto = new IdeiaDTO();
			
			objideiadto.setId_ideia(id);
			
			IdeiaDAO objideiadao =  new IdeiaDAO();
			
			objideiadao.excluirIdeia(objideiadto);
		}
}
