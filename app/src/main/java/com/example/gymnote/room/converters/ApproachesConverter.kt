package com.example.gymnote.room.converters

import androidx.room.TypeConverter
import com.example.gymnote.Approache
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ApproachesConverter {

    @TypeConverter
    open fun fromApproaches(approaches: MutableList<Approache>?): String? {
        return Json.encodeToString(approaches)
    }

    @TypeConverter
    open fun toApproaches(string: String?): MutableList<Approache>?{
        return Json.decodeFromString<MutableList<Approache>>(string!!)
    }
}