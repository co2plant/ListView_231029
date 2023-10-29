package kr.ac.wku.listview_231029.Datas

import android.util.Log

class StudentData( //StudnetData의 생성자를 변경했습니다. : 이름, 출생년도, 폰번을 넣어서 생성하도록
    val name:String,
    val birthYear:Int,
    val phoneNum:String) {

    constructor(name:String, birthYear: Int):this(name, birthYear, "모름")

    fun getKoreanAge(year:Int) : Int{
        return year-this.birthYear+1
    }

    fun printSimplePhoneNum()
    {
        Log.d("StudentData", "klk")
    }
}