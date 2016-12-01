package thecorner

class LandingController {

    def index() {
        println "in LandingController index"
        render(view: "index", model:[user: session.user])
    }
}
