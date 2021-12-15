package com.booklendingsystem.admin;

import com.booklendingsystem.admin.mapper.BookInfoMapper;
import com.booklendingsystem.admin.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    CategoryMapper categoryInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testPages() {
        int i = categoryInfoMapper.deleteById(6);
    }

}

