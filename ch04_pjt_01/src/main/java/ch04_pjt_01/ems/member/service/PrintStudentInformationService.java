package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService {

	StudentAllSelectService allSelectService;
	
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	public void printStudentInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("STUDENT LIST START ----------------------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum:"+student.getsNum() + "\t");
			System.out.print("|sId:"+student.getsId() + "\t");
			System.out.print("|sPw:"+student.getsPw() + "\t");
			System.out.print("|sName:"+student.getsName() + "\t");
			System.out.print("|sAge:"+student.getsAge() + "\t");
			System.out.print("|sGender:"+student.getsGender() + "\t");
			System.out.println("|sMajor:"+student.getsMajor() + "\t");
			
		}
		System.out.println("END -------------------------------------");
	}
}
