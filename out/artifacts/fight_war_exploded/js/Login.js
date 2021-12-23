function Log() {
	const username = document.getElementById("username1").value;
	const pwd = document.getElementById("password1").value;
	if (username === "") {
		alert("用户名不能为空!");
		return false;
	}
	if (pwd === "") {
		alert("密码不能为空!");
		return false;
	}
	document.getElementById("lg").submit();
}
function Reg() {
	const username = document.getElementById("username2").value;
	const pwd = document.getElementById("password2").value;
	const repwd = document.getElementById("password3").value;
	if (username === "") {
		alert("初始用户名不能为空!");
		return false;
	}
	if (pwd === "" || repwd === "") {
		alert("密码不能为空!");
		return false;
	}
	if (pwd !== repwd) {
		alert("两次密码不一致!");
		return false;
	} else {
		document.getElementById("sg").submit();
	}
}