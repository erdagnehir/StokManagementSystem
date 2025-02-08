   const products = document.querySelectorAll('#productId option');
   const stockMessage = document.getElementById('stockMessage');
   const quantityInput = document.getElementById('quantity');
   const saveButton = document.getElementById('saveButton');

   document.getElementById('productId').addEventListener('change', function() {
       const selectedProduct = Array.from(products).find(option => option.value === this.value);
       const stock = selectedProduct ? selectedProduct.getAttribute('data-stock') : 0;

       if (stock > 0) {
           stockMessage.textContent = `Bu üründen stokta ${stock} adet bulunmaktadır.`;
           stockMessage.style.color = 'green';
           saveButton.disabled = false;  // Stok varsa Kaydet butonunu aktif et
       } else {
           stockMessage.textContent = 'Bu ürün stokta yok.';
           stockMessage.style.color = 'red';
           saveButton.disabled = true;  // Stok yoksa Kaydet butonunu devre dışı bırak
       }
   });

   quantityInput.addEventListener('input', function() {
       const selectedProduct = Array.from(products).find(option => option.value === document.getElementById('productId').value);
       const stock = selectedProduct ? parseInt(selectedProduct.getAttribute('data-stock')) : 0;
       
       if (this.value > stock && stock !== 0) {
           alert(`Stokta sadece ${stock} adet ürün bulunmaktadır.`);
           this.value = stock;  // Stoktan fazla girilmesini engelle
       }
   });
