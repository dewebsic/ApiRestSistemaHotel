package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.dtos.VoucherTypeDto;
import com.angelsepulveda.apirestsistemahotel.models.VoucherType;
import com.angelsepulveda.apirestsistemahotel.services.contracts.VoucherTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vouchertypes")
@CrossOrigin(origins = "*")
public class VoucherTypeController {

    private final VoucherTypeService voucherTypeService;

    public VoucherTypeController(VoucherTypeService voucherTypeService){
        this.voucherTypeService = voucherTypeService;
    }

    @Operation(summary = "Obtener todos los VoucherTypes",description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DocumentTypeDto.class))})
    })
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<VoucherTypeDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.findAll());
    }

    @Operation(summary = "Obtener todos los VoucherTypes paginados",description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VoucherType.class))})
    })
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paged")
    public ResponseEntity<Page<VoucherType>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.findAll(pageable));
    }

    @Operation(summary = "buscar registros en los VoucherTypes con resultados paginados",description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VoucherType.class))})
    })
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/search")
    public ResponseEntity<Page<VoucherType>> search(@RequestParam String filter, Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.search(filter,pageable));
    }

    @Operation(summary = "Obtener un VoucherType por su id",description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VoucherTypeDto.class)) }),
            @ApiResponse(responseCode = "404", description = "VoucherType not found",
                    content = @Content) })
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<VoucherTypeDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.voucherTypeService.findById(id));
    }


    @Operation(summary = "Agregar un VoucherType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "VoucherType created",
                    content = @Content(schema = @Schema(implementation = VoucherTypeDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<VoucherTypeDto> save(@RequestBody VoucherTypeDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.voucherTypeService.save(entity));
    }

    @Operation(summary = "Actualizar un VoucherType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = VoucherTypeDto.class))),
            @ApiResponse(responseCode = "404", description = "VoucherType not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<VoucherTypeDto> update(@PathVariable Long id,@RequestBody VoucherTypeDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.voucherTypeService.update(id,entity));
    }

    @Operation(summary = "Desactivar un VoucherType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.voucherTypeService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un DocumentType", description = "", tags = { "voucherType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.voucherTypeService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
