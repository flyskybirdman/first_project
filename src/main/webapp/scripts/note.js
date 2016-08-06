/**note加载操作*/
function loadBookNotes(){
	$("#book_ul li").find("a").removeClass("checked");
	$(this).find("a").addClass("checked");
	
	var bookid=$(this).data("bookid");
	$.ajax({
		url:basepath+"/note/loadbooknote.do",type:"post",data:{"bookid":bookid},
		dataType:"json",success:function(result){
		var notes=result.data;
		$("#note_ul").empty();
		for(var i=0;i<notes.length;i++){
			var noteid=notes[i].cn_note_id;
			var ntitle=notes[i].cn_note_title;
			var sli="";
			sli+='<li class="online">';
			sli+='<a>';
			sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+ntitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
			sli+='</a>';
			sli+='<div class="note_menu" tabindex="-1">';
			sli+='	<dl>';
			sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
			sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
			sli+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
			sli+='	</dl>';
			sli+='</div>';
			sli+='</li>';
			$li=$(sli);
			$li.data("noteid",noteid);
			$("#note_ul").append($li);
		}
		},error:function(){alert("加载笔记异常")}
	});
	
}

function loadNote(){
	$("#note_ul li").find("a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var noteid=$(this).data("noteid");
	$.ajax({
		url:basepath+"/note/loadnote.do",type:"post",data:{"noteid":noteid},
		dataType:"json",success:function(result){
			var note=result.data;
			var Title=note.cn_note_title;
			var body=note.cn_note_body;
			$("#input_note_title").val(Title);
			um.setContent(body);
		},error:function(){alert("笔记加载异常")}
	});
}





