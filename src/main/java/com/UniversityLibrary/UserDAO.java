package com.UniversityLibrary;

import java.util.ArrayList;
import java.util.List;

//Lista de Usuarios: Utiliza una lista en memoria para almacenar los usuarios.
//Datos de Prueba: Inicializa la lista con algunos datos de prueba.
//Métodos CRUD: Implementa métodos para crear, leer, actualizar y eliminar usuarios.

public class UserDAO {
    private List<User> users;

    public UserDAO(){
        this.users = new ArrayList<>();
        //Add some test data
        users.add(new Student("Yazmin", "12.458.358-1", 'F', "Computer Science"));
        users.add(new Teacher("Roberto", "9.852.458-2", 'M', "Accountant"));
    }
    // Obtiene un usuario por su ID
    public User getUserById(String id){
        for (User user : users){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
    // Añade un nuevo usuario a la lista
    public void addUser(User user){
        users.add(user);
    }
    // Actualiza un usuario existente
    public void updateUser(User user){
        for (int i = 0; i <users.size(); i++){
            if (users.get(i).getId().equals(user.getId())){
                users.set(i,user);
                return;
            }
        }
    }
    // Elimina un usuario por su ID
    public void deleteUser(String id){
        users.removeIf(user -> user.getId().equals(id));
    }
    // Obtiene todos los usuarios

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
