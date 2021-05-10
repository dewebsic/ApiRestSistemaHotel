package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.dtos.MethodPaymentDto;
import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.models.MethodPayment;
import com.angelsepulveda.apirestsistemahotel.services.contracts.MethodPaymentService;
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
@RequestMapping("api/v1/methodpayments")
public class MethodPaymentController {

    private final MethodPaymentService methodPaymentService;

    public MethodPaymentController(MethodPaymentService methodPaymentService){
        this.methodPaymentService = methodPaymentService;
    }

    @Operation(summary = "Obtener todos los MethodPayments",description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MethodPaymentDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<MethodPaymentDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.methodPaymentService.findAll());
    }

    @Operation(summary = "Obtener todos los MethodPayments paginados",description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MethodPayment.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<MethodPayment>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.methodPaymentService.findAll(pageable));
    }

    @Operation(summary = "buscar registros en los MethodPayments con resultados paginados",description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MethodPayment.class))})
    })
    @GetMapping("/search")
    public ResponseEntity<Page<MethodPayment>> search(@RequestParam String filter, Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.methodPaymentService.search(filter,pageable));
    }

    @Operation(summary = "Obtener un MethodPaymeent por su id",description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MethodPaymentDto.class)) }),
            @ApiResponse(responseCode = "404", description = "MethodPayment not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<MethodPaymentDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.methodPaymentService.findById(id));
    }


    @Operation(summary = "Agregar un MethodPayment", description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "MethodPayment created",
                    content = @Content(schema = @Schema(implementation = MethodPaymentDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<MethodPaymentDto> save(@RequestBody MethodPaymentDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.methodPaymentService.save(entity));
    }

    @Operation(summary = "Actualizar un MethodPayment", description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = MethodPaymentDto.class))),
            @ApiResponse(responseCode = "404", description = "MethodPayment not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<MethodPaymentDto> update(@PathVariable Long id,@RequestBody MethodPaymentDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.methodPaymentService.update(id,entity));
    }

    @Operation(summary = "Desactivar un MethodPayment", description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "MethodPayment not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.methodPaymentService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un MethodPayment", description = "", tags = { "methodPayment" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "MethodPayment not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.methodPaymentService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
