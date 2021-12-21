import kotlin.system.exitProcess

open class Agenda() {
    var lista = mutableSetOf<Telefono>()


    fun imprimirLista() {
        lista.forEach { println(it) }

    }

    fun addTel(tel: Telefono) {
        lista.add(tel)
    }

    fun filtrarNombre(nombre: String): Set<Telefono> {
        return lista.filter { it.name.equals(nombre) }.toSet()
    }
}

data class Telefono(var name: String, var nummer: Int) : Agenda() {
    override fun toString(): String {
        return "nombre: $name, número de teléfono: $nummer"
    }
}

fun main(args: Array<String>) {
    var agenda = Agenda()
    println("ingrese número de teléfono")
    do {
        var read = readLine()
        while (read != "salida") {
            when {
                read == "listado" -> agenda.imprimirLista()
                read == "filtrar" -> agenda.filtrarNombre("cuco")
                read == "adios" -> exitProcess(1)
            }
        }
    }
        var t1: Telefono = Telefono("Uchi", +666)
        var t2: Telefono = Telefono("cuco", +777)

        agenda.addTel(t1)
        agenda.addTel(t2)
        agenda.imprimirLista()

    }
