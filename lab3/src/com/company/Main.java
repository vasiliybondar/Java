package com.company;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String find = "Новий текстовий документ.TXT";
        File path = new File("C:");
        new SearchFile(find, path);
    }
}
