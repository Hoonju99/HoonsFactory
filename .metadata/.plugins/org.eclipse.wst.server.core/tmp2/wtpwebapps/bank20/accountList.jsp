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
			<span>핀테크이용번호</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span>출금기관명</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span>계좌별명</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span>계좌번호</span>
		</div>
	</div>
	<div id="result"></div>
	<h1>실명인증페이지</h1>
		<div id="real">
			<div class="qwe">
				<span>은행</span><select>
				<option>오픈은행</option>
				</select><br>
				
				<span>계좌번호</span><input id="account"><br>
				<span>주민번호앞자리</span><input id="holder"><br>
				<button class="btnSearch">실명인증페이지</button>
			</div>
		</div>
		<div id="qqq"></div>	
	<script>

var url = "accountList";
$(function(){
	$.ajax(url)
	.done(function(result){
		for(bank of result){
			$("<div>").addClass("acc").data("usenum", bank.fintech_use_num)
			.append( $("<span>").html(bank.fintech_use_num))
			.append( $("<span>").html(bank.bank_name))
			.append( $("<input>").val(bank.account_alias))
			.append( $("<button>").html("변경").addClass("btnTrans"))
			.append( $("<span>").html(bank.account_num_masked))
			.appendTo("#list")
		}
	})
		//실명인증
$("#real").on("click", ".btnSearch", function(){
	
	var account = $(this).closest(".qwe").find("#account").val()
	var holder = $(this).closest(".qwe").find("#holder").val()
	$.ajax({
		url:"getRealName",
		data : {
			account_num : account	,
			account_holder_info : holder
		}

	}).done(function(data){
		$("#qqq").html();
	})
	
}) 
	
	
	
	
//별병변경
 $("#list").on("click", ".btnTrans", function(){
	 var name = $(this).closest(".acc").find("input").val()
	 $.ajax({
		 url:"updateInfo",
		 data: {
			 account_alias : name 
		 }
	 
	 }).done(function(data){
		 console.log(data)
	 })
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
$(function(){
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
 


</script>

</body>
</html>
