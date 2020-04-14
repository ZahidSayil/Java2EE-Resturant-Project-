
var socket = new WebSocket("ws://localhost:8080/kitchenManagement");
socket.onmessage = onMessage;

function onMessage(event) {

    var order = JSON.parse(event.data);  
    if (order.action == "add") {
        displayOrder(order);
    }
    if (order.action == "remove") {
        removeOrder(order);
    }
}

function displayOrder(order) {
    var content = document.getElementById("content");
    var div = document.createElement("div");
    div.setAttribute("id", order.id);
    
    var html = "<h3>Order " + order.id + "</h3>";
    html += "<p>Last update :" + order.update + "</p>";
    html += "<p>Current status : " + order.status + "</p>";
    html += "<p>Contents : " + order.content + "</p>";
    div.innerHTML= html;
    
    content.appendChild(div);
}

function removeOrder(order) {
 
    var div = document.getElementById(order.id);
    div.remove();
}