package com.example.a24.a3_UI.recyclerViewAdapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a24.R
import com.example.a24.a2_Domain.UserStatus
import com.example.a24.a3_UI.modelUi.UsersPostUIModel
import com.example.a24.databinding.RecyclerViewTamplateBinding

class RecyclerViewAdapter : RecyclerView.Adapter<UsersPostViewHolder>() {

    private val usersPostsList = mutableListOf<UsersPostUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UsersPostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_tamplate, parent, false)
        )

    override fun getItemCount(): Int {
        return usersPostsList.size
    }

    override fun onBindViewHolder(holder: UsersPostViewHolder, position: Int) {
        holder.bind(usersPostsList[position])
    }

    fun updateAdapter(newList: List<UsersPostUIModel>) {
        usersPostsList.clear()
        usersPostsList.addAll(newList)
        notifyDataSetChanged()
    }
}


class UsersPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DataBindingUtil.bind<RecyclerViewTamplateBinding>(view)!!

    @SuppressLint("ResourceType")
    fun bind(model: UsersPostUIModel) {
        binding.xml = model
        if (model.status == UserStatus.NORMAL) {
            binding.tvBody.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        else if (model.status == UserStatus.WARNING) {
            binding.tvBody.setBackgroundColor(Color.parseColor("#FFD900"))
        }
        else if (model.status == UserStatus.BANNED) {
            binding.tvBody.setBackgroundColor(Color.parseColor("#FF0000"))
        }
    }
}
