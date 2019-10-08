'use strict';
module.exports = function(app) {
  var rusangu = require('../controller/eController');

  // http://localhost/2020/business 5 CRUD METHODS

  app.route('/business')
    .get(rusangu.employeeAll)
    .post(rusangu.employeeMake);
   
  app.route('/business/:taskId')  // always small letters
    .get(rusangu.employeeOne)
    .put(rusangu.employeeUpdate)
    .delete(rusangu.employeeDelete);
    };