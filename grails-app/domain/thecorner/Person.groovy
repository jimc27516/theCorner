package thecorner

class Person {

    String userName
    String password
    String firstName
    String lastName
    String favoriteFruit
    Date lastLogin

    static constraints = {
        userName(blank: false)
        password(blank: false)
        firstName(blank: false)
        lastName(blank: false)
        favoriteFruit(blank: true, nullable: true)
        lastLogin(nullable: true)
    }
}

