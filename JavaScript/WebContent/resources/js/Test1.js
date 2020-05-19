
var selectValue = null;
var select = document.getElementsByName("num");

function drawImg() {

	for (var i = 0; i < select.length; i++) {
		if (select[i].checked) {
			selectValue = select[i].value;
		}
	}

	if (selectValue == "1") {
		document.querySelector(".one").style.opacity = "1";
		document.querySelector(".two").style.opacity = "0";
		document.querySelector(".three").style.opacity = "0";
	} else if (selectValue == "2") {
		document.querySelector(".one").style.opacity = "0";
		document.querySelector(".two").style.opacity = "1";
		document.querySelector(".three").style.opacity = "0";
	} else if (selectValue == "3") {
		document.querySelector(".one").style.opacity = "0";
		document.querySelector(".two").style.opacity = "0";
		document.querySelector(".three").style.opacity = "1";
	}


}

function delImg() {
	document.querySelector(".one").style.opacity = "0";
	document.querySelector(".two").style.opacity = "0";
	document.querySelector(".three").style.opacity = "0";
}




