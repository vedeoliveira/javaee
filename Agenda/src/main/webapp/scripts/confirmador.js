/**
 * Confirma se o contato será excluido.
 * @param id  
 */
function confirmar(id){
	let resposta = confirm("Deseja realmente excluir esse contato?")
	if(resposta === true){
		window.location.href ="apagar?id=" + id;				
	}
	
}