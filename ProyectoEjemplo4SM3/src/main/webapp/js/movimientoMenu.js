//Ejecutar función en el evento click
document.getElementById("botonMenu").addEventListener("click", onOffMenu);

//Declaramos variables
var menuLateral = document.getElementById("menuLateral");
var botonMenu = document.getElementById("botonMenu");
var body = document.getElementById("body");

//Evento para mostrar y ocultar menú
    function onOffMenu(){
        body.classList.toggle("moverBody");
        menuLateral.classList.toggle("moverMenuLateral");
    }

// Si el ancho de la página es menor a 760px, ocultará el menú al recargar la página.
if (window.innerWidth < 760){
    body.classList.add("moverBody");
    menuLateral.classList.add("moverMenuLateral");
}

//Haciendo el menú responsive(adaptable)

window.addEventListener("resize", 
    function(){
        if (window.innerWidth > 760){
            body.classList.remove("moverBody");
            menuLateral.classList.remove("moverMenuLateral");
        }
        if (window.innerWidth < 760){
            body.classList.add("moverBody");
            menuLateral.classList.add("moverMenuLateral");
        }
    }
);