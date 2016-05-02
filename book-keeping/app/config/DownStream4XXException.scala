package config

class DownStream4XXException(message: String) extends Exception(message)
class DownStream5XXException(message: String) extends Exception(message)
class DownStreamUnknownException(message: String) extends Exception(message)
class DownStreamException(message: String, throwable: Throwable) extends Exception(message, throwable)

