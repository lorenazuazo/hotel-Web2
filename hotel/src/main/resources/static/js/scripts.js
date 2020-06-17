//para ocultar los formularios
function Ocultar(id){
    document.getElementById(id).style.display = "none";
}
//para delete
function confirmDelete(id){
	$('#deleteModal').modal('show');
	$("#Input").val(id);
}

function deleteUser(){
	var id = $("#Input").val();
    window.location = "/modificaciones/deleteUser/"+id;
}

function deleteHabitacion(){
	var id = $("#Input").val();
    window.location = "/modificaciones/deleteHabitacion/"+id;
}

function deleteReserva(){
	var id = $("#Input").val();
    window.location = "/modificaciones/deleteReserva/"+id;
}

function deleteServicio(){
	var id = $("#Input").val();
    window.location = "/modificaciones/eliminar-servicio/"+id;
}

function deleteCaracteristica(){
	var id = $("#Input").val();
    window.location = "/modificaciones/eliminar-caracteristica/"+id;
}

function deleteTipohabitacion(){
	var id = $("#Input").val();
    window.location = "/modificaciones/eliminar-tipoHabitacion/"+id;
}

function deleteRoles(){
	var id = $("#Input").val();
    window.location = "/modificaciones/eliminar-Rol/"+id;
}

function deleteHuesped(){
	var id = $("#Input").val();
    window.location = "/modificaciones/eliminar-Huesped/"+id;
}


//configuraciones de dataTable
$(document).ready(function () {
    $('#ListDataTable').DataTable({
        "language": {
            "decimal": "",
            "emptyTable": "No hay datos disponibles",
            "info": "_TOTAL_ registros encontrados",
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