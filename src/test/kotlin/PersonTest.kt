
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({

    test("Named Argument 사용해서 객체 생성하기") {
        val person = Person(name = "박정호", age = 29, nickname = "바저호")

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe "바저호"
    }

    test("Argument 중 null 타입일 수 있는 argument 에 대해 테스트해본다.") {
        val person = Person(name = "박정호", age = 29, nickname = null)

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    test("Person 을 데이터 클래스로 만들어 보고 정상 동작 하는지 확인해본다.") {
        val person = Person(name = "박정호", age = 29, nickname = null)

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe null
    }
})
