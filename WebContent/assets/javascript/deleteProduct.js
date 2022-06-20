var idProduct = 0;

$(document).on('show.bs.modal', '#exampleModalCenter', function (event){
	$('#exampleModalCenter').modal('show')
	var button = $(event.relatedTarget);
	var clickedButtonId = button.data('id');
	console.log(button);
	console.log(clickedButtonId);
	idProduct = button.data('id');
})

$(document).on("click", "#excluir", function(){
	$.ajax({
		method: "GET",
		url: "list?action=delete",
		data: {
			idProduct: idProduct,
		}
	}).done(function (){
		$("#exampleModalCenter").modal('hide')
		window.setTimeout(function(){location.reload()},100)
	}).fail(function (){
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'Something went wrong',
		  showConfirmButton: false,
		  timer: 1500
		})
	})
});

