function userLogin() {

    var userName = $("#userName").val();
    var userPwd = $("#userPwd").val();

    /*if(userName==null||""==userName.trim()){
        alert("用户名不能为空")
    }else if(userPwd==null||""==userPwd.trim()){
        alert("密码不能为空")
    }*/
    var params = {}
    params.userName = userName;
    params.userPwd = userPwd;

    $.ajax({
        type : "post",
        url : ctx + "/user/userLogin",
        data : params,
        dataType : "json",
        success : function (data) {
            if(data.code == 200){
                window.location.href = "main.shtml";
            }else {
                alert(data.msg)
            }
        }
    }
)
};

