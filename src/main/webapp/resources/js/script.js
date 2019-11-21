$(document).ready(function () {

	$("#buttonCollapse").on('click', function () {
		$("#sidebarMenu").toggleClass('active');
	});
});


function novaCategoria() {
	var displayID = document.getElementById('cadastrarTipoCategoriaID');
	var displayTipo = displayID.style.display;

	if (displayTipo == 'none') {
		displayID.style.display = 'block';
	}

}