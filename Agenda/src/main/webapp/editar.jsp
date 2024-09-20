<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="icon" href="images/contato.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="atualizar">
		<table>
			<tr>
				<td><input type="text" name="id"
					class="Caixa3" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>		
			<tr>
				<td><input type="text" name="nome"
					class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="rg"
					class="Caixa2"value="<%out.print(request.getAttribute("rg"));%>"><input type="text" name="cpf"
					class="Caixa2"value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone"
					class="Caixa2"value="<%out.print(request.getAttribute("fone"));%>"><input type="text" name="email"
					class="Caixa2" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="rua"
					class="Caixa2" value="<%out.print(request.getAttribute("rua"));%>"><input type="text" name="numero"
					class="Caixa2" value="<%out.print(request.getAttribute("numero"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="bairro"
					class="Caixa2" value="<%out.print(request.getAttribute("bairro"));%>"><input type="text" name="cidade"
					class="Caixa2" value="<%out.print(request.getAttribute("cidade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="estado"
					class="Caixa2" value="<%out.print(request.getAttribute("estado"));%>"><input type="text" name="cep"
					class="Caixa2" value="<%out.print(request.getAttribute("cep"));%>"></td>
			</tr>

		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>