package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ReturnDAO {
    private Connection connection;
    public ReturnDAO(Connection connection){
        this.connection = connection;
    }
}
