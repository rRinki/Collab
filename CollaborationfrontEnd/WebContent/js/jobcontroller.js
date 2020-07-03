/**
 * 
 */
angular
		.module('frontApp')
		.controller(
				'jobcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.jobs = {

							"job_Titile":""  ,
							"job_Description":"",
							"skill_Set":"",
							"job_Salary":"",
							"no_vaccany":"" ,
							"last_Date":""
								};
					mydata.createUser = createUser;
					getUsers();
					function createUser() {
						$http
								.post(
										'http://localhost:8080/CollaborationMiddleWare/jobs/addjobs',
										mydata.jobs)
								.then(function(response) {
									alert("Jobs Added Successfully");
									$location.path("/jobs");
								}, function(errresponse) {
									alert("Jobs not added");
								});
					}
					
					function getUsers(){
						$http
						.get(
						'http://localhost:8080/CollaborationMiddleWare/jobs/adminapproval')
						.then(function(response) {
							mydata.customers=null;
						}, function(errresponse) {
							mydata.customers=errresponse.data;
							console.log(mydata.customers);
						});
						
					}
})