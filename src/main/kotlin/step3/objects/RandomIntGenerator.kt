package step3.objects

class RandomIntGenerator {
    companion object {
        fun generate(): Int = (Math.random() * 10).toInt()
    }
}
