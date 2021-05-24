package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.CategoryRoomDto;
import com.angelsepulveda.apirestsistemahotel.models.CategoryRoom;
import com.angelsepulveda.apirestsistemahotel.services.contracts.CategoryRoomService;
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
@RequestMapping("api/v1/categoryrooms")
@CrossOrigin(origins = "*")
public class CategoryRoomController {

    private final CategoryRoomService categoryRoomService;

    public CategoryRoomController(CategoryRoomService categoryRoomService) {
        this.categoryRoomService = categoryRoomService;
    }

    @Operation(summary = "Obtener todos los CategoryRoom",description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRoomDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<CategoryRoomDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryRoomService.findAll());
    }

    @Operation(summary = "Obtener todos los CategoryRoom paginados",description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRoom.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<CategoryRoom>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryRoomService.findAll(pageable));
    }

    @Operation(summary = "buscar registros en los CategoryRoom con resultados paginados",description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRoom.class))})
    })
    @GetMapping("/search")
    public ResponseEntity<Page<CategoryRoom>> search(@RequestParam String filter, Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryRoomService.search(filter,pageable));
    }

    @Operation(summary = "Obtener un CategoryRoom por su id",description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRoomDto.class)) }),
            @ApiResponse(responseCode = "404", description = "CategoryRoom not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryRoomDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryRoomService.findById(id));
    }


    @Operation(summary = "Agregar un CategoryRoom", description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CategoryRoom created",
                    content = @Content(schema = @Schema(implementation = CategoryRoomDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryRoomDto> save(@RequestBody CategoryRoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryRoomService.save(entity));
    }

    @Operation(summary = "Actualizar un CategoryRoom", description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = CategoryRoomDto.class))),
            @ApiResponse(responseCode = "404", description = "CategoryServi not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryRoomDto> update(@PathVariable Long id,@RequestBody CategoryRoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryRoomService.update(id,entity));
    }

    @Operation(summary = "Desactivar un CategoryRoom", description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "CategoryRoom not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.categoryRoomService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un CategoryRoom", description = "", tags = { "categoryRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "CategoryRoom not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.categoryRoomService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
