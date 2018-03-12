

<div class="container">
    <!-- Indicators -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img style="height: 250px; width: 100%" src="${pageContext.request.contextPath}/Resources/images/footwear1.jpg" alt="Chania">
                <div class="carousel-caption">
                    <h3 align="left">A journey of a thousand miles begins with a fabulous pair of shoes</h3>
                </div>
            </div>
            <div class="item">
                <img style="height: 250px; width: 100%" src="${pageContext.request.contextPath}/Resources/images/footwear2.jpg" alt="Chania">
                <div class="carousel-caption">
                    <h3 align="right">Good shoes take you good places</h3>
                </div>
            </div>
            <div class="item">
                <img style="height: 250px; width: 100%" src="${pageContext.request.contextPath}/Resources/images/footwear3.jpg" alt="Flower">
                <div class="carousel-caption">
                    <h3 align="left">Keep your head, heels and standard high</h3>
                </div>
            </div>
        </div>
        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="fa fa-angle-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="fa fa-angle-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
    </div>
</div>