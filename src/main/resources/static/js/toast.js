function showToast() {
    const toast = document.getElementById("toast");
    if (toast) {
        toast.classList.remove('hidden');
        setTimeout(function(){ toast.classList.add('hidden'); }, 3000);
    }
}

window.onload = showToast;
