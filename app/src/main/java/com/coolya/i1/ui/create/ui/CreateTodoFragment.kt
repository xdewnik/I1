package com.coolya.i1.ui.create.ui

import android.os.Bundle
import android.view.View
import com.coolya.i1.R
import com.coolya.i1.data.ToDo
import com.coolya.i1.databinding.FragmentCreateBinding
import com.coolya.i1.ui.base.BaseBottomFragment
import com.coolya.i1.ui.create.vm.CreateToDoViewModel
import kotlinx.android.synthetic.main.fragment_create.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CreateTodoFragment : BaseBottomFragment<FragmentCreateBinding>() {
    override fun setLayoutId(): Int = R.layout.fragment_create

    private val viewModel by viewModel<CreateToDoViewModel> { parametersOf(this@CreateTodoFragment) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_button.setOnClickListener {
            viewModel.saveTodo(
                ToDo(
                    title = title.text.toString(),
                    quantity = times.text.toString().toInt()
                )
            )
        }

    }
}