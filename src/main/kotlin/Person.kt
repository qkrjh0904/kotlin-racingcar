data class Person(
    val name: String,
    val age: Int,
    var nickname: String?
) {

    constructor(name: String) : this(name, 29, null) {
    }
}