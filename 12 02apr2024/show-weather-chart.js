function showWeatherChart(showElement,labels,inputTemp, inputHumidity){
    new Chart(showElement, {
        type:'line',
        data: {
          labels: labels,
          datasets: [{
            label: 'Temperature',
            data: inputTemp,
            borderWidth: 1
          }, {
            label: 'Relative Humidity',
            data: inputHumidity,
            borderWidth: 1
          }]
          //^ datasets is a list of dict!
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });
}