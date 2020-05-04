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
            "emptyTable": "No hay datos disponibles",
            "info": "Mostrando _TOTAL_ registros",
            "infoEmpty": "No hay datos disponibles.",
            "infoFiltered": "(_MAX_ registros totales)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "_MENU_ registros",
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