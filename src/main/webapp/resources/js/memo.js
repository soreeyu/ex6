/**
 * 
 */
function memoView(num){
	$.get("memoView/"+num,function(data){
		alert(data.writer);
	})
}

function memoWrite(writer, contents) {
		$.ajax({
			url:"memoWrite",
			type:"post",
			data:{
				writer:writer,
				contents:contents
			},
			success:function(data){
				//$("#result").html(data);
				//alert(data.trim());
				//getList(1,'','');
				//$("#result").prepend(data);
				
				var result = "<table>";
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.reg_date+"</td></tr>";
				});
				result = result+ "</table>";
				$("#result").html(result);
			}
		});
	}

	function getList(curPage, search, kind) {
		$.ajax({
			url:"getMemoList/"+curPage+"/"+search+"/"+kind,
			type:"get",
			data:{
				curPage:curPage,
				search:search,
				kind:kind
			},
			success:function(data){

				//$("#result").html(data);
				//data = data.trim();
				//data = JSON.parse(data);
				//자동으로 JSON 형식으로 파싱됨
				var result = "<table>";
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.reg_date+"</td></tr>";
				});
				result = result+ "</table>";
				$("#result").html(result);
			}
		});
	}