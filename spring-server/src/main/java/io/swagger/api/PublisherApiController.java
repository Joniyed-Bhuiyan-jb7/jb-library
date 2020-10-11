package io.swagger.api;

import io.swagger.exception.ResourceAlreadyExistsException;
import io.swagger.exception.ResourceDoesNotExistsException;
import io.swagger.interfaces.PublisherApi;
import io.swagger.model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.PublisherApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")

@Controller
public class PublisherApiController implements PublisherApi {

    private PublisherApiService publisherApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public PublisherApiController(PublisherApiService publisherApiService) {
        this.publisherApiService = publisherApiService;
    }

    public ResponseEntity<Publisher> addPublisher(@ApiParam(value = "publisher object that needs to be added to the store" ,required=true )  @Valid @RequestBody Publisher body) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(publisherApiService.addPublisher(body));
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deletePublisherInfo(@ApiParam(value = "publisher id to delete",required=true) @PathVariable("id") String id) {
        try {
            publisherApiService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<List<Publisher>> getAllPublisherInfo() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(publisherApiService.getAllPublisher());
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Publisher> getPublisherById(@ApiParam(value = "ID of publisher to return",required=true) @PathVariable("id") String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(publisherApiService.getPublisherById(id));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Void> updatePublisher(@ApiParam(value = "Publisher object that needs to be update" ,required=true )  @Valid @RequestBody Publisher body) {
        try {
            publisherApiService.update(body);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
