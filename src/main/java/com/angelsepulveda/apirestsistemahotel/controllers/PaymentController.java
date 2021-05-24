package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.PaymentDto;
import com.angelsepulveda.apirestsistemahotel.models.Payment;
import com.angelsepulveda.apirestsistemahotel.services.contracts.PaymentService;
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
@RequestMapping("api/v1/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Obtener todos los Payments",description = "", tags = { "payments" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Payment.class))})
    })
    @GetMapping
    public ResponseEntity<List<Payment>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.paymentService.findAll());
    }

    @Operation(summary = "Obtener todos los payments paginados",description = "", tags = { "payments" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Payment.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<Payment>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.paymentService.findAll(pageable));
    }

    @Operation(summary = "Obtener un Payment por su id",description = "", tags = { "payments" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Payment.class)) }),
            @ApiResponse(responseCode = "404", description = "Payment not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.paymentService.findById(id));
    }


    @Operation(summary = "Agregar un Payment", description = "", tags = { "payments" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created",
                    content = @Content(schema = @Schema(implementation = Payment.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody PaymentDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.paymentService.save(entity));
    }


    @Operation(summary = "Anular Payment", description = "", tags = { "payments" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Payment not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/cancel/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.paymentService.cancel(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Anulado Correctamente");
    }


}
