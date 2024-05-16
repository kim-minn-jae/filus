package com.example.login

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context,private val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    /**
     * 화면 설정
     */

    //user_layout 연결 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).
        inflate(R.layout.user_layout,parent, false)

        return UserViewHolder(view)
    }
    //데이터 연결 함수
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //데이터 담기
        val currentUser = userList[position]
        Log.d("CURRENTUSER", currentUser.toString())

        //화면에 데이터 보여주기
        holder.nameText.text = currentUser.name

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener{

            val intent = Intent(context, ChatActivity::class.java)

            //넘길 데이터
            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)
            Log.d("ADAPTER", currentUser.uid)
            Log.d("ADAPTER", currentUser.name)
            Log.d("ADAPTER", currentUser.toString())

            context.startActivity(intent)
        }
    }
    //실제 userList의 갯수를 가져오는 함수
    override fun getItemCount(): Int {
        return userList.size
    }



    class UserViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        val nameText: TextView = itemView.findViewById(R.id.name_text)
    }
}