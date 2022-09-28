package tech.thatgravyboat.jukebox.impl.apple.state

import kotlinx.serialization.Serializer
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializer(AppleState::class)
object AppleStateSerializer : JsonContentPolymorphicSerializer<AppleState>(AppleState::class) {

    override fun selectDeserializer(element: JsonElement) = when(element.jsonObject.get("type")?.jsonPrimitive?.content) {
        "playbackStateUpdate" -> ApplePlayerState.serializer()
        else -> BaseAppleState.serializer()
    }

}