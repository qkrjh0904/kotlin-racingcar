
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({

    test("Person 을 named arguments 로 객체를 생성할 수 있다.") {
        val person = Person(name = "박정호", age = 29, nickname = "바저호")

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe "바저호"
    }

    test("Person 의 nickname 을 null 가능하게 만들고, null 타입 인자를 넣고 객체를 생성할 수 있다.") {
        val person = Person(name = "박정호", age = 29, nickname = null)

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    test("Person 을 데이터 클래스로 만들어도 정상동작 할 수 있다.") {
        val person = Person(name = "박정호", age = 29, nickname = null)

        person.name shouldBe "박정호"
        person.age shouldBe 29
        person.nickname shouldBe null
    }
})
