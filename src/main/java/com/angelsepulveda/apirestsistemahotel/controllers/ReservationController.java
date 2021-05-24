package com.angelsepulveda.apirestsistemahotel.controllers;


import com.angelsepulveda.apirestsistemahotel.dtos.ReservationDto;
import com.angelsepulveda.apirestsistemahotel.models.Reservation;
import com.angelsepulveda.apirestsistemahotel.services.contracts.ReservationService;
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
@RequestMapping("api/v1/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService =  reservationService;
    }

    @Operation(summary = "Obtener todos los Reservations",description = "", tags = { "reservations" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reservation.class))})
    })
    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.reservationService.findAll());
    }

    @Operation(summary = "Obtener todos los reservations paginados",description = "", tags = { "reservations" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se obtuvo todos los registros",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reservation.class))})
    })
    @GetMapping("/paged")
    public ResponseEntity<Page<Reservation>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.reservationService.findAll(pageable));
    }

    @Operation(summary = "Obtener un Reservation por su id",description = "", tags = { "reservations" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el archivo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reservation.class)) }),
            @ApiResponse(responseCode = "404", description = "Reservation not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getOne(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.reservationService.findById(id));
    }


    @Operation(summary = "Agregar un Reservation", description = "", tags = { "reservations" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservation created",
                    content = @Content(schema = @Schema(implementation = Reservation.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping
    public ResponseEntity<Reservation> save(@RequestBody ReservationDto entity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.reservationService.save(entity));
    }


    @Operation(summary = "Anular Reservation", description = "", tags = { "reservations" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Reservation not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PatchMapping("/cancel/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) throws Exception{
        this.reservationService.cancel(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Anulado Correctamente");
    }


}
