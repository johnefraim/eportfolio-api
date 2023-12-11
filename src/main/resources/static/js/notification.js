function showToast(message) {
    let toast = document.getElementById("toast");
    let toastMessage = document.getElementById("toastMessage");
    if (toast && toastMessage) {
        toastMessage.textContent = message;
        toast.classList.remove("hidden");

        setTimeout(() => {
            toast.classList.add("hidden");
        }, 3000);
    }
}
