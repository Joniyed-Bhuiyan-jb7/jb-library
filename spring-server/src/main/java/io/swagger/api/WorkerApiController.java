package io.swagger.api;

import io.swagger.exception.ResourceAlreadyExistsException;
import io.swagger.exception.ResourceDoesNotExistsException;
import io.swagger.interfaces.WorkerApi;
import io.swagger.interfaces.WorkerByNameApi;
import io.swagger.model.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.WorkerApiRepository;
import io.swagger.service.WorkerApiService;
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
public class WorkerApiController implements WorkerApi, WorkerByNameApi {


    private WorkerApiService workerApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public WorkerApiController(WorkerApiService workerApiService) {
        this.workerApiService = workerApiService;
    }

    public ResponseEntity<Worker> addWorker(@ApiParam(value = "member object that needs to be added to the store" ,required=true )  @Valid @RequestBody Worker body) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(workerApiService.addWorker(body));
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> deleteWorker(@ApiParam(value = "worker id to delete",required=true) @PathVariable("id") String id) {
        try {
            workerApiService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<List<Worker>> getAllWorker() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerApiService.getAllWorker());
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Worker> getWorkerById(@ApiParam(value = "ID of worker to return",required=true) @PathVariable("id") String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerApiService.getWorkerById(id));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<Void> updateWorker(@ApiParam(value = "Worker object that needs to be update" ,required=true )  @Valid @RequestBody Worker body) {
        try {
            workerApiService.update(body);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    public ResponseEntity<List<Worker>> getWorkerByName(@ApiParam(value = "name of worker to return",required=true) @PathVariable("name") String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerApiService.getWorkerByName(name));
        } catch (ResourceDoesNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


}
