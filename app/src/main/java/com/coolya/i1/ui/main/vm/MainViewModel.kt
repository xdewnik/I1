package com.coolya.i1.ui.main.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.base.BaseViewModel
import com.coolya.i1.ui.main.data.MainRepository

class MainViewModel(
    app: Application,
    private val repo: MainRepository
) : BaseViewModel(app) {

    lateinit var pagedList: LiveData<PagedList<ToDo>>

    init {
        pagedList = repo.fetchList()

    }


}