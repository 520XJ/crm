function searchUsers(){
	$("#dg").datagrid("load",{
		userName:$("#userName").val(),
		trueName:$("#trueName").val(),
		phone:$("#phone").val(),
		email:$("#email").val()
	});
}

function openAddUserDialog(){
	openDlg("dlg", "添加用户记录");
}

function closeDialog(){
	closeDlg("dlg");
}

function saveOrUpdateUser(){
	var id=$("#id").val();
	var url=ctx+"/sysuser/insert";
	if(!isEmpty(id)){
		url=ctx+"/sysuser/update";
	}
	saveOrUpdate("fm", url, searchUsers, "dlg");
}

function openModifyUserDialog(){
	$("#password").attr("type","hidden");
	$("#pw").remove();
	openModifyDlg("dg", "fm", "dlg", "修改用户记录");
}
function deleteUser(){
	delRecode("dg", ctx+"/sysuser/delete", searchUsers);
}