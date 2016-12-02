package thecorner

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*


/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class RegisterUserSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "navigating to base URL results in login page"() {
        when:"The home page is visited"
            go '/'

        then:"The login page is displayed"
        	title == "login"
    }

    void "navigate to the login page, click register, register user"() {
        when:"user clicks on register link"
            go '/'
            // $("a", href: "foo.html")
            report "login screen"
            $("a", id: 'registerLink').click()

        then:"the register page is displayed"
            title == "landing"
    }
}
