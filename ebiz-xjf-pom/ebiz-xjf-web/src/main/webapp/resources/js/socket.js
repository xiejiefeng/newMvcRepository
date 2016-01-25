var ws = null;

function connect(param) {
    //if (!url) {
    //    alert('Select whether to use W3C WebSocket or SockJS');
    //    return;
    //}

    //ws = (url.indexOf('sockjs') != -1) ?new SockJS(url, undefined, {protocols_whitelist: transports}) : new WebSocket(url);
    if ('WebSocket' in window) {
        ws= new WebSocket("ws://localhost:8080/websck");
    }else {
    	alert();
        ws = new SockJS("http://localhost:8080/sockjs/websck");
    }
    //websocket = new SockJS("http://localhost:8084/SpringWebSocketPush/sockjs/websck");
    ws.onopen = function () {
        //alert('open');
        //setConnected(true);
        //log('Info: connection opened.');
    };
    ws.onmessage = function (event) {
        //alert('Received:' + event.data);
    	//$("#loadImg").fadeOut();
        //log('Received: ' + event.data);
    	param.successfnc(event.data);
    };
    ws.onclose = function (event) {
        //setConnected(false);
        //log('Info: connection closed.');
        //log(event);
    };
}

function disconnect() {
    if (ws != null) {
        ws.close();
        ws = null;
    }
    //setConnected(false);
}

function echo(message) {
    if (ws != null) {
        //var message = document.getElementById('message').value;
        //log('Sent: ' + message);
        ws.send(message);
    } else {
        alert('connection not established, please connect.');
    }
}