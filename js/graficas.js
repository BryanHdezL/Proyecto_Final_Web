/*Datos de Ejemplo */
const labelsYear = [
    'Product1',
    'Product2',
    'Product3',
    'Product4',
    'Product5',
    'Product6',
    'Product7',
    'Product8',
    'Product9',
    'Product10'
];
const labelsMonth = [
    'Enero',
    'Febrero',
    'Marzo',
    'Abril',
    'Mayo',
    'Junio',
    'Julio',
    'Agosto',
    'Septiembre',
    'Octubre',
    'Noviembre',
    'Dociembre'
];
const labelsCat = [
    'Product1',
    'Product2',
    'Product3',
    'Product4',
    'Product5'
];

const dataYear = {
    labels: labelsYear,
    datasets: [{
        label: 'Año 2022',
        backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(255, 206, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(153, 102, 255, 0.8)',
            'rgba(255, 159, 64, 0.8)'
        ],
        borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ],
        data: [10, 5, 2, 20, 30, 45, 35, 22, 15, 50]
    }]
};

const configYear = {
    type: 'bar',
    data: dataYear,
    options: {
        responsive: true
    }
};

const dataMonth = {
    labels: labelsMonth,
    datasets: [{
        label: 'Meses 2022',
        backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(255, 206, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(153, 102, 255, 0.8)',
            'rgba(255, 159, 64, 0.8)'
        ],
        borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ],
        data: [10, 5, 2, 20, 30, 45, 35, 22, 15, 50, 45, 50],
    }]
};

const configMonth = {
    type: 'bar',
    data: dataMonth,
    options: {
        responsive: true
    }
};

const dataCat = {
    labels: labelsCat,
    datasets: [{
        label: 'Datos por Categoria',
        backgroundColor: [
            'rgba(255, 99, 132, 0.8)',
            'rgba(54, 162, 235, 0.8)',
            'rgba(255, 206, 86, 0.8)',
            'rgba(75, 192, 192, 0.8)',
            'rgba(153, 102, 255, 0.8)',
            'rgba(255, 159, 64, 0.8)'
        ],
        borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ],
        data: [10, 5, 2, 20, 30],
    }]
};

const configCat = {
    type: 'bar',
    data: dataCat,
    options: {
        responsive: true
    }
};

/*Fin graficas ejemplo */





/*Constantes DOM */
const select = document.querySelector("#Selectector");
const secundaria = document.querySelector("#Second");
const label = document.querySelector("#label2");
let myChart = new Chart(document.getElementById('myChart'));

/*Duncion limpiar selectores */
const limpiar = () => {
    while (secundaria.firstChild) {
        secundaria.removeChild(secundaria.firstChild);
    }
};

/*Ejecutar seleccion */
const opcion = () => {
    
    const indice = select.selectedIndex;
    if (indice === -1) return; // Esto es cuando no hay elementos
    const opcionSeleccionada = select.options[indice];
    const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    const año = ["2021", "2022"];
    const categoria = ["Dulces", "Tecnologia", "Detergentes", "Sopas"];

    if(opcionSeleccionada.value === "Año"){
        limpiar();
        myChart.destroy();
        label.innerHTML='Selecciona Año';
        secundaria.style= "visibility:visible";
        label.style= "visibility:visible";
        for(let i=0; i<2; i++){
            const newOpcion =  document.createElement('option');
            newOpcion.value = año[i];
            newOpcion.text = año[i];
            secundaria.appendChild(newOpcion);
        }
        myChart = new Chart(document.getElementById('myChart'), configYear);
        
    }else if(opcionSeleccionada.value === "Mes"){
        limpiar();
        myChart.destroy();
        label.innerHTML = "Selecciona Mes";
        secundaria.style= "visibility:visible";
        label.style= "visibility:visible";
        for(let i=0; i<12; i++){
            const newOpcion =  document.createElement('option');
            newOpcion.value = meses[i];
            newOpcion.text = meses[i];
            secundaria.appendChild(newOpcion);
        }
        myChart = new Chart(document.getElementById('myChart'), configMonth);
        
    }else if(opcionSeleccionada.value === "Categoria"){
        limpiar();
        myChart.destroy();
        label.innerHTML = "Selecciona Categoria";
        secundaria.style= "visibility:visible";
        label.style= "visibility:visible";
        for(let i=0; i<4; i++){
            const newOpcion =  document.createElement('option');
            newOpcion.value = categoria[i];
            newOpcion.text = categoria[i];
            secundaria.appendChild(newOpcion);
        }
        myChart = new Chart(document.getElementById('myChart'), configCat);
    }else{
        limpiar();
        myChart.destroy();
        secundaria.style= "visibility: hidden";
        label.style= "visibility: hidden";
    } 
};

/*Ejecuta cambios en cada seleccion */
select.addEventListener("change", opcion);