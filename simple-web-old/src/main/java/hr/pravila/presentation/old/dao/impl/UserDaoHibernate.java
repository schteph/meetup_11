package hr.pravila.presentation.old.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import hr.pravila.presentation.old.dao.UserDao;
import hr.pravila.presentation.old.domain.User;

/**
 * @author stjep
 */
public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {
    
    private static final Log log = LogFactory.getLog(UserDaoHibernate.class);
    
    public List findAll() {
        log.debug("Finding all");
        return getHibernateTemplate().loadAll(User.class);
    }

    public User findByIdentificationNumber(String identificationNumber) {
        log.debug("Finding by identification number");
        List l = getHibernateTemplate().find("from User where identificationNumber = ?", 
        		identificationNumber);
        if (l.isEmpty()) {
            return null;
        }
        return (User) l.get(0);
    }

    public User save(User user) {
        log.debug("Saving user");
        if (user.getId() == null) {
            Long id = (Long) getHibernateTemplate().save(user);
            user.setId(id);
        } else {
            getHibernateTemplate().saveOrUpdate(user);
        }
        return user;
    }
    
}
