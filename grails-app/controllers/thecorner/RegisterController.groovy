package thecorner

class RegisterController {

    def index() {
        render Person.count()
    }

    def registerPerson() {

        def p = params as Person
        p.lastLogin = new Date()

        if (!p.save(flush: true)) {
            p.errors.allErrors.each {
                println it
            }
        }
        render(view: "/theCorner/landing/LandingView", model: params)
    }
}


