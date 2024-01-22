package MsHabitacion.MsHabitacion.controller;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/habitaciones")
    public ResponseEntity<List<HabitacionDTO>> getAllHabitaciones() {
        List<HabitacionDTO> habitaciones = habitacionService.getAllHabitaciones();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/habitacion/{id}")
    public ResponseEntity<HabitacionDTO> getHabitacionById(@PathVariable Long id) {
        HabitacionDTO habitacion = habitacionService.getHabitacionById(id);
        return (habitacion != null) ? new ResponseEntity<>(habitacion, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<HabitacionDTO> createHabitacion(@RequestBody HabitacionDTO habitacionDTO) {
        HabitacionDTO nuevaHabitacion = habitacionService.createHabitacion(habitacionDTO);
        return new ResponseEntity<>(nuevaHabitacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/habitacion/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Long id) {
        habitacionService.deleteHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
