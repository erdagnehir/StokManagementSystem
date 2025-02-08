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




