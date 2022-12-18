package com.dzt.web;

import com.dzt.pojo.Book;
import com.dzt.pojo.Page;
import com.dzt.service.BookService;
import com.dzt.service.impl.BookServiceImpl;
import com.dzt.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.psrseInt(req.getParameter("pageNo"),0);
        pageNo += 1;
        // 1、获取请求的参数,保存到book对象中
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // 2、调用bookService.addbook保存图书
        bookService.addBook(book);
        // 3、跳到图书列表页面 /manager
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+ pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数id，图书编号
        int id = WebUtils.psrseInt(req.getParameter("id"), 0);
        // 2、调用bookService.deleteBookId(),删除图书
        bookService.deleteBookById(id);
        // 3、重定向图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+ req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() +"/manager/bookServlet?action=page&pageNo="+ req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数的图书编号
        int id = WebUtils.psrseInt(req.getParameter("id"), 0);
        //2、调用查询方法
        Book book = bookService.queryBookById(id);
        //3、将插到的信息保存到request
        req.setAttribute("book", book);
        //4、请求转发到其他页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、通过bookservice查询全部数据
        List<Book> books = bookService.queryBooks();
        // 2、把全部图书保存到request域中
        req.setAttribute("books", books);
        // 3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1获取请求的参数
        int pageNo = WebUtils.psrseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.psrseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用bookService.page方法
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3、将page对象保存到request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }
}
