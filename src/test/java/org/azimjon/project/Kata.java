package org.azimjon.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Kata {
    public static void main(String[] args) {
        System.out.println(getUserById("!234"));
        StringBuilder as = new StringBuilder();
        as.append("1");
        as.
        System.out.println(as);
    }

    public static String getUserById(String id) {
        String query = String.format("SELECT * FROM users WHERE id = %s", id);
        return query;
    }
}