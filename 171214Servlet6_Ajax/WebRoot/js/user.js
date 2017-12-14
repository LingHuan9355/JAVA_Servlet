var req;
//get请求Ajax验证
function valGet(){
	//1.创建手机
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//获取文本框的用户名 
	var userName = document.getElementById("userName").value;
	//2.电话号码
	var url = "userServlet?uname="+userName+"&"+Math.random();
	//3.拨号
	req.open("get", url, true);
	
	//4.拨出去
	req.send(null);
	
	//5.监听返回结果
	req.onreadystatechange = callback;
}

function callback(){
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

//post请求Ajax验证
function valPost(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var userName = document.getElementById("userName").value;
	
	var url = "userServlet";
 
    req.open("post", url, true);    
    //设置请求头
    req.setRequestHeader("content-Type", "application/x-www-form-urlencoded");
    
    req.send("uname="+userName+"&"+Math.random());
    
    req.onreadystatechange = callback;



}