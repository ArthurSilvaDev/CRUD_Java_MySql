package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.IdeiaDTO;

public class IdeiaDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<IdeiaDTO> lista = new ArrayList<>();
	
	public void cadastrarIdeia(IdeiaDTO objideiadto) {
		
		String sql = "insert into ideia (TITULO, DESCRICAO, URGENCIA) values (?,?,?)";
		
		new ConexaoDAO();
		conn = ConexaoDAO.getConnection();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objideiadto.getTitulo_ideia());
			pstm.setString(2, objideiadto.getDescricao_ideia());
			pstm.setString(3, objideiadto.getUrgencia_ideia());
			
			pstm.execute();
			pstm.close();
			
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null,"IdeiaDAO Cadastrar: " +  erro);
		}
		
	}
	
	public ArrayList<IdeiaDTO> PesquisarIdeia() {
		
		String sql ="select * FROM ideia";
		
		
		new ConexaoDAO();
		conn = ConexaoDAO.getConnection();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				IdeiaDTO objIdeiaDTO = new IdeiaDTO();
				objIdeiaDTO.setId_ideia(rs.getInt("ID"));
				objIdeiaDTO.setTitulo_ideia(rs.getString("TITULO"));
				objIdeiaDTO.setDescricao_ideia(rs.getString("DESCRICAO"));
				objIdeiaDTO.setUrgencia_ideia(rs.getString("URGENCIA"));
				
				lista.add(objIdeiaDTO);
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"IdeiaDAO Pesquisar: " +  erro);
		}
		
		return lista;
	}
	
	public void alterarIdeia (IdeiaDTO objideiadto) {
		
		String sql = "UPDATE ideia set titulo = ?, descricao = ?, urgencia = ? where id = ?";
		
		new ConexaoDAO();
		conn = ConexaoDAO.getConnection();
		
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objideiadto.getTitulo_ideia());
			pstm.setString(2, objideiadto.getDescricao_ideia());
			pstm.setString(3, objideiadto.getUrgencia_ideia());
			pstm.setInt(4, objideiadto.getId_ideia());

			pstm.execute();
			pstm.close();


		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null,"IdeiaDAO Alterar: " +  erro);
		}
		
	}
	
	
	public void excluirIdeia(IdeiaDTO objideiadto) {
		
		String sql = "DELETE from ideia where id = ?";
		
		new ConexaoDAO();
		conn = ConexaoDAO.getConnection();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objideiadto.getId_ideia());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"IdeiaDAO Excluir: " +  erro);
		}
		
	}
	
}
