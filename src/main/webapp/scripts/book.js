/** book加载的相关操作,先绑定函数.加载整个网页后自动执行函数,执行读取book菜单操作 */
function loadUserBooks(){
	var userId=getCookie("userId");
	if(userId==null){
		window.location.href="log_in.html";
	}
	
	$.ajax({
		url:basepath+"/book/loadbooks.do",type:"post",data:{"userId":userId},
		dataType:"json",success:function(result){		
			var books=result.data;	
			for(var i=0;i<books.length;i++){
				var bookid=books[i].cn_notebook_id;
				var bookname=books[i].cn_notebook_name;
				var sli="";
				sli+='<li class="online">';
				sli+='<a>';
				sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
				sli+='</i>'+bookname;
				sli+='</a>';
				sli+='</li>';
				var $li=$(sli);
				$li.data("bookid",bookid);
				$("#book_ul").append($li);
			}

		},error:function(){alert("加载笔记本异常")}
	});
}