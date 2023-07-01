package com.example.tap.ui.dashboard

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.tap.databinding.FragmentDashboardBinding
import com.example.tap.databinding.ItmeRecyclerViewBinding
import com.bumptech.glide.Glide
import com.example.tap.R


data class BoardItem(val image: String, val title: String, val time: String)

class BoardAdapter(val itemList: ArrayList<BoardItem>):
    RecyclerView.Adapter<BoardAdapter.BoardViewHolder>(){
    override fun getItemCount(): Int {
       return itemList.count()
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.itme_recycler_view, parent, false)
        return BoardViewHolder(view)
    }


    class BoardViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindItems(data: BoardItem){
            Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.findViewById(R.id.tv_img))
            itemView.findViewById<TextView>(R.id.tv_title).text = data.title
            itemView.findViewById<TextView>(R.id.tv_time).text = data.time


            itemView.setOnClickListener({
                //여기서 토스터를 어떻게?
//                zoomImageFromThumb(itemView, data.image)
                Toast.makeText(itemView.context, "아이템 '${data.title}'를 클릭했습니다.", Toast.LENGTH_LONG).show()
            })
        }
    }


    }


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //클릭시 이미지 확대
//    private fun clickEvent(view: View, pos: Int) {
//        val intent = Intent(this, ImageActivity::class.java)
//        intent.putExtra("pos", pos)
//        val opt = ActivityOptions.makeSceneTransitionAnimation(this, view, "imgTrans")
//        startActivity(intent, opt.toBundle())
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        /*make itemList*/
        val itemList = ArrayList<BoardItem>()
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))
        itemList.add(BoardItem("res/drawable/jokebear33.jpg","농담입니다","2023/07/01"))
        itemList.add(BoardItem("https://postfiles.pstatic.net/MjAyMTEyMTdfNDIg/MDAxNjM5NzI0NTM0NTQy.Kg00KseRfKe1s7IYhOxaA_q8ZwPqrmyf5rg1loN9scEg.UGdQ2hlKt4RzmTXAlMuzwWM9q3F3L88euDZZfwvw8Wwg.JPEG.xvx404/KakaoTalk_20211104_114046906.jpg?type=w966","농담곰인물","2023/07/01"))

        val boardAdapter = BoardAdapter(itemList)
        boardAdapter.notifyDataSetChanged()

        val RV_board :RecyclerView = binding.rvBoard
        RV_board.adapter = boardAdapter
        RV_board.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}