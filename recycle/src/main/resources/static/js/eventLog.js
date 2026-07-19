const modal = document.getElementById("noteModal");
const noteText = document.getElementById("noteText");

document.querySelectorAll(".note-btn").forEach(btn => {
    btn.addEventListener("click", () => {
        noteText.textContent = btn.dataset.note;
        modal.style.display = "flex";
    });
});

document.querySelector(".close-btn").onclick = () => {
    modal.style.display = "none";
};

modal.onclick = e => {
    if(e.target === modal){
        modal.style.display = "none";
    }
};

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