package hr.pravila.presentation.old.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;

import hr.pravila.presentation.old.dao.UserDao;
import hr.pravila.presentation.old.domain.User;

/**
 * @author stjep
 */
public class UserControllerDelegate {
    
    private static final Log log = LogFactory.getLog(UserControllerDelegate.class);
    
    private UserDao userDao;
    
    private XStream xstream;
    
    public void findAll(HttpServletRequest req, HttpServletResponse res) throws IOException {
        log.debug("Find all");
        List users = userDao.findAll();//of user
        writeResponse(users, res);
    }
    
    public void findByIdentificationNumber(HttpServletRequest req, HttpServletResponse res) throws IOException {
        log.debug("Find by identification number");
        String identificationNumber = req.getParameter("identificationNumber");
        User u = userDao.findByIdentificationNumber(identificationNumber);
        writeResponse(u, res);
    }
    
    public void save(HttpServletRequest req, HttpServletResponse res) throws IOException {
        log.debug("Converting to user from request body");
        InputStream is = req.getInputStream();
        User u = (User) xstream.fromXML(is);
        log.debug("Saving");
        u = userDao.save(u);
        writeResponse(u, res);
    }
    
    protected void writeResponse(Object obj, HttpServletResponse res) throws IOException {
        log.debug("Writing response");
        res.setContentType("application/xml");
        OutputStreamWriter osw = null;
        try {
        	osw = new OutputStreamWriter(res.getOutputStream(), StandardCharsets.UTF_8);
        	xstream.toXML(obj, osw);
        } finally {
        	if (osw != null) {
        		osw.close();
        	}
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public XStream getXstream() {
        return xstream;
    }

    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }
}