package com.miu.edu.animalkingdomexplorer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "species",
    indices = [Index(value = ["id"], unique = true)])
data class Species(

    @PrimaryKey(autoGenerate = true)
    val id: Long= 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String
){
    constructor(name: String, description: String) : this(0, name, description)
}