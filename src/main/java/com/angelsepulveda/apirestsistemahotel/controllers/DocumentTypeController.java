package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.models.DocumentType;
import com.angelsepulveda.apirestsistemahotel.services.contracts.DocumentTypeService;
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
@RequestMapping("api/v1/documenttypes")
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    public DocumentTypeController(DocumentTypeService documentTypeService){
        this.documentTypeService = documentTypeService;
    }

    @Operation(summary = "Obtener todos los DocumentTypes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping
    public ResponseEntity<List<DocumentType>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.documentTypeService.findAll());
    }

    @Operation(summary = "Obtener un DocumentType por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DocumentType.class)) }),
            @ApiResponse(responseCode = "404", description = "DocumentType not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.documentTypeService.findById(id));
    }


    @Operation(summary = "Agregar un DocumentType", description = "", tags = { "documentType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DocumentType created",
                    content = @Content(schema = @Schema(implementation = DocumentType.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<DocumentType> save(@RequestBody DocumentType entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.documentTypeService.save(entity));
    }

    @Operation(summary = "Actualizar un DocumentType", description = "", tags = { "documentType" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "DocumentType not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<DocumentType> update(@PathVariable Long id,@RequestBody DocumentType entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.documentTypeService.update(id,entity));
    }
}
