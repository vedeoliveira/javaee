package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/controller", "/main", "/insert", "/selecionar", "/atualizar", "/apagar", "/relatorio" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/selecionar")) {
			selecionarContato(request, response);
		} else if (action.equals("/atualizar")) {
			atualizarContato(request, response);
		} else if (action.equals("/apagar")) {
			apagaContato(request, response);
		} else if (action.equals("/relatorio")) {
			relatorioContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();

		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome(request.getParameter("nome"));
		contato.setBairro(request.getParameter("bairro"));
		contato.setCep(request.getParameter("cep"));
		contato.setCidade(request.getParameter("cidade"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setEmail(request.getParameter("email"));
		contato.setEstado(request.getParameter("estado"));
		contato.setFone(request.getParameter("fone"));
		contato.setNumero(request.getParameter("numero"));
		contato.setRg(request.getParameter("rg"));
		contato.setRua(request.getParameter("rua"));
		dao.novoContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Selecionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId(request.getParameter("id"));
		dao.selContato(contato);
		request.setAttribute("id", contato.getId());
		request.setAttribute("bairro", contato.getBairro());
		request.setAttribute("cep", contato.getCep());
		request.setAttribute("cidade", contato.getCidade());
		request.setAttribute("cpf", contato.getCpf());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("estado", contato.getEstado());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("numero", contato.getNumero());
		request.setAttribute("rg", contato.getRg());
		request.setAttribute("rua", contato.getRua());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Atualizar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void atualizarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId(request.getParameter("id"));
		contato.setBairro(request.getParameter("bairro"));
		contato.setCep(request.getParameter("cep"));
		contato.setCidade(request.getParameter("cidade"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setEstado(request.getParameter("email"));
		contato.setEstado(request.getParameter("estado"));
		contato.setFone(request.getParameter("fone"));
		contato.setNome(request.getParameter("nome"));
		contato.setNumero(request.getParameter("numero"));
		contato.setRg(request.getParameter("rg"));
		contato.setRua(request.getParameter("rua"));
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Apaga contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void apagaContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId(request.getParameter("id"));
		dao.deletaContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Relatorio contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void relatorioContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());

			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			documento.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(3);
			PdfPCell coluna1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell coluna2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell coluna3 = new PdfPCell(new Paragraph("E-mail"));

			tabela.addCell(coluna1);
			tabela.addCell(coluna2);
			tabela.addCell(coluna3);

			ArrayList<JavaBeans> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}
}
