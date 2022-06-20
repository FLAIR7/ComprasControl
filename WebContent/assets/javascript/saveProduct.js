var idProduct = 0;

$(document).on('show.bs.modal', '#exampleModal', function (event){
	$('#exampleModal').modal('show')
	var button = $(event.relatedTarget);
	var clickedButtonId = button.data('id');
	console.log(button);
	console.log(clickedButtonId);
	idProduct = button.data('id');
})

function saveProduct(){
	let name = $('#name').val();
	let price = $('#price').val();
	
	if(name == '' || name == null){
		console.log('Error');
	} else {
		$.ajax({
			method: "POST",
			url: "list?action=update",
			data: {
				idProduct: idProduct,
				name: name,
				price: price
			}
		}).done( function (){
			$("#exampleModal").modal('hide')
//			location.reload(); 
			window.setTimeout(function(){location.reload()},100)
		})
	}
}

/*

$(document).on("click", "#salvar", function(){
	let name = $('#name').val();
	let price = $('#price').val();
	$.ajax({
		method: "POST",
		url: "list?action=update",
		data: {
			idProduct: idProduct,
			name: name,
			price: price
		}
	}).done(function (){
		$("#exampleModalCenter").modal('hide')
		Swal.fire({
		  position: 'top-end',
		  icon: 'success',
		  title: 'Product updated',
		  showConfirmButton: false,
		  timer: 1500
		})
	}).fail(function (){
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'Something went wrong',
		  showConfirmButton: false,
		  timer: 1500
		})
	})
});*/

