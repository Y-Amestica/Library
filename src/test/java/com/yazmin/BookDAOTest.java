package com;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.sql.*;

public class BookDAOTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private BookDAO bookDAO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    public void testGetBookByIsbn() throws Exception {
        // Configurar el comportamiento del mock
        Book expectedBook = new Book("1234567890", "El Quijote", "Miguel de Cervantes", 10, 5, "image.jpg");
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("isbn")).thenReturn(expectedBook.getIsbn());
        when(mockResultSet.getString("title")).thenReturn(expectedBook.getTitle());
        when(mockResultSet.getString("author")).thenReturn(expectedBook.getAuthor());
        when(mockResultSet.getInt("amountInLibrary")).thenReturn(expectedBook.getAmountInLibrary());
        when(mockResultSet.getInt("amountAvailable")).thenReturn(expectedBook.getAmountAvailable());
        when(mockResultSet.getString("image")).thenReturn(expectedBook.getImage());

        // Llamar al método a probar
        Book book = bookDAO.getBookByIsbn("1234567890");

        // Verificar el resultado
        assertEquals(expectedBook, book);
    }
}

