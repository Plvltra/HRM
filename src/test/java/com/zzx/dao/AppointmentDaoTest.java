package com.zzx.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzx.BaseTest;
import com.zzx.dao.AppointmentDao;
import com.zzx.entity.Appointment;

public class AppointmentDaoTest extends BaseTest{

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Test
	public void testInsertAppointment() {
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointment(bookId, studentId);
		System.out.println("1111111111111111111111111111");
		System.out.println("insert=" + insert);
	}

	@Test
	public void testQueryByKeyWithBook() {
		long bookId = 1000;
		long studentId = 12345678910L;
		Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println("2222222222222222222222222");
		System.out.println(appointment);
	}

}
