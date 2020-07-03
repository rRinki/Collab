/**
 * $scope-->defines the scope ofthis controller.it helps me in establish the
 * scope of this controller to a view page where it is called $location-->is
 * used to change the url in the browser $http is used to refer to a service
 * with which i would like to communicate. $http.get()---request header
 * $http.post(,)--request header,request body $http.put(,)
 * $http.delete(,)or$http.delete(); this refers to the current object
 */
angular
		.module('frontApp')
		.controller(
				'rcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.customer = {
						cus_Name : "",
						cus_Email : "",
						cust_Password : "",
						cus_Phone:"",
						cust_Role : ""  
					};
					mydata.createUser = createUser;
					function createUser() {
						$http
								.post(
										'http://localhost:8080/CollaborationMiddleWare/customer',
										mydata.customer)
								.then(function(response) {
									alert("Registration Successful");
									$location.path("/login");
								}, function(errresponse) {
									alert("Registration not Successful");
								});
					}
					
					function getUsers(){
						$http
						.get(
						'http://localhost:8080/CollaborationMiddleWare/customer')
						.then(function(response) {
							mydata.customers=null;
						}, function(errresponse) {
							mydata.customers=errresponse.data;
							console.log(mydata.customers);
						});
						
					}
})