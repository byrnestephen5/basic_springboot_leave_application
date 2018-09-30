/**
 * 
 */
$(document).ready(function(){
	
	$('.nBtn, .table .eBtn').on('click',function(event){
		// avoid json 
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit'){
		$.get(href,function(teammember,status){
			$('.myForm #id').val(teammember.id);
			$('.myForm #firstname').val(teammember.firstname);
			$('.myForm #lastname').val(teammember.lastname);
			$('.myForm #teamid').val(teammember.teamid);
			
		});
		
		$('.myForm #exampleModal').modal();
		}else{
			
			$('.myForm #id').val('');
			$('.myForm #firstname').val('');
			$('.myForm #lastname').val('');
			$('.myForm #teamid').val('');
			$('.myForm #exampleModal').modal();
		}
	});
	
	$(' .table .delBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
		
	});
	
	
	
});