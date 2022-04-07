$(function(){
	// 조회
	const item ={type: "ref_count"} ;
	ajax_article_count(item);
	      
	      
	//좋아요
	$("#good_count").click(function(){
	ajax_article_count({type: "good_count"});

	});
	
	
	//싫어요
	$("#bad_count").click(function(){
	ajax_article_count({type: "bad_count"});

	});
})


function ajax_article_count(item) {
	$.ajax("", {
		method: "POST",
		contentType: "application/json",
		dataType: "json",
		         //json으로 보냄
		data: JSON.stringify(item),
		         //서버로 받아오는 데이터 타입
		success: result => {
			console.log(` [성공] ${item.type} 수 증가: ${result}`);
			
			const count = $(`#${item.type}_count`).text();
			$(`#${item.type}_count`).text(Number(count)+1);

			//Number()=실수,parseInt()=정수
 //result값을 json에서 변경해온거 저렇게 쓰는구나! 템플릿리터널=$ !! `=백틱!   jsp입장에선$이엘문법임
/*그래서 js파일로 바꿔줘야지 백틱과 템플릿리터널을 인식함*/
//jsp는 서블릿으로 변환함
},
		error: (xhr, result) => console.log(`[실패] ${item.type} 수 증가: ${result}`)
		//location.href+"/count"

	});
}
