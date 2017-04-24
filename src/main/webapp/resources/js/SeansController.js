var app = angular.module('SeansApp', []);
app.controller('SeansCtrl', function ($scope, $http){
	
	$scope.pokaz = function(film, dz){
		
		var data = {
			        nazwa: film,
			        dzien: dz
			    };
		
		var successCallBack = function(response){
				 $scope.seans = response.data;
				 $scope.pokazujaca = true; 
			    };
	
	    var errorCallBack = function(response){
	    		$scope.seans = response.status;
			    };
			      
			  $http.post('http://localhost:8080/kino/seans/rest',JSON.stringify(data)).then(successCallBack, errorCallBack);
			    
			  /* $http({
	                method : "GET",
	                url : "/seans/abc/abc",
	                contentType: 'application/json',
	                mimeType: 'application/json',
	                data: JSON.stringify(data)
	                }).then(successCallBack, errorCallBack);*/
	}
});

 














