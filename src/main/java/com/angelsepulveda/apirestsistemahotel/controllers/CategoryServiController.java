package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryServiDto;
import com.angelsepulveda.apirestsistemahotel.dtos.DocumentTypeDto;
import com.angelsepulveda.apirestsistemahotel.models.CategoryServi;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CategoryServiService;
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
@RequestMapping("api/v1/categoryservices")
public class CategoryServiController {

    private final CategoryServiService categoryServiService;

    public CategoryServiController(CategoryServiService categoryServiService) {
        this.categoryServiService = categoryServiService;
    }

    @Operation(summary = "Obtener todos los CategoryServi",description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryServiDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<CategoryServiDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryServiService.findAll());
    }

    @Operation(summary = "Obtener todos los CategoryServi paginados",description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryServi.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<CategoryServi>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryServiService.findAll(pageable));
    }

    @Operation(summary = "buscar registros en los CategoryServi con resultados paginados",description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryServi.class))})
    })
    @GetMapping("/search")
    public ResponseEntity<Page<CategoryServi>> search(@RequestParam String filter, Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryServiService.search(filter,pageable));
    }

    @Operation(summary = "Obtener un CategoryServi por su id",description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryServiDto.class)) }),
            @ApiResponse(responseCode = "404", description = "CategoryServi not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryServiDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryServiService.findById(id));
    }


    @Operation(summary = "Agregar un CategoryServi", description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CategoryServi created",
                    content = @Content(schema = @Schema(implementation = DocumentTypeDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<CategoryServiDto> save(@RequestBody CategoryServiDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryServiService.save(entity));
    }

    @Operation(summary = "Actualizar un CategoryServi", description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = CategoryServiDto.class))),
            @ApiResponse(responseCode = "404", description = "CategoryServi not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryServiDto> update(@PathVariable Long id,@RequestBody CategoryServiDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryServiService.update(id,entity));
    }

    @Operation(summary = "Desactivar un CategoryServi", description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "CategoryServi not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.categoryServiService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un CategoryServi", description = "", tags = { "categoryServi" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "CategoryServi not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.categoryServiService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
