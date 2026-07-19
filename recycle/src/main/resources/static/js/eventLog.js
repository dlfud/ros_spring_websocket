const PAGE_SIZE = 10;
const BLOCK_SIZE = 10;
let eventLogCount
let eventLogList
let pageNumber = 1
document.addEventListener("DOMContentLoaded", () => {
    getEventLogList(1);
});

let getEventLogList = async (page) => {
    pageNumber = page
    let eventType = document.querySelector("#eventType").value
    let startDate = document.querySelector("#startDate").value
    let endDate = document.querySelector("#endDate").value
    let data = {
        eventType: eventType === "" ? null : eventType,
        searchDto: {
            page: page,
            pageSize: PAGE_SIZE,
            offset: (pageNumber - 1) * PAGE_SIZE,
            startDate: startDate === "" ? null : startDate,
            endDate: endDate === "" ? null : endDate
        }
    }
    eventLogCount = await apiFetch("/eventLog/listCount", "POST", data)
    eventLogList = await apiFetch("/eventLog/list", "post", data)

    let table = document.querySelector("#eventTbody")
    table.innerHTML = ``
    let tbody = ""
    eventLogList.forEach(log => {
        let status = "success"
        if(log.status == 'Detect'){
            status = 'detect'
        }else if(log.status == 'Warning'){
            status = 'warning'
        }else if(log.status == 'Error'){
            status = 'error'
        }

        let note = ""
        if(log.note){
            note = `
                <td>
                    <button class="note-btn" data-note="${log.note}">
                        ...
                    </button>
                </td>
            `
        }else{
            note = `
                <td>-</td>
            `
        }
        tbody += `
            <tr>
                <td><span class="dot ${status}"></span></td>
                <td>${log.createTime}</td>
                <td>${log.eventType}</td>
                <td>${log.message}</td>
                ${note}
            </tr>
        `
    })
    table.innerHTML = tbody

    document.querySelectorAll(".note-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            noteText.textContent = btn.dataset.note;
            modal.style.display = "flex";
        });
    });

    paging()
}

const modal = document.getElementById("noteModal");
const noteText = document.getElementById("noteText");

document.querySelector(".close-btn").onclick = () => {
    modal.style.display = "none";
};

modal.onclick = e => {
    if(e.target === modal){
        modal.style.display = "none";
    }
};

//socket
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

//paging
let paging = () => {
    let html = document.querySelector("#pageDiv")

    const totalPage = Math.ceil(eventLogCount / PAGE_SIZE);
    const currentBlock = Math.floor((pageNumber - 1) / BLOCK_SIZE);
    const startPage = currentBlock * BLOCK_SIZE + 1;
    const endPage = Math.min(startPage + BLOCK_SIZE - 1, totalPage);
    let content = "";

    if(startPage > 1){
        content += `
            <button onclick="movePage(${startPage - BLOCK_SIZE})">&lt;</button>
        `;
    }

    for(let i = startPage; i <= endPage; i++){
        content += `
            <button
                class="${pageNumber === i ? 'active' : ''}"
                onclick="movePage(${i})">
                ${i}
            </button>
        `;
    }

    if(endPage < totalPage){
        content += `
            <button onclick="movePage(${startPage + BLOCK_SIZE})">&gt;</button>
        `;
    }
    html.innerHTML = content;
}

let movePage = (page) => {
    getEventLogList(page);
    paging();
}