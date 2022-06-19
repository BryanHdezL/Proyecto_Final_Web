function data() {
    console.log("entre");
    let usuario = document.getElementById('usuario').value;
    let pass = document.getElementById('password').value;  
    if(usuario === "ARMA" && pass === "ARMA22"){
        window.location.replace("html/graficas.html");
    }else if(usuario === "BRYAN" && pass === "BRYAN23"){
        window.location.replace("html/graficas.html");
    }else if(usuario === "CASSIE" && pass === "CASSIE20"){
        window.location.replace("html/graficas.html");
    }else if(usuario === "EMI" && pass === "EMI21"){
        window.location.replace("html/graficas.html");
    }else if(usuario === "LALO" && pass === "LALO24"){
        window.location.replace("html/graficas.html");
    }else{
        alert("Por favor ingrese un usuario y contraseña validos");
    }
}
function mostrar(){
    alert("Este es un usuario: CASSIE; password: CASSIE20. Los demas los puede consultar en el reporte");
}