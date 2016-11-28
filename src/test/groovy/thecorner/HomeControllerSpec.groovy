package thecorner

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "login POST with user name null renders login view"() {
        when:
        request.method = 'POST'
        params.userName = null
        controller.login()

        then:
        view == "/home/login"
        model.message == "invalid user"
    }

    void "login GET renders login view with empty status message"() {
        when:
        request.method = 'GET'
        controller.login()

        then:
        view == "/home/login"
        model.message == null
    }

    void "login POST with username and valid pwd renders landing view"() {
        when:
        request.method = 'POST'
        params.userName = "jimmy"
        params.password = "jimmy"
        controller.login()

        then:
        response.redirectedUrl == "/landing/index"
    }

    void "invalid password results in login screen with invalid message"() {
        when:
        request.method = 'POST'
        params.userName = "jimmy"
        params.password = "invalidPwd"
        controller.login()

        then:
        view == "/home/login"
        model.message == "invalid password"
    }
}
