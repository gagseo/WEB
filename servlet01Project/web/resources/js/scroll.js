/* onscroll */

(function () {
	var pageId = 1;
	var is_end = false;
	var xhr = new XMLHttpRequest();

	//load : 통신이 성공적으로 완료가 되면 발생하는 이벤트
	xhr.addEventListener('load', ajaxTest);

	function $(selector) {
		return document.querySelector(selector);
	}

	function $All(selector) {
		return document.querySelectorAll(selector);
	}

	//이벤트걸어주기
	$('#bt').onclick = jsAjax;




	function jsAjax() {

		//사용자가 입력한 검색어
		var search = $('#search').value;

		var url = 'https://dapi.kakao.com/v3/search/book?query=' + search + '&page=' + pageId;

		//http메시지 시작줄, encodeURI처리
		xhr.open('GET', encodeURI(url));

		//헤더설정
		xhr.setRequestHeader('Authorization', 'KakaoAK b882c6b99f515162fe5325904859d724');

		//바디 설정
		xhr.send();
	}

	function ajaxTest() {

		//통신 성공 후 데이터를 res에 담음
		var res = xhr.response;

		//json문자열 -> Object : JSON.parse
		//Object -> json문자열 : JSON.stringify

		var dataObj = JSON.parse(res);
		console.dir(dataObj);

		var copy = $('.bookData').outerHTML;

		is_end = dataObj.meta.is_end;

		dataObj.documents.forEach(function (v) {
			$('.wrapper').innerHTML += copy;
			var lh = $('.wrapper').lastChild;
			lh.children[0].textContent = v.title;
			lh.children[1].textContent = v.price;
			lh.children[2].textContent = v.publisher;
			lh.children[3].innerHTML = '<img src="' + v.thumbnail + '">';
		})

	}


	window.onscroll = function () {
		var bodyHeight = $('body').clientHeight;
		if (!is_end) {
			if ($('.wrapper').clientHeight <= bodyHeight) {
				jsAjax();
				pageId++;
			} else if (window.scrollY > $('.wrapper').clientHeight - bodyHeight) {
				jsAjax();
				pageId++;
			}
		} else {
			alert("더이상 검색할 데이터가 없습니다.");
		}
	}
}());
