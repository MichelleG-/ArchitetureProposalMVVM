package com.architeture.proprosal.presentation.view.model.persistence

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.architeture.proprosal.presentation.utils.KParcelable
import com.architeture.proprosal.presentation.utils.readLongNullable
import com.architeture.proprosal.presentation.utils.writeLongNullable

data class ProductViewModel(
    val id: Long?,
    var name: String?,
    var value: Double,
    var valueFormat: String?
) : KParcelable, ViewModel() {
    constructor(parcel: Parcel) : this(
        parcel.readLongNullable(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLongNullable(id)
        dest.writeString(name)
        dest.writeDouble(value)
        dest.writeString(valueFormat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductViewModel> {
        override fun createFromParcel(parcel: Parcel): ProductViewModel {
            return ProductViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductViewModel?> {
            return arrayOfNulls(size)
        }
    }
}
