
var select = document.getElementsByName("color");
var selectValue = null;

function selectImg() {

	for (var i = 0; i < select.length; i++) {
		if (select[i].checked) {
			selectValue = select[i].value;
		}
	}

	if (selectValue == "1") {
		document.querySelector('.color1').style.backgroundColor = 'red';
		document.querySelector('.color2').style.backgroundColor = 'yellow';
		document.querySelector('.color3').style.backgroundColor = 'blue';
		document.querySelector('.color4').style.backgroundColor = 'black';
	} else if (selectValue == "2") {
		document.querySelector('.color1').style.backgroundColor = 'red';
	} else if (selectValue == "3") {
		document.querySelector('.color2').style.backgroundColor = 'yellow';
	} else if (selectValue == "4") {
		document.querySelector('.color3').style.backgroundColor = 'blue';
	} else if (selectValue == "5") {
		document.querySelector('.color4').style.backgroundColor = 'black';
	}
}

function clearImg() {

	for (var i = 0; i < select.length; i++) {
		if (select[i].checked) {
			selectValue = select[i].value;
		}
	}

	if (selectValue == "1") {
		document.querySelector('.color1').style.backgroundColor = 'white';
		document.querySelector('.color2').style.backgroundColor = 'white';
		document.querySelector('.color3').style.backgroundColor = 'white';
		document.querySelector('.color4').style.backgroundColor = 'white';
	} else if (selectValue == "2") {
		document.querySelector('.color1').style.backgroundColor = 'white';
	} else if (selectValue == "3") {
		document.querySelector('.color2').style.backgroundColor = 'white';
	} else if (selectValue == "4") {
		document.querySelector('.color3').style.backgroundColor = 'white';
	} else if (selectValue == "5") {
		document.querySelector('.color4').style.backgroundColor = 'white';
	}

}