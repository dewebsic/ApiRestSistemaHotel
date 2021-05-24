package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.CustomerDto;
import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.models.Customer;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Obtener todos los Customers",description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.customerService.findAll());
    }

    @Operation(summary = "Obtener todos los customers paginados",description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<Customer>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.customerService.findAll(pageable));
    }

    @Operation(summary = "Obtener un Customer por su id",description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.customerService.findById(id));
    }


    @Operation(summary = "Agregar un Customer", description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created",
                    content = @Content(schema = @Schema(implementation = DocumentTypeDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.save(entity));
    }

    @Operation(summary = "Actualizar un Customer", description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = CustomerDto.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id,@RequestBody CustomerDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.update(id,entity));
    }

    @Operation(summary = "Desactivar un Customer", description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.customerService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un Customer", description = "", tags = { "customers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.customerService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
