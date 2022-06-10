package mafia

class Comerciante( var ingresosMensuales : Double) {
    var deuda = 0.0

    fun pagarProteccion()  = ingresosMensuales * 0.1

    fun recibirPrestamo(prestamo: Double){
        deuda += prestamo
    }
}
