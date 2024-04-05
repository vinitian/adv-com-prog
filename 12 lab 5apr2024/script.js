async function generateChart() {
  const response = await fetch("https://restcountries.com/v3.1/all");
  const countries = await response.json();
  let n = document.getElementById("numberOfCountries").value;
  let countryList = countries.slice(0,n);
  let names = countryList.map(element => element.name.common);
  let population = countryList.map(element => element.population);
  const showElement = document.getElementById("barChart");

  if (typeof CountryBarChart != "undefined") {
    CountryBarChart.destroy();
  }
  CountryBarChart = new Chart(showElement, {
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