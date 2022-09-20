package JDBC.services;

import JDBC.entiti.User;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.exceptions.UserAlreadyExistException;
import JDBC.exceptions.UserNotFoundException;
import JDBC.models.UserCredentials;

import java.sql.SQLException;
import java.util.List;

public interface UserService {


    //  TODO implement login method using method getByEmail from DAO
    User login(UserCredentials userCredentials) throws IncorectCredentialException;

    void save(User user) throws UserAlreadyExistException;
    User getById(int id) throws UserNotFoundException, SQLException;

//    void remove(int id);
}
