const socket = new SockJS("/ws");

const stomp = Stomp.over(socket);


stomp.connect({}, function(){

    console.log("WebSocket connected");


    stomp.subscribe(
        "/topic/status",
        function(message){

            console.log(message.body);

        }
    );

});