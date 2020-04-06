package ru.otus.hm3.izbrodin.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
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
