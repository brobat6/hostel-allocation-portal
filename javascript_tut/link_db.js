var mysql = require('mysql2');

var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "barbara",
    port: 3007,
    database: "node_db"
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    // var sql = "DESCRIBE customers";
    var sql = "SELECT * FROM customers";
    con.query(sql, function (err, result) {
        if (err) throw err;
        console.log(result);
        // console.log(fields[2].name);
    });
});