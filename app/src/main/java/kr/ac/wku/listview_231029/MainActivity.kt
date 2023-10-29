package kr.ac.wku.listview_231029

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        mStudentList.add(StudentData("m", 2002))

        //수기작업 : mStudentList에 임시 학생 데이터 추가
        /*
        실전에서는 API가 내려주는 학생데이터를 추가하는 것이 일반적임.
        * */

        mStdAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        binding.studentListView.adapter = mStdAdapter

        //한명의 학생을 클릭하면 -> 토스트로 이름 연락처를 출력하는 것.(Event)

        binding.studentListView.setOnItemClickListener { adapterView, view, position, l ->
            //이 함수의 세번째 변수(i, position) -> 클릭된 위치를 알려주는 역할
            val clickedStd = mStudentList[position]
            Toast.makeText(this, "${clickedStd.name} : ${clickedStd.phoneNum}", Toast.LENGTH_SHORT).show()
        }

        //한명의 학생을 오래 클릭하면 -> 해당 학생 삭제
        binding.studentListView.setOnItemLongClickListener { adapterView, view, position, l ->
            //long click event -> boolean type의 리턴값을 받도록 되어잇음.

            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제확인")
            alert.setMessage("정말 ${mStudentList[position].name}학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener{
                dialogInterface, i ->
                mStudentList.removeAt(position) //내용물 변경 발생
                mStdAdapter.notifyDataSetChanged()
                //삭제기능은 확인 버튼이 눌릴때 실행
                // 오래 클릭된 학생 => 목록에서 삭제
            })
            alert.setNegativeButton("취소", null)
            alert.show()
            //정말 지울건지 물어보고 OK라면 해당 학생을 삭제하도록 추가



            return@setOnItemLongClickListener true
        }
    }
}