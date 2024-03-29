# JavaScript

- unordered list
```html
<ul>
    <li>sakurai haruka</li>
    <li>kashiki yuno</li>
    <li>kajiyama fuuta</li>
    <li>kusunoki muu</li>    
</ul>
```
- ordered list
```html
<ol>
    <li>sakurai haruka</li>
    <li>kashiki yuno</li>
    <li>kajiyama fuuta</li>
    <li>kusunoki muu</li>    
</ol>
```
- `alert("Hello World")`
- `.textContent`
- `.trim()` = `strip()` in python
- `document.createElement('li')` means create `<li></li>`
- `.appendChild()`
- in second.html: `btn.addEventListener('click', () => li.remove());`
- in second.html: 
```javascript
setTimeout(function() {
    paragraph.textContent = 'This is a text';
}, 3000);
```
- means wait for 3000 ms then do the function

## Arrow function
!(https://www.w3schools.com/js/js_arrow_function.asp)[W3Schools: Arrow function]

- compare these two:
```javascript
function doubleIt(x) {
                return 2*x;
            }
```
and
```javascript
const myfunc = (x) => 2*x;
```
^ this is called an **Arrow Function**.

### more examples of Arrow Function
```javascript
hello = () => {
  return "Hello World!";
} 
```
```javascript
hello = () => "Hello World!"; 
```
```javascript
hello = (val) => "Hello " + val; 
```

In fact, if you have only one parameter, you can skip the parentheses as well:
```javascript
hello = val => "Hello " + val; 
```

in third.html:
```javascript
addnameButton.addEventListener("click", ()=>addName(document.getElementById('nameInput').value));
```
