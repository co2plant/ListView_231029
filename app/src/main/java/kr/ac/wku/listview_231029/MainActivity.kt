package kr.ac.wku.listview_231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.listview_231029.Adapters.StudentAdapter
import kr.ac.wku.listview_231029.Datas.StudentData
import kr.ac.wku.listview_231029.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    val mStudentList = ArrayList<StudentData>()

    lateinit var mStdAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //화면이 켜질때, 학생 목록을 ArrayList에 수기로 추가(임시 -> 실무에서는 활용 안함)

        mStudentList.add(StudentData("a", 1990, "010-1234-1234"))
        mStudentList.add(StudentData("b", 1991, "010-1234-1234"))
        mStudentList.add(StudentData("c", 1992, "010-1234-1234"))
        mStudentList.add(StudentData("d", 1993, "010-1234-1234"))
        mStudentList.add(StudentData("e", 1994, "010-1234-1234"))
        mStudentList.add(StudentData("f", 1995, "010-1234-1234"))
        mStudentList.add(StudentData("g", 1996, "010-1234-1234"))
        mStudentList.add(StudentData("h", 1997, "010-1234-1234"))
        mStudentList.add(StudentData("i", 1998, "010-1234-1234"))
        mStudentList.add(StudentData("j", 1999, "010-1234-1234"))
        mStudentList.add(StudentData("k", 2000, "010-1234-1234"))
        mStudentList.add(StudentData("l", 2001, "010-1234-1234"))
        mStudentList.add(StudentData("m", 2002, "010-1234-1234"))

        //수기작업 : mStudentList에 임시 학생 데이터 추가
        /*
        실전에서는 API가 내려주는 학생데이터를 추가하는 것이 일반적임.
        * */

        mStdAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        binding.studentListView.adapter = mStdAdapter
    }
}