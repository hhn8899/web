package com.dzt.test;

import com.dzt.dao.BookDao;
import com.dzt.dao.impl.BookDaoImpl;
import com.dzt.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "我的前半生", "爱新觉罗", new BigDecimal(9999), 232, 232, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookDao.updateBook(new Book(21, "我", "我", new BigDecimal(9999), 232, 232, "static/pages/log.jpf"));
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));

    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        List<Book> books = bookDao.queryForPageItems(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
