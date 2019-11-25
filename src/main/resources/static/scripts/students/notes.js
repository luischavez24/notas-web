let notesModule = (function ($, { periods }) {
  function main() {
    var ctx = document.getElementById("notesChart").getContext('2d');
    var myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: periods.map(p => p.academicPeriod).map(({ academicPeriod, academicYear }) => `${academicYear}-${academicPeriod}`),
        datasets: [
          {
            data: periods.map(p => p.avgNote),
            borderColor: 'rgba(78, 115, 223, 1)',
            backgroundColor: 'rgba(78, 115, 223, 0.2)',
          },
        ]
      },
      options: {
        legend: {
          display: false,
        }
      }
    });
  }

  return { main }
})