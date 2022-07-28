package com.oa.shoestore.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Shoe(val
           shoeName:String,val ShoeCompany:String,val ShoeSize:Int,val ShoeDescription: String):Parcelable{


}