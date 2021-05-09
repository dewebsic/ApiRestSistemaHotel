package com.angelsepulveda.apirestsistemahotel.controllers;

import com.angelsepulveda.apirestsistemahotel.models.Room;
import com.angelsepulveda.apirestsistemahotel.services.contracts.RoomService;
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
@RequestMapping("api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Operation(summary = "Obtener todos los Rooms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json")})
    })
    @GetMapping
    public ResponseEntity<List<Room>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.roomService.findAll());
    }

    @Operation(summary = "Obtener un Room por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el registro",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Room.class)) }),
            @ApiResponse(responseCode = "404", description = "Room not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Room> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.roomService.findById(id));
    }


    @Operation(summary = "Agregar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "DocumentType created",
                    content = @Content(schema = @Schema(implementation = Room.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roomService.save(entity));
    }

    @Operation(summary = "Actualizar un Room", description = "", tags = { "room" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Room not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable Long id,@RequestBody Room entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roomService.update(id,entity));
    }
}
