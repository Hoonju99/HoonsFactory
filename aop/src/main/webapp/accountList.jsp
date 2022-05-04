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
	<h3>���¸���Ʈ</h3>
	<div id="list">
		<div class="acc" data-usenum="12323232">
			<span>����ũ�̿��ȣ</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span>��ݱ����</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span>���º���</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span>���¹�ȣ</span>
		</div>
	</div>
	<div id="result"></div>
	<h1>�Ǹ�����������</h1>
		<div id="real">
			<div class="qwe">
				<span>����</span><select>
				<option>��������</option>
				</select><br>
				
				<span>���¹�ȣ</span><input id="account"><br>
				<span>�ֹι�ȣ���ڸ�</span><input id="holder"><br>
				<button class="btnSearch">�Ǹ�����������</button>
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
			.append( $("<button>").html("����").addClass("btnTrans"))
			.append( $("<span>").html(bank.account_num_masked))
			.appendTo("#list")
		}
	})
		//�Ǹ�����
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
	
	
	
	
//��������
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

	
//�ܾ���ȸ	
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
	
	
//�ŷ�����
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