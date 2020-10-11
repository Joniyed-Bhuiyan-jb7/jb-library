package io.swagger.model;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Book
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-10T06:19:32.249Z")



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Book   {
    @Id
    private String bookCode;
    @Column(length = 255,nullable = false)
    private String title;
    @Column(length = 255,nullable = false)
    private String subject;
    @Column(length = 30,nullable = false)
    private String edition;
    @Column(length = 255,nullable = false)
    private String author;
    @Column(nullable = false)
    private LocalDate publish_date;
    @Column(nullable = false)
    private double price;
    @Column(length = 255,nullable = false)
    private String publisher;
}

