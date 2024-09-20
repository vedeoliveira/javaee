<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="images/contato.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo Contato</a>
	<a href="relatorio" class="Botao2">Relatório</a>
	<table id ="tabela">
		<thead>
			<tr>				
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Cpf</th>
				<th>Rg</th>
				<th>Rua</th>
				<th>Nº</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Cep</th>		
				<th>Opc</th>						
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getCpf()%></td>
					<td><%=lista.get(i).getRg()%></td>
					<td><%=lista.get(i).getRua()%></td>
					<td><%=lista.get(i).getNumero()%></td>
					<td><%=lista.get(i).getBairro()%></td>
					<td><%=lista.get(i).getCidade()%></td>
					<td><%=lista.get(i).getEstado()%></td>
					<td><%=lista.get(i).getCep()%></td>
					<td><a href="selecionar?id=<%=lista.get(i).getId() %>" class="Botao1">Editar</a>
					    <a href="javascript:confirmar(<%=lista.get(i).getId() %>)" class="Botao2">Apagar</a></td>															
				</tr>
			<%} %>
		</tbody>		
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>