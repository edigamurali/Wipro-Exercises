package com.wipro.thread;

import java.util.Arrays;
import java.util.List;

public class RunnableThread {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Murali", "Vishnu", "Ajay", "Emanul", "Rajesh", "Obu", "uday");

        // Thread for capitalizing names starting with vowels
        Runnable r1 = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (name.substring(0, 1).equalsIgnoreCase("a") ||
                    name.substring(0, 1).equalsIgnoreCase("e") ||
                    name.substring(0, 1).equalsIgnoreCase("i") ||
                    name.substring(0, 1).equalsIgnoreCase("o") ||
                    name.substring(0, 1).equalsIgnoreCase("u")) {
                    
                    names.set(i, name.toUpperCase());
                }
            }
        };

        // Thread for lowercasing names not starting with vowels
        Runnable r2 = () -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (!(name.substring(0, 1).equalsIgnoreCase("a") ||
                      name.substring(0, 1).equalsIgnoreCase("e") ||
                      name.substring(0, 1).equalsIgnoreCase("i") ||
                      name.substring(0, 1).equalsIgnoreCase("o") ||
                      name.substring(0, 1).equalsIgnoreCase("u"))) {

                    names.set(i, name.toLowerCase());
                }
            }
        };

        Thread vowelThread = new Thread(r1);
        Thread consonantThread = new Thread(r2);

        vowelThread.start();
        consonantThread.start();

        try {
            vowelThread.join();
            consonantThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( names);
    }
}
