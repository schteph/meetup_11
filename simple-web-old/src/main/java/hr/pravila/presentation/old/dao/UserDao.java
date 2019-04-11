package hr.pravila.presentation.old.dao;

import java.util.List;

import hr.pravila.presentation.old.domain.User;

/**
 * @author stjep
 */
public interface UserDao {

    /**
     * 
     * @return {@link List} of all the {@link User users} in the db.
     */
    List findAll();

    /**
     * @param identificationNumber
     * @return Returns the user with the identification number, or <code>null</code> if no such user exists.
     */
    User findByIdentificationNumber(String identificationNumber);
    
    User save(User user);
}
