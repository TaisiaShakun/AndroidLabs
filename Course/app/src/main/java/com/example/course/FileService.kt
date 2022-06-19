package com.example.course

import android.content.Context
import java.io.File

class FavoritesService(private val context: Context) {
    private val SEPARATOR : String = ","
    private val FILE_NAME : String = "favorites1.txt"

    fun get() : List<Int> {
        val ids = ArrayList<Int>()
        val file = File(context.filesDir, FILE_NAME)
        if(!file.exists()) {
            return ids
        }

        val oldContent = file.readText()
        if(oldContent.isEmpty()) {
            return ids
        }

        val oldIds = oldContent.split(SEPARATOR)
        for(idString in oldIds) {
            val id = idString.toInt()
            ids.add((id))
        }

        return ids
    }

    fun add(id : Int) {
        val file = File(context.filesDir, FILE_NAME)
        if(!file.exists()) {
            file.createNewFile()
        }

        val oldContent = file.readText()
        if(oldContent.isEmpty()) {
            val content = id.toString()
            file.writeText(content)
            return
        }

        val newIds = ArrayList<Int>()
        val oldIds = oldContent.split(SEPARATOR)
        for(idString in oldIds) {
            val parsedId = idString.toInt()
            if(id == parsedId) {
                continue
            }

            newIds.add((id))
        }

        newIds.add((id))

        val newContent = newIds.joinToString(separator = SEPARATOR)
        file.writeText(newContent)
    }

    fun remove(id : Int) {
        val file = File(context.filesDir, FILE_NAME)
        if(!file.exists()) {
            return
        }

        val oldContent = file.readText()
        if(oldContent.isEmpty()) {
            return
        }

        val newIds = ArrayList<Int>()
        val oldIds = oldContent.split(SEPARATOR)
        for(idString in oldIds) {
            val parsedId = idString.toInt()
            if(parsedId != id) {
                newIds.add((parsedId))
            }
        }

        val newContent = newIds.joinToString(separator = SEPARATOR)
        file.writeText(newContent)
    }
}