package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.ServiceRoomDto;
import com.angelsepulveda.apirestsistemahotel.models.ServiceRoom;
import com.angelsepulveda.apirestsistemahotel.services.contracts.ServiceRoomService;
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
@RequestMapping("api/v1/servicerooms")
@CrossOrigin(origins = "*")
public class ServiceRoomController {

    private final ServiceRoomService serviceRoomService;

    public ServiceRoomController(ServiceRoomService serviceRoomService) {
        this.serviceRoomService = serviceRoomService;
    }

    @Operation(summary = "Obtener todos los ServiceRoom",description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceRoomDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<ServiceRoomDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceRoomService.findAll());
    }

    @Operation(summary = "Obtener todos los ServiceRooms paginados",description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceRoom.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<ServiceRoom>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceRoomService.findAll(pageable));
    }

    @Operation(summary = "Obtener un ServiceRoom por su id",description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceRoomDto.class)) }),
            @ApiResponse(responseCode = "404", description = "ServiceRoom not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<ServiceRoomDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceRoomService.findById(id));
    }


    @Operation(summary = "Agregar un ServiceRoom", description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ServiceRoom created",
                    content = @Content(schema = @Schema(implementation = ServiceRoomDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<ServiceRoomDto> save(@RequestBody ServiceRoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.serviceRoomService.save(entity));
    }

   @Operation(summary = "Actualizar un ServiceRoom", description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ServiceRoomDto.class))),
            @ApiResponse(responseCode = "404", description = "ServiceRoom not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<ServiceRoomDto> update(@PathVariable Long id,@RequestBody ServiceRoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.serviceRoomService.update(id,entity));
    }

    @Operation(summary = "Desactivar un ServiceRoom", description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "ServiceRoom not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.serviceRoomService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un ServiceRoom", description = "", tags = { "serviceRoom" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "ServiceRoom not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.serviceRoomService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
