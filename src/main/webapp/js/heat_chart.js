window.addEventListener('DOMContentLoaded', function() {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'filter', true);
  xhr.onload = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var weatherList = JSON.parse(xhr.responseText);

      var temperatures = [];
      var humidities = [];
      var times = [];

      for (var i = 0; i < weatherList.length; i++) {
        temperatures.push(weatherList[i].current.temp_c);
        humidities.push(weatherList[i].current.humidity);
        var datetime = weatherList[i].location.localtime;
        times.push(datetime.split(" ")[1]);
        
      }

      var ctx = document.getElementById('temperatureChart').getContext('2d');
      var chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: times,
          datasets: [{
            label: 'Temperature',
            data: temperatures,
            borderColor: 'red',
            fill: false,
            yAxisID: 'temperature-y-axis' // Đặt ID cho trục y của nhiệt độ
          },
          {
            label: 'Humidity',
            data: humidities,
            borderColor: 'blue',
            fill: false,
            yAxisID: 'humidity-y-axis' // Đặt ID cho trục y của độ ẩm
          }]
        },
        options: {
          responsive: true,
          scales: {
            x: {
              display: true,
              title: {
                display: true,
                text: 'Time'
              }
            },
            'temperature-y-axis': { // Trục y cho nhiệt độ
              position: 'right',
              display: true,
              title: {
                display: true,
                text: 'Temperature (C)'
              },
              beginAtZero: true
            },
            'humidity-y-axis': { // Trục y cho độ ẩm
              position: 'left',
              display: true,
              title: {
                display: true,
                text: 'Humidity (%)'
              },
              beginAtZero: true,
              suggestedMax: 100
            }
          }
        }
      });
    }
  };
  xhr.send();
});