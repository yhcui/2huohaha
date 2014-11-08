function bad(id){
	var badid = 'bad'+id;
	$('#'+badid).html(parseInt($('#'+badid).html())+1);
	$.post("bad.sb",
		  {id:id},
		  function(result){
			  
		  }
	);
}
function good(id){
	var goodid = 'good'+id;
	$('#'+goodid).html(parseInt($('#'+goodid).html())+1);
	$.post("good.sb",
		  {id:id},
		  function(result){
			  
		  }
	);
}