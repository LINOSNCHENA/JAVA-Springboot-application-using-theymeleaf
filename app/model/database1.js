'user strict';

// profile One for database connection
var mysql = require('mysql');
var connection = mysql.createConnection
({
    host     : 'localhost',
    user     : 'root',
    password : 'Monze2019@',
    database : 'presly'
});

module.exports = connection;


