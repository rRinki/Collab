/**
 * $scope-->defines the scope ofthis controller.it helps me in establish the
 * scope of this controller to a view page where it is called $location-->is
 * used to change the url in the browser $http is used to refer to a service
 * with which i would like to communicate. $http.get()---request header
 * $http.post(,)--request header,request body $http.put(,)
 * $http.delete(,)or$http.delete(); this refers to the current object
 */
angular.module('frontApp').controller(
		'lcontroller',
		function($scope, $location, $http,$rootScope) {
			var mydata = this;
			mydata.customer = {
				cus_Email : "",
				cust_Password : ""
			};
			mydata.onlineuser = {
				cus_Name : "",
				cus_Email : "",
				cust_Password : "",
				cus_Phone:"",
				cust_Role : ""
			};
			mydata.loginUser = loginUser;

			function loginUser() {
				$http.post(
						'http://localhost:8080/CollaborationMiddleWare/login',
						mydata.customer).then(function(response) {
					alert("Login Successful");
					mydata.onlineuser=response.data;
					$rootScope.loggeduser=mydata.onlineuser.cust_Role;
					//$cookieStore.put('loggeduser',$rootScope.loggeduser);
					$rootScope.loginstatus=true;
					//$cookieStore.put('loggedin',$rootScope.loginstatus);
					if(mydata.onlineuser.cust_Role=='Employee'){
						//alert("Employee Login Successful");
						$location.path("/");
					}
					else if(mydata.onlineuser.cust_Role=='Employer'){
						//alert("Employer Login Successful");
						$location.path("/aboutus");
					}else{
						//alert("Admin Login Successful");
						$location.path("/contactus");
						}
				}, function(errresponse) {
					alert("Login not Successful");
				});
			}
		});