package com.special.robinhood.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "mobile")
data class MobileCacheEntity(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "brand") var brand: String? = null,
    @ColumnInfo(name = "thumbImageURL") var thumbImageURL: String? = null,
    @ColumnInfo(name = "price") var price: String? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "rating") var rating: String? = null,
    @ColumnInfo(name = "description") var description: String? = null
)