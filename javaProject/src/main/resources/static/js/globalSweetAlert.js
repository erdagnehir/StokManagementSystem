document.addEventListener("DOMContentLoaded", () => {
    const body = document.querySelector("body");
    let message = body.getAttribute("data-sweet-alert-message") || "";
    let type = body.getAttribute("data-sweet-alert-type") || "info";
    let action = body.getAttribute("data-sweet-alert-action") || "default";
    let registeredUserName = body.getAttribute("data-registered-user-name") || "Değerli Kullanıcı";

    console.log("SweetAlert Action:", action);
    console.log("SweetAlert Message:", message);

    if (!message || message.trim() === "") {
        return;
    }

    let title = "";
    let extraText = "";

    switch (action) {
        case "create":
            title = "Sipariş Oluşturuldu!";
            extraText = `📅 <b>Sipariş Tarihi:</b> ${body.getAttribute("data-order-date") || "Belirtilmedi"}<br>
                         🚚 <b>Tahmini Kargoya Veriliş:</b> ${body.getAttribute("data-estimated-shipping-date") || "Belirtilmedi"}`;
            type = "success";
            break;
        case "approve":
            title = "Sipariş Onaylandı!";
            extraText = "✅ Sipariş başarıyla onaylandı.";
            type = "success";
            break;
        case "reject":
            title = "Sipariş Reddedildi!";
            extraText = "⚠ Sipariş başarıyla reddedildi.";
            type = "warning";
            break;
        case "register":
            title = `Hoş Geldin, ${registeredUserName}! 🎉`;
            extraText = "✔ Üyelik başarılı! Giriş ekranına yönlendiriliyorsunuz.";
            type = "success";
            break;
        case "error":
            title = "Hata!";
            extraText = message;
            type = "error";
            break;
        default:
            title = "Bilgilendirme";
            type = "info";
            break;
    }

    Swal.fire({
        icon: type,
        title: title,
        html: extraText,
        background: '#ffffff',
        color: '#000000'
    });
});