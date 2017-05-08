<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Godziny</title>
		<style type="text/css">
						button.css3button {
					font-family: Arial, Helvetica, sans-serif;
					font-size: 14px;
					color: #000000;
					padding: 30px 27px;
					background: -moz-linear-gradient(
						top,
						#cf1fb5 0%,
						#ffffff 75%,
						#2c8ba1);
					background: -webkit-gradient(
						linear, left top, left bottom,
						from(#cf1fb5),
						color-stop(0.75, #ffffff),
						to(#2c8ba1));
					-moz-border-radius: 9px;
					-webkit-border-radius: 9px;
					border-radius: 9px;
					border: 0px solid #0b1926;
					-moz-box-shadow:
						0px 1px 3px rgba(14,0,143,1),
						inset 0px 0px 1px rgba(212,23,212,1);
					-webkit-box-shadow:
						0px 1px 3px rgba(14,0,143,1),
						inset 0px 0px 1px rgba(212,23,212,1);
					box-shadow:
						0px 1px 3px rgba(14,0,143,1),
						inset 0px 0px 1px rgba(212,23,212,1);
					text-shadow:
						0px -1px 0px rgba(54,2,54,0.7),
						0px 1px 0px rgba(255,255,255,0.3);
				}
		</style>
	</head>
	<body>
			
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1>${seans[0].film.nazwa}</h1>
					</div>
				</div>
			</section>
			
			<section class="container">
				
				<div class="row">
				
						<div class="col-md-6" style="padding-bottom: 15px">
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/${seans[0].film.nazwa}.jpg"></c:url>" alt="image" style= "width:100%" />
							</div>
						</div>
						
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						
						<div class="col-md-2  col-md-offset-1" style="padding-bottom: 15px">
								<a href="<spring:url value="/${seans[0].film.nazwa}/${seans[0].dzien}/${seans[0].godziny[0]}"/>" class="btn btn-warning btn-block">						
										
											${seans[0].godziny[0]}
											${seans[0].typ[0]}
											${seans[0].napisy[0]} ${seans[0].jezyk}
										
								</a>
							
						</div>	
								
						<div class="col-md-2" style="padding-bottom: 15px">
								<a href="<spring:url value="/${seans[0].film.nazwa}/${seans[0].dzien}/${seans[0].godziny[1]}"/>" class="btn btn-warning btn-block">						
									${seans[0].godziny[1]}
									${seans[0].typ[1]}
									${seans[0].napisy[1]} ${seans[0].jezyk}
								</a>
						
						</div>	
						</br>
						</br>
						
						<div class="col-md-2  col-md-offset-1" style="padding-bottom: 15px">
								<a href="<spring:url value="/${seans[0].film.nazwa}/${seans[0].dzien}/${seans[0].godziny[2]}"/>" class="btn btn-warning btn-block">						
									${seans[0].godziny[2]}
									${seans[0].typ[2]}
									${seans[0].napisy[2]} ${seans[0].jezyk}
								</a>
						
						</div>	
						<div class="col-md-2" style="padding-bottom: 15px">
								<a href="<spring:url value="/${seans[0].film.nazwa}/${seans[0].dzien}/${seans[0].godziny[3]}"/>" class="btn btn-warning btn-block">						
									${seans[0].godziny[3]}
									${seans[0].typ[3]}
									${seans[0].napisy[3]} ${seans[0].jezyk}
								</a>
						
						</div>	
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						</br>
						
						
						<div class="col-md-2  col-md-offset-4" style="padding-bottom: 15px">
							
										<FORM>
											<INPUT TYPE="BUTTON" VALUE="Powrót" ONCLICK="history.back(-1)" class="btn btn-default">
											<span class="glyphicon-hand-left glyphicon"></span>
										</FORM>			
								
						</div>			
				</div>
			</section>
</body>



