/*
 * Copyright (c) 2016, Quancheng-ec.com All right reserved. This software is the
 * confidential and proprietary information of Quancheng-ec.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Quancheng-ec.com.
 */
package com.nykko.repo;

import com.nykko.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <strong>描述：</strong>TODO 描述 <br>
 * <strong>功能：</strong><br>
 * <strong>使用场景：</strong><br>
 * <strong>注意事项：</strong>
 * <ul>
 * <li></li>
 * </ul>
 *
 * @author zhaoranguang 2016/10/18 下午4:48
 * @version $$Id: BookManager, v 0.0.1 2016/10/18 下午4:48 zhaoranguang Exp $$
 */
@Component
public class BookManager {

    private static final String SQL_PREFIX = "BookMapper.";

    @Autowired
    private SqlSession sqlSession;

    public Integer addBook(Book book){
        return sqlSession.insert(SQL_PREFIX+"addBook",book);
    }


}
