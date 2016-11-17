package thecorner

class HomeController {

    def index() {
        def emptyMap = [:]

    }

    def login() {
        println("in login")

        if (request.get) {
            return
        }

        def user = params.userName
        if (user != null) {
            session.user = user
            // next step figure out how to get to landing page
            redirect(controller:'Landing', action:'index')
        }
        else {
            render(view: "login", model:[message: "invalid user"])
        }


    }
}
