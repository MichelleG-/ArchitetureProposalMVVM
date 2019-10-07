package com.architeture.proprosal.infrastructure.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.architeture.proprosal.infrastructure.local.db.entity.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Query("DELETE FROM product_table")
    fun deleteAll()

    @Query("SELECT * FROM product_table ORDER BY id")
    fun getAllProductsByIds(): LiveData<List<Product>>

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun delete(product: Product)

}