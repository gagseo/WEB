<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

</head>
<body>
	<%@ include file="../include/top.jsp"%>
	<%@ include file="../include/floatDiv.jsp"%>
	<div class="content">
		<section class="middle">
			<div class="siteTitleWrapper">
				<div class="siteTitle">
					<div class="sitetitle">U CLASS 도서관</div>
					<div class="search">
						<form action="<%=request.getContextPath()%>/book/booksearch.do">
							<div class="searchButton">
								<p>검색</p>
							</div>

							<input Type="text" name="searchBook" placeholder="검색어를 입력하세요">
							<button value="" class="searchIcon">
								<i class="fas fa-search" style="color: black"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</section>

		<nav class="planShop">
			<div class="planShopMenu">
				<div class="ps-1">
					<i class="far fa-clipboard"></i> <a
						href="/servletBM/notice/notice.do">
						<p>공지사항</p>
					</a>
				</div>
				<div class="ps-2">
					<i class="fas fa-search-plus"></i>
					<p>도서검색</p>
				</div>
				<div class="ps-3">
					<i class="far fa-question-circle"></i>
					<p>QnA</p>
				</div>
				<div class="ps-4">
					<i class="fas fa-users"></i>
					<p>AboutUs</p>
				</div>
			</div>
		</nav>

		<section class="product">
			<div class="productWrapper">
				<div class="productBox">
					<div class="issueTitle">
						<span>인기 도서</span>
					</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>

						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>

					</div>
					<div class="issueTitle">스테디셀러</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
					<div class="issueTitle">최근 대출 도서</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
					<div class="issueTitle">최근 입고 도서</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<footer class="bottom"> bottom </footer>

	</div>
</body>
</html>
