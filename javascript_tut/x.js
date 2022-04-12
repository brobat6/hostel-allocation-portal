var http = require('http');
// var dt = require('./custom_module')
var url = require('url');
var fs = require('fs');
// var mysql = require('mysql');

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.write("The date and time are currently: " + dt.myDateTime());
  res.end();
}).listen(8000);