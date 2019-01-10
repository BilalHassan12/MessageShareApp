package com.smartherd.messageshareapp.activities.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.smartherd.messageshareapp.R
import com.smartherd.messageshareapp.activities.activities.MainActivity
import com.smartherd.messageshareapp.activities.models.Hobby
import com.smartherd.messageshareapp.activities.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = HobbiesAdapter::class.java.simpleName
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
              currentHobby?.let {
                  context.showToast(currentHobby!!.title + "Clicked !")
              }
            }

            itemView.imgShare.setOnClickListener {

                currentHobby?.let {
                    val message: String = "My hobby is: " + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Please select app: "))
                }
            }
        }

        fun setData(hobby: Hobby?, pos: Int){
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }

    }

}