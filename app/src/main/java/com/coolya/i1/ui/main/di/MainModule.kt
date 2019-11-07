package com.coolya.i1.ui.main.di

import com.coolya.i1.room.I1Room
import com.coolya.i1.ui.create.data.CreateLocalDataSource
import com.coolya.i1.ui.create.data.CreateTodoRepository
import com.coolya.i1.ui.create.vm.CreateToDoViewModel
import com.coolya.i1.ui.main.data.MainLocalDataSource
import com.coolya.i1.ui.main.data.MainRepository
import com.coolya.i1.ui.main.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainModule = module {
    factory { MainLocalDataSource(get()) }
    factory { MainRepository(get()) }
    viewModel { MainViewModel(get(),get()) }
}

val CreateModule = module {
    factory { CreateLocalDataSource(get()) }
    factory { CreateTodoRepository(get()) }
    viewModel { CreateToDoViewModel(get(),get()) }
}
