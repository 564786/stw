
var wsUri = "ws://" + document.location.host + "/depositoSim/deposito";
var webSocket;

// elementos IU 
//var lectura = document.getElementById(lecutura);
var nivelDeposito = document.getElementById("nivelDeposito");
var grifoIn = document.getElementById("grifoIn");
var grifoOut = document.getElementById("grifoOut");
var estadoLectura = document.getElementById("estadoLectura");
 
var gd = document.getElementById("graficoDeposito");
var graficaDeposito = gd.getContext("2d");
//var gIn = document.getElementById("ledGrifoIn");
//var ledGrifoIn = gIn.getContext("2d");
var gOut = document.getElementById("ledGrifoOut");
//var ledGrifoOut = gOut.getContext("2d");


//botones
var iniciarLectura = document.getElementById("iniciarLectura");
var pararLectura = document.getElementById("pararLectura");
var lecturaEnCurso = false;
//var pararLectura = document.getElementById("pararLectura");
/*
var abrirGrifoIn = document.getElementById("abrirGrifoIn");
var cerrarGrifoIn = document.getElementById("cerrarGrifoIn");
var abrirGrifoOut = document.getElementById("abrirGrifoOut");
var cerrarGrifoOut = document.getElementById("cerrarGrifoOut");
//abrirGrifoIn.disabled = true;
//cerrarGrifoIn.disabled = true;
//abrirGrifoOut.disabled = true;
//cerrarGrifoOut.disabled = true;

//iniciarLectura.disabled = false;
//pararLectura.disabled = true;

var estadoGrifoIn  = false;
var estadoGrifoOut = false;

*/
openSocket();



/**
 * ==================== openSocket =========================================
 * @returns {undefined}
 */
 function openSocket(){
     console.log("OPENING: "+wsUri);
    // Ensures only one connection is open at a time
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
       closeSocket();
    }
    
    webSocket = new WebSocket(wsUri);

        //abrirGrifoIn.disabled = false;
       // abrirGrifoOut.disabled = false;
    /**
     * Binds functions to the listeners for the websocket.
     */
    webSocket.onopen = function(event){
        if(event.data === undefined){
            return;
        }
        console.log(event.data);
    };

    webSocket.onmessage = function(event){
        var msg = event.data;
        console.log("==== "+msg);
        
        if(msg==="iniciarLectura"){
            lecturaEnCurso = true;
        }else if(msg==="pararLectura"){
            lecturaEnCurso = false;
        }else{        
            updateDeposito(msg);

        /*
        if (msg==="grifoInABIERTO"){
            //abrirGrifoIn.disabled = true;
            //cerrarGrifoIn.disabled = false;
            estadoGrifoIn = true;
        }else if (msg==="grifoInCERRADO"){
            //abrirGrifoIn.disabled = false;
            //cerrarGrifoIn.disabled = true;
            estadoGrifoIn = false;
        }else if (msg==="grifoOutABIERTO"){
            //abrirGrifoOut.disabled = true;
            //cerrarGrifoOut.disabled = false;
            estadoGrifoOut = true;
        }else if (msg==="grifoOutCERRADO"){
            //abrirGrifoOut.disabled = false;
            //cerrarGrifoOut.disabled = true;
            estadoGrifoOut = false;
        }else if(msg==="iniciarLectura"){
            
        }else if(msg==="pararLectura"){
        }else{        
            updateDeposito(msg);
        */
        }            
    };

    webSocket.onclose = function(event){
        console.log("Connection Closed");
    };

    webSocket.onerror = function (event){
        console.log("ERROR: "+event.toString());
    };
} //openSocket

/**
 * ==================== open/closeGrifo IN/OUT =========================================
 * @returns {undefined}
 */
function iniciarLectura(){
    webSocket.send("iniciarLectura");
}

function pararLectura(){
    webSocket.send("pararLectura");
}
/*
function openGrifoIn(){
    webSocket.send("openGrifoIn");
}
function closeGrifoIn(){
    webSocket.send("closeGrifoIn");
}
function openGrifoOut(){
    webSocket.send("openGrifoOut");
}
function closeGrifoOut(){
    webSocket.send("closeGrifoOut");

}*/



/**
 * ==================== closeSocket =========================================
 * @returns {undefined}
 */
function closeSocket(){
    webSocket.close();
}
/**
 * ==================== updateDeposito =========================================
 * @param {type} _nuevoNivel
 * @returns {undefined}
 */

function updateDeposito(_nuevoNivel){
    var temperatura = 30;
    
//==== depósito ============================
    graficaDeposito.fillStyle = "#FFFFFF"; //blanco
    graficaDeposito.fillRect(5,0,40,260);
    graficaDeposito.fillStyle = "#0000FF"; // rojo
    graficaDeposito.fillRect(5, (255-temperatura), 40, temperatura);
    
    temperatura = 40; //(_nuevoNivel*1.0).toFixed(2);
    nivelDeposito.innerHTML = temperatura;
    
//==== depósito ============================
    graficaDeposito.fillStyle = "#FFFFFF"; //blanco
    graficaDeposito.fillRect(5,0,40,260);
    graficaDeposito.fillStyle = "#0000FF"; // rojo
    graficaDeposito.fillRect(5, (255-), 40, );
    
//==== grifo IN ============================
    
    //CODIGO SUBIR Y BAJAR TEMPERATURA
    if (lecturaEnCurso === true){
        estadoLectura.innerHTML="Leyendo temperatura";
        //ledGrifoIn.fillStyle = "#00FF00"; //("green");
    }else{
        estadoLectura.innerHTML="Sin lecturas";
        //ledGrifoIn.fillStyle = "#FF0000"; //("red");
    }
//==== grifo IN ============================    
    //ledGrifoIn.beginPath();
   /* if (estadoGrifoIn === true){
        grifoIn.innerHTML="ABIERTO";
        //ledGrifoIn.fillStyle = "#00FF00"; //("green");
    }else{
        grifoIn.innerHTML="CERRADO";
        //ledGrifoIn.fillStyle = "#FF0000"; //("red");
    }*/
    //ledGrifoIn.arc(25,25, 20, 0, 2 * Math.PI);
    //ledGrifoIn.fill();
    
//==== grifo OUT ============================        
    //ledGrifoOut.beginPath();
    /*if (estadoGrifoOut === true){
        grifoOut.innerHTML="ABIERTO";
        //ledGrifoOut.fillStyle = "#00FF00"; //("green");
    }else{
        grifoOut.innerHTML="CERRADO";
        //ledGrifoOut.fillStyle = "#FF0000"; //("red");
    }*/
    //ledGrifoOut.arc(25,25, 20, 0, 2 * Math.PI);
    //ledGrifoOut.fill();
}