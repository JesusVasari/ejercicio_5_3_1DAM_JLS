
class Agenda() {
    private var contactos = mutableSetOf<Contacto>()

    fun buscarContacto(telefono: String): Contacto? {

        return contactos.find { it.nombre.equals(telefono) }
    }
    fun buscarTelefono(telefono:String):Contacto? {
        return contactos.find { it.telefono.equals(telefono) }
    }


    fun imprimirLista(second: String) {
        contactos.forEach { println(it) }
    }

    fun filtrarNombre(second: String): Set<Contacto> {
        return contactos.filter { it.nombre.equals(second) }.toSet()
    }

    fun addTel(tel: Contacto) {
        contactos.add(tel)
    }


}


class Contacto(var nombre: String, var telefono: String) {
    override fun toString(): String {
        return nombre + "::" + telefono
    }
}

fun main() {
    var agenda = Agenda()
    var entrada: String? = ""
    var c1 = Contacto("pepito","+235235")
    var c2 = Contacto("jaimito","45345435")
    agenda.addTel(c1)
    agenda.addTel(c2)
    do {
        println("Introduza un comando, numero o nombre de contacto: ")
        entrada = readLine()
        var procesadaEntrada: Pair<String, String> = Pair("", "")
        if (entrada != null)
            procesadaEntrada = procesarEntrada(entrada)

        ejecutaAccion(procesadaEntrada, agenda)

    } while ("ADIOS" != procesadaEntrada.first.uppercase())


}

fun ejecutaAccion(procesadaEntrada: Pair<String, String>, agenda: Agenda) {

    when {
        procesadaEntrada.first == "telefono" -> {
            println("buscar telefono")
            var contacto: Contacto? = agenda.buscarTelefono(procesadaEntrada.second)
            println(contacto)
        }
        procesadaEntrada.first == "contacto" -> {
            println("buscar contacto")
            var contacto: Contacto? = agenda.buscarContacto(procesadaEntrada.second)
            println(contacto)
        }
        procesadaEntrada.first == "listar" -> {
            println("listar contactos")
            var contacto: Unit = agenda.imprimirLista(procesadaEntrada.second)
            println(contacto)

        }
        procesadaEntrada.first == "filtrar" -> {
            println("filtrar contacto")
            var contacto: Set<Contacto> = agenda.filtrarNombre(procesadaEntrada.second)
            println(contacto)
        }
    }
}

fun procesarEntrada(entrada: String): Pair<String, String> {

    var entradaProc = entrada.replace(" ", "")

    var procesado: Pair<String, String> = Pair("", "")
    when {
        (entradaProc.first().isDigit() || entradaProc.first().equals('+')) -> {
            try {
                procesado = Pair("telefono", entradaProc.toLong().toString())
            } catch (_: Exception) {
            }
        }
        (entrada.trim().equals("listar")) -> {
            procesado = Pair("listar", entrada)
        }
        (entrada.trim().startsWith("filtrar")) -> {
            procesado = Pair("filtrar", entrada)
        }
        (entrada.trim().startsWith("adios")) -> {
            procesado = Pair("adios", entrada)
        }
        (entradaProc.first().isLetter()) -> {
            procesado = Pair("contacto", entrada)
        }

    }
    return procesado
}