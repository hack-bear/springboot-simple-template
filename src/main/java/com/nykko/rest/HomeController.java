package com.nykko.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nykko.model.Book;
import com.nykko.repo.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

	@Autowired
	BookManager bookManager;

	@RequestMapping(value = "/add/book", method = { RequestMethod.POST }, produces = {MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Integer> addBook(@RequestBody Book book) {
		Map result = new HashMap<>();
		Integer bookId = bookManager.addBook(book);
		result.put("bookId",bookId);
		return result;
	}

}
