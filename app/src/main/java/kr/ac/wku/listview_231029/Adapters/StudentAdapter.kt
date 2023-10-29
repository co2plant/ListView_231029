package kr.ac.wku.listview_231029.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.ac.wku.listview_231029.Datas.StudentData
import kr.ac.wku.listview_231029.R
import org.w3c.dom.Text

class StudentAdapter(
    mContext:Context,
    resId:Int,
    val mList:ArrayList<StudentData>
) : ArrayAdapter<StudentData>(mContext, resId, mList) {
    //ArrayAdapter : 기본 생성자 지원 안함
    //학생 데이터 + xml을 조합해서 뿌려줄 클래스
    //StudentAdapter 생성
    //ArrayAdapter상속 => 기본생성자 지원 안함
    // 어댑터 클래스가 생성자에서 변수 받아오게
    //받아오는 변수를 부모클래스에 전달.

    //커스텀으로 만든 xml을 코틀린단으로 끌어와주는 객체
    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null)
        {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!
        //

        val stdData = mList[position] //그림을 그려줄 위치에 맞는 학생 객체 추출

        //Adapter에서는 데이터 바인딩 사용 불가 -> 직접 코드로 불러내야함.
        val txtName = row.findViewById<TextView>(R.id.textviewname)
        val txtAge = row.findViewById<TextView>(R.id.textviewage)
        val txtPhoneNum = row.findViewById<TextView>(R.id.textviewphonenum)

        txtName.text = stdData.name
        txtAge.text = "(${2023-stdData.birthYear + 1}세)"
        txtPhoneNum.text = stdData.phoneNum


        return row
    }
}