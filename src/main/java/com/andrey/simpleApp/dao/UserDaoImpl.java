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
        try (Connection connection = databaseConfig.getConnection()) {
            String sql = "INSERT INTO usr (name, surname, age) Values (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = databaseConfig.getConnection()) {
            String sql = "UPDATE usr set (name, surname, age) = (?, ?, ?) WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = databaseConfig.getConnection()) {

            String sql = "SELECT * FROM usr ORDER BY id";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String surname = set.getString(3);
                int age = set.getInt(4);

                User user = new User(id, name, surname, age);

                users.add(user);
            }
            return users;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean deleteUser(int userId) {

        try (Connection connection = databaseConfig.getConnection()) {
            String sql = "DELETE FROM usr WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            return preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUser(int userId) {

        try (Connection connection = databaseConfig.getConnection()) {
            String sql = "SELECT * FROM usr WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet set = preparedStatement.executeQuery();
            while(set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String surname = set.getString(3);
                int age = set.getInt(4);
                User user = new User(id, name, surname, age);
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
