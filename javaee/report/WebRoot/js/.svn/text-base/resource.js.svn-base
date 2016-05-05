		$(function(){
			//禁止文本窗口选中
			//tm_forbiddenSelect();
			//禁止浏览器的右键
			//document.body.oncontextmenu=document.body.ondragstart= document.body.onselectstart=document.body.onbeforecopy=function(){return false;};
			//工具类的高度是自动换算的
			$("#sidebar").height(getClientHeight()-103);
			//内容栏的高度是自动换算的
			$("#content").height(getClientHeight()-104);
			//这行是浏览器改变的时候自动的改变内容和工具栏的高度
			$(window).resize(function(){
				$("#sidebar").height(getClientHeight()-103);
				$("#content").height(getClientHeight()-104);
			});
			//tm_deleteresource2();	
			tm_rename();
		});
			
        //保存文件信息
        function tm_saveresource(jdata){
        	var name = jdata.name;
        	var size = jdata.size;
        	var sizeString = jdata.sizeString;
        	var ext = jdata.ext;
        	var url = jdata.url;
        	var width = "600";
        	var height = "300";
        	var folderId ="3";
        	var newname = jdata.newName;
        	var userId = "3";
        	var description = "";
        	var params = {
        		"name":name,
        		"size":size,
        		"sizeString":sizeString,
        		"ext":ext,
        		"url":url,
        		"width":width,
        		"height":height,
        		"folderId":folderId,
        		"newname":newname,
        		"userId":userId,
        		"description":description       		
        	};
        	$.ajax({
        		type:"post",
        		url:"http://localhost/yunpan/service/resource.jsp",
        		data:params,
        		success:function(data){
	        	    var backdata = data.trim();
	        	    if(backdata=="fail"){
	        	    	tm_dialoag({title:"添加提示",width:340,height:200,content:"非常抱歉，文件添加失败！"});        	    	
	        	    }else{
	        	    	var datajdata = eval("("+backdata+")");
	       	        	$("#contentbox").prepend("<li class='items' id='tm-items-"+datajdata.id+"'>"+
	       					"				<div class='col c1' style='width: 50%;'>"+
	       			        "        <span class='chk fl'></span>"+
	       			        "        <span class='fl icon'>"+
	       			        "<input type='checkbox' class='chk' value='"+datajdata.id+"'>&nbsp;"+
	       			        "<img src='images/text.png'></span>"+
	       			        "        <div class='name fl'><span class='name-text' title='"+jdata.name+"' data-opid='"+datajdata.id+"'>"+jdata.name+"</span>"+
			     			"<a href='javascript:void(0);' class='tmui-btns save'>确定</a>&nbsp;&nbsp;"+
						    "<a href='javascript:void(0);' class='tmui-btns cancle'>取消</a>&nbsp;&nbsp;"+		       			        
						    "</div>"+	       			        
						    "    </div>"+
	       			        "    <div class='col' style='width: 16%' title='字节大小:size'>"+jdata.sizeString+"</div>"+
	       			        "    <div class='col' style='width: 23%;color:green'>"+new Date().format("yyyy-MM-dd HH:mm:ss")+"&nbsp;&nbsp;("+getTimeFormat(new Date())+")"+"</div>"+
	       			        "    <div class='col buttons' style='width: 10%'>"+
	       			        "    	<a href='javascript:void(0);' class='edit'><img src='images/edit.png'></a>&nbsp;&nbsp;"+
	       	 		        "            <a href='javascript:void(0);' data-opid='"+datajdata.id+"' onclick='tm_deleteresource(this);'><img src='images/delete.gif'></a>"+
	            //  	        "    	<a href='javascript:void(0);' data-opid='"+datajdata.id+"' class='delete'><img src='images/delete.gif'></a>"+
	       			        "    </div>"+
	       					"</li>");  
	       	 	         //tm_deleteresource2();	       	        	
	        	     };
	        	}
        	});
        }
        //tm_saveresource();
		/*上传组件调用方法*/
		$.tmUpload({"fileTypes":"*.*",callback:function(data,file){
			var jdata = eval("("+data+")");
			tm_saveresource(jdata);
		}}); 
		
		//删除文件调用的方法。
		function tm_deleteresource(obj){
		   var opid = $(obj).data("opid");
		   //不管任何删除都要给提示。
		   tm_dialoag({content:"您确定删除该文件吗？",width:340,height:200,callback:function(ok){
			   if(ok){
				   $.ajax({
					   type:"post",
					   url:"http://localhost/yunpan/service/deleteResource.jsp",
					   data:{"id":opid},
					   success:function(data){
						   jdata = data.trim();
						   if(jdata="success"){
							   $(obj).parents(".items").slideUp("slow",function(){
								   $(this).remove();
							   });
						   }else{
							   alert("删除失败！");
						   }
					   }
				   });
			   }
		   }});		   
		}
		
		//批量删除
		function tm_deleteResources(){
			var arr = [];
			//效率最高。
			$("#contentbox").find(".chk:checked").each(function(){
				arr.push($(this).val());
			});
			if(arr.length==0){
				alert("请选择您要删除的文件！");
				return;
			}
//			$("#contentbox").find("input[type='checkbox'][name='ridchk']:checked").each(function(){
//				arr.push($(this).val());
//			});
			
//			$("#contentbox").find(".chk").each(function(){
//				if($(this).prop("checked")){
//					arr.push($(this).val());
//				}
//			});
			
//			$("#contentbox").find(".chk").filter(function(){
//				if($(this).prop("checked")){
//					arr.push($(this).val());
//				}
//			});
			tm_dialoag({content:"您确定删除您选中的这些文件吗？",width:340,height:200,callback:function(ok){
               if(ok){
   				 $.ajax({
  				   type:"post",
  				   url:"http://localhost/yunpan/service/deleteResources.jsp",
  				   data:{"ids":arr.toString()},
  				   success:function(data){
  					  var jdata = data.trim();
  					  if(jdata=="success"){
//  						   $("#contentbox").find(".chk:checked").each(function(){
//  							  $(this).parents(".items").fadeOut("slow",function(){
//  								  $(this).remove();  
//  							  });
//  						   });
  						   for(var i=0;i<arr.length;i++){
  							   $("#tm-items-"+arr[i]).fadeOut("slow",function(){
  								   $(this).remove();
  							   });  
  						   }
  					  }else{
  						  alert("删除失败！");
  					  }
  				   }
  				 });            	   
              } 
			}});
		}
		//第二种删除文件的方法：动态绑定。
/*         function tm_deleteresource2(){
			//tm_deleteresource2()
			
			$(".delete").click(function(){
				   var $this = $(this);
				   var opid = $this.data("opid");
				   alert(opid);
				   //不管任何删除都要给提示。
				   tm_dialoag({content:"您确定删除该文件吗？",width:340,height:200,callback:function(ok){
					   if(ok){
						   $.ajax({
							   type:"post",
							   url:"http://localhost/yunpan/service/deleteResource.jsp",
							   data:{"id":opid},
							   success:function(data){
								   jdata = data.trim();
								   if(jdata="success"){
									   $this.parents(".items").slideUp("slow",function(){
										   $this.remove();
									   });
								   }else{
									   alert("删除失败！");
								   }
							   }
						   });
					   }
			       }});					
			    });			
		};	 */	
       //jquery事件委托就是专门去处理ajax添加后备元素的一种动态绑定事件的方法。解决了你实际开发过程重复绑定事件。 	
      $("#contentbox").on("click",".delete",function(){
		  $(".delete").click(function(){
			   var $this = $(this);
			   var opid = $this.data("opid");
			   //不管任何删除都要给提示。
			   tm_dialoag({content:"您确定删除该文件吗？",width:340,height:200,callback:function(ok){
				   if(ok){
					   $.ajax({
						   type:"post",
						   url:"http://localhost/yunpan/service/deleteResource.jsp",
						   data:{"id":opid},
						   success:function(data){
							   jdata = data.trim();
							   if(jdata="success"){
								   $this.parents(".items").slideUp("slow",function(){
									   $this.remove();
								   });
							   }else{
								   alert("删除失败！");
							   }
						   }
					   });
				   }
		       }});					
		    });	    	  
        });
        //文件重命名。
		function tm_rename(){
			//文件重命名的编辑按钮。
			$("#contentbox").on("click",".edit",function(){			
                //var text = $(this).prev().text();
                //获取name标签对象
                var $name= $(this).parents(".items").find(".name-text");
                //获取name标签对象的文本值
                var text = $name.text(); 
                //将编辑按钮隐藏
                $(this).hide();
                //将确定和取消按钮显示
                $(this).parents(".items").find(".tmui-btns").show();
                //将带有text的值的input框添加到name标签中
                $name.html("<input type='text' class='itemvalue' value='"+text+"'>");
                //获取input框的焦点
                $name.find(".itemvalue").select();
           });
		   //文件重命名的取消按钮。
		   $("#contentbox").on("click",".cancle",function(){	
              //获取name的对象
              var $name = $(this).parents(".items").find(".name-text");
              //获取name标签的属性title的值。
              var text = $name.attr("title");
              //点击取消时将存放在name标签的属性title中的值赋给name标签
              $name.html(text); 
              //将确定和取消按钮隐藏
              $(this).parents(".items").find(".tmui-btns").hide();
              //将编辑按钮显示。
              $(this).parents(".items").find(".edit").show();
           });
           
		   //文件重命名的确定按钮。
		   $("#contentbox").on("click",".save",function(){
               //获取name标签的对象                
               $name = $(this).parents(".items").find(".name-text");
               //获取name标签的id值
               var id = $name.data("opid");
               //获取input框中的值。
               var text = $(this).parents(".items").find(".itemvalue").val();
               //获取name标签原来的值
                var stext = $name.attr("title");
               //判断input框中的值是否修改了
               if(text!=""&&text==stext){
                 //trigger事件触发
                 $(this).parents(".items").find(".cancle").trigger("click");//触发我们的取消事件
                 return;
               }
               //判断值是否为空。
               if(text!=""&&text.length<250){
                 //如果不为空则将确定取消按钮显示出来，并且将编辑按钮隐藏.
                  $(this).parents(".items").find(".tmui-btns").hide();
                  $(this).parents(".items").find(".edit").show();                  
                  //将input框中的值赋给title属性。   
                  $name.attr("title",text);       
                  //将input框中的值赋给name标签。           
                  $name.html(text);
                  alert("您保存的文件名是："+text+"====id是"+id);
                  $.ajax({
                	 type:"post",
                	 url:"http://localhost/yunpan/service/updateResource.jsp",
                	 data:{"id":id,"name":text},
                	 success:function(data){
                	     var jdata = data.trim();
                	     if(jdata=="success"){
                	    	 alert("修改成功！");
                	     }else{
                	    	 alert("修改失败！");
                	     }
                	 }
                  });
               }else{
            	   $(this).parents(".items").find(".itemvalue").select();
                 alert("您未输入文件名，或者您输入的文件名超过了255个字符！！！");
               }
             
           });			
		}
		//全部选中页面中的数据。
        $("#checkall").click(function(){
       	 //   $("#contentbox").find(".chk").attr("checked","checked");
       	 //   $("#contentbox").find(".chk").attr("checked",true);
       	 //   $("#contentbox").find(".chk").prop("checked","checked");
       	 var text = $(this).attr("op");
       	 if(text=="on"){
       	    $("#contentbox").find(".chk").prop("checked",true);
       	    $(this).attr("op","off");
       	    $(this).text("反选");
       	 }else{        		 
       	    $("#contentbox").find(".chk").prop("checked",false);
       	    $(this).attr("op","on");
       	    $(this).text("全选");
       	 }
         });      		