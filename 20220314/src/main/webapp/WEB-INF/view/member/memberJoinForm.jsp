<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div align="center">
   <div><h1>회원가입</h1></div>
   <div>
      <form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
         <div>
            <table border="1">
               <tr>
                  <th width="100">아이디</th>
                  <td width="300">
                     <input type="id" id="memberId" name="memberId" required="required" > &nbsp;&nbsp;
                     <button type="button" id="checkId" value="No" onclick="isIdCheck()">중복체크</button>
                  </td>
               </tr>
               <tr>
                  <th>패스워드</th>
                  <td><input type="password" id="memberPassword" name="memberPassword" required="required"></td>
               </tr>
               <tr>
                  <th>패스워드 확인</th>
                  <td><input type="password" id="memberPassword1" name="memberPassword1" required="required"></td>
               </tr>
               <tr>
                  <th>이 름</th>
                  <td><input type="text" id="memberName" name="memberName" required="required"></td>
               </tr>
               <tr>
                  <th>전화번호</th>
                  <td><input type="text" id="memberPhone" name="memberPhone"></td>
               </tr>
               <tr>
                  <th>이메일</th>
                  <td><input type="email" id="memberEmail" name="memberEmail" placeholder="Your Email"></td>
               </tr>
            </table>
         </div><br>
         <div>
            <input type="submit" value="회원가입">&nbsp;&nbsp;
            <input type="reset" value="취소">&nbsp;&nbsp;
            <input type="button" onclick="formCheck()" value="홈 가기" onclick="location.href='homeCommand.do'">
         </div>               
      </form>
   </div>
</div>
<script type="text/javascript">
   function isIdCheck(){
      $.ajax({
         url : "ajaxMemberIdCheck.do",
         type : "post",
         data : {"str" : $('#memberId').val()},
         dataType : "text",
         success : function(result){
            if(result == '1'){
               alert("사용 가능한 아이디입니다.");
               $("#checkId").attr("disabled", "disabled");
               $("#checkId").val('Yes');
               $("#memberPassword").focus();
            }else{
               alert("사용 불가능한 아이디입니다.");
               $("#memberId").val('');
               $("#memberId").focus();
            };
         }
      });
   }
   
   function formCheck(){
      if($("#checkId").val() != 'Yes'){
         alert("아이디 중복체크를 해주세요.");
         return false;
      }
      
      if($("#memberPassword").val() != $("#memberPassword1").val()){
         alert("패스워드가 일치하지 않습니다.")
         $("#memberPassword").val('');
         $("#memberPassword1").val('');
         $("#memberPassword").focus();
         return false;
      }
      
      return true;
   }
</script>
</body>
</html>