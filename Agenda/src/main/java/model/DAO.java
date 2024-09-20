package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The pw. */
	private String pw = "8102@Tveo"; // variável password

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Novo contato.
	 *
	 * @param contato the contato
	 */
	public void novoContato(JavaBeans contato) {
		String criar = "insert into contatos (bairro, cep, cidade, cpf, email, estado, fone, nome, numero, rg, rua) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(criar);
			pst.setString(1, contato.getBairro());
			pst.setString(2, contato.getCep());
			pst.setString(3, contato.getCidade());
			pst.setString(4, contato.getCpf());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getEstado());
			pst.setString(7, contato.getFone());
			pst.setString(8, contato.getNome());
			pst.setString(9, contato.getNumero());
			pst.setString(10, contato.getRg());
			pst.setString(11, contato.getRua());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String listar = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(listar);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String rua = rs.getString(5);
				String numero = rs.getString(6);
				String bairro = rs.getString(7);
				String cidade = rs.getString(8);
				String estado = rs.getString(9);
				String cep = rs.getString(10);
				String rg = rs.getString(11);
				String cpf = rs.getString(12);

				contatos.add(new JavaBeans(id, nome, fone, email, rua, numero, bairro, cidade, estado, cep, rg, cpf));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Sel contato.
	 *
	 * @param contato the contato
	 */
	public void selContato(JavaBeans contato) {
		String sel = "select * from contatos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sel);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2)); 
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				contato.setRua(rs.getString(5));
				contato.setNumero(rs.getString(6));
				contato.setBairro(rs.getString(7));
				contato.setCidade(rs.getString(8));
				contato.setEstado(rs.getString(9));
				contato.setCep(rs.getString(10));
				contato.setRg(rs.getString(11));
				contato.setCpf(rs.getString(12));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String altera = "update contatos set nome =?, fone =?, email =?, rg =?, cpf =?, rua =?, "
				+ "numero =?, bairro =?, cep =?, cidade =?, estado =? where id =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(altera);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getRg());
			pst.setString(5, contato.getCpf());
			pst.setString(6, contato.getRua());
			pst.setString(7, contato.getNumero());
			pst.setString(8, contato.getBairro());
			pst.setString(9, contato.getCep());
			pst.setString(10, contato.getCidade());
			pst.setString(11, contato.getEstado());
			pst.setString(12, contato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deleta contato.
	 *
	 * @param contato the contato
	 */
	public void deletaContato(JavaBeans contato) {		
		String deleta = "delete from contatos where id =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(deleta);
			pst.setString(1, contato.getId());			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
