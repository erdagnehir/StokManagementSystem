function toggleSidebar() {
    var sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("collapsed");

    // Sidebar küçüldüğünde localStorage'a kaydedelim
    localStorage.setItem("sidebarState", sidebar.classList.contains("collapsed") ? "collapsed" : "expanded");
}

// Sayfa yüklendiğinde sidebar'ın durumunu kontrol et
document.addEventListener("DOMContentLoaded", function () {
    var sidebar = document.getElementById("sidebar");
    var savedState = localStorage.getItem("sidebarState");
    if (savedState === "collapsed") {
        sidebar.classList.add("collapsed");
    }
});
