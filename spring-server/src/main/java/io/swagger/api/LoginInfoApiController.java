package io.swagger.api;

import io.swagger.exception.ResourceAlreadyExistsException;
import io.swagger.exception.ResourceDoesNotExistsException;
import io.swagger.interfaces.LoginApi;
import io.swagger.interfaces.LoginInfoApi;
import io.swagger.model.LoginInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.LoginInfoApiService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")

@Controller
public class LoginInfoApiController implements LoginInfoApi, LoginApi {

    private LoginInfoApiService loginInfoApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginInfoApiController(LoginInfoApiService loginInfoApiService) {
        this.loginInfoApiService = loginInfoApiService;
    }

    public ResponseEntity<Void> addLoginInfo(@ApiParam(value = "login info object that needs to be added to the store" ,required=true )  @Valid @RequestBody LoginInfo body) {
        try {
            loginInfoApiService.addLogin(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> updateLoginInfo(@ApiParam(value = "Login info object that needs to be update" ,required=true )  @Valid @RequestBody LoginInfo body) {
        try {
            loginInfoApiService.updateLogin(body);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deleteLoginInfo(@ApiParam(value = "borrow info id to delete",required=true) @PathVariable("username") String username) {
        try {
            loginInfoApiService.delete(username);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<LoginInfo> getLoginByUsername(@ApiParam(value = "ID of login information to return",required=true) @PathVariable("username") String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(loginInfoApiService.getLoginByUserName(username));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
