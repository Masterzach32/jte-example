import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.output.StringOutput
import gg.jte.resolve.DirectoryCodeResolver
import java.nio.file.Path

sealed class A(val name: String)
class B : A("B") {
    val x = "2"
}
open class C(name: String) : A(name) {
    val y = "5"
}
class D : C("D") {
    val z1 = "10"
}
class E : C("E") {
    val z2 = "20"
}

fun main() {
    val templateEngine = TemplateEngine.create(DirectoryCodeResolver(Path.of("src", "main", "kte")), ContentType.Html)

    val objects = listOf(
        B(), B(), D(), B(), B(), E(), B(), E()
    )

    val writer = StringOutput()
    templateEngine.render("test.kte", objects, writer)
    println(writer.toString())
}