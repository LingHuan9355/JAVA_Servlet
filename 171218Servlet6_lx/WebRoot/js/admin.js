var req;
function valGet(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Mircosoft.XMLHTTP");
	}
	//ȡ��������Ԫ��
	var  hd = document.getElementsByName("hd");
	var content=document.getElementById("content").innerHTML;
	//alert(content);
	//���嵥ѡ���ֵ����û��ѡ���κ�һ��ѡ��ʱ��ֵ��Ч����������Ϊ�Ƿ�ѡ��ѡ���ݵı�־
	var item_answer="";
	for(var i=0;i<hd.length;i++){ 
		if(hd[i].checked){ 
			item_answer=hd[i].value;
		}
	}

		if(item_answer==""){
		  alert("��ѡ��ͶƱѡ�");
		  return false;
		}else{
		    //����Ϊ������ִ�д���
			//alert(item_answer);
			//2.����·��
			var url = "compareServlet?answer="+item_answer +"&content="+content+"&" +Math.random();
			//alert(url);
			//3.����
			req.open("get", url, true);
			//4.����ȥ
			req.send(null);
			//5.�������ؽ��
			req.onreadystatechange = callback ;
		}
			
		
	}

function callback(){

	//�������Ѿ���Ӧ��ɵ�ʱ��
	if(req.readyState == 4){
		//��������Ӧ��״̬
		if(req.status == 200){
			//��ȡ����˵���Ӧ�ı�
			var msg = req.responseText;
			//alert(msg);
			//document.getElementById("msg").innerHTML = msg;
		}
	}
}




