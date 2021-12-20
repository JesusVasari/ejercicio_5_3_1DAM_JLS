class Agenda() {
    var lista = mutableSetOf<Telefono>()

    fun imprimirAgenda(agenda: Map<Int, String>) {
        for ((Int, String) in agenda) {
            println()
        }
    }

    fun imprimirLista() {
        lista.forEach { println(it) }

    }

    fun addTel(tel: Telefono) {
        lista.add(tel)
    }
}

data class Telefono(var name: String, var nummer: Int) : Agenda {
    override fun toString(): String {
        return "nombre: $name, número de teléfono: $nummer"
    }

    fun filtraNombre() {
        return
    }

}

fun main(args: Array<String>) {
    var agenda = Agenda()
    println("ingrese número de teléfono")
    do {
        var read = readLine()
        while (read != "salida")
            when {
                read == "listado" -> agenda.imprimirLista()
                // read == "filtrar" ->
               // read == "adios" -> break
            }
    }
    var t1: Telefono = Telefono("Uchi", +666)
    var t2: Telefono = Telefono("cuco", +777)

    agenda.addTel(t1)
    agenda.addTel(t2)
    agenda.imprimirLista()

}