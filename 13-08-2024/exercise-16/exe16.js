var images = [
  "https://www.bing.com/th/id/OIP.UP_pojE1G38JYZF9yNaZqgHaFj?w=236&h=211&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2",
  "https://th.bing.com/th/id/OIP.TdzZgEMPXDsvdzFU5-ZOrwHaEK?w=312&h=180&c=7&r=0&o=7&pid=1.7&rm=3",
  "https://th.bing.com/th/id/OIP.Bu9ZW8_nR1sThBF9E3u2JQHaEK?w=326&h=183&c=7&r=0&o=7&pid=1.7&rm=3",
  "https://th.bing.com/th/id/OIP.tcmcKAMnz80blqPjV7WH1gHaEI?w=299&h=180&c=7&r=0&o=5&pid=1.7",
  "https://th.bing.com/th/id/OIP.x_bmWJjtcml6vd4Pm9jEowHaE7?w=219&h=180&c=7&r=0&o=5&pid=1.7",
  "https://th.bing.com/th/id/OIP.1-xLLYa9Lpn8D0h5J33t4AHaEo?w=252&h=180&c=7&r=0&o=5&pid=1.7",
  "https://th.bing.com/th/id/OIP.qXSF1CAWxwehV9rLuXgmJwHaFA?w=264&h=180&c=7&r=0&o=5&pid=1.7",
];

var currentImage = 0;
var image = document.getElementById("image");

image.src = images[currentImage];

function next() {
  currentImage++;
  if (currentImage >= images.length) {
    currentImage = 0;
  }
  image.src = images[currentImage];
}

function previous() {
  currentImage--;
  if (currentImage < 0) {
    currentImage = images.length - 1;
  }
  image.src = images[currentImage];
}
