package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentSelectService {

	private StudentDao studentDao;
	
	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}
