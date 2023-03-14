package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarifas")
public class TarifaController {
    @Autowired
    private TarifaRepository tarifaRepository;

    @GetMapping
    public List<TarifaResponse> consultarTarifas(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam("productoId") Long productoId,
            @RequestParam("cadenaId") Long cadenaId) {
        List<Tarifa> tarifas = tarifaRepository
                .findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqualAndProductoIdAndCadenaId(
                        fecha, fecha, productoId, cadenaId);
        return tarifas.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private TarifaResponse convertToResponse(Tarifa tarifa) {
        return new TarifaResponse(tarifa.getProducto().getId(), tarifa.getCadena().getId(),
                tarifa.getPrecio(), tarifa.getFechaInicio(), tarifa.getFechaFin());
    }
}
