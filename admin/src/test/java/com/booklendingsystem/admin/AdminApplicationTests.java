package com.booklendingsystem.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.mapper.BookInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    BookInfoMapper bookInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testPages() {
        Page<BookInfo> page = new Page<>(2, 5);
        bookInfoMapper.selectPage(page, null);
        page.getRecords();
    }
}
