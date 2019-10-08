const express = require('express'),
  app = express(),
  bodyParser = require('body-parser');
  port = process.env.PORT || 2020;


app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
var routes = require('./app/routes/approutes'); 
routes(app); 

app.listen(port);
console.log('API server #2 is pembing at port :' + port);