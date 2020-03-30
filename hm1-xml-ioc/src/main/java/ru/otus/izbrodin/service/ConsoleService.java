package ru.otus.izbrodin.service;

import java.util.Scanner;

public class ConsoleService implements IOService {

    @Override
    public String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void printLine(String text) {
        System.out.println(text);
    }
}
