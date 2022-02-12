package com.vignesh.basics.oops;

public class DefaultMethodDemo implements FileWriter,ConsoleWriter{
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    @Override
    public void writeFile(String s) {

    }

    @Override
    public void writeConsole(String s) {

    }
}

interface FileWriter {
//    default void write(String s) {
//        System.out.println("FileWriter::write");
//    }
    public void writeFile(String s);
}

interface ConsoleWriter {
    default void write(String s) {
        System.out.println("ConsoleWriter::write");
    }
    public void writeConsole(String s);
}
