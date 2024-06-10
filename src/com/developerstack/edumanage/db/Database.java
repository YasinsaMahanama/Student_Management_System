package com.developerstack.edumanage.db;

import com.developerstack.edumanage.model.Student;
import com.developerstack.edumanage.model.User;
import com.developerstack.edumanage.util.security.PasswordManager;

import javax.management.relation.Role;
import java.util.ArrayList;

public class Database {
    public static ArrayList<User> usersTable = new ArrayList<>();
    public static ArrayList<Student> studentTable = new ArrayList<>();

    static {
        usersTable.add(
                new User("Hasika", "Sandaruwan","hasika@gmail.com", new PasswordManager().encrypt("1234"))
        );
    }
}
