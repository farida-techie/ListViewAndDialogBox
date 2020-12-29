package com.malkinfo.listviewanddialogbox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var addBtn:FloatingActionButton
    private lateinit var listUser:ListView
    private lateinit var showtext:TextView
    private lateinit var adapter:MyUserAdapter
    private  var userAdd = mutableListOf<UserData>()
    var title = "Add the User Information"
    var add = "Add"
    var cancel = "Cancel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set View*/
        addBtn = findViewById(R.id.addUserBtn)
        listUser = findViewById<ListView>(R.id.userList)
        showtext = findViewById(R.id.textShow)
        /**set Adapter*/
        adapter = MyUserAdapter(this,R.layout.item_user,userAdd)
        listUser.adapter = adapter
        addBtn.setOnClickListener { showUserDialog() }

    }

    @SuppressLint("InflateParams")
    private fun showUserDialog() {
        /**set User Information Dialog*/
        val inflat = LayoutInflater.from(this)
        val showView = inflat.inflate(R.layout.addding_user,null)
        /**set View find Id*/
        val name = showView.findViewById<EditText>(R.id.userName)
        val phone = showView.findViewById<EditText>(R.id.userphone)
        val addUserDialog = AlertDialog.Builder(this)
        addUserDialog.setView(showView)
        addUserDialog.setTitle(title)
        /**set Button*/
        addUserDialog.setPositiveButton(add){
            dialog,which->
            /**set data*/
            userAdd.add(UserData(
                    "Name: ${name.text.toString()}",
                    "Mobile No.:${phone.text.toString()}"
            ))
            adapter.notifyDataSetChanged()
            showtext.visibility = View.GONE
            /** set Toast massage*/
            Toast.makeText(this,"Information is Adding Data",Toast.LENGTH_SHORT).show()

        }
        addUserDialog.setNegativeButton(cancel){
            dialog,which->
            dialog.dismiss()
            Toast.makeText(this,cancel,Toast.LENGTH_SHORT).show()
        }
        addUserDialog.create()
        addUserDialog.show()
    }
}