
document.addEventListener('DOMContentLoaded', function () {
    // Retrieve data from Thymeleaf model
    var totalPrograms = /*[(${totalprogramMajor})]*/ [];

    // Separate program labels and counts
    var programLabels = totalPrograms.map(function (item) {
        return item[0];
    });

    var programCounts = totalPrograms.map(function (item) {
        return item[1];
    });

    // Create and render the chart
    var programChart = new Chart(document.getElementById('programChart').getContext('2d'), {
        type: 'bar',
        data: {
            labels: programLabels,
            datasets: [{
                data: programCounts,
                backgroundColor: ['#3490dc', '#38a169', '#f6e05e'],
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
        }
    });
});