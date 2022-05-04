<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="our-services section-pad-t30">
   <div class="container">
      <!-- Section Tittle -->
      <div class="row">
         <div class="col-lg-12">
            <div class="section-tittle text-center">
            	<c:if test="${members.subscription ne 0}">
            		<span>구독 기간 : ${payment.paymentDate }</span>
                </c:if>
                <c:if test="${members.subscription eq 0}">
                	<span>구독 중이 아닙니다!</span>
                </c:if>                       
               <h2>환영합니다. ${memberId } 님!</h2>      
                        
            </div>
         </div>
      </div>
      <div class="row d-flex justify-contnet-center">
      
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            <div class="single-services text-center mb-30">
               <div class="services-ion">
                  <a href="memberUpdateForm.do"><span class="flaticon-search"></span></a>
               </div>
               <div class="services-cap">
                  <h5>
                     <a href="memberUpdateForm.do">내 정보 관리</a>
                  </h5>
                  
               </div>
            </div>
         </div>
 
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            <div class="single-services text-center mb-30">
               <div class="services-ion">
                  <a href="notesListForm.do"><span class="flaticon-real-estate"></span></a>
               </div>
               <div class="services-cap">
                  <h5>
                     <a href="notesListForm.do">쪽지함</a>
                  </h5>
                  
               </div>
            </div>
         </div>
         
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            <div class="single-services text-center mb-30">
               <div class="services-ion">
                  <a href="myZzim.do"><span class="flaticon-content"></span></a>
               </div>
               <div class="services-cap">
                  <h5>
                     <a href="myZzim.do">찜 목록</a>
                  </h5>                  
               </div>
            </div>
         </div>
         
         
         	<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            	<div class="single-services text-center mb-30">
            		
					<form id="payment" action="paymentInsert.do" method="post">               
               			<div class="services-ion">
                  			<a onclick="iamport()"><span class="flaticon-tour"></span></a>
               			</div>
               
               			<div class="services-cap">
               			   	<a onclick="iamport()">
                  			<h5>구독하기</h5>
                  			</a>                  
               			</div>
               		</form>
            	</div>
         	</div>
         	<input type="hidden" id="price" name="price" value="100">
	       			<input type="hidden" id="memberNum" name="memberNum" value=${memberNum }>
         
         
      </div>      
      
   </div>
</div>
<script>
function iamport(){
	//가맹점 식별코드
	IMP.init('imp60368887');
	IMP.request_pay({
	    pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '한달 구독권' , //결제창에서 보여질 이름
	    amount : 100, //실제 결제되는 가격
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울 강남구 도곡동',
	    buyer_postcode : '123-456'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	var msg = '결제가 완료되었습니다.';
	        msg += '결제 금액 : ' + rsp.paid_amount + '원';	        
	        payment.submit();
	    } else {
	    	 var msg = '결제에 실패하였습니다.';
	         msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}
</script>
</body>
</html>