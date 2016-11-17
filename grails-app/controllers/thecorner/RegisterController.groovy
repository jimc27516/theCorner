package thecorner

class RegisterController {

    def index() {
        println "registerController index"
    }

    def registerPerson() {

        def p = params as Person
        p.lastLogin = new Date()

        if (!p.save(flush: true)) {
            p.errors.allErrors.each {
                println it
            }
        }
        render(view: "index", model: params)
    }
}


