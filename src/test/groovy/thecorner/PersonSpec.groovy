package thecorner

import grails.test.mixin.TestFor
import spock.lang.Specification

import java.time.Instant

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test userName is blank" () {
        when: "userName is blank"
        def p = new Person(firstName: "Jimmy",
                lastName: "Campbell",
                password: "foobar",
                favoriteFruit: "apple",
                lastLogin: Date.from(Instant.now()))

        then: "validation should fail"
        !p.validate()
    }

    void "all fields are valid happy path" () {
        when: "all fields are valid"
        def p = new Person(firstName: "Jimmy",
                lastName: "Campbell",
                userName: "jimbo",
                password: "foobar",
                favoriteFruit: "apple",
                lastLogin: Date.from(Instant.now()))

        then: "validation should pass"
        p.validate()
    }

    void "only favoriteFruit and lastLogin are null" () {
        when: "userName is blank"
        def p = new Person(userName: "jimbo",
                firstName: "Jimmy",
                lastName: "Campbell",
                password: "foobar")

        then: "validation should pass"
        p.validate()
    }

    void "funky string instead of date" () {
        when: "funky string instead of date"
        def p = new Person(firstName: "Jimmy",
                lastName: "Campbell",
                userName: "jimbo",
                password: "foobar",
                favoriteFruit: "apple",
                lastLogin: "yesterday")

        then: "validation should fail"
        !p.validate()
    }

}
