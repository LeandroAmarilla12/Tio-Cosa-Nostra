package mafia
const val numeroDeVito = "12341245123513"
interface AccionesObserver {
    fun realizar(tarea: Tarea,unaBanda: Banda)
}

class NotificarXWPP(var wppSender: WPPSender): AccionesObserver{
    override fun realizar(tarea: Tarea,unaBanda: Banda){
        var mensaje = "${tarea.nombreClave} $ ${tarea.montoANotificar} "
        wppSender.mandarWpp(numeroDeVito,mensaje)
    }
}

class NotificarAFIP : AccionesObserver{
    override fun realizar(tarea: Tarea,unaBanda: Banda) {
        if(unaBanda.fondo > 1000000){

        }
    }
}