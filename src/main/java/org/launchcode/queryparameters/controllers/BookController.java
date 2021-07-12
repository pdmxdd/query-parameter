package org.launchcode.queryparameters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    // test this file out!
    // in your browser make a request to http://localhost:8080/book
    // http://localhost:8080/book/author?authorName=King
    // http://localhost:8080/book/author?authorName=Zakas
    // http://localhost:8080/book/title?titleName=It
    // http://localhost:8080/book/title?titleName=Understanding%20Ecmascript%206

    // GET /book -> returns a JSON List of all the books
    @GetMapping
    @ResponseBody
    public ArrayList<HashMap<String, String>> getAllBooks() {
        ArrayList<HashMap<String,String>> books = generateBooks();
        return books;
    }

    // GET /book/author?author=authorName -> returns a JSON List of all of the books matching the query parameter authorName
    @GetMapping(value = "/author")
    @ResponseBody
    public ArrayList<HashMap<String, String>> getBooksByAuthor(@RequestParam String authorName) {
        ArrayList<HashMap<String, String>> books = generateBooks();
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("author").equals(authorName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // GET /book/title?title=titleName -> returns a JSON List of all of the books matching the query parameter titleName
    @GetMapping(value = "/title")
    @ResponseBody
    public ArrayList<HashMap<String, String>> getBooksByTitle(@RequestParam String titleName) {
        ArrayList<HashMap<String, String>> books = generateBooks();
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("title").equals(titleName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // helper method. it just generates and returns a list of book-like objects (HashMaps)
    public static ArrayList<HashMap<String, String>> generateBooks() {
        ArrayList<HashMap<String, String>> books = new ArrayList<>();
        HashMap<String, String> bookOne = new HashMap<>();
        bookOne.put("title", "It");
        bookOne.put("author", "King");
        bookOne.put("ISBN", "9048qhf");
        HashMap<String, String> bookTwo = new HashMap<>();
        bookTwo.put("title", "Understanding Ecmascript 6");
        bookTwo.put("author", "Zakas");
        bookTwo.put("ISBN", "1-59327-757-1");
        HashMap<String, String> bookThree = new HashMap<>();
        bookThree.put("title", "Salem's Lot");
        bookThree.put("author", "King");
        bookThree.put("ISBN", "43q0978yf");
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        return books;
    }
}
