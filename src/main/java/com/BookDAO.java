import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public Book getBookByIsbn(String isbn) throws SQLException {
        String query = "SELECT * FROM books WHERE isbn = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("amountInLibrary"),
                        rs.getInt("amountAvailable"),
                        rs.getString("image")
                );
            }
        }
        return null;
    }
}
