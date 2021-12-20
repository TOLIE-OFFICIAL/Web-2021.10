function Chg() {
    const oldname = document.getElementById("oldname").value;
    const username = document.getElementById("username2").value;
    const pwd = document.getElementById("password2").value;
    if(oldname === ""){
        alert("旧用户名不能为空!");
        return false;
    }
    if (username === "") {
        alert("新用户名不能为空!");
        return false;
    }
    if (pwd === "") {
        alert("新密码不能为空!");
        return false;
    }
    
    document.getElementById("chg").submit();
}