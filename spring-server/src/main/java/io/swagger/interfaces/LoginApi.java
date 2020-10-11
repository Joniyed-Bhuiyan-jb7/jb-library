/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.interfaces;

import io.swagger.model.LoginInfo;
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

@Api(value = "login", description = "the login API")
@RequestMapping()
public interface LoginApi {

    @ApiOperation(value = "Delete a login info", nickname = "deleteLoginInfo", notes = "", tags={ "login_info", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "borrow info not found") })
    @RequestMapping(value = "/login/{username}",
        produces = {"application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLoginInfo(@ApiParam(value = "borrow info id to delete",required=true) @PathVariable("username") String username);


    @ApiOperation(value = "Find inforamtion by username", nickname = "getLoginByUsername", notes = "Returns a single login info", response = LoginInfo.class, tags={ "login_info", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = LoginInfo.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "information not found") })
    @RequestMapping(value = "/login/{username}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<LoginInfo> getLoginByUsername(@ApiParam(value = "ID of login information to return",required=true) @PathVariable("username") String username);

}
