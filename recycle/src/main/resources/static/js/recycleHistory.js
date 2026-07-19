// recycleHistory.js

// 종류별 수거 현황 (Bar Chart)
collectionTypeLabel = ["Plastic", "Can", "Paper", "Glass"]
collectionTypeCount = [15, 20, 4, 3]

collectionDateLabel = ["07-13", "07-14", "07-15", "07-16", "07-17"]
collectionDateCount = [15, 18, 22, 17, 20]

const typeCtx = document.getElementById("typeChart").getContext("2d");

new Chart(typeCtx, {
    type: "bar",
    data: {
        labels: collectionTypeLabel,
        datasets: [{
            label: "Collection Count",
            data: collectionTypeCount,
            backgroundColor: [
                "#42a5f5",
                "#66bb6a",
                "#ffa726",
                "#ab47bc"
            ],
            borderRadius: 8,
            borderSkipped: false
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                display: false
            },
            title: {
                display: true,
                text: "Collection by Type"
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

// 날짜별 수거 현황 (Line Chart)
const dateCtx = document.getElementById("dateChart").getContext("2d");

new Chart(dateCtx, {
    type: "line",
    data: {
        labels: collectionDateLabel,
        datasets: [{
            label: "Daily Collection",
            data: collectionDateCount,
            borderColor: "#1976d2",
            tension: 0.3,
            pointRadius: 5,
            pointHoverRadius: 7
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            title: {
                display: true,
                text: "Collection by Date"
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});