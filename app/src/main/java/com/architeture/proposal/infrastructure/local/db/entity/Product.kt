package com.architeture.proprosal.infrastructure.local.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product constructor(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Long?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "value")
    val value: Double
)