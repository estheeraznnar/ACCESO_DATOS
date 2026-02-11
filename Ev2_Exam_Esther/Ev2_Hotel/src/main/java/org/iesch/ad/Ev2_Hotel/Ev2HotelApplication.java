package org.iesch.ad.Ev2_Hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Debes desarrollar una API REST para gestionar un "hotel" que permita
 * 	Crear y gestionar reservas de habitaciones.
 * 	Reaslizar Check-in y Check-out de huéspedes
 * 	Realizar consultas sobre disponibilidad, ocupacion y estadisticas
 *
 * Ejercicios:
 * 	Ej1: Crear reserva (POST/api/resrvas)
 * 	logica de negocio:
 * 		1: Validar que existe al menos una habitacion disponible del tipo solicitado en las fechas indicadas
 * 		2: No permitir reservas conmenos de 24h de antelacion
 * 		3: Calcular el numero de noches de estancia
 * 		4: Aplicar descuento del 15% si la estancia es superior a 7 dias
 * 		5: Calcular precio total segun:
 * 			a) Precio base de la habitacion por noche
 * 			b) Temporada (alta: +30%, media: precio base, baja:-20%)
 * 			c)Regimen (SOLO_ALOJAMIENTO: 0€, DESAYUNO: +15€/dia, MEDIA_PENSION: +35€/dia, PENSION_COMPLETA: +55€/dia)
 * 		6: si el cliente es vip (mas de 5 reservas previas), hacer upgrade automatico de categoria:
 * 			a) INDIVIDUAL -> DOUBLE
 * 			b) DOBLE -> SUIT
 * 			c) SUIT -> se mantien
 * 		7: Generar codigo de reserva unico (formato: HTL-YYYYMMDD-XXXX) se puede usar un random para (XXXX)
 * 		8: Estado inicial: PENDIENTE_CONFIRMACION
 * 		9: ASIGNAR la primera habitacion disponible del tipo solicitado
 *
 * 	Ej2: Chck-In (PUT/api/reservas/{codigo}/check-in
 * 	logica de negocio
 * 		validar la reserva existe.
 * 		La fecha debe estar en estado confirmada.
 * 		Comprobar que el cliente no tenga facturas impagadas(deudaPendiente>0).
 * 		Si llega antes de las 14:00,cobra suplemento de "early check-in"(20€)
 * 		Cambiar estado de la habitacion a OCUPADA
 * 		Registrar hora real de entrada(LocalDateTime.now())
 * 		Cambiar estado de la reserva a EN_CURSO
 * 		Actualizar el metodo de pago
 *
 * 	Ej3: Check-Out (PUT/api/reservas/{codigo}/check-out)
 * 	logica de negocio
 * 		validar que la reserva existe
 * 		la reserva debe estar en estado EN_CURSO
 * 		si la salida es despues de las 12:00h, cobrar suplemento "late check-out"(25€)
 * 		sumar el importe de todos los servicios adicionales consumidos
 * 		calcular el importe final total
 * 		generar factura con desglose:
 * 			precio base de la reserva
 * 			servicios adicionales consumidos
 * 			suplementos (early/late check-out/out)
 * 			total a pagar
 * 		cambiar estado de la habitacion a EN_LIMPIEZA
 * 		cambiar el estado de la resrva a FINALIZADA
 * 		registrar la hora real de salida
 * 		actualizar puntos de fidelidad del cliente(+1 punto por cada 10€ gastados)
 *
 * 	Implementacion endpoints de consulta
 * 	a)habitaciones disponibles
 * 		GET/api/habitaciones/disponibles?fechaInicio=2026-03-15&fechaFin=2026-03-20&tipo=DOUBLE
 * 	logica
 * 		buscar habiataciones que no tengan resrvas confirmadas o en curso en el rango de fechas
 * 		devolver lista de habitaciones con su informacion completa
 * 	b)Reservas activas
 * 		GET/api/resrvas/activas
 * 	logica
 * 		devolver todas las reservas emn estado EN_CURSO
 * 		ordenar por numerode habitacion
 * 		incluir informacion del cliente y datos de la resrva
 * 	c)clientes vip
 * 		GET/api/clientes/vip
 * 	logica
 * 		clientes que cumplan almenos una de estas condiciones:
 * 			masde 5 reservas en el ultimo año
 * 			gasto total acumulado >3000€
 * 			ordenar por gasto total descendente
 * 			mostrar estadisticas: total reservas, gasto total, puntos fidelidad
 *
 * 	d)estadisticas de ocupacion
 * 		GET/api/estadisticas/ocupacion?mes=3&anio=2026
 * 	logica
 * 		calcular para cada dia del mes
 * 			numero de habitaciones ocupadas
 * 			porcentaje de ocupacion
 * 			ingresos totales del mes
 * 			servicio adicional mas solicitado
 * 			numero total de huespedes
 * 	e)habitaciones en mantenimioento
 * 		GET/api/habitaciones/mantenimiento
 * 	logica
 * 		habitaciones en estado EN_MANTENIMIENTO
 * 		habitaciones en estado EN_LIMPIEZA
 * 	f)proximas llegadas
 * 		GET /api/reservas/proximas-llegadas
 * 	logica
 * 		resrvas con check-in previsto para hoy o mañana
 * 		estado confirmada
 * 		ordenar por fecha y hora de entrada
 * 		incluir daros del cliente para preparar la bienvenida
 */

@SpringBootApplication
public class Ev2HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ev2HotelApplication.class, args);
	}

}
