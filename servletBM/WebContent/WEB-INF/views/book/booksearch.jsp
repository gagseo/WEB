<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="/servletBM/resources/css/book.css" />
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="Menu">
		<div class="MenuBox"></div>
	</div>
	<br>
	<br>
	<h1 style="text-align: center;">도서검색결과</h1>
	<hr>
	<section class="recentBook">
		<div class="recentBookWrapper">
			<div class="recentBookBox">
				<div class="recentBookLine">
					<c:forEach items="${data.searchList }" var="list">
						<div class="productItem">
							<div>
								<img
									src="<%=request.getContextPath()%>/resources/image/book/${list.bIsbn}.jpg">
							</div>
							<div class="bookTitle">
								${list.bTitle }<br> ${list.bAuthor }
							</div>
							<div class="bookUse" id="bookUse">
								<div>
									<a href="/servletBM/book/rentbook.do">대출</a>
								</div>
								<div>
									<a href="/servletBM/book/detail.do?b_isbn=${list.bIsbn }">상세보기</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- <li>번호: , 순번: , 책 이름 : </li> -->


				<!-- 				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788932916194.jpg">
					</div>
					<div class="bookTitle">창문 넘어 도망친 100세 노인 :요나스 요나손 장편소설<br>작가:요나스 요나손 [지음]</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788932916194">상세보기</a></div>
					</div>
				</div>
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788972756194.jpg">
					</div>
					<div class="bookTitle">나미야 잡화점의 기적 :히가시노 게이고 장편소설<br>작가:히가시노 게이고 지음</div>
					<div class="bookUse" id="bookUse" style="display: none;">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788972756194">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791196797706.jpg">
					</div>
					<div class="bookTitle">지쳤거나 좋아하는 게 없거나<br>작가:글배우 지음</div>
					<div class="bookUse" id="bookUse" style="display: none;">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791196797706">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791187119845.jpg">
					</div>
					<div class="bookTitle">나는 나로 살기로 했다 :냉담한 현실에서 어른살이를 위한 to do list<br>작가:김수현 글·그림</div>
					<div class="bookUse" id="bookUse" style="display: none;">
						<div><a href="/servletBM/use/rentbook.do?b_bno=101039&amp;b_title=나는 나로 살기로 했다 :냉담한 현실에서 어른살이를 위한 to do list">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791187119845">상세보기</a></div>
					</div>
				</div>
				</div>
				<div class="recentBookLine">
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788998441074.jpg">
					</div>
					<div class="bookTitle">나는 소망한다 내게 금지된 것을 :양귀자 장편소설<br>작가:양귀자 [지음]</div>
					<div class="bookUse" id="bookUse" style="display: none;">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788998441074">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788952773487.jpg">
					</div>
					<div class="bookTitle">나는 부동산과 맞벌이한다 :배우자 대신 꼬박꼬박 월급을 가져오는 시스템 만들기<br>작가:너바나 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788952773487">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791189932084.jpg">
					</div>
					<div class="bookTitle">나는 내 파이를 구할 뿐 인류를 구하러 온 게 아니라고 :자기 몫을 되찾고 싶은 여성들을 위한 야망 에세이<br>작가:김진아 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791189932084">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788901230801.jpg">
					</div>
					<div class="bookTitle">나의 월급 독립 프로젝트 :3년 만에 30억 벌고 퇴사한 슈퍼개미의 실전 주식투자 생중계<br>작가:유목민 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/use/rentbook.do?b_bno=101015&amp;b_title=나의 월급 독립 프로젝트 :3년 만에 30억 벌고 퇴사한 슈퍼개미의 실전 주식투자 생중계">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788901230801">상세보기</a></div>
					</div>
				</div>
				</div>
				<div class="recentBookLine">
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788932919874.jpg">
					</div>
					<div class="bookTitle">핵을 들고 도망친101세 노인 :요나스 요나손 장편소설<br>작가:요나스 요나손 [지음]</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788932919874">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788974839840.jpg">
					</div>
					<div class="bookTitle">지도에서 사라진 나라들 :오늘의 세계를 만들고 소멸한 나라들의 역사<br>작가:도현신 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788974839840">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791195322183.jpg">
					</div>
					<div class="bookTitle">완벽하지 않은 것들에 대한 사랑 :온전한 나를 위한 혜민 스님의 따뜻한 응원<br>작가:혜민 지음</div>
					<div class="bookUse" id="bookUse" style="display: none;">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791195322183">상세보기</a></div>
					</div>
				</div>
				
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791188388905.jpg">
					</div>
					<div class="bookTitle">에이트 :인공지능에 대체되지 않는 나를 만드는 법 =eight<br>작가:이지성 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/use/rentbook.do?b_bno=101079&amp;b_title=에이트 :인공지능에 대체되지 않는 나를 만드는 법 =eight">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791188388905">상세보기</a></div>
					</div>
				</div>
				</div>
				<div class="recentBookLine">
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9791196722005.jpg">
					</div>
					<div class="bookTitle">시절일기 :우리가 함께 지나온 밤<br>작가:김연수 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9791196722005">상세보기</a></div>
					</div>
				</div>
				
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788934999348.jpg">
					</div>
					<div class="bookTitle">나를 돌보지 않는 나에게 :정여울의 심리테라피<br>작가:정여울 지음</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788934999348">상세보기</a></div>
					</div>
				</div>
				
				
			
				
				<div class="productItem">
					<div>
						<img src="/servletBM/resources/image/book/9788933870839.jpg">
					</div>
					<div class="bookTitle">(설민석의) 삼국지 :누구나 쉽게 시작하고 모두가 빠져드는 이야기 .2<br>작가:설민석 [지음]</div>
					<div class="bookUse" id="bookUse">
						<div><a href="/servletBM/book/rentbook.do">대출</a></div>
						<div><a href="/servletBM/book/detail.do?b_isbn=9788933870839">상세보기</a></div>
					</div>
				</div>-->




			</div>
		</div>
	</section>

	<footer class="bottom"> bottom </footer>
	<script>
		document.querySelectorAll('.productItem').forEach(function(v) {
			v.addEventListener('mouseover', function() {
				v.lastElementChild.style.display = 'block';
			})

			v.addEventListener('mouseout', function() {
				v.lastElementChild.style.display = 'none';
			})
		})
	</script>
</body>
</html>