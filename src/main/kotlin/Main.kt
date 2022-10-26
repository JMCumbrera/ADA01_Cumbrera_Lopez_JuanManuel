import java.io.FileReader
import java.io.Reader
import java.util.*
import kotlin.system.exitProcess

fun main() {
    println("MENU DEL ARCHIVO DE CONFIGURACIÓN\r\n")
    println("1. Mostrar lista de keys y valores del archivo de configuración.")
    println("2. Modificar uno de los campos del archivo de configuración.")
    println("3. Terminar programa.\r\n")
    println("Elija una opción: ")

    val option = readln().toInt()
    val readClass = ReadAndWriteConfigFiles()

    when (option) {
        1 -> {
            val prop = Properties()
            val reader: Reader = FileReader(
                System.getProperty("user.dir") +
                        System.getProperty("file.separator") +
                        "Resources" + System.getProperty("file.separator") +
                        "configuracion.conf"
            )
            prop.load(reader)

            println()
            println("*** Archivo de configuración cargado ***")
            println("Usuario: ${prop.getProperty("user")}")
            println("Contraseña: ${prop.getProperty("password")}")
            println("Servidor: ${prop.getProperty("port")}")
            println("Puerto: ${prop.getProperty("server")}")
        }
        2 -> {
            println()
            println("¿Que valor desea cambiar?")
            println()
            println("1. Usuario")
            println("2. Contraseña")
            println("3. Servidor")
            println("4. Puerto")
            println("5. Salir")
            println()
            println("Elija una opción: ")

            val choose = readln().toInt()

            when (choose) {
                1 -> {
                    println("Introduzca el nuevo usuario: ")
                    val newUser = readln().toString()
                    readClass.changeUsername(newUser)
                    println("\r\n")
                    println("El nombre de usuario ha sido cambiado satisfactoriamente")
                }
                2 -> {
                    println("Introduzca la contraseña actual: ")
                    val contraseñaAntigua = readln().toString()

                    val prop = Properties()
                    val reader: Reader = FileReader(
                        System.getProperty("user.dir") +
                                System.getProperty("file.separator") +
                                "Resources" + System.getProperty("file.separator") +
                                "configuracion.conf"
                    )
                    prop.load(reader)

                    val contraseñaActualDescifrada = readClass.descifrarContraseña(prop.getProperty("password"))

                    if (contraseñaAntigua == contraseñaActualDescifrada) {
                        println("Introduzca la nueva contraseña: ")
                        val newPassword = readln().toString()
                        val cipheredPass = readClass.cifrarContraseña(newPassword)
                        readClass.changePassword(cipheredPass)
                        println("\r\n")
                        println("El valor de la contraseña ha sido cambiado satisfactoriamente")
                    } else {
                        println("La contraseña actual no coincide con la contraseña introducida")
                    }
                }
                3 -> {
                    println("Introduzca el nuevo servidor: ")
                    val newServer = readln().toString()
                    readClass.changeServer(newServer)
                    println("\r\n")
                    println("El valor del servidor ha sido cambiado satisfactoriamente")
                }
                4 -> {
                    println("Introduzca el nuevo puerto: ")
                    val newPort = readln().toString()
                    readClass.changePort(newPort)
                    println("\r\n")
                    println("El valor del servidor ha sido cambiado satisfactoriamente")
                }
                5 -> { exitProcess(-1) }
                else -> { throw IllegalArgumentException() }
            }
        }
        3 -> {
            exitProcess(-1)
        }
        else -> { throw IllegalArgumentException() }
    }
}