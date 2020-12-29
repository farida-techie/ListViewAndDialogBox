package com.malkinfo.listviewanddialogbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyUserAdapter(var c :Context ,var resource:Int, var userList:List<UserData>):
ArrayAdapter<UserData>(c,resource,userList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val infalat = LayoutInflater.from(c)
        val userView = infalat.inflate(resource,null)
        /**set findId*/
        val name = userView.findViewById<TextView>(R.id.name)
        val phone = userView.findViewById<TextView>(R.id.phone)

        /**set View*/
         val listUser = userList[position]
        name.text = listUser.userName
        phone.text = listUser.UserPhone
        return userView
    }
}