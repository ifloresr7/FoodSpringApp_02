let clientesList;
const dialogCliente = document.getElementById('clienteModal');
const diClienteId = document.getElementById('diClienteId');
const diNombre = document.getElementById('diNombre');
const diApellidos = document.getElementById('diApellidos');
const diEmail = document.getElementById('diEmail');
const diTelefono = document.getElementById('diTelefono');
const diDireccion = document.getElementById('diDireccion');

fetch('/api/clientes')
    .then(response => response.json())
    .then(clientes => {
        const tableBody = document.getElementById('clientesTable');
        tableBody.innerHTML = '';
        clientesList = clientes;
        clientes.forEach(cliente => {
            const row = `<tr data-id="${cliente.id}">
                <td>${cliente.id}</td>
                <td>${cliente.nombre} ${cliente.apellidos}</td>
                <td>${cliente.email}</td>
                <td>${cliente.telefono}</td>
                <td>${cliente.direccion}</td>
                <td>
                    <button class="editButton">Editar</button>
                    <button class="delete">Eliminar</button>
                </td>
            </tr>`;
            tableBody.insertAdjacentHTML('beforeend', row);
        });
        createFunctionalityButton();
    });

    function createFunctionalityButton() {
        const closeButtonModal = document.querySelectorAll('.closeButtonModal');
        closeButtonModal.forEach(button => {
            button.addEventListener('click', (e) => {
                e.preventDefault();
                const dialog = button.closest('dialog');
                dialog.close();
            });
        });
    
        const editButtons = document.querySelectorAll('.editButton');
        editButtons.forEach(function (button) {
            button.addEventListener('click', function () {
                const id = this.closest('tr').getAttribute('data-id');
                const cliente = clientesList.find(cliente => cliente.id === parseInt(id, 10));
                if (cliente) {
                    diClienteId.value = cliente.id;
                    diNombre.value = cliente.nombre;
                    diApellidos.value = cliente.apellidos;
                    diEmail.value = cliente.email;
                    diTelefono.value = cliente.telefono;
                    diDireccion.value = cliente.direccion;
                    dialogCliente.showModal();
                } else {
                    console.log("Cliente no encontrado");
                }
            });
        });

        document.querySelector('.createClienteButton').addEventListener('click', function () {
            diClienteId.value = "";
            diNombre.value = "";
            diApellidos.value = "";
            diEmail.value = "";
            diTelefono.value = "";
            diDireccion.value = "";
            dialogCliente.showModal();
        }); 
    }
    
    document.getElementById('clienteForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const dialog = document.getElementById('clienteForm').closest('dialog');
        dialog.close();
        const clienteData = {
            id: document.getElementById('diClienteId').value,
            nombre: document.getElementById('diNombre').value,
            apellidos: document.getElementById('diApellidos').value,
            email: document.getElementById('diEmail').value,
            telefono: document.getElementById('diTelefono').value,
            direccion: document.getElementById('diDireccion').value
        };
        const method = clienteData.id ? 'PUT' : 'POST';
        const url = clienteData.id ? `/clientes/${clienteData.id}` : '/clientes';
        fetch(url, {
            method: method, 
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(clienteData)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Cliente creado/actualizado:', data);
        })
        .catch(error => {
            console.error('Error al enviar datos:', error);
        });
    });
