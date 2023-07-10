
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({

    test("Person 에 이름을 넣어 객체를 생성해본다.") {
        val person = Person("박정호")

        person.name shouldBe "박정호"
    }

    test("Person 에 null 타입일 수 있는 인자에 대해 테스트 해본다.") {
        val person = Person("박정호")

        person.name shouldBe "박정호"
        person.nickname shouldBe null
    }

    test("Person을 데이터 클래스로 만들어 보고 정상 동작 하는지 확인해본다.") {
        val person = Person("박정호")

        person.name shouldBe "박정호"
        person.nickname shouldBe null
    }
})
