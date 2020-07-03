var myApp = angular.module("frontApp", [ "ngRoute" ]);
myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "home.html"
	}).when("/aboutus", {
		templateUrl : "aboutus.html"
	}).when("/login", {
		templateUrl : "login.html"
	}).when("/register", {
		templateUrl : "register.html"
	}).when("/contactus", {
		templateUrl : "contactus.html"

	}).when("/addjob", {
		templateUrl : "job.html"
	}).when("/addforum", {
		templateUrl : "forum.html"
	}).when("/login", {
		templateUrl : "login.html"
	}).when("/addblog", {
		templateUrl : "blogs.html"
	}).when("/viewallblogs", {
		templateUrl : "viewallblogs.html"
	}).when("/myblog", {
		templateUrl : "myblog.html"
	}).when("/blogapproval", {
		templateUrl : "approveblog.html"
	}).when("/alljobs", {
		templateUrl : "viewalljobs.html"
	}).when("/allforum", {
		templateUrl : "viewallforum.html"
	});

});

myApp.run(function($rootScope, $location, $http, $route) {
	$rootScope.$on('$locationChangeStart', function(event, next) {
		var status = $rootScope.loginstatus;
		var role = $rootScope.loggeduser;
		var emp_page = [];
		var employer_page = ['/addblog', '/addforum', '/addjob', '/alljobs','/allforum'];
		var admin_page = ['/blogapproval'];
		var currenturl = $location.path();
		var isemppage = $.inArray(currenturl, emp_page) >= 0;
		var isemployerpage = $.inArray(currenturl, employer_page) >= 0;
		var isadminpage = $.inArray(currenturl, admin_page) >= 0;
		alert(role);
		alert(status);
		if (status) {
			if (role == 'Employee') {
				if (isemployerpage || isadminpage) {
					alert("Sorry you dont access" +role)
					$location.path("/")

				}
			}

			else if (role == 'Employer') {
				if (isemppage || isadminpage) {
					alert("Sorry you dont access" +role)
					$location.path("/")
				}
			} else {
				if (isemppage || isemployerpage) {
					alert("Sorry you dont access"+role)
					$location.path("/")
				}
			}
		} else {
			if (isemppage || isemployerpage || isadminpage) {
				alert("Please login to view the content")
				$location.path("/login")
			}
		}
	});

});