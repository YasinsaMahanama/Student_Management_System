package com.developerstack.edumanage.util.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {

    public String encrypt(String rowPassword){
        return BCrypt.hashpw(rowPassword, BCrypt.gensalt(10));
    }

    public boolean checkPassword(String rowPassword, String hashedPassword){
        return BCrypt.checkpw(rowPassword, hashedPassword);
    }
}
