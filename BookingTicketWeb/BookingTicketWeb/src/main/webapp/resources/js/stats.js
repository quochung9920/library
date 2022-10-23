/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);
    return `rgb(${r},${g}, ${b})`;
}

function tripstatisticsChart(id, tripLabels = [], routeInfo = []) {
    let colors = [];
    for (let i = 0; i < routeInfo.length; i++)
        colors.push(generateColor());
    const data = {
        labels: tripLabels,
        datasets: [{
                label: 'Tổng số chuyến xe theo tuyến',
                data: routeInfo,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 2,
                tension: 0.1,
                hoverOffset: 15
            }]
    };
    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    };
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);


}

function turnovertatisticsbytripChart(id, tripturnoverLabels = [], tripturnoverInfo = []) {
    let colors = [];
    for (let i = 0; i < tripturnoverInfo.length; i++)
        colors.push(generateColor());
    const data = {
        labels: tripturnoverLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo chuyến',
                data: tripturnoverInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'doughnut',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function turnoverTatisticsByTripMonthChart(id, tripMonthTurnoverLabels = [], tripMonthTurnoverInfo = []) {
    let colors = [];
    for (let i = 0; i < tripMonthTurnoverInfo.length; i++)
        colors.push(generateColor());
    const data = {
        labels: tripMonthTurnoverLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo tháng',
                data: tripMonthTurnoverInfo,
                fill: false,
                borderColor: colors,
                borderWidth: 2,
                hoverOffset: 15,
                tension: 0.3
            }]
    };
    const config = {
        type: 'line',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function turnoverTatisticsByTripQuarterChart(id, tripQuarterTurnoverLabels = [], tripQuarterTurnoverInfo = []) {
    let colors = [];
    for (let i = 0; i < tripQuarterTurnoverInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: tripQuarterTurnoverLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo quý',
                data: tripQuarterTurnoverInfo,
                fill: false,
                borderColor: colors,
                borderWidth: 2,
                hoverOffset: 15,
                tension: 0.3
            }]
    };
    const config = {
        type: 'line',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

function turnoverTatisticsByTripYearChart(id, tripYearTurnoverLabels = [], tripYearTurnoverInfo = []) {
    let colors = [];
    for (let i = 0; i < tripYearTurnoverInfo.length; i++)
        colors.push(generateColor());
    const data = {
        labels: tripYearTurnoverLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo năm',
                data: tripYearTurnoverInfo,
                fill: false,
                borderColor: colors,
                borderWidth: 2,
                hoverOffset: 15,
                tension: 0.3
            }]
    };
    const config = {
        type: 'line',
        data: data
    };

    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}
