package com.example.privateambulance.data.networking.remote

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateDeserializer : JsonDeserializer<Date> {
    override fun deserialize(
        jsonElement: JsonElement,
        typeOF: Type,
        context: JsonDeserializationContext
    ): Date {
        val formats = arrayOf(
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd",
            "HH:mm:ss"
        )

        for (format in formats) {
            try {
                return SimpleDateFormat(format, Locale.US)
                    .parse(jsonElement.asString)!!
            } catch (_: Exception) {}
        }

        throw JsonParseException("Unparseable date: ${jsonElement.asString}")
    }
}