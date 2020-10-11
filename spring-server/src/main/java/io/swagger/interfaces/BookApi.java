/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.interfaces;

import io.swagger.annotations.*;
import io.swagger.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")

@Api(value = "book", description = "the book API")
@RequestMapping()
public interface BookApi {

    @ApiOperation(value = "Add new book information", nickname = "addbook", notes = "", tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "bad request(data already exist)") })
    @RequestMapping(value = "/book",
        produces = {"application/json"},
        consumes = { "application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Book> addbook(@ApiParam(value = "book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body);


    @ApiOperation(value = "Deletes a book", nickname = "deleteBook", notes = "", tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "book not found") })
    @RequestMapping(value = "/book/{bookCode}",
        produces = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBook(@ApiParam(value = "bookcode to delete",required=true) @PathVariable("bookCode") String bookCode);


    @ApiOperation(value = "Find all book", nickname = "getAllBook", notes = "Returns all book", response = Book.class, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Book.class),
        @ApiResponse(code = 404, message = "book info not found") })
    @RequestMapping(value = "/book",
        produces = {"application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Book>> getAllBook();


    @ApiOperation(value = "Find book by bookcode", nickname = "getBookById", notes = "Returns a single book info", response = Book.class, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Book.class),
        @ApiResponse(code = 400, message = "Invalid bookCode supplied"),
        @ApiResponse(code = 404, message = "book info not found") })
    @RequestMapping(value = "/book/{bookCode}",
        produces = {"application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Book> getBookById(@ApiParam(value = "code of book to return",required=true) @PathVariable("bookCode") String bookCode);


    @ApiOperation(value = "Update an existing book", nickname = "updateBook", notes = "", tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Book not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/book",
        produces = { "application/json" },
        consumes = { "application/json",},
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be update" ,required=true )  @Valid @RequestBody Book body);



    @ApiOperation(value = "Find book by title", nickname = "getBookByTitle", notes = "Returns a single book", response = Book.class, tags={ "book", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Book.class),
            @ApiResponse(code = 400, message = "Invalid title supplied"),
            @ApiResponse(code = 404, message = "book not found") })
    @RequestMapping(value = "/bookByTitle/{title}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBookByTitle(@ApiParam(value = "title of book to return",required=true) @PathVariable("title") String title);

    @ApiOperation(value = "Find book by author name", nickname = "getBookByAuthor", notes = "Returns a single book", response = Book.class, tags={ "book", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Book.class),
            @ApiResponse(code = 400, message = "Invalid author name supplied"),
            @ApiResponse(code = 404, message = "book not found") })
    @RequestMapping(value = "/bookByAuthor/{author}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBookByAuthor(@ApiParam(value = "author of book to return",required=true) @PathVariable("author") String author);



    @ApiOperation(value = "Find book by publisher name", nickname = "getBookByPublisher", notes = "Returns a single book", response = Book.class, tags={ "book", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Book.class),
            @ApiResponse(code = 400, message = "Invalid publisher name supplied"),
            @ApiResponse(code = 404, message = "book not found") })
    @RequestMapping(value = "/bookByPublisher/{publisher}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBookByPublisher(@ApiParam(value = "publisher of book to return",required=true) @PathVariable("publisher") String publisher);

}