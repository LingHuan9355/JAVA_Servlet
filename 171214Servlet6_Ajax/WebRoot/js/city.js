var req;
 function getCity(){
	 if(window.XMLHttpRequest){
		 
		 req = new XMLHttpRequest();
	 }else{
		           
		 req = new ActiveXObject("Microsoft.XMLHTTP");
	 }
	 
	 var pid = document.getElementById("province").value;
	 
	 var url = "cityServlet?pid="+pid +"&" + Math.random();
	 
	 if(pid !=0){
		 req.open("get", url, true);
		 req.send(null);
		 req.onreadystatechange = callback;
	 }
	 
 }
 
 function callback(){
	 if(req.readyState == 4){
		 if(req.status == 200){
			//��ȡ����˷��� ��xml����
			 var msg = req.responseXML;
			//���ݱ�ǩ����ȡ���еĶ��������
			 var cityObj = msg.getElementsByTagName("city");
			 var city  = document.getElementById("city");
			 city.length = 1;
			 for ( var i = 0; i < cityObj.length; i++) {
				 var cid = cityObj[i].childNodes[0].childNodes[0].nodeValue;
				 var cname = cityObj[i].childNodes[1].childNodes[0].nodeValue;
				// alert(cid+"--"+cname);
				city.add(new Option(cname,cid));
			}
		 }
	 }
 }