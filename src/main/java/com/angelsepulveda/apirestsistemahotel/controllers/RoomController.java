package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.dtos.RoomDto;
import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.services.contracts.RoomService;
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
@RequestMapping("api/v1/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Operation(summary = "Obtener todos los Rooms",description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomDto.class))})
    })
    @GetMapping
    public ResponseEntity<List<RoomDto>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.roomService.findAll());
    }

    @Operation(summary = "Obtener todos los rooms paginados",description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<Room>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.roomService.findAll(pageable));
    }

    @Operation(summary = "Obtener un Room por su id",description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Room not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.roomService.findById(id));
    }


    @Operation(summary = "Agregar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Room created",
                    content = @Content(schema = @Schema(implementation = RoomDto.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<RoomDto> save(@RequestBody RoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roomService.save(entity));
    }

    @Operation(summary = "Actualizar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = RoomDto.class))),
            @ApiResponse(responseCode = "404", description = "Room not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> update(@PathVariable Long id,@RequestBody RoomDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roomService.update(id,entity));
    }

    @Operation(summary = "Desactivar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Room not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.roomService.deactivate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Desactivado Correctamente");
    }

    @Operation(summary = "Activar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Room not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id) throws Exception{
        this.roomService.activate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activado Correctamente");
    }
}
