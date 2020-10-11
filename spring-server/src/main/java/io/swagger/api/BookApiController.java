package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.exception.ResourceAlreadyExistsException;
import io.swagger.exception.ResourceDoesNotExistsException;
import io.swagger.interfaces.BookApi;
import io.swagger.model.Book;
import io.swagger.service.BookApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")

@Controller
public class BookApiController implements BookApi {


    private BookApiService bookApiService;
    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    public ResponseEntity<Book> addbook(@ApiParam(value = "book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookApiService.addBook(body));
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deleteBook(@ApiParam(value = "bookCode to delete",required=true) @PathVariable("bookCode") String bookCode) {
        try {
            bookApiService.deleteBook(bookCode);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<List<Book>> getAllBook() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookApiService.getAllBook());
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "bookCode of book to return",required=true) @PathVariable("bookCode") String bookCode) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookApiService.getBookById(bookCode));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be update" ,required=true )  @Valid @RequestBody Book body) {
        try {
            bookApiService.updateBook(body);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<List<Book>> getBookByTitle(@ApiParam(value = "title of book to return",required=true) @PathVariable("title") String title) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookApiService.findByName(title));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<List<Book>> getBookByAuthor(@ApiParam(value = "author of book to return",required=true) @PathVariable("author") String author) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookApiService.findByAuthor(author));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    public ResponseEntity<List<Book>> getBookByPublisher(@ApiParam(value = "Publisher of book to return",required=true) @PathVariable("publisher") String publisher) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookApiService.findByPublisher(publisher));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
