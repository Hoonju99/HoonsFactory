<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
   <head>
      <title>exam1</title>
      <style>
      	th { min-width: 130px;}
      </style>
      <script src="./scripts/jquery-3.2.1.min.js"></script>
      <script>    
        var counselType = {'g1': '업무', 'g2':'개인'};
        
        //상품 선택시 단가 입력 및 체크 상태 변경
      	$(function(){
      		$("[name='goods']").change(function(){   
          		$(this).closest("tr").children().eq(4).text(price[$(this).val()]);
          		if($(this).val() != '') {
          			$(this).closest("tr").find("input:checkbox").attr("checked", true);
          		} else {
          			$(this).closest("tr").find("input:checkbox").attr("checked", false);
          		}
      		})
      	});  
      	
      	function makeData(){
      		let list = [];
      		
			//체크한 행만 전송할 데이터 만들기.
      		$("[name='selId']:checked").each(function(i, checkbox){
      			var tr = $(checkbox).parent().parent();
				var td = $(tr).children();
				var obj = {};
				
				var employee_id  = td.eq(1).text();
				var name    	 = td.eq(2).text();
				var counsel_type = td.eq(3).find("[name='counselTp']:checked").val();
				var dttm		 = td.eq(4).find("input").val();
				
				
				//객체에 담기
				obj["employee_id"] = employee_id;  // 사번
				obj["name"] = name;             // 이름
				obj["counsel_type"] = counsel_type;
				obj["dttm"] = dttm;
				//목록에 담기
				list.push(obj);

		
      		});
			console.log( JSON.stringify(list) );
			
			//ajax호출
			$.ajax({
				url:"/exam/insert",
				method : "post",
				data : JSON.stringify(list),
				contentType : "application/json"
			}).done(function(data){
				alert(`처리건수:\${data.total} success:\${data.success} errList:\${data.errList}`)
			})
      		

      	}
      </script>
   </head>

   <body>
	<!-- 데이터조회 시작 -->
      <sql:setDataSource var = "snapshot" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "hr"  password = "hr"/>

         <sql:query dataSource = "${snapshot}" var = "result">
            SELECT e.*, round(salary*commission_pct, 2) as commission, d.department_name 
              FROM Employees e, departments d 
             WHERE e.department_id =d.department_id 
              -- AND commission_pct>0
             ORDER BY first_name  
         </sql:query>
	<!-- 데이터조회 끝--> 
	
      <button type="button" id="" onclick="makeData()">상담요청</button>
      <!-- 목록 시작  -->
      <table border = "1" style="width:40%">
         <tr>
         	<th><input type="checkbox" id="chkAll"></th>
            <th>사번</th>
            <th>이름</th>
            <th>상담구분</th>   
            <th>상담시간</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}"> 
            <tr>
               <td align="center"><input type="checkbox" name="selId"></td>
               <td align="center"><c:out value = "${row.employee_id}"/></td>
               <td> ${row.last_name}</td>
               <td align="center"><input type="checkbox" name="counselTp" value="g1">업무
                                  <input type="checkbox" name="counselTp" value="g2">개인</td>
               <td align="center"><input type="text" name="counselDt" size="5"></td>
            </tr>
         </c:forEach>
      </table>
      <!-- 목록 끝  -->
   </body>
</html>