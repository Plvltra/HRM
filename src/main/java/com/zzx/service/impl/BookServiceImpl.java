package com.zzx.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzx.dao.AppointmentDao;
import com.zzx.dao.BookDao;
import com.zzx.dto.AppointExecution;
import com.zzx.entity.Appointment;
import com.zzx.entity.Book;
import com.zzx.enums.AppointStateEnum;
import com.zzx.exception.AppointException;
import com.zzx.exception.NoNumberException;
import com.zzx.exception.RepeatAppointException;
import com.zzx.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private BookDao bookDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Book getBookById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.queryAll(0, 1000);
	}

	@Override
	public AppointExecution appointBook(long bookId, long studentId) {
//		try {
//			Book book = bookDao.queryById(bookId);
//			if(book == null){
//				throw new AppointException("no book");
//			}else if(book.getNumber() <= 0){
//				throw new NoNumberException("no number");
//			}else{
//				Appointment tempAppointment = appointmentDao.queryByKeyWithBook(bookId, studentId); 
//				if(tempAppointment != null){
//					throw new RepeatAppointException("repeat appoint");
//				}else{
//					appointmentDao.insertAppointment(bookId, studentId);
//					bookDao.reduceNumber(bookId);
//					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
//					return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
//				}
//			}
//		} catch (NoNumberException e1) {
//			throw e1;
//		} catch (RepeatAppointException e2) {
//			throw e2;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			// 所有编译期异常转换为运行期异常
//			//return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//错误写法
//			throw new AppointException("appoint inner error:" + e.getMessage());
//		}
		Book book = bookDao.queryById(bookId);
		if(book == null){
			throw new AppointException("no book");
		}else if(book.getNumber() <= 0){
			throw new NoNumberException("no number");
		}else{
			Appointment tempAppointment = appointmentDao.queryByKeyWithBook(bookId, studentId); 
			if(tempAppointment != null){
				throw new RepeatAppointException("repeat appoint");
			}else{
				appointmentDao.insertAppointment(bookId, studentId);
				bookDao.reduceNumber(bookId);
				Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
				return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
			}
		}
	}
}
