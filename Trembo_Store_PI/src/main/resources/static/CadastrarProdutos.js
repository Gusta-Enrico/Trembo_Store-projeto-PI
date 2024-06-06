document.addEventListener("DOMContentLoaded", function() {
    const imageInput = document.getElementById("productImages");
    const imagePreviewContainer = document.getElementById("imagePreview");
    const mainImageSelect = document.getElementById("mainImageSelect");

    imageInput.addEventListener("change", function(event) {
        imagePreviewContainer.innerHTML = ""; 
        mainImageSelect.innerHTML = ""; 

        const files = event.target.files; 

        if (files) {
            for (const file of files) {
                const reader = new FileReader(); 
                reader.onload = function (e) {
                    const imageElement = document.createElement("img"); 
                    imageElement.src = e.target.result; 
                    imageElement.classList.add("preview-image");
                    imagePreviewContainer.appendChild(imageElement); 

                    const option = document.createElement("option");
                    option.value = file.name; 
                    option.text = file.name; 
                    mainImageSelect.appendChild(option); 
                };
                reader.readAsDataURL(file); 
            }
        }
    });
});

function cancel() {
    window.location.href = "/listaProdutos.html";
}
