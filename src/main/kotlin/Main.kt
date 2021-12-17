class Agenda (){
    var lista = mutableListOf<Telefono>()

    fun imprimirLista() {
        lista.forEach { println(it) }

    }

fun addTel (tel:Telefono) {
    lista.add(tel)
}

}

 class Telefono (var name:String, var nummer:Int) {
     override fun toString(): String {
         return "nombre: $name, número de teléfono: $nummer"
     }

 }
fun main(args: Array<String>) {
    var t1:Telefono = Telefono("Uchi", +666)
    var t2:Telefono = Telefono("cuco", +777)
    var agenda = Agenda()
    agenda.addTel(t1)
    agenda.addTel(t2)
    agenda.imprimirLista()
}