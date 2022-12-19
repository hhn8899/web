package com.dzt.test;

import com.dzt.pojo.Book;
import com.dzt.pojo.Page;
import com.dzt.service.BookService;
import com.dzt.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"我","我",new BigDecimal("123"),23,23,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(null,"我","我",new BigDecimal("123"),232,2323,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(page);
    }

    @Test
    public void pageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(1, Page.PAGE_SIZE, 20, 50);
        System.out.println(bookPage);
    }
}
