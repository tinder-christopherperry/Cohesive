package com.tinder.user

class UserRepository {

    fun getUsers(): List<User> {
        return listOf(
            User(
                id = 1,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/capnamerica",
                name = "Steve",
                bio = "I don't like bullies; I don't care where they're from."
            ),
            User(
                id = 2,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/blackpanther",
                name = "T'Challa",
                bio = "Wakanda Forever!"
            ),
            User(
                id = 3,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/ironman",
                name = "Tony",
                bio = "Sometimes you gotta run before you walk."
            ),
            User(
                id = 4,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/hulk",
                name = "Bruce",
                bio = "Don't make me angry. You wouldn't like me when I'm angry."
            ),
            User(
                id = 5,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/thor",
                name = "Thor",
                bio = "I don't drink tea."
            ),
            User(
                id = 6,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/spidey",
                name = "Peter",
                bio = "With Great Power, Comes Great Responsibility."
            ),
            User(
                id = 7,
                imageResourceUri = "android.resource://com.tinder.cohesive/drawable/capnmarvel",
                name = "Carol",
                bio = "Higher, further, faster."
            )
        )
    }

    fun getUser(id: Long): User? {
        if (id == 0L) return getLoggedInUser()
        return getUsers().firstOrNull { it.id == id }
    }

    fun getLoggedInUser(): User {
        return User(
            id = 0,
            imageResourceUri = "android.resource://com.tinder.cohesive/drawable/nickfury",
            name = "Nick",
            bio = "Last Time I Trusted Someone, I Lost An Eye."
        )
    }
}