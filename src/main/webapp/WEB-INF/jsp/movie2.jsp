<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<script src="resource/js/SeansController.js"></script>
		<title>Strona Filmu:</title>
	</head>
	<body>
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1>${movie.name}</h1>
					</div>
				</div>
			</section>
			
			<section class="container" ng-app="SeansApp">
			
				<div class="row" ng-controller="SeansCtrl">
					
						<div class="col-md-3" style="padding-bottom: 15px">
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/${movie.name}.jpg"></c:url>" alt="image" style= "width:100%" />	
								
								<div class="caption" style="text-align:center">
									<p><spring:message code="stronaFilmu.rezyser" />${movie.director}</p>
									<p><spring:message code="stronaFilmu.rokProdukcji" />${movie.yearOfProduction}</p>
									<p><spring:message code="stronaFilmu.obsada" />${movie.cast}</p>
								</div>
							
							</div>
						</div>
						<div class="col-md-1">
							
						</div>
							<div class="col-md-6" style="padding-bottom: 25px">
								<div class="caption" style="text-align:left">
									</br>
										
										<div class="btn-group">
										
											<h2><font face="Verdana"><spring:message code="stronaFilmu.WybierzDzien" /></font></h2>
											</br>			
											</br>
											</br>
											
											<a class="btn btn-info" ng-click="pokaz('${movie.name}', '${days[0]}')"><spring:message code="stronaFilmu.poniedzialek" /></a>
											
											<a class="btn btn-primary" ng-click="pokaz('${movie.name}','${days[1]}')"><spring:message code="stronaFilmu.wtorek" /></a>
										
										
											<a class="btn btn-info" ng-click="pokaz('${movie.name}','${days[2]}')"><spring:message code="stronaFilmu.sroda" /></a>
										
										
											<a class="btn btn-primary" ng-click="pokaz('${movie.name}','${days[3]}')"><spring:message code="stronaFilmu.czwartek" /></a>
										
										
											<a class="btn btn-info" ng-click="pokaz('${movie.name}','${days[4]}')"><spring:message code="stronaFilmu.piatek" /></a>
											
											<a class="btn btn-warning" ng-click="pokaz('${movie.name}','${days[5]}')"><spring:message code="stronaFilmu.sobota" /></a>
											
											<a class="btn btn-warning" ng-click="pokaz('${movie.name}','${days[6]}')"><spring:message code="stronaFilmu.niedziela" /></a>
										
										</div>
									</br>			
									</br>
									</br>										
									
						<div ng-show="pokazujaca">	
							<h2><font face="Verdana"><spring:message code="stronaFilmu.WybierzSeans" /></font></h2>		
							</br>
							</br>
							<div class="col-md-4  col-md-offset-1" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[0].hour}}"/>" class="btn btn-success btn-block">						
											
												{{seans[0].hour}}
												{{seans[0].type}}
												{{seans[0].subtitlesOrLector}} {{seans[0].language}}
											
									</a>
								
							</div>	
									
							<div class="col-md-4" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[1].hour}}"/>" class="btn btn-success btn-block">						
												{{seans[1].hour}}
												{{seans[1].type}}
												{{seans[1].subtitlesOrLector}} {{seans[1].language}}
									</a>
							
							</div>	
							</br>
							</br>
							
							<div class="col-md-4  col-md-offset-1" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[2].hour}}"/>" class="btn btn-success btn-block">						
												{{seans[2].hour}}
												{{seans[2].type}}
												{{seans[2].subtitlesOrLector}} {{seans[2].language}}
									</a>
							
							</div>	
							<div class="col-md-4" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[3].hour}}"/>" class="btn btn-success btn-block">						
												{{seans[3].hour}}
												{{seans[3].type}}
												{{seans[3].subtitlesOrLector}} {{seans[3].language}}
									</a>
							
							</div>	
						</div>
						</br>
						</br>
						</br>
						</br>
						
						<p><h3><blockquote>${movie.description}</blockquote></h3></p>
								</div>
							</div>
						</div>
			</section>
	</body>
</html>