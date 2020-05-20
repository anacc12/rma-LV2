package com.example.famous

object PeopleRepository {
    val people: MutableList<InspiringPerson>
    init {
        people = retrievePeople()
    }
    private fun retrievePeople(): MutableList<InspiringPerson> {
        return mutableListOf(
            InspiringPerson("Bill Gates", "1955.", "/",
                "Bill Gates is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation.", "https://cdn.britannica.com/47/188747-050-1D34E743/Bill-Gates-2011.jpg",
                mutableListOf("Patience is a key element of success.", "I choose a lazy person to do the hard job. Because the lazy person will find an easy way to do it.", "To win big, you sometimes need to take big risks.", "If you can't make it good, at least make it look good.")),
            InspiringPerson("Linus Torvalds", "1969.", "/","Linus Torvalds is a software engineer who is the creator and, historically, the principal developer of the Linux kernel, which is the kernel for Linux operating systems and other operating systems such as Android and Chrome OS.",
                "https://avatars0.githubusercontent.com/u/1024025?s=460&v=4", mutableListOf("Theory and practice sometimes  clash. And when that happens, \r\ntheory loses.", "A computer is like air conditioning - it becomes useless when you open Windows")),
            InspiringPerson("Tim Berners-Lee", "1955.", "/","Berners-Lee is the director of the World Wide Web Consortium (W3C) which oversees the continued development of the Web. He is also the founder of the World Wide Web Foundation.",
                "https://www.celebrityborn.com/admin/assets/images/people/cNHrqxJsEs9ZoUZupa7x_2017_06_05.jpg",
                mutableListOf("You affect the world by what you browse.", "The important thing is the diversity available on the Web.", "Data is a precious thing and will last longer than the systems themselves.", "We can't blame the technology when we make mistakes.")),
            InspiringPerson("Dennis Ritchie", "1941.", "2011.","Dennis Ritchie created the C programming language and, with long-time colleague Ken Thompson, the Unix operating system and B programming language.",
                "https://www.proprofs.com/quiz-school/user_upload/ckeditor/DennisRitchie.jpg",
                mutableListOf("The only way to learn a new programming language is by writing programs in it.", "Twenty percent of all input forms filled out by people contain bad data.")),
            InspiringPerson("James Gosling", "1955", "/","James Gosling is a Canadian computer scientist, best known as the founder and lead designer behind the Java programming language.",
                "https://pcchip.hr/wp-content/uploads/2017/06/James-Gosling.jpeg",
                mutableListOf("Java is C++ without the guns, knives and clubs.", "One of the toughest things about life is making choices.", "The real payoffs you never understand."))
        )
    }
    fun get(quotes: MutableList<String>) = people.find { person -> person.quotes == quotes }
    fun add(person: InspiringPerson) = people.add(person)
}
