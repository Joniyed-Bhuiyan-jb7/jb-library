/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.interfaces;

import io.swagger.model.Publisher;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")

@Api(value = "publisher", description = "the publisher API")
@RequestMapping()
public interface PublisherApi {

    @ApiOperation(value = "Add new publisher information", nickname = "addPublisher", notes = "", tags={ "publisher", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/publisher",
        produces = {"application/json" },
        consumes = { "application/json"},
        method = RequestMethod.POST)
    ResponseEntity<Publisher> addPublisher(@ApiParam(value = "member object that needs to be added to the store" ,required=true )  @Valid @RequestBody Publisher body);


    @ApiOperation(value = "Deletes a publisher information from db", nickname = "deletePublisherInfo", notes = "", tags={ "publisher", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "publisher info not found") })
    @RequestMapping(value = "/publisher/{id}",
        produces = {"application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePublisherInfo(@ApiParam(value = "publisher id to delete",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "Find all publisher info", nickname = "getAllPublisherInfo", notes = "Returns all publisher info ", response = Publisher.class, tags={ "publisher", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Publisher.class),
        @ApiResponse(code = 404, message = "publsher not found") })
    @RequestMapping(value = "/publisher",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Publisher>> getAllPublisherInfo();


    @ApiOperation(value = "Find publisher info by ID", nickname = "getPublisherById", notes = "Returns a single publisher info", response = Publisher.class, tags={ "publisher", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Publisher.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "member not found") })
    @RequestMapping(value = "/publisher/{id}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Publisher> getPublisherById(@ApiParam(value = "ID of publisher to return",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "Update an existing publisher info", nickname = "updatePublisher", notes = "", tags={ "publisher", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Publisher info  not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/publisher",
        produces = {"application/json" },
        consumes = { "application/json"},
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePublisher(@ApiParam(value = "Publisher object that needs to be update" ,required=true )  @Valid @RequestBody Publisher body);

}
