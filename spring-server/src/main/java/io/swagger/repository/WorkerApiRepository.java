package io.swagger.repository;import io.swagger.model.Worker;import org.springframework.data.repository.CrudRepository;import org.springframework.stereotype.Repository;import java.util.List;@Repositorypublic interface WorkerApiRepository extends CrudRepository<Worker,String> {    Iterable<Worker> findByName(String name);}