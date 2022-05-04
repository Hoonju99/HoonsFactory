<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" method="post" action="findById">
<input name="employee_id" id="empId"><button type="button" id="btn">조회</button>
</form>
<div id="result"></div>
<button type="button" id="btnAjax">ajax조회</button>
<script>
	btn.addEventListener("click", function(){		
		//get
		//location.href="findById?emplpyee_id="+ empId.value;
		
		//post
		//document.forms[0]
		frm.submit();
	})
	
	//btnajax
	btnAjax.addEventListener("click", function(){
		fetch("ajax/findById", {
			method,
			headers :{    }
			data : employee_id=" + empId.value 
		})
		 .then( res => res.json() )
		 .then( res => result.innerHTML = res[0].first_name)
	});
</script>
</body>
</html>