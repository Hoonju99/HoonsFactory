<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h3>계좌리스트</h3>
	<div id="list">
		<div class="acc" data-usenum="12323232">
			<span>대구은행</span><span>1111222***</span>
		</div>
	</div>
	<div id="result"></div>
	<script>

var url = "accountList";
$(function(){
	$.ajax(url)
	.done(function(result){
		for(bank of result){
			$("<div>").addClass("acc").data("usenum", bank.fintech_use_num)
			.append( $("<span>").html(bank.bank_name))
			.append( $("<span>").html(bank.account_num_masked))
			.append( $("<input>").val(bank.별칭))
			.append( $("<button>").html("거래내역").addClass("btnTrans"))
			.appendTo("#list")
		}
	})
//잔액조회	
	$("#list").on("click", "span", function(){
		var num = $(this).closest(".acc").data("usenum");
		$.ajax({
			url:"balanceInfo",
			data : {fintechUseNum : num},
		}).done(function(data){
			console.log(data);
			$("#result").html(data);
		})
	})
	
	
//거래내역
$("#list").on("click", ".btnTrans", function(){
	var num = $(this).closest(".acc").data("usenum");
	$.ajax({
		url  : "getTransaction",
		data : {fintechUseNum : num},
	}).done(function(data){
		//console.log(data);
		for(data of data.res_list){
			console.log(data)			
		$("<div>")
		.append( $("<sapn>").html(data.after_balance_amt))
		.append( $("<sapn>").html(data.branch_name))
		.append( $("<sapn>").html(data.inout_type))
		.append( $("<sapn>").html(data.print_content))
		.append( $("<sapn>").html(data.tran_amt))
		.append( $("<sapn>").html(data.tran_date))
		.append( $("<sapn>").html(data.tran_time))
		.append( $("<sapn>").html(data.tran_type))
		.appendTo("#result")
		}
		
	})

	

})
})
 
/* $.ajax(url)
.done(function(datas){
	//console.log(datas)
	for(data of datas){
		console.log(data)
		$("<div>").append(data.account_holder_name + "<br>").append(data.bank_name + "<br>")
		.append(data.account_num_masked)
		.append($("<button>").html("조회").click(function(){
			data.
		}))
		.appendTo($("#list"))
	}
}) */


</script>

</body>
</html>
