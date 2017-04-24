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
						<h1>${film.nazwa}</h1>
					</div>
				</div>
			</section>
			
			<section class="container" ng-app="SeansApp">
			
				<div class="row" ng-controller="SeansCtrl">
					
						<div class="col-md-3" style="padding-bottom: 15px">
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/${film.nazwa}.jpg"></c:url>" alt="image" style= "width:100%" />	
								
								<div class="caption" style="text-align:center">
									<p><spring:message code="stronaFilmu.rezyser" />${film.rezyser}</p>
									<p><spring:message code="stronaFilmu.rokProdukcji" />${film.rokProdukcji}</p>
									<p><spring:message code="stronaFilmu.obsada" />${film.obsada}</p>
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
											
											<a class="btn btn-info" ng-click="pokaz('${film.nazwa}', '${dniTygodnia[0]}')"><spring:message code="stronaFilmu.poniedzialek" /></a>
											
											<a class="btn btn-primary" ng-click="pokaz('${film.nazwa}','${dniTygodnia[1]}')"><spring:message code="stronaFilmu.wtorek" /></a>
										
										
											<a class="btn btn-info" ng-click="pokaz('${film.nazwa}','${dniTygodnia[2]}')"><spring:message code="stronaFilmu.sroda" /></a>
										
										
											<a class="btn btn-primary" ng-click="pokaz('${film.nazwa}','${dniTygodnia[3]}')"><spring:message code="stronaFilmu.czwartek" /></a>
										
										
											<a class="btn btn-info" ng-click="pokaz('${film.nazwa}','${dniTygodnia[4]}')"><spring:message code="stronaFilmu.piatek" /></a>
											
											<a class="btn btn-warning" ng-click="pokaz('${film.nazwa}','${dniTygodnia[5]}')"><spring:message code="stronaFilmu.sobota" /></a>
											
											<a class="btn btn-warning" ng-click="pokaz('${film.nazwa}','${dniTygodnia[6]}')"><spring:message code="stronaFilmu.niedziela" /></a>
										
										</div>
									</br>			
									</br>
									</br>										
									
						<div ng-show="pokazujaca">	
							<h2><font face="Verdana"><spring:message code="stronaFilmu.WybierzSeans" /></font></h2>		
							</br>
							</br>
							<div class="col-md-4  col-md-offset-1" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[0].godzina}}"/>" class="btn btn-success btn-block">						
											
												{{seans[0].godzina}}
												{{seans[0].typ}}
												{{seans[0].napisy}} {{seans[0].jezyk}}
											
									</a>
								
							</div>	
									
							<div class="col-md-4" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[1].godzina}}"/>" class="btn btn-success btn-block">						
												{{seans[1].godzina}}
												{{seans[1].typ}}
												{{seans[1].napisy}} {{seans[1].jezyk}}
									</a>
							
							</div>	
							</br>
							</br>
							
							<div class="col-md-4  col-md-offset-1" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[2].godzina}}"/>" class="btn btn-success btn-block">						
												{{seans[2].godzina}}
												{{seans[2].typ}}
												{{seans[2].napisy}} {{seans[2].jezyk}}
									</a>
							
							</div>	
							<div class="col-md-4" style="padding-bottom: 15px">
									<a href="<spring:url value="/seans/{{seans[3].godzina}}"/>" class="btn btn-success btn-block">						
												{{seans[3].godzina}}
												{{seans[3].typ}}
												{{seans[3].napisy}} {{seans[3].jezyk}}
									</a>
							
							</div>	
						</div>
						</br>
						</br>
						</br>
						</br>
						
						<p><h3><blockquote>${film.opis}</blockquote></h3></p>
								</div>
							</div>
						</div>
			</section>
	</body>
</html>