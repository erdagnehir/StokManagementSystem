document.getElementById("sortSelect").addEventListener("change", function() {
	let sortOrder = this.value;
	console.log("1");
	fetch(`/products/sort?order=${sortOrder}`, {
		method: 'GET',
		headers: {
			'Accept': 'application/json'
		}
	})
	
	.then(response => {
	    return response.json();
	})
		.then(data => {
			    if (!Array.isArray(data)) {
			        console.error("Hata: JSON dizisi bekleniyordu ama tek bir nesne döndü!");
			        return;
			    }
			let tableBody = document.getElementById("productTableBody");
			tableBody.innerHTML = "";
			data.forEach(product => {
				let row = `<tr>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.stock}</td>
                        <td>${product.warehouse.name}</td>
                        <td>${product.stock > 0 ? 'Evet' : 'Hayır'}</td>
                        <td>
                            <form action="/products/delete/${product.id}" method="post" class="d-inline">
                                <button type="submit" class="btn btn-danger btn-sm">Sil</button>
                            </form>
                            <a href="/products/add/${product.id}" class="btn btn-warning btn-sm">Güncelle</a>
                        </td>
                    </tr>`;
				tableBody.innerHTML += row;
			});
		})
		.catch(error => console.error("Hata:", error));
});
