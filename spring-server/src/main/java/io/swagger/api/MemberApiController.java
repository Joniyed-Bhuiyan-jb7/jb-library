package io.swagger.api;

import io.swagger.exception.ResourceAlreadyExistsException;
import io.swagger.exception.ResourceDoesNotExistsException;
import io.swagger.interfaces.MemberApi;
import io.swagger.interfaces.MemberByNameApi;
import io.swagger.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.MemberApiService;
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
public class MemberApiController implements MemberApi, MemberByNameApi {

    private MemberApiService memberApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public MemberApiController(MemberApiService memberApiService) {
        this.memberApiService = memberApiService;
    }

    public ResponseEntity<Void> addmember(@ApiParam(value = "member object that needs to be added to the store" ,required=true )  @Valid @RequestBody Member body) {
        try {
            memberApiService.addMember(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deletemember(@ApiParam(value = "member id to delete",required=true) @PathVariable("id") String username) {
        try {
            memberApiService.delete(username);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<List<Member>> getAllMember() {
        try {
            List<Member> members = memberApiService.geAllMember();
            return ResponseEntity.status(HttpStatus.OK).body(members);
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Member> getMemberById(@ApiParam(value = "ID of member to return",required=true) @PathVariable("id") String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(memberApiService.getMemberByUsername(username));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Void> updateMember(@ApiParam(value = "Member object that needs to be update" ,required=true )  @Valid @RequestBody Member body) {
        try {
            memberApiService.update(body);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    public ResponseEntity<List<Member>> getMemberByName(@ApiParam(value = "name of member to return",required=true) @PathVariable("name") String name) {
        try {
            List<Member> memberByName = memberApiService.getMemberByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(memberByName);
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


}
