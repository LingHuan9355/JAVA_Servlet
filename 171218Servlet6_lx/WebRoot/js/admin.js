var req;
function valGet(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Mircosoft.XMLHTTP");
	}
	//取得属性名元素
	var  hd = document.getElementsByName("hd");
	var content=document.getElementById("content").innerHTML;
	//alert(content);
	//定义单选框初值，当没有选择任何一个选项时此值有效，用它来作为是否选择单选内容的标志
	var item_answer="";
	for(var i=0;i<hd.length;i++){ 
		if(hd[i].checked){ 
			item_answer=hd[i].value;
		}
	}

		if(item_answer==""){
		  alert("请选择投票选项！");
		  return false;
		}else{
		    //以下为正常的执行代码
			//alert(item_answer);
			//2.访问路径
			var url = "compareServlet?answer="+item_answer +"&content="+content+"&" +Math.random();
			//alert(url);
			//3.拨号
			req.open("get", url, true);
			//4.拨出去
			req.send(null);
			//5.监听返回结果
			req.onreadystatechange = callback ;
		}
			
		
	}

function callback(){

	//当请求已经响应完成的时候
	if(req.readyState == 4){
		//服务器响应的状态
		if(req.status == 200){
			//获取服务端的响应文本
			var msg = req.responseText;
			//alert(msg);
			//document.getElementById("msg").innerHTML = msg;
		}
	}
}




