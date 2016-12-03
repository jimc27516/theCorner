package thecorner

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RegisterController)
@Mock(Person)
class RegisterControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "successful registerPerson submit action" () {
        when:
        params.userName = "jimbo"
        params.password = "1234"
        params.firstName = "Jim"
        params.lastName = "Campbell"
        params.favoriteFruit = "apple"

        controller.registerPerson()

        then:
        response.redirectedUrl == "/landing/index"
        params.userName == "jimbo"
        params.password == "1234"
        params.firstName == "Jim"
        params.lastName == "Campbell"
        params.favoriteFruit == "apple"
        Person.count() == 1

    }

    void "failed registerPerson submit action" () {
        when:
//        params.userName = ""
        params.password = "1234"
        params.firstName = "Jim"
        params.lastName = "Campbell"
        params.favoriteFruit = "apple"

        controller.registerPerson()

        then:
        view == "/register/error"
        params.userName == null
        params.password == "1234"
        params.firstName == "Jim"
        params.lastName == "Campbell"
        params.favoriteFruit == "apple"
        Person.count() == 0

    }
}
