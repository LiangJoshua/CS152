var cluster = require('cluster');
var http = require('http');
var numCpus = require('os').cpus().length;
var eol = require('os').EOL;

if (cluster.isMaster) {
  //fork workers
  for (var i=0; i<numCpus; i++) {
    cluster.fork();
  }

  cluster.on('death', function(worker) {
    console.log('worker ' + worker.pid + ' died');
  });
} else {
  http.Server(function(req,res) {
    res.writeHead(200);
    res.end("hello world" + eol);
  }).listen(8000);
}

