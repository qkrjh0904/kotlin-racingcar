package step3.objects

class InputDevice {
    companion object {
        fun input(): Int {
            val input = readln()
            InputValidator.validate(input)
            return input.toInt()
        }
    }
}
