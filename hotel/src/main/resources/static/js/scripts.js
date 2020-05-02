function Mostrar(id){
    document.getElementById(id).style.display = "block";
    // document.getElementById("boton").value = "Ocultar";
}

function Ocultar(id){
    document.getElementById(id).style.display = "none";
    // document.getElementById("boton").value = "Mostrar";
}

// llama a dataTable y cambia lo que dice el data table
$(document).ready(function () {
    $('#userList').DataTable({
        "language": {
            "decimal": "",
            "emptyTable": "No hay datos disponibles en la tabla",
            "info": "Mostrando _START_ de _END_ de _TOTAL_ entradas",
            "infoEmpty": "No hay datos disponibles.",
            "infoFiltered": "(filtrado de _MAX_ entradas totales)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Mostrando _MENU_ entradas",
            "loadingRecords": "Buscando...",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "Registro no encontrado",
            "paginate": {
                "first": "Primero",
                "last": "Ultimmo",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
        }
    });
});