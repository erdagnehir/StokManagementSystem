function filterOrders() {
	const status = document.getElementById("statusFilter").value;

	fetch(`/orders/ordersFilter?status=${status}`)
		.then(response => {
			console.log("Response Status:", response.status);
			return response.text();
		})
		.then(html => {
			console.log("Returned HTML:", html);
			const tableBody = document.querySelector("table tbody");
			if (tableBody) {
				tableBody.innerHTML = html;
			} else {
				console.error("Table body not found in DOM");
			}
		})
		.catch(error => console.error('Error fetching filtered orders:', error));
}

document.addEventListener("DOMContentLoaded", () => {
	const body = document.querySelector("body");
	const message = body.getAttribute("data-sweet-alert-message");
	const type = body.getAttribute("data-sweet-alert-type");

	if (message) {	
		
		let title;

	        if (type === 'success') {
	            title = 'Başarılı';
	        } else if (type === 'error') {
	            title = 'Bilgilendirme';
	        } else {
	            title = 'Uyarı';
	        }

		Swal.fire({
			icon: type || 'info',
			title: title,
			text: message,
			background: '#ffffff',
			color: '#000000'
		});
	}
});

