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

public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();
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
        page.setUrl("client/bookServlet?action=page");
        //3、将page对象保存到request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
