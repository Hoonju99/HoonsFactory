<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>toastgrid.jsp</title>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<script>
	$(function(){
		const Grid = tui.Grid;
		const instance = new Grid({
			  el: document.getElementById('grid'), // Container element
			  columns: [
			    {
			      header: '번호',
			      name: 'employee_id'
			    },
			    {
			      header: '이름',
			      name: 'last_name',
			      editor: 'text'
			    },
			    {
			      header: '이메일',
			      name: 'email',
			      editor: 'text'
			    },
			    {
				  header: '담당',
				  name: 'job_id',
			      editor: {
			    	  type: 'select',
			          options: {
			              listItems: [
			                { text: 'President', value: 'AD_PRES' },
			                { text: 'Administration', value: 'Assistant' },
			                { text: 'Sales Manager', value: 'SA_MAN' },
			                { text: 'IT_PROG', value: 'IT_PROG' },
			                { text: 'MK_MAN', value: 'MK_MAN' },
			                { text: 'ST_CLERK', value: 'ST_CLERK' }
			              ]
			          }
			      }
				},
			    {
			      header: '급여',
			      name: 'salary',
			      editor: 'text'
			    },
			    {
			      header: '입사일자',
			      name: 'hire_date',
			      editor: 'text'
			    }
			  ],
			  data: { api: {  readData: { url: '/readEmp', method: 'GET'},
						      modifyData : { url: '/modifyEmp', method: 'POST'},
						   }
				    },
				    contentType: 'application/json',
			});
 			//let jsonData;
/* 			$.ajax({
				url: '/empSelect',
				//async: false
			}).done(function(datas){
				//jsonData = datas
				instance.resetData(datas); // Call API of instance's public method
			}) */			
			Grid.applyTheme('striped'); // Call API of static method
			$("#btnIns").on("click", function(){
				instance.appendRow(1);
			})
			$("#btnDel").on("click", function(){
				console.log(instance.getFocusedCell());
				if(instance.getFocusedCell())
					instance.removeRow( instance.getFocusedCell().rowKey );  //getfocusCell
			})
			$("#btnMdf").on("click", function(){
				instance.request('modifyData');
			})
	})
</script>
</head>
<body>
  	<button id="btnIns">추가</button>
  	<button id="btnDel">삭제</button>
  	<button id="btnMdf">저장</button>
	<div id="grid"></div>
</body>
</html>