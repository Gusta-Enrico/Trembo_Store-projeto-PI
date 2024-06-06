document.addEventListener('DOMContentLoaded', () => {
    fetchProducts();
});

const user = JSON.parse(localStorage.getItem('user'));
const userCargo = user ? user.cargo : null;

function fetchProducts() {
    fetch('/produto/lista')
        .then(response => response.json())
        .then(data => {
            data.sort((a, b) => b.id - a.id);

            const tableBody = document.getElementById('productTableBody');
            tableBody.innerHTML = '';
            data.forEach(prod => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${prod.id}</td>
                    <td>${prod.nome}</td>
                    <td>${prod.qtdProduto}</td>
                    <td>R$ ${prod.preco}</td>
                    <td>${prod.status}</td>
                    <td><button onclick="abrirNovaJanela('${prod.id}', '${prod.nome}', '${prod.avaliacao}', '${prod.descricao}', '${prod.preco}', '${prod.qtdProduto}', '${prod.status}', '${prod.imagem}')">Editar</button></td>
                    <td><button onclick="confirmStatusUpdate('${prod.id}', '${prod.status}')">Ativar/Inativar</button></td>
                    <td><a href="interno.html?id=${prod.id}&imgurl=img/${prod.imagem}&name=${prod.nome}&description=${prod.descricao}&price=${prod.preco}" class="btn btn-dark">Visualizar</a></td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
}

function filterTable() {
    const input = document.getElementById("searchInput");
    const filter = input.value.toUpperCase();
    const table = document.getElementById("productTable");
    const tr = table.getElementsByTagName("tr");

    for (let i = 1; i < tr.length; i++) {
        const td = tr[i].getElementsByTagName("td")[1]; 
        if (td) {
            const txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function abrirNovaJanela(id, nome, avaliacao, descricao, preco, qtdProduto, status, imagem) {
    const url = `editarProduto.html?id=${encodeURIComponent(id)}`;
    window.open(url, "_blank");
}

function confirmStatusUpdate(productId, currentStatus) {
    if (userCargo === 'Administrador') {
        const confirmation = confirm("Tem certeza que deseja ativar/inativar este produto?");
        if (confirmation) {
            const newStatus = currentStatus === 'Ativo' ? 'Inativo' : 'Ativo';
            fetch(`/produto/${productId}/status`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ status: newStatus })
            })
            .then(response => {
                if (response.ok) {
                    fetchProducts();
                } else {
                    alert('Erro ao atualizar o status do produto');
                }
            })
            .catch(error => console.error('Error updating product status:', error));
        }
    } else {
        alert('Ação não permitida: você não tem permissão para ativar/inativar produtos.');
    }
}
