(function() {
	var idx = 0;

	function slideSelector(elList, idx, that) {

		if (that.className.endsWith('navButton')) {

			/* while (true) {
				elList = document.querySelectorAll('.slideBox li');
				if (elList[1].id.substring(6) == that.id.substring(4)) {
					document.querySelector('.slideBox').appendChild(elList[0]);
					break;
				} else {
					document.querySelector('.slideBox').appendChild(elList[0]);
				}
			} */

			elList = document.querySelectorAll('.slideBox li');
			if (elList[0].id.substring(6) == idx) {
				elList[0].style.transitionDuration = '1s';
				document.querySelector('.slideBox').insertBefore(elList[3], elList[0]);

				elList.forEach(function (v) {

					v.style.transitionDuration = '1s';

					document.querySelectorAll('.navButton').forEach(function (v) {
						v.style.backgroundColor = 'white';
					})
					document.querySelector('#nb-0' + idx).style.backgroundColor = 'black';
				})
				return;

			} else if (elList[1].id.substring(6) == idx) {
				return;
			}

			while (true) {
				elList = document.querySelectorAll('.slideBox li');
				if (elList[2].id.substring(6) == idx) {
					elList[1].style.transitionDuration = '1s';
					document.querySelector('.slideBox').append(elList[0]);
					break;
				} else {
					elList[0].style.transitionDuration = null;
					document.querySelector('.slideBox').append(elList[0]);
				}
			}
		}

		elList.forEach(function (v) {

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
			var elList = document.querySelectorAll('.slideBox li');
			slideSelector(elList, idx, this);
		})
	});

	document.querySelectorAll('i').forEach(function (el) {

		el.addEventListener('click', function () {

			var elList = document.querySelectorAll('.slideBox li');

			if (el.className.endsWith('left')) {
				if (idx > 0) {
					idx--;
				} else {
					idx = 3;
				}
				document.querySelector('.slideBox').insertBefore(elList[3], elList[0]);
			} else {
				if (idx < 3) {
					idx++;
				} else {
					idx = 0;
				}
				document.querySelector('.slideBox').appendChild(elList[0]);
				slideSelector(elList, idx, this);
			}
		})
	});
}());