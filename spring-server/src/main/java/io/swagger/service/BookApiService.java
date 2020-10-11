package io.swagger.service;import io.swagger.exception.ResourceAlreadyExistsException;import io.swagger.exception.ResourceDoesNotExistsException;import io.swagger.model.Book;import io.swagger.repository.BookApiRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;@Servicepublic class BookApiService {    @Autowired    private BookApiRepository bookApiRepository;    public Book addBook(Book body) throws ResourceAlreadyExistsException {        if(!bookApiRepository.exists(body.getBookCode())){            return bookApiRepository.save(body);        }        else{            throw new ResourceAlreadyExistsException(body.getBookCode());        }    }    public void deleteBook(String bookCode) throws ResourceDoesNotExistsException {        if(bookApiRepository.exists(bookCode)){            bookApiRepository.delete(bookCode);        }else{            throw new ResourceDoesNotExistsException(bookCode);        }    }    public List<Book> getAllBook() throws ResourceDoesNotExistsException {        List<Book> books = new ArrayList<>();        bookApiRepository.findAll().forEach(books::add);        if(!books.isEmpty()){          return books;        }else{            throw new ResourceDoesNotExistsException("empty");        }    }    public Book getBookById(String bookCode) throws ResourceDoesNotExistsException {        if(bookApiRepository.exists(bookCode)){            return bookApiRepository.findOne(bookCode);        }else{            throw new ResourceDoesNotExistsException("book not found");        }    }    public void updateBook(Book body) throws ResourceDoesNotExistsException {        if(bookApiRepository.exists(body.getBookCode())){            bookApiRepository.delete(body.getBookCode());            bookApiRepository.save(body);        }else{            throw new ResourceDoesNotExistsException("no content");        }    }    public List<Book> findByName(String name) throws ResourceDoesNotExistsException {        List<Book> byTitle = new ArrayList<>();        bookApiRepository.findByTitle(name).forEach(byTitle::add);        if(!byTitle.isEmpty()){            return byTitle;        }else{            throw new ResourceDoesNotExistsException(name);        }    }    public List<Book> findByAuthor(String author) throws ResourceDoesNotExistsException {        List<Book> byAuthor = new ArrayList<>();        bookApiRepository.findByAuthor(author).forEach(byAuthor::add);        if(!byAuthor.isEmpty()){            return byAuthor;        }else{            throw new ResourceDoesNotExistsException(author);        }    }    public List<Book> findByPublisher(String publisher) throws ResourceDoesNotExistsException {        List<Book> byPublisher = new ArrayList<>();        bookApiRepository.findByPublisher(publisher).forEach(byPublisher::add);        if(!byPublisher.isEmpty()){            return byPublisher;        }else{            throw new ResourceDoesNotExistsException(publisher);        }    }}