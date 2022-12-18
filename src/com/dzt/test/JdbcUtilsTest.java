package com.dzt.test;

import com.dzt.utils.JdbcUtils;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for(int i = 0;i < 100;i ++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection +"\t\t"+ (i + 1));
            JdbcUtils.close(connection);
        }
    }
}
