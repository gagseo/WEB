
function $(id, value) {
	if (arguments.length >= 2) {
		document.querySelector(id).innerHTML += value + '<br>';
	} else {
		return document.querySelector(id);
	}
}

var addId = "";
var password = "";
var address = "";
var phone = "";


function add() {

	addId = $('#id').value;
	password = ('#password').value;
	address = $('#address').value;
	phone = $('#phone').value;


	$('#thead').innerHTML += '<tbody><tr><td>' + addId + '</tb>'
		+ '<td>' + password + '</td>'
		+ '<td>' + address + '</td>'
		+ '<td>' + phone + '</td>'
		+ '<td>' + '<button onclick = \'clear1()\'>삭제</button>' + '</td></tr></tbody>';

}

function clear() {

	document.getElementsByTagName('tbody').style.display = 'none';

}

function clear1() {



}























