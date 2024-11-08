let vehiculosList;
 
const dialogVehiculo = document.getElementById('vehiculoModal');
const diVehiculoId = document.getElementById('diVehiculoId');
const diMarca = document.getElementById('diMarca');
const diPuertas = document.getElementById('diPuertas');
const diAutonomia_km = document.getElementById('diAutonomia_km');
const diPotencia_cv = document.getElementById('diPotencia_cv');
 
// Función para cargar vehiculos
function cargarVehiculos() {
    fetch('/api/vehiculos')
        .then(response => response.json())
        .then(vehiculos => {
            const tableBody = document.getElementById('vehiculosTable');
            tableBody.innerHTML = '';
            vehiculosList = vehiculos;
            vehiculos.forEach(vehiculo => {
                const row = `<tr data-id="${vehiculo.id}">                        
                    <td th:text="${vehiculo.color}"></td>
                    <td th:text="${vehiculo.marca}"></td>
                    <td th:text="${vehiculo.puertas}"></td>
                    <td th:text="${vehiculo.autonomia_km}"></td>
                    <td th:text="${vehiculo.potencia_cv}"></td>
                    <td>
                        <button class="editButton">Editar</button>
                        <button class="deleteButton">Eliminar</button>
                    </td>
                </tr>`;
                tableBody.insertAdjacentHTML('beforeend', row);
            });
            createFunctionalityButton();
        });
}

// Configura los botones de edición y eliminación
function createFunctionalityButton() {
    document.querySelectorAll('.closeButtonModal').forEach(button => {
        button.addEventListener('click', (e) => {
            e.preventDefault();
            dialogVehiculo.close();
        });
    });

    document.querySelectorAll('.editButton').forEach(button => {
        button.addEventListener('click', function () {
            const id = this.closest('tr').getAttribute('data-id');
            const vehiculo = vehiculosList.find(vehiculo => vehiculo.id === parseInt(id, 10));
            if (vehiculo) {
                diVehiculoId.value = vehiculo.id;
                diColor.value = vehiculo.color;
                diMarca.value = vehiculo.marca;
                diPuertas.value = vehiculo.puertas;
                diAutonomia_km.value = vehiculo.autonomia_km;
                diPotencia_cv.value = vehiculo.potencia_cv;
                dialogVehiculo.showModal();
            }
        });
    });

    document.querySelectorAll('.deleteButton').forEach(button => {
        button.addEventListener('click', function () {
            const id = this.closest('tr').getAttribute('data-id');
            eliminarVehiculo(id);
        });
    });

    document.querySelector('.createVehiculoButton').addEventListener('click', function () {
        diVehiculoId.value = "";
        diColor.value = "";
        diMarca.value = "";
        diPuertas.value = "";
        diAutonomia_km.value = "";
        diPotencia_cv.value = "";

        dialogVehiculo.showModal();
    });
}

// Función para guardar o actualizar un vehiculo
document.getElementById('vehciuloForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const vehiculoData = {
        id: diVehiculoId.value,
        color: diColor.value,
        marca: diMarca.value,
        puertas: diPuertas.value,
        autonomia_km: diAutonomia_km.value,
        potencia_cv: diPotencia_cv.value
    };
    const method = vehiculoData.id ? 'PUT' : 'POST';
    const url = vehiculoData.id ? `/api/vehiculos/${vehiculoData.id}` : '/api/vehiculos';

    fetch(url, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(vehiculoData)
    })
    .then(response => response.json())
    .then(data => {
        alert('Vehiculo creado/actualizado correctamente');
        dialogVehiculo.close();
        cargarVehiculos();
    })
    .catch(error => console.error('Error al guardar el vehiculo:', error));
});

// Función para eliminar un vehiculo
function eliminarVehiculo(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este vehiculo?')) {
        fetch(`/api/vehiculo/eliminar/${id}`, {
            method: 'DELETE',
        })
        .then(() => {
            alert('Vehiculo eliminado correctamente');

        })
        .catch(error => console.error('Error al eliminar el vehiculo:', error));
    }
}


// Cargar Vehiculos al iniciar
document.addEventListener('DOMContentLoaded', cargarVehiculos);