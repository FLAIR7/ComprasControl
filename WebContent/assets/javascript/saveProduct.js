var idProduct = 0;

$(document).on('show.bs.modal', '#exampleModal', function (event){
	$('#exampleModal').modal('show')
	var button = $(event.relatedTarget);
	//var clickedButtonId = button.data('id');
	idProduct = button.data('id');
})

function saveProduct(){
	let name = $('#name').val();
	let price = $('#price').val();
	let purchase = $('#myselect option:selected').val();
	
	if(!name || !price || !purchase){
		console.log('Error');
		Swal.fire({
				heightAuto: false,
  				icon: 'error',
  				title: 'Field Invalid!',
  				text: 'please check the fields!',
			})
	} else if(name && price){
		$.ajax({
			method: "POST",
			url: "list?action=update",
			data: {
				idProduct: idProduct,
				name: name,
				price: price,
				purchase: purchase
			}
		}).done( function (){
			$("#exampleModal").modal('hide')
			window.setTimeout(function(){location.reload()},100)
		})
	}
}

