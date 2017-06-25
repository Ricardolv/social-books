package com.richard.socialbooks.client;


import com.richard.socialbooks.client.domain.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Application {

    private static final String URL = "http://localhost:8080";
    private static final String USER = "richard";
    private static final String PASSWORD = "senha";

    public static void main(String[] args) throws ParseException {

       BooksClient client = new BooksClient(URL, USER, PASSWORD);
       List<Book> listBooks = client.list();

        for (Book book : listBooks) {
            System.out.println("livro: " + book.getName());
        }

        Book book = new Book();
        book.setName("Rest aplicado volume II");
        book.setPublishers("RichardSoftware");

        SimpleDateFormat publication = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        book.setPublication(publication.parse("25/06/2017 13:50"));

        book.setResume("este livro aborda tecnicas de desenvolvimento de APIS.");

        String location = client.save(book);
        System.out.println("URI do livro salvo: " + location);

        Book returnBook = client.search(location);

        System.out.println("Livro buscado: " + returnBook.getName());

    }

}
