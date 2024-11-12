package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
    private Connection connection;
    public UserDAO(Connection connection){
        this.connection = connection;
    }
}
