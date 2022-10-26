/*class WriteConfigFiles (user: String, password: String, server: String, port: String) {
    var user: String = user
        set(value)
        {
            if(user.isEmpty()) throw IllegalArgumentException()
            field = value
        }
        init {
            this.user = user
        }

    private var password: String = password
        set(value) {
            if (password.isEmpty()) throw IllegalArgumentException()
            field = value
        }
        init {
            this.password = password
        }

    private var port: String = port
        set(value) {
            if (port.isEmpty()) throw java.lang.IllegalArgumentException()
            field = value
        }
        init {
            this.port = port
        }

    private var server: String = server
        set(value) {
            if (server.isEmpty()) throw IllegalArgumentException()
            field = value
        }
        init {
            this.server = server
        }

    constructor(user: String) : this(user, "thisisthesafestpasswordpossible", "localhost", "80") {
        this.user = user
    }

    constructor(password: String) : this("Juan", password, "localhost", "80") {
        this.password = password
    }
} */