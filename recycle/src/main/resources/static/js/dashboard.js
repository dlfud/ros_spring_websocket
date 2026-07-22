let todayCountList

document.addEventListener("DOMContentLoaded", () => {
    getTodayCollectionCount()
});

let getTodayCollectionCount = async () => {
    let data = {
        searchDto: {
            startDate: formatDate(new Date()),
            endDate: formatDate(new Date()) + ' 23:59:59'
        }
    }
    todayCountList = await apiFetch("/recycleHistory/getCollectionCount", "POST", data)

    document.querySelector("#todayCount").innerHTML = todayCountList.collectionCount
    document.querySelector("#todaySuccess").innerHTML = todayCountList.successCount
    document.querySelector("#todayFail").innerHTML = todayCountList.failCount
}

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

/*
{
    "topic": "battery",
    "timestamp": 1784200000,
    "data": {
    "percentage": 82,
        "voltage": 11.8
}
}*/
