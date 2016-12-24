/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import model.*;
import dao.*;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Анюта
 */
public class SessionBean {

    private final Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
    private HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
    public int idBookForReading;
    private Book ReadingBook;
    private ArrayList<Comment> Comments;
    private Comment addedComm;
    private final DAOBook daob = new DAOBook();

    public Principal getPrincipal() {
        return principal;
    }

    
    
    public int getIdBookForReading() {
        try {
            getReadingBook();
            getComments();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return idBookForReading;
        }
    }

    public String setIdBookForReading(int idBookForReading) {
        this.idBookForReading = idBookForReading;
        return "case1";
    }

    public Book getReadingBook() throws SQLException, ClassNotFoundException {
        try 
        {
            Book b = new Book(idBookForReading);
            ReadingBook = daob.read(b).get(0);
            //addedComm.setCommentedBook(ReadingBook);
            //b.setName("aaaaaa");
            //ReadingBook = b;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return ReadingBook;
        }
    }

    public void setReadingBook(Book ReadingBook) {
        this.ReadingBook = ReadingBook;
    }

    public ArrayList<Comment> getComments() {

        try {
            Comments = new ArrayList<>();
            DAOComment daoc = new DAOComment();
            Comments = daoc.read(ReadingBook);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return Comments;
        }
    }

    public void setComments(ArrayList<Comment> Comments) {
        this.Comments = Comments;
    }

    public Comment getAddedComm() {
        return addedComm;
    }

    public void setAddedComm(Comment addedComm) {
        this.addedComm = addedComm;
    }

    public String add() {
        try {
            //addedComm = new Comment();
            String username;
            
            username = principal.getName();
            
            DAOUser daou = new DAOUser();
            DAOReader daor = new DAOReader();
            User user = daou.getUserByUsername(username);
            Reader commentAuthor = daor.read(user.getId_visitor()).get(0);
            addedComm.setCommentAuthor(commentAuthor);
            DAOBook daob = new DAOBook();
            Book b = new Book(idBookForReading);
            b = daob.read(b).get(0);
            addedComm.setCommentedBook(b);
            addedComm.setStatus("Составлен");
            DAOComment daoc = new DAOComment();
            daoc.create(addedComm);
            return "ok";
        } catch (ClassNotFoundException | SQLException | NamingException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        }
    }

    public SessionBean() {

        addedComm = new Comment();
    }

}
