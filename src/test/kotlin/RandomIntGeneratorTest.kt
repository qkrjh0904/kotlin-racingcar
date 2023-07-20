import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import step3.objects.RandomIntGenerator

class RandomIntGeneratorTest : BehaviorSpec({

    Given("랜덤 숫자 생성기로 0~9 사이의 랜덤한 정수를 뽑는다.") {
        When("랜덤 숫자 생성기로 숫자를 생성한다.") {
            val num = RandomIntGenerator.generate()
            Then("0 에서 9 사이의 숫자가 생성된다.") {
                num shouldBeInRange IntRange(0, 9)
            }
        }
    }
})
