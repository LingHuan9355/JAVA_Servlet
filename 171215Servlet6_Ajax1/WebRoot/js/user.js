var req;

function valGet(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var uname = document.getElementById("userName").value;
	
	var url = "userServlet?uname=" + uname + "&" +Math.random();
	
	req.open("get", url, true);
	req.send(null);
	req.onreadystatechange = callback;
	
	
}

function valPost(){
	if(window.XMLHttpRequest){
		 req = new XMLHttpRequest();
	}else{
		 req = new ActiveXObject("Microsoft.XMLHTTP");
	}
   
	var uname = document.getElementById("userName").value;

    var url = "userServlet";

    req.open("post", url, true);
    //设置请求头
    req.setRequestHeader("content-Type", "application/x-www-form-urlencoded");
    req.send("uname="+uname + "&" +Math.random());
    req.onreadystatechange = callback ;

}

function callback() {
	//当请求已经响应完成的时候
	 if(req.readyState == 4){
		//服务器响应的状态
		 if(req.status == 200){
			//获取服务端的响应文本
			 var msg = req.responseText;
			 document.getElementById("msg").innerHTML = msg;
		 }
	 }
}