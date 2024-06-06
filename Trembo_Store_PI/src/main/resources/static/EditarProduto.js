document.addEventListener("DOMContentLoaded", function() {
    const imageInput = document.getElementById("productImages");
    const imagePreviewContainer = document.getElementById("imagePreview");
    const mainImageSelect = document.getElementById("mainImageSelect");
    const form = document.getElementById("editProductForm");

    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');
    const user = JSON.parse(localStorage.getItem('user'));

    if (user && user.cargo !== 'Administrador') {
        restrictFields();
    }

    fetch(`/produto/${productId}`)
        .then(response => response.json())
        .then(product => {
            document.getElementById("productName").value = product.nome;
            document.getElementById("productRating").value = product.avaliacao;
            document.getElementById("productDescription").value = product.descricao;
            document.getElementById("productPrice").value = product.preco;
            document.getElementById("productMarca").value = product.marca;
            document.getElementById("productCategoria").value = product.categoria;
            document.getElementById("productStock").value = product.qtdProduto;
            document.getElementById("productId").value = product.id;

            product.imagens.forEach(image => {
                const option = document.createElement("option");
                option.value = image;
                option.text = image;
                mainImageSelect.appendChild(option);

                const imageElement = document.createElement("img");
                imageElement.src = `/img/${image}`;
                imageElement.classList.add("preview-image");
                imagePreviewContainer.appendChild(imageElement);
            });

            mainImageSelect.value = product.imagemPrincipal;
        })
        .catch(error => console.error('Erro ao buscar produto:', error));

    form.addEventListener("submit", function(event) {
        event.preventDefault();

        enableRestrictedFields();

        const formData = new FormData(form);

        if (!isAdmin()) {
            restrictFields();
        }

        fetch(`/produto/${productId}`, {
            method: 'PUT',
            body: formData
        })
        .then(response => {
            if (response.ok) {
                window.location.href = "/listaProdutos.html";
            } else {
                alert('Erro ao atualizar o produto');
            }
        })
        .catch(error => console.error('Erro ao atualizar produto:', error));
    });
});

function restrictFields() {
    const fields = [
        "productName",
        "productRating",
        "productDescription",
        "productPrice",
        "productMarca",
        "productCategoria",
        "productImages",
    ];
    fields.forEach(fieldId => {
        const field = document.getElementById(fieldId);
        field.disabled = true;
    });
}

function isAdmin() {
    const user = JSON.parse(localStorage.getItem('user'));
    return user && user.cargo === 'Administrador';
}

function enableRestrictedFields() {
    const fields = [
        "productName",
        "productRating",
        "productDescription",
        "productPrice",
        "productImages",
        "mainImageSelect"
    ];
    fields.forEach(fieldId => {
        const field = document.getElementById(fieldId);
        field.disabled = false;
    });
}

function cancel() {
    window.location.href = "/listaProdutos.html";
}
