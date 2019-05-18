var c=0
var min=0
var t
function timedCount()
 {
 		if(min<10){
		 	if(c<10){document.getElementById('txt').value="00:0"+ min +":0" + c ;}
		 	else if(c>=10){document.getElementById('txt').value="00:0"+ min +":" + c ;}
		 	if(c=60){c=0;document.getElementById('txt').value="00:0"+ min +":0" + c ;}
		 	c=c+1;
		}
 		else if(60>min>=10){
	 		if(c<10){document.getElementById('txt').value="00:"+ min +":0" + c ;}
		 	else if(c>=10){document.getElementById('txt').value="00:"+ min +":" + c ;}
		 	if(c=60){c=0;document.getElementById('txt').value="00:"+ min +":0" + c ;}
		 	c=c+1;
	 	}
 		else if(min==60) alert("Time out!!!");
	
 	t=setTimeout("timedCount()",1000)
 }



