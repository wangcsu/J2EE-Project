
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>ExciteWorld</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="include/header.jsp"></jsp:include>
        <div id="slidenav">
            <div class="carousel slide" id="myCarousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li calss="active" data-slide-to="0" data-target="#myCarousel"></li>
                    <li data-slide-to="1" data-target="#myCarousel"></li>
                    <li data-slide-to="2" data-target="#myCarousel"></li>
                    <li data-slide-to="3" data-target="#myCarousel"></li>
                    <li data-slide-to="4" data-target="#myCarousel"></li>
                </ol><!-- end of indicators -->
                <div class="carousel-inner">
                    <div class="item active" id="slide1">
                        <div class="carousel-caption">
                            <h4>Hawaii</h4>
                        </div>
                    </div><!-- end of slide1 -->
                    <div class="item" id="slide2">
                        <div class="carousel-caption">
                            <h4>Barcelona</h4>
                        </div>
                    </div><!-- end of slide2 -->
                    <div class="item" id="slide3">
                        <div class="carousel-caption">
                            <h4>Melbourne</h4>
                        </div>
                    </div><!-- end of slide3 -->
                    <div class="item" id="slide4">
                        <div class="carousel-caption">
                            <h4>Seoul</h4>
                        </div>
                    </div><!-- end of slide4 -->
                    <div class="item" id="slide5">
                        <div class="carousel-caption">
                            <h4>Rio de Janeiro</h4>
                        </div>
                    </div><!-- end of slide5 -->
                </div><!-- end of carousel-inner -->
                <!-- Controls -->
                <a class="left carousel-control" data-slide="prev" href="#myCarousel"><span class="icon-prev"></span></a>
                <a class="right carousel-control" data-slide="next" href="#myCarousel"><span class="icon-next"></span></a>
            </div><!-- end of myCarousel -->
            <div class="list-group">
                <a href="#" class="list-group-item active">Destination</a>
                <a href="#" class="list-group-item">Forum</a>
                <a href="#" class="list-group-item">Deals</a>
                <a href="#" class="list-group-item">Trip Planner</a>
                <a href="#" class="list-group-item">Blogs</a>
                <div class="app">
                    <h4>Download our Apps</h4>
                    <div class="btn-group btn-group-lg">
                        <button type="button" class="btn btn-default">iPhone</button>
                        <button type="button" class="btn btn-default">Android</button>
                        <button type="button" class="btn btn-default">iPad</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="">
            
        </div>
    </body>
</html>
