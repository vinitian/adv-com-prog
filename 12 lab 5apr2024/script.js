async function generateChart() {
    const response = await fetch("https://restcountries.com/v3.1/all");
    const countries = await response.json();
    const n = document.getElementById("numberOfCountries").value;
    const countryList = countries.slice(0,n);
    const names = countryList.map(element => element.name.common);
    const population = countryList.map(element => element.population);
    const showElement = document.getElementById("barChart");

    new Chart(showElement, {
        type: "bar",
        data: {
          labels: names,
          datasets: [
            {
              label: "Total Population",
              data: population,
              backgroundColor: 'rgba(237, 219, 0, 0.3)',
              borderColor: 'rgb(237, 219, 0)',
              borderWidth: 1
            }
          ],
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });

};