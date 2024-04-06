- see these files in order:
1. fetch.html
2. chartjs.html
3. show-weather-chart.js
4. fetch-and-chart.html

# Using the Fetch API

- `fetch()`
- [How to: Fetch API (Mozilla Firefox)](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
- [weather data: 7timer.info](https://7timer.info/)
    - go to Wiki > copy the code at Machine-readable API and change `product=civil` and `output=json`
    - [json](http://www.7timer.info/bin/api.pl?lon=113.17&lat=23.09&product=civil&output=json)
    - [json for @ ISE building 2 (see the latitude and longtitude)](http://www.7timer.info/bin/api.pl?lon=100.53&lat=13.736&product=civil&output=json)


- `<pre></pre>` is preformatted text
    - [pre tag(W3Schools)](https://www.w3schools.com/tags/tag_pre.asp)
    - >>> Text in a `<pre>` element is displayed in a fixed-width font, and the text preserves both spaces and line breaks. The text will be **displayed exactly as written in the HTML source code**.

- javascript is "semicolon optional"

# Chart.js
- [chartjs.org](https://www.chartjs.org/)
    - [creating a chart](https://www.chartjs.org/docs/latest/getting-started/)


questions
- in javascript, it's parseInt() not Int.parseInt()
    - yes. it's better than the fucking java
- what is toDateString()?
    - toDateString() and toTimeString()
- differences between forEach and map?
    - forEach doesn't create a new list, while map() does