/*
 * Copyright (c) 2016, Quancheng-ec.com All right reserved. This software is the
 * confidential and proprietary information of Quancheng-ec.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Quancheng-ec.com.
 */
package com.nykko.rest;

import com.nykko.model.Book;
import com.nykko.repo.BookManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <strong>描述：</strong>TODO 描述 <br>
 * <strong>功能：</strong><br>
 * <strong>使用场景：</strong><br>
 * <strong>注意事项：</strong>
 * <ul>
 * <li></li>
 * </ul>
 *
 * @author zhaoranguang 2016/10/18 下午8:29
 * @version $$Id: TestHomeController, v 0.0.1 2016/10/18 下午8:29 zhaoranguang Exp $$
 */
@RunWith(SpringRunner.class)
@JsonTest
//@WebMvcTest(HomeController.class)
public class TestHomeController {

    @Autowired
    private JacksonTester<Book> json;

//    @MockBean
//    private BookManager bookManager;
//
//    @Autowired
//    private MockMvc mockMvc;

//    @Before
//    public void setupMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }



    @Test
    public void testAddBook() throws Exception{
        Book book = new Book();
        book.setAuthor("笨笨");
        book.setName("熊熊");
        book.setPublisher("电子工业出版社");
        book.setSaleCount(1000L);

        assertThat(this.json.write(book)).isEqualToJson("book.json");

//        given(this.bookManager.addBook(book)).willReturn(1);
//        this.mockMvc.perform(post("/add/book")
//                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                .content("{\n" +
//                        "\"author\":\"benben\",\n" +
//                        "\"name\":\"熊熊数据库\",\n" +
//                        "\"publisher\":\"电子工业出版社\",\n" +
//                        "\"saleCount\":1000\n" +
//                        "}"))
//                .andExpect(status().isOk())
//                .andDo(print());
    }


}
