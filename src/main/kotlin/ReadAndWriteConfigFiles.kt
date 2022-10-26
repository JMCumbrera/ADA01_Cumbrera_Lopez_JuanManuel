import java.io.FileReader
import java.io.FileWriter
import java.io.Reader
import java.io.Writer
import java.nio.charset.Charset
import java.util.*

/**
 * IMPORTANTE: Las variables reader y writer deben estar en las posiciones
 * donde se encuentran, si no, el programa falla.
 */

class ReadAndWriteConfigFiles() {
    fun cifrarContraseña(password: String): String {
        val pass = password.toCharArray()
        val intASCII: MutableList<Int> = mutableListOf()
        val cipheredPass: MutableList<Char> = mutableListOf()

        for (i in pass.indices) {
            var a: Int
            a = pass[i].code.toByte().toInt()
            intASCII.add(a)
        }
        for (j in intASCII.indices) {
            intASCII[j] = intASCII[j] + 3
        }
        for (k in intASCII.indices) {
            var b: Int = intASCII[k]
            var c = b.toChar()
            cipheredPass.add(c)
        }
        return cipheredPass.toString().filterNot { it == '[' }.filterNot { it == ']' }.filterNot { it == ',' }.filterNot { it == ' ' }
    }

    fun descifrarContraseña(password: String): String {
        val pass = password.toCharArray()
        val intASCII: MutableList<Int> = mutableListOf()
        val decipheredPass: MutableList<Char> = mutableListOf()

        for (i in pass.indices) {
            var a: Int
            a = pass[i].code.toByte().toInt()
            intASCII.add(a)
        }
        for (j in intASCII.indices) {
            intASCII[j] = intASCII[j] - 3
        }
        for (k in intASCII.indices) {
            var b: Int = intASCII[k]
            var c = b.toChar()
            decipheredPass.add(c)
        }
        return decipheredPass.toString().filterNot { it == '[' }.filterNot { it == ']' }.filterNot { it == ',' }.filterNot { it == ' ' }
    }

    fun changeUsername(user: String) {
        val reader: Reader = FileReader(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        val propRead = Properties()
        val propWrite = Properties()
        propRead.load(reader)

        if (user.isEmpty()) { throw IllegalArgumentException() }
        else {
            propWrite.setProperty("user", user)
            propWrite.setProperty("password", propRead.getProperty("password"))
            propWrite.setProperty("port", propRead.getProperty("port"))
            propWrite.setProperty("server", propRead.getProperty("server"))
        }
        val writer: Writer = FileWriter(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        propWrite.store(writer,"Nombre de usuario cambiado")
        writer.close()
    }

    fun changeServer(server: String) {
        val reader: Reader = FileReader(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        val propRead = Properties()
        val propWrite = Properties()
        propRead.load(reader)

        if (server.isEmpty()) { throw IllegalArgumentException() }
        else {
            propWrite.setProperty("user", propRead.getProperty("user"))
            propWrite.setProperty("password", propRead.getProperty("password"))
            propWrite.setProperty("port", propRead.getProperty("port"))
            propWrite.setProperty("server", server)
        }
        val writer: Writer = FileWriter(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        propWrite.store(writer,"Valor del servidor cambiado")
        writer.close()
    }

    fun changePort(port: String) {
        val reader: Reader = FileReader(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        val propRead = Properties()
        val propWrite = Properties()
        propRead.load(reader)

        if (port.isEmpty()) { throw IllegalArgumentException() }
        else {
            propWrite.setProperty("user", propRead.getProperty("user"))
            propWrite.setProperty("password", propRead.getProperty("password"))
            propWrite.setProperty("port", port)
            propWrite.setProperty("server", propRead.getProperty("server"))
        }
        val writer: Writer = FileWriter(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        propWrite.store(writer,"Nombre de usuario cambiado")
        writer.close()
    }

    fun changePassword(newPassword: String) {
        val reader: Reader = FileReader(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        val propRead = Properties()
        val propWrite = Properties()
        propRead.load(reader)

        if (newPassword.isEmpty()) { throw IllegalArgumentException() }
        else {
            propWrite.setProperty("user", propRead.getProperty("user"))
            propWrite.setProperty("password", newPassword)
            propWrite.setProperty("port", propRead.getProperty("port"))
            propWrite.setProperty("server", propRead.getProperty("server"))
        }
        val writer: Writer = FileWriter(
            System.getProperty("user.dir") +
                    System.getProperty("file.separator") +
                    "Resources" + System.getProperty("file.separator") +
                    "configuracion.conf")
        propWrite.store(writer,"Nombre de usuario cambiado")
        writer.close()
    }
}