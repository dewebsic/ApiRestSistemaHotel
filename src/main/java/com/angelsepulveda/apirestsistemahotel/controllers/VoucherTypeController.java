package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import com.angelsepulveda.apirestsistemahotel.services.contracts.VoucherTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vouchertypes")
public class VoucherTypeController {

    private final VoucherTypeService voucherTypeService;

    public VoucherTypeController(VoucherTypeService voucherTypeService){
        this.voucherTypeService = voucherTypeService;
    }

    @Operation(summary = "Obtener todos los VoucherTypes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping
    public ResponseEntity<List<VoucherType>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.findAll());
    }

    @Operation(summary = "Obtener un VoucherType por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el registro",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VoucherType.class)) }),
            @ApiResponse(responseCode = "404", description = "VoucherType not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<VoucherType> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.findById(id));
    }


    @Operation(summary = "Agregar un VoucherType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "VoucherType created",
                    content = @Content(schema = @Schema(implementation = VoucherType.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<VoucherType> save(@RequestBody VoucherType entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.voucherTypeService.save(entity));
    }

    @Operation(summary = "Actualizar un VoucherType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "VoucherType not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<VoucherType> update(@PathVariable Long id,@RequestBody VoucherType entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.voucherTypeService.update(id,entity));
    }
}
