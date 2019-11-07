package com.coolya.i1.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.coolya.i1.data.ToDo
import com.coolya.i1.databinding.ItemTodoBinding

class ToDoAdapter : PagedListAdapter<ToDo, ToDoViewHolder>(asyncDiff) {

    var onTodoClick = OnTodoClick.empty

    companion object asyncDiff : DiffUtil.ItemCallback<ToDo>() {
        override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return LayoutInflater.from(parent.context).run {
            ItemTodoBinding.inflate(this, parent, false)
        }.run { ToDoViewHolder(this) }
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.itemView.setOnClickListener { onTodoClick.onToDoClick(getItem(position)!!) }
    }
}

class ToDoViewHolder(private val binding: ItemTodoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(toDo: ToDo) = with(binding) {
        this.todo = toDo
        executePendingBindings()
    }
}

interface OnTodoClick {

    companion object {
        val empty = object : OnTodoClick {
            override fun onToDoClick(toDo: ToDo) {
            }

        }
    }

    fun onToDoClick(toDo: ToDo)
}