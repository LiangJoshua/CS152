var EE = require('events').EventEmitter;
var ee = new EE();

die = false;

ee.on('die', function() {
  console.log("I'm melting!!!  Oh, what a world... what a world...");
  die = true;
});


setTimeout(function() {
  ee.emit('die');
}, 100);

// Which message prints out first?

// while (!die) {} // If uncommented, the program will run forever

console.log('done');


