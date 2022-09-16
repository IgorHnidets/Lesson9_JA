package JDBC.services;

import JDBC.entiti.User;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.exceptions.UserAlreadyExistException;
import JDBC.models.UserCredentials;

import java.util.List;

public interface UserService {


    //  TODO implement login method using method getByEmail from DAO
    User login(UserCredentials userCredentials) throws IncorectCredentialException;

    void save(User user) throws UserAlreadyExistException;

//    void remove(int id);
}
