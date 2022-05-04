package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.department.Department;
import com.yedam.java.department.DepartmentDAO;
import com.yedam.java.department.DepartmentDAOImpl;

public class DepartmentFrame {
	private DepartmentDAO deptDAO = DepartmentDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);

	public DepartmentFrame() {
		while (true) {
			menuPrint();

			// 메뉴 출력
			int menuNO = menuSelect();
			// 메뉴 선택

			// 각 메뉴별 기능실행

			if (menuNO == 1) {
				insertDepartment();
			} else if (menuNO == 2) {

				updateDepartment();
			} else if (menuNO == 3) {
				deleteDepartment();

			} else if (menuNO == 4) {
				selectOne();

			} else if (menuNO == 5) {
				selectAll();
			} else if (menuNO == 9) {
				end();
				break;

			}
		}
		public void menuPrint() {
			System.out.println("=== 1.등록 2.수정 3.삭제 4.단건조회 5.전체조회 9.종료 ===");
			System.out.println("선택>");
			
		}
		public int menusSelect() {
			int menuNo = 0;
			try {
				menuNO = Integer.parseInt(scanner.nextLine());
			}catch(Exception e) {
				System.out.println("없는 메뉴입니다.");
			}
			return menuNo;
		}
			public void insertDepartment() {
				//부서정보 입력 
				Department dept = inputDeptInfo();
				//부서정보 등록
				deptDAO.insert(dept);
	
			}
			
			public void updateDepartment() {
				//부서정보 입력
				Department dept = inputDeptNmae();
				//부서정보 등록
				deptDAO.update(dept	);
			}
			public void deleteDepartment() {
				//부서번호 입력
				int departmentId = inputDeptId();
				
				//부서정보 삭제
				deptDAO.delete(departmentId);
				
			}
			public void selectOne() {
				//부서번호 입력
				int departmentId = inputDeptId();
				//부서정보 조회
				Department dept = deptDAO.selectAll(departmentId);
				//부서정보 출력
				if(dept == null) {
					System.out.println("해당 부서 정보가 존재하지 안흣ㅂ니다.");
				}else {
					System.out.println(dept);
				}
			}
			public void selectAll() {
				List<Department> list = deptDAO.selectAll();
				for(Department dept : list) {
					System.out.println(dept);
				}
			}
		
		public void end() {
			System.out.println("종료");
		}
		
		public Department inputDeptInfo() {
			Department dept = new Department();
			System.out.println("부서명>");
			dept.setDepartmentId(Integer.parseInt(scanner.nextLine()));
			System.out.println("매니저번호>");
			dept.setManagerId(scanner.nextLine());
			System.out.println("지역번호");
			dept.setLocationId(Integer.parseInt(scanner.nextLine()));
			return dept;
			
		}
		public 
		
		
		
		
		
	}
}
