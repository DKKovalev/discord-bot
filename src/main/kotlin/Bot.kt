import net.dv8tion.jda.client.events.message.group.GroupMessageReceivedEvent
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

private const val TOKEN = "NTQwMTgyMTE1NzQ5NDYyMDE5.DzNaLQ.Iyv_UY0nWB_kEix16_ro-6cmC-M"

fun main() {
    val jda = JDABuilder(TOKEN).addEventListener(Listener()).build()
}

class Listener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent?) {
        super.onMessageReceived(event)

        val message = event?.message?.contentRaw
        val channel = event?.channel
        
        when (message) {
            "!commands" -> channel?.sendMessage("")
            "!pidor" -> channel?.sendMessage("NO U")?.queue()
        }
    }

    override fun onGroupMessageReceived(event: GroupMessageReceivedEvent?) {
        super.onGroupMessageReceived(event)

        val message = event?.message?.contentRaw
        val channel = event?.group

        println("!!! message = $message")

        when (message) {
            "!pidor" -> channel?.sendMessage("САМ ПИДОР")?.queue()
        }
    }
}