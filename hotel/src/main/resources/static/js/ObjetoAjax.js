//Creamos un nuevo objeto javascript llamado ObjetoAjax
//función constructora.
function ObjetoAjax () {
    //recogemos el objeto XMLHttpRequest en una variable
    var nuevoajax=creaObjetoAjax();
    //devolvemos el XMLHttpRequest como una propiedad del objeto.
    this.objeto=nuevoajax;
    this.pedirTexto=pedirTextoAjax;
    }
//Función para crear el objeto XMLHpptRequest.
function creaObjetoAjax () { 
    var obj; //variable que recogerá el objeto
    if (window.XMLHttpRequest) { //código para mayoría de navegadores
       obj=new XMLHttpRequest();
       }
    else { //para IE 5 y IE 6
       obj=new ActiveXObject(Microsoft.XMLHTTP);
       }
       return obj; //devolvemos objeto
    }

//función para el método objeto.pedirTexto(url,id) 		
function pedirTextoAjax(url,id) {
    //Crear objeto XMLHttpRequest
    var nuevoajax=this.objeto;
    //Lugar de la página donde se inserta el objeto.
    var idajax=id;
    //preparar el envio: método open
    nuevoajax.open("GET",url,true);
    //Devolver el archivo cuando éste se haya cargado
    nuevoajax.onreadystatechange=function () {  
      if (nuevoajax.readyState==4 && nuevoajax.status==200) {
          var textoAjax=nuevoajax.responseText;
          document.getElementById(idajax).innerHTML=textoAjax;
          }
       }
    nuevoajax.send(); //enviar
    }