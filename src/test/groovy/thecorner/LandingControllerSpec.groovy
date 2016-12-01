package thecorner

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LandingController)
class LandingControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "landing page displays username"() {
        when:
        session.user = "jimbo"
        controller.index()

        then:
        view == "/landing/index"
        model.user == "jimbo"
    }
}
