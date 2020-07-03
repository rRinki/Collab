
angular
		.module('frontApp')
		.controller(
				'forumcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.forum = {
						forum_Title : ""  
					};
					mydata.createUser = createUser;
					getUsers();
					function createUser() {
						$http
								.post(
										'http://localhost:8080/CollaborationMiddleWare/forum/addforum',
										mydata.forum)
								.then(function(response) {
									alert("Forum Added Successful");
									$location.path("/forum");
								}, function(errresponse) {
									alert("Forum not added");
								});
					}
					
					function getUsers(){
						$http
						.get(
						'http://localhost:8080/CollaborationMiddleWare/forum/allforum')
						.then(function(response) {
							mydata.customers=null;
						}, function(errresponse) {
							mydata.customers=errresponse.data;
							console.log(mydata.customers);
						});
						
					}
})