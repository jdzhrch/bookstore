package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderitemDao;
import dao.UserDao;
import java.util.List;
import model.Book;
import model.Order;
import model.Orderitem;
import model.User;
import service.AppService;

public class AppServiceImpl
  implements AppService
{
  private BookDao bookDao;
  private OrderDao orderDao;
  private OrderitemDao orderitemDao;
  private UserDao userDao;
  
  public void setBookDao(BookDao bookDao)
  {
    this.bookDao = bookDao;
  }
  
  public void setOrderDao(OrderDao orderDao)
  {
    this.orderDao = orderDao;
  }
  
  public void setOrderitemDao(OrderitemDao orderitemDao)
  {
    this.orderitemDao = orderitemDao;
  }
  
  public void setUserDao(UserDao userDao)
  {
    this.userDao = userDao;
  }
  
  public Integer addBook(Book book)
  {
    return this.bookDao.save(book);
  }
  
  public void deleteBook(Book book)
  {
    this.bookDao.delete(book);
  }
  
  public void updateBook(Book book)
  {
    this.bookDao.update(book);
  }
  
  public Book getBookById(int id)
  {
    return this.bookDao.getBookById(id);
  }
  
  public List<Book> getAllBooks()
  {
    return this.bookDao.getAllBooks();
  }
  
  public Integer addOrder(Order order)
  {
    return this.orderDao.save(order);
  }
  
  public void deleteOrder(Order order)
  {
    this.orderDao.delete(order);
  }
  
  public void updateOrder(Order order)
  {
    this.orderDao.update(order);
  }
  
  public Order getOrderById(int id)
  {
    return this.orderDao.getOrderById(id);
  }
  
  public List<Order> getOrderByUserid(int userid)
  {
    return this.orderDao.getOrderByUserid(userid);
  }
  
  public List<Order> getAllOrders()
  {
    return this.orderDao.getAllOrders();
  }
  
  public List<Order> getCartByUserid(int userid)
  {
    return this.orderDao.getCartByUserid(userid);
  }
  
  public Integer addOrderitem(Orderitem orderitem)
  {
    return this.orderitemDao.save(orderitem);
  }
  
  public void deleteOrderitem(Orderitem orderitem)
  {
    this.orderitemDao.delete(orderitem);
  }
  
  public void updateOrderitem(Orderitem orderitem)
  {
    this.orderitemDao.update(orderitem);
  }
  
  public Orderitem getOrderitemById(int id)
  {
    return this.orderitemDao.getOrderitemById(id);
  }
  
  public List<Orderitem> getOrderitemByOrderid(int orderid)
  {
    return this.orderitemDao.getOrderitemByOrderid(orderid);
  }
  
  public Orderitem getOrderitemByOrderidBookid(int orderid, int bookid)
  {
    return this.orderitemDao.getOrderitemByOrderidBookid(orderid, bookid);
  }
  
  public List<Orderitem> getAllOrderitems()
  {
    return this.orderitemDao.getAllOrderitems();
  }
  
  public Integer addUser(User user)
  {
    return this.userDao.save(user);
  }
  
  public void deleteUser(User user)
  {
    this.userDao.delete(user);
  }
  
  public void updateUser(User user)
  {
    this.userDao.update(user);
  }
  
  public User getUserById(int id)
  {
    return this.userDao.getUserById(id);
  }
  
  public User getUserByUsername(String username)
  {
    return this.userDao.getUserByUsername(username);
  }
  
  public User getUserByUsernamePassword(String username, String password)
  {
    return this.userDao.getUserByUsernamePassword(username, password);
  }
  
  public List<User> getAllUsers()
  {
    return this.userDao.getAllUsers();
  }
  
  public List<Book> searchBookByBookname(String bookname)
  {
    return this.bookDao.searchBookByBookname(bookname);
  }
  
  public boolean checkUsername(String username)
  {
    return this.userDao.checkUsername(username);
  }
}
