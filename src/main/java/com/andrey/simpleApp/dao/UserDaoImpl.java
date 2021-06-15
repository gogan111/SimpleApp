package com.andrey.simpleApp.dao;

import com.andrey.simpleApp.config.DatabaseConfig;
import com.andrey.simpleApp.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public boolean saveUser(User user) {
        String INSERT = "INSERT INTO usr (name, surname, age) Values (?, ?, ?)";

        try (
                Connection connection = databaseConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String UPDATE = "UPDATE usr set (name, surname, age) = (?, ?, ?) WHERE id=?";

        try (
                Connection connection = databaseConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String SELECT_ALL = "SELECT * FROM usr ORDER BY id";

        try (
                Connection connection = databaseConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet set = preparedStatement.executeQuery();
        ) {
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String surname = set.getString(3);
                int age = set.getInt(4);

                User user = new User(id, name, surname, age);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(int userId) {
        String SELECT_BY_ID = "SELECT * FROM usr WHERE id = ?";

        try (
                Connection connection = databaseConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, userId);
            try (ResultSet set = preparedStatement.executeQuery()) {
                while (set.next()) {
                    int id = set.getInt(1);
                    String name = set.getString(2);
                    String surname = set.getString(3);
                    int age = set.getInt(4);

                    return new User(id, name, surname, age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        String DELETE = "DELETE FROM usr WHERE id = ?";

        try (
                Connection connection = databaseConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        ) {
            preparedStatement.setInt(1, userId);

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
