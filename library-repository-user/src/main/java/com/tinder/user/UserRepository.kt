package com.tinder.user

class UserRepository {

    fun getUsers(): List<User> {
        return listOf(
            User(
                id = 1,
                imageResourceId = R.drawable.capnamerica,
                name = "Steve",
                bio = "I don't like bullies; I don't care where they're from."
            ),
            User(
                id = 2,
                imageResourceId = R.drawable.blackpanther,
                name = "T'Challa",
                bio = "Wakanda Forever!"
            ),
            User(
                id = 3,
                imageResourceId = R.drawable.ironman,
                name = "Tony",
                bio = "Sometimes you gotta run before you walk."
            ),
            User(
                id = 4,
                imageResourceId = R.drawable.hulk,
                name = "Bruce",
                bio = "Don't make me angry. You wouldn't like me when I'm angry."
            ),
            User(
                id = 5,
                imageResourceId = R.drawable.thor,
                name = "Thor",
                bio = "I don't drink tea."
            ),
            User(
                id = 6,
                imageResourceId = R.drawable.spidey,
                name = "Peter",
                bio = "With Great Power, Comes Great Responsibility."
            ),
            User(
                id = 7,
                imageResourceId = R.drawable.capnmarvel,
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
            imageResourceId = R.drawable.nickfury,
            name = "Nick",
            bio = "Last Time I Trusted Someone, I Lost An Eye."
        )
    }
}