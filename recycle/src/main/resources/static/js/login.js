let goJoinPage = () => {
    location.href = "/pages/join.html";
}

let goLoginPage = () => {
    location.href = "/index.html";
}

async function join() {
    alert("join 시작");
    const member = {
        id: document.querySelector("#id").value,
        password: document.querySelector("#password").value,
        name: document.querySelector("#name").value
    };

    const response = await fetch("/join", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(member)
    });

    if (response.ok) {
        alert("회원가입 완료");
        location.href = "/login";
    } else {
        alert("회원가입 실패");
    }
}
