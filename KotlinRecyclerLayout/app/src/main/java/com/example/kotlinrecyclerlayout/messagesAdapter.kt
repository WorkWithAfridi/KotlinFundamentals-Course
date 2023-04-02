package com.example.kotlinrecyclerlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
    var userList = ArrayList<String>()
    var messageList = ArrayList<String>()
    lateinit var context: Context

    constructor(userList: ArrayList<String>, messageList: ArrayList<String>, context: Context) {
        this.userList = userList
        this.messageList = messageList
        this.context = context
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userName : TextView = itemView.findViewById(R.id.userName)
        var userMessage : TextView = itemView.findViewById(R.id.userMessage)
        var messageCard : CardView = itemView.findViewById(R.id.messageCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.message_tile,
            parent,
            false,
        )
        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.userName.text=userList[position]
        holder.userMessage.text=messageList[position]
    }
}