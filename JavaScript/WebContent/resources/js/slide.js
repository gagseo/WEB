(function () {
	var idx = 0;

	function slideSelector(idx) {
		var elList = document.querySelectorAll('.slideBox li');
		elList.forEach(function (v) {
			v.style.transform = 'translateX(' + (-idx * 100) + '%)';
			v.style.transitionDuration = '1s';

			document.querySelectorAll('.navButton').forEach(function (v) {
				v.style.backgroundColor = 'white';
			})
			document.querySelector('#nb-0' + idx).style.backgroundColor = 'black';
		})
	};

	document.querySelectorAll('.navButton').forEach(function (el) {
		el.addEventListener('click', function (e) {
			idx = e.target.id.substring(4);
			slideSelector(idx);
		})
	});


	document.querySelectorAll('i').forEach(function (el) {
		el.addEventListener('click', function () {
			if (el.className.endsWith('left')) {
				if (idx > 0) {
					idx--;
				} else {
					idx = 3;
				}
			} else {
				if (idx < 3) {
					idx++;
				} else {
					idx = 0;
				}
			}
			slideSelector(idx);
		})
	});
}());

// document.querySelector('.left').addEventListener('click', function () {
// 	if (idx == 0) {
// 		idx = 4;
// 	}
// 	slideSelector(--idx);
// });

// document.querySelector('.right').addEventListener('click', function () {
// 	if (idx == 3) {
// 		idx = -1;
// 	}
// 	slideSelector(++idx);
// });










