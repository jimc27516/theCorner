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

    void "test registerPerson submit action" () {
        when:
        params.userName = "jimbo"
        params.password = "1234"
        params.firstName = "Jim"
        params.lastName = "Campbell"
        params.favoriteFruit = "apple"

        controller.registerPerson()

        then:
        view == '/theCorner/landing/LandingView'
        params.userName == "jimbo"
        params.password == "1234"
        params.firstName == "Jim"
        params.lastName == "Campbell"
        params.favoriteFruit == "apple"
        Person.count() == 1

    }

}
