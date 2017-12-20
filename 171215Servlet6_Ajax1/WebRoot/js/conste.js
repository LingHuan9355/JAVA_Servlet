var req;
function getRadio(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//获取的的值默认一直为第一个rdiao的值
	var name = document.getElementById("conste").value;
    
	var url="contentServlet?name="+name + "&" + Math.random();
   if(conste != null){
	   req.open("get", url, true);
	   req.send(null);
	   req.onreadystatechange = callback;
   }
}

function callback() {
	if(req.readyState == 4){
		if(req.status == 200){
			var msg = req.responseXML;
			var consteObj = msg.getElementsByTagName("constes");
            var conste = document.getElementById("content");
            
            /*for ( var i = 0; i < consteObj.length; i++) {
            	var cid = consteObj[i].childNodes[0].childNodes[0].nodeValue;
				var cname = consteObj[i].childNodes[1].childNodes[0].nodeValue;
				var content = consteObj[i].childNodes[2].childNodes[0].nodeValue;
			   alert(cid+"--"+cname);
			  // city.add(new Option(cname,cid));
			}*/
            
		
		}
	}
}