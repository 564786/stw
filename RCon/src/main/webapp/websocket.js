/**
 * @author Alvaro Fraidias NIP 780336
 * @author Rafael Rodriguez NIP 564786
 * 
 * Referencias utilizadas:
 * apuntes de @fserna
 * 
 */

var wsUri = "ws://" + document.location.host + "/RCon/termometro";
var webSocket;

// elementos IU - div
var tempTermometro = document.getElementById("tempTermometro");
var lectura = document.getElementById("lectura");
 
var gd = document.getElementById("graficoTermometro");
var graficoTermometro = gd.getContext("2d");

//botones
var botonIniciarLectura = document.getElementById("botonIniciarLectura");
var botonPararLectura = document.getElementById("botonPararLectura");
var botonIniciarRefrigeracion = document.getElementById("botonIniciarRefrigeracion");
var botonParararRefrigeracion = document.getElementById("botonParararRefrigeracion");

botonIniciarLectura.disabled = false;
botonPararLectura.disabled = true;

var estadoLectura = false;

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

        if(msg==="lecturaIniciada"){
            estadoLectura = true;
            botonIniciarLectura.disabled = true;
            botonPararLectura.disabled = false;
        }else if(msg==="lecturaParada"){
            estadoLectura = false;
            botonIniciarLectura.disabled = false;
            botonPararLectura.disabled = true;
        }
        else{
            
            updateTermometro(msg);      
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
 * Accion botones
 * 
 * @returns {undefined}
 */
function iniciarLectura(){
    webSocket.send("iniciarLectura");
}

function pararLectura(){
    webSocket.send("pararLectura");
}

function iniciarRefrigeracion(){
    webSocket.send("iniciarRefrigeracion");
}

function pararRefrigeracion(){
    webSocket.send("pararRefrigeracion");
}


/**
 * ==================== closeSocket =========================================
 * @returns {undefined}
 */
function closeSocket(){
    webSocket.close();
}

/**
 * ==================== updateDeposito =========================================
 * @param {type} _temperatura
 * @returns {undefined}
 */

function updateTermometro(_temperatura){
    //var temperatura = _temperatura;
    var temperatura = (_temperatura*1.0).toFixed(2);
    tempTermometro.innerHTML = temperatura;
    
//==== termometro ============================
        
    graficoTermometro.fillStyle = "#FFFFFF"; //blanco #FFFFFF
    graficoTermometro.fillRect(5,0,40,126);
    if(temperatura<=45.5){
            graficoTermometro.fillStyle = "green";
    }else if((temperatura>45.5)&&(temperatura<=47.5)){
            graficoTermometro.fillStyle = "orange";
    }else{
            graficoTermometro.fillStyle = "red"; 
    }
    graficoTermometro.fillRect(5, (120-temperatura), 40, temperatura);    
    
//==== lectura temperatura ============================
    if(estadoLectura === true){
            lectura.innerHTML="Recibiendo lecturas";
    }else{
            lectura.innerHTML="Sin lecturas";
        }
}