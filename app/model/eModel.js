'user strict';
var sql = require('./database1.js');
//Obeject constructor
var Employee = function(employee){
    this.names = employee.names;
    this.dept = employee.dept;
    this.post = employee.post;
    this.salary = employee.salary;
    this.status = employee.status;
    this.created_at = new Date();
};

// http://localhost:2020/business                           // GET ALL      #1
Employee.getRxAll = function (result) {                                   
  sql.query("Select * from bank2", function (err, res) {
        if(err) { console.log("error: ", err);  result(null, err); }
         else   { console.log('Rusangu staff #1 : ', res);  result(null, res);   }
    });   
};

// http://localhost:2020/business/:id                        // GET ONE     #2
Employee.getRxById = function (employeeX, result) {
sql.query("Select * from bank2 where id = ? ", employeeX, function (err, res) {          
                if(err) { console.log("error: ", err);    result(err, null);  }
                else { console.log('Rusangu chosen one: ',  res); result(null, res); }
            });   
};

// http://localhost:2020/business/:id                        // DELETE ONE  #3
Employee.removeRx = function(id, result){
    sql.query("DELETE FROM bank2 WHERE id = ?", [id], function (err, res) {
           if(err) { console.log("error: ", err);   result(null, err);  }
            else{ console.log(res,'Employeed ID #',id,' has been deleted: '); 
            result(null, res);       }
           }); 
};

// http://localhost:2020/business/:id                       // UPDATE ONE   #4
Employee.updateRxById = function(id, employee, result) {
    sql.query("UPDATE bank2 SET post=?,names=?,dept=?,salary=? WHERE id = ?",
     [employee.post,employee.names,employee.dept, employee.salary,id], function (err, res) {
     if(err) {  console.log("error: ", err);     result(null, err);   }
      else   { console.log('Employee ID # ',id,'has been updated: res ',id);  
      result(null, res);     }   
    }); 
  };

  // http://localhost:2020/business/:id                   // POST EMPLOYEE     #5
Employee.createRxOne = function (newEmployee, result) {    
    sql.query("INSERT INTO bank2 set ?", newEmployee, function (err, res) {
            if(err) {console.log("error: ", err);   result(err, null);  }
            else{ console.log('Employee ID #',res.insertId,' Has been created',res); 
            result(null, res.insertId); }
        });           
};

module.exports= Employee;