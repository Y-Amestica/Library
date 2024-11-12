import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LoanDAO {
    private Connection connection;
    public LoanDAO(Connection connection){
        this.connection = connection;
    }
}
