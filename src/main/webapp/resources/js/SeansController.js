var app = angular.module('SeansApp', []);
app.controller('SeansCtrl', function ($scope, $http){
	
	$scope.pokaz = function(film, dz){
		
		var data = {
			        name: film,
			        day: dz
			    };
		
		var successCallBack = function(response){
				 $scope.seans = response.data;
				 $scope.pokazujaca = true; 
			    };
	
	    var errorCallBack = function(response){
	    		$scope.seans = response.status;
			    };
			      
			  $http.post('http://localhost:8080/kino/seans/rest',JSON.stringify(data)).then(successCallBack, errorCallBack);
			  
	}
});

 














