package com.coolya.i1.ui.main.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.coolya.i1.data.ToDo

class MainRepository(private val local: MainLocalDataSource) {


    fun fetchList(): LiveData<PagedList<ToDo>> = local.fetchPagedListFromDb()


}