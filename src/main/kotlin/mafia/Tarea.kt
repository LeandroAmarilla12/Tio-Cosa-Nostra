package mafia

import java.time.LocalDate

abstract class Tarea(var nombreClave : String) {
    var fecha : LocalDate = LocalDate.of(LocalDate.now().year, LocalDate.now().month, 5)


    var montoANotificar = 0.0
    var montoARepartir = 0.0
    abstract fun realizar()

    fun realizarYEjecutarAcciones( accionesObserver : List<AccionesObserver>,unaBanda : Banda){
        realizar()
        accionesObserver.forEach{it.realizar(this,unaBanda)}
    }

}

class RecolectarDinero(var unComerciante: Comerciante): Tarea("La puerca esta en la pocilga"){
    override fun realizar() {
        montoANotificar = unComerciante.pagarProteccion()

    }

}

class AbrirDeposito(var area : Double): Tarea("La luna salio al amanecer"){
    override fun realizar() {
        montoANotificar = -(area * 100.0)
    }
}

class DarPrestamo(var unComerciante: Comerciante,var montoPrestamo: Double, var listaDeTareas : MutableList<Tarea>): Tarea(""){
    override fun realizar() {
        unComerciante.recibirPrestamo(montoPrestamo)
        montoANotificar = -montoPrestamo
        val montoACobrar = montoPrestamo * 2
        val primerCobro = CobrarPrestamo(montoACobrar/4).apply { fecha.plusMonths(1) }
        val segundoCobro = CobrarPrestamo(montoACobrar/4).apply { fecha.plusMonths(2) }
        val tercerCobro = CobrarPrestamo(montoACobrar/4).apply { fecha.plusMonths(3) }
        val cuartoCobro = CobrarPrestamo(montoACobrar/4).apply { fecha.plusMonths(4) }
        listaDeTareas.addAll(listOf(primerCobro,segundoCobro,tercerCobro,cuartoCobro))
    }
}

class CobrarPrestamo(var montoACobrar : Double) : Tarea(""){
    override fun realizar() {
        montoANotificar = montoACobrar
    }
}
