package pl.marchuck.navigationexample

class CustomPojo {
    var name: String? = null
    var surname: String? = null
    var age: Int = 0

    var child: CustomPojo? = null
    override fun toString(): String {
        return "CustomPojo(name=$name, surname=$surname, age=$age, child=$child)"
    }


}