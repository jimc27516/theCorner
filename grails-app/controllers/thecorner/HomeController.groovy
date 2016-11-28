package thecorner

class HomeController {

    def index() {
        def emptyMap = [:]

    }

    def login() {
        println("in login")

        def user = params.userName
        def pwd = params.password

        if (request.get) {
            render(view: "login", model: [:])
        }
        else {
            if (user != null) {
                if (user != pwd) {
                    // password has to be the same as login name for now
                    render(view: "login", model:[message: "invalid password"])
                }
                else {
                    session.user = user
                    // next step figure out how to get to landing page
                    redirect(controller:'Landing', action:'index')
                }
            }
            else {
                render(view: "login", model:[message: "invalid user"])
            }
        }
    }
}
