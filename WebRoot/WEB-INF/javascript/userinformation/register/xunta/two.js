  var flag1=false;
	  var flag2=false;
	  var flag3=false;
	  var flag4=false;
	  var flag5=false;
	  var flag6=false;
	  var flag7=false;
	  var flag8=false;
	  var flag9=false;
	  var flag10=false;
	  var flag11=false;
	  var flag12=false;//女生答
	  var flag13=false;//男生答
	  var flag12_13=false;
	  var flag14=true;//100分
	  var reg14=/^(\d{1,2}|100)$/;
	  var flag15=false;
	  var flag16=false;
	  var flag17=false;
	  var flag18=false;
	  var flag19=false;//text
	  var flag20=false;//text
$(document).ready(function(){
  $('#footer #submit').click(function(){
	 // alert($('body .list h1'));
	//  alert($('body .list h1').eq(0).siblings().find('input').prop("checked"));
  //$.each($('body .list h1').eq(0).siblings(),function(i,value){
	// alert("i位置:"+$(value).find('input').prop("checked")); 
  //});
	  $.each($('body .list h1').eq(0).siblings(),function(i,value){
		//  alert("i位置:"+$(value).find('input').prop("checked")); 
		  if($(value).find('input').prop("checked")==true){
			  flag1=true;
			  return false;}
	  });
	  $.each($('body .list h1').eq(1).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag2=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(2).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag3=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(3).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag4=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(4).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag5=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(5).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag6=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(6).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag7=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(7).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag8=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(8).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag9=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(9).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag10=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(10).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag11=true;
			  return false;}
	  });
	  $.each($('body .list h1').eq(11).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag12=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(12).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag13=true;
			  return false;}
	  });	
	  if(flag12!=flag13){
		  flag12_13=true;
	  }
	  $.each($('body .list h1').eq(14).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag15=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(15).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag16=true;
			  return false;}
	  });
	  $.each($('body .list h1').eq(16).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag17=true;
			  return false;}
	  });	
	  $.each($('body .list h1').eq(17).siblings(),function(i,value){
		  if($(value).find('input').prop("checked")==true){
			  flag18=true;
			  return false;}
	  });
	  var text19=$('body .list h1').eq(18).next().find('textarea').val();
	  if(text19==""){ 
		  $('body .list h1').eq(18).next().find('textarea').focus();
		  flag19=false; }else{
		flag19=true;
	  }
	  var text20=$('body .list h1').eq(19).next().find('textarea').val();
	  if(text20==""){ 
		  $('body .list h1').eq(19).next().find('textarea').focus();
		  flag20=false;  
	  }else{
		flag20=true;
	  }
	  if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9&&flag10&&flag11&&flag12_13&&flag14&&flag15&&flag16&&flag17&&flag18&&flag19&&flag20){
	 $('form:first').submit();
	 
	  }else{
		  alert("请检查红色标出部分,是否漏选或不符合格式");
		 if(!flag1){
			 $('body .list h1').eq(0).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(0).siblings().click(function(){
				 $('body .list h1').eq(0).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag2){
			 $('body .list h1').eq(1).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(1).siblings().click(function(){
				 $('body .list h1').eq(1).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag3){
			 $('body .list h1').eq(2).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(2).siblings().click(function(){
				 $('body .list h1').eq(2).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag4){
			 $('body .list h1').eq(3).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(3).siblings().click(function(){
				 $('body .list h1').eq(3).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag5){
			 $('body .list h1').eq(4).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(4).siblings().click(function(){
				 $('body .list h1').eq(4).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag6){
			 $('body .list h1').eq(5).css({"border-bottom":"2px red solid"});
		 
			 $('body .list h1').eq(5).siblings().click(function(){
				 $('body .list h1').eq(5).css({"border-bottom":"none"});
			 });}
		 if(!flag7){
			 $('body .list h1').eq(6).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(6).siblings().click(function(){
				 $('body .list h1').eq(6).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag8){
			 $('body .list h1').eq(7).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(7).siblings().click(function(){
				 $('body .list h1').eq(7).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag9){
			 $('body .list h1').eq(8).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(8).siblings().click(function(){
				 $('body .list h1').eq(8).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag10){
			 $('body .list h1').eq(9).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(9).siblings().click(function(){
				 $('body .list h1').eq(9).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag11){
			 $('body .list h1').eq(10).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(10).siblings().click(function(){
				 $('body .list h1').eq(10).css({"border-bottom":"none"});
			 });
		 }
		 if(flag12==flag13){
			 $('body .list h1').eq(11).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(12).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(11).siblings().click(function(){
				 $('body .list h1').eq(11).css({"border-bottom":"none"});
				 $('body .list h1').eq(12).css({"border-bottom":"none"});
			 });
			 $('body .list h1').eq(12).siblings().click(function(){
				 $('body .list h1').eq(11).css({"border-bottom":"none"});
				 $('body .list h1').eq(12).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag14){
			 $('body .list h1').eq(13).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(13).siblings().click(function(){
				 $('body .list h1').eq(13).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag15){
			 $('body .list h1').eq(14).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(14).siblings().click(function(){
				 $('body .list h1').eq(14).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag16){
			 $('body .list h1').eq(15).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(15).siblings().click(function(){
				 $('body .list h1').eq(15).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag17){
			 $('body .list h1').eq(16).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(16).siblings().click(function(){
				 $('body .list h1').eq(16).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag18){
			 $('body .list h1').eq(17).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(17).siblings().click(function(){
				 $('body .list h1').eq(17).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag19){
			 $('body .list h1').eq(18).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(18).siblings().click(function(){
				 $('body .list h1').eq(18).css({"border-bottom":"none"});
			 });
		 }
		 if(!flag20){
			 $('body .list h1').eq(19).css({"border-bottom":"2px red solid"});
			 $('body .list h1').eq(19).siblings().click(function(){
				 $('body .list h1').eq(19).css({"border-bottom":"none"});
			 });
		 }
		 return false;
	 }
  });
  $('body .list h1').eq(13).siblings().find('input').focus(function(){
		 var index=$(this).parent('p').index();
		switch(index){
		case 1:{
			   $(this).css({"border":"blue solid 1px"});	
			break;
		}
		case 2:{
			   $(this).css({"border":"blue solid 1px"});	
			break;
		}
		}
	  });//100分
  $('body .list h1').eq(13).siblings().find('input').blur(function(){
		 var index=$(this).parent('p').index();
		 var value1=0;
		 var value2=0;
		switch(index){
		case 1:{
			var value1=$(this).val();
			var value2=$(this).parent('p').next().find('input').val();
			var flag=reg14.test(value1);
			if(!flag){ 
			   $(this).css({"border":"red solid 1px"});
			   $(this).focus();
			   flag14=false;
			}else{
				$(this).css({"border":"black solid 1px"});
				if(value1+value2==100) flag14=true;
			}
			break;
		}
		case 2:{
			var value1=	$(this).parent('p').prev().find('input').val();
			var value2=$(this).val();
			var flag=reg14.test(value2);
			if(!flag){ 	   
				$(this).css({"border":"red solid 1px"});
			   $(this).focus();
			   flag14=false;
			}else{
				$(this).css({"border":"black solid 1px"});
				if(value1+value2==100) flag14=true;
			}
			break;
		}
		}
	  });//100分blur
  $('body .list h1').eq(13).siblings().find('input').keyup(function(){
		 var index=$(this).parent('p').index();
		switch(index){
		case 1:{
			var value=$(this).val();
			var flag=reg14.test(value);
			if(!flag){ 
			   $(this).css({"border":"red solid 1px"});	
			}else{
				$(this).css({"border":"blue solid 1px"});	
			$(this).parent('p').next().find('input').val(100-value);
			}
			break;
		}
		case 2:{
			var value=$(this).val();
			var flag=reg14.test(value);
			if(!flag){ $(this).css({"border":"red solid 1px"});	
			}else{
				$(this).css({"border":"blue solid 1px"});	
			$(this).parent('p').prev().find('input').val(100-value);
			}
			break;
		}
		}
	  });//100分
  $('body .list h1').eq(3).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }
	  });//4
  $('body .list h1').eq(4).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }
  });//5
  $('body .list h1').eq(5).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//6
  $('body .list h1').eq(6).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//7
  $('body .list h1').eq(10).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//11 
  $('body .list h1').eq(11).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//12
  $('body .list h1').eq(12).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//13
  $('body .list h1').eq(14).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//15
  
  $('body .list h1').eq(15).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//16
  
  $('body .list h1').eq(16).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//17
  
  $('body .list h1').eq(17).siblings().find('input').click(function(){
	  var index=$(this).parents('p').index();
	  var value=$(this).prop("checked");
	  if(value){
	  $(this).parents('p').siblings().children('input').prop("disabled",true);
	  }else{
		  $(this).parents('p').siblings().children('input').prop("disabled",false);  
	  }});//18
});