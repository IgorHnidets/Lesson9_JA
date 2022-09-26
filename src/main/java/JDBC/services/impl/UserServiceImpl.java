package JDBC.services.impl;


import JDBC.dao.BucketDao;
import JDBC.dao.UserDao;
import JDBC.entiti.User;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.exceptions.UserAlreadyExistException;
import JDBC.exceptions.UserNotFoundException;
import JDBC.models.UserCredentials;
import JDBC.services.UserService;

import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BucketDao bucketDao;

    public UserServiceImpl(UserDao userDao, BucketDao bucketDao) {
        this.userDao = userDao;
        this.bucketDao = bucketDao;
    }


//  TODO implement login method using method getByEmail from DAO
    @Override
    public User login(UserCredentials userCredentials) throws IncorectCredentialException {
        try {
            Optional<User> getbyEmail = userDao.getbyEmail(userCredentials.getEmail());
            if (getbyEmail.isPresent()){
                User user = getbyEmail.get();

                if (user.getPassword().equals(userCredentials.getPassword())){
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        throw new IncorectCredentialException();
    }

    @Override
    public void save(User user) throws UserAlreadyExistException {
        try {
            Optional<User> byEmail = userDao.getbyEmail(user.getEmail());
            if (byEmail.isPresent()){
                throw new UserAlreadyExistException();
            }
            int saveId = userDao.insert(user);
            bucketDao.create(saveId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getById(int id) throws UserNotFoundException, SQLException {
            Optional<User> user = userDao.getbyId(id);

            if (user.isPresent()) {
                return user.get();
            }
            throw new UserNotFoundException();
        }
    }



