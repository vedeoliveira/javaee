/**
 * Validação de Formulario
 */
function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	if (nome === "") {
		alert("Campo nome não pode estar vazio!")
		frm.contato.nome.focus();
		return false
	} else if (fone === "") {
		alert("Campo fone não pode estar vazio!")
		frm.contato.fone.focus();
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}