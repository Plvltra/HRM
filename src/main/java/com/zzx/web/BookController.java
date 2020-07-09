package com.zzx.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzx.dto.AppointExecution;
import com.zzx.dto.Result;
import com.zzx.entity.Book;
import com.zzx.enums.AppointStateEnum;
import com.zzx.exception.AppointException;
import com.zzx.exception.NoNumberException;
import com.zzx.exception.RepeatAppointException;
import com.zzx.service.BookService;

@Controller
@RequestMapping("/book") // url:/ģ��/��Դ/{id}/ϸ�� /seckill/list
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/index")  
	private String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getAllBooks();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list"; // WEB-INF/jsp/"list".jsp
	}
	
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		if(bookId == null) {
			return "redirect:/book/list";
		}
		
		Book book = bookService.getBookById(bookId);
		if(book == null){
			return "forward:/book/list";
		}else{
			model.addAttribute("book", book);
			return "detail";
		}
	}
	
	@RequestMapping(value = "/{bookId}/appoint", 
			method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
	@ResponseBody
	private Result<AppointExecution> appoint(
			@PathVariable("bookId") Long bookId, 
			@RequestParam("studentId") Long studentId) {
		
		if(bookId == null || studentId == null){
			return new Result<>(false, "��Ż�ѧ�Ų���Ϊ��");
		}
		
		AppointExecution execution;
		try {
			execution = bookService.appointBook(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (AppointException e3) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}
}
