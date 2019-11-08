package com.coolya.i1.di

import com.coolya.i1.data.ToDo
import com.coolya.i1.ui.create.data.CreateLocalDataSource
import com.coolya.i1.ui.create.data.CreateTodoRepository
import com.coolya.i1.ui.create.vm.CreateToDoViewModel
import com.coolya.i1.ui.main.data.MainLocalDataSource
import com.coolya.i1.ui.main.data.MainRepository
import com.coolya.i1.ui.main.vm.MainViewModel
import com.coolya.i1.ui.progress.data.ProgressLocalDataSource
import com.coolya.i1.ui.progress.data.ProgressRepo
import com.coolya.i1.ui.progress.vm.ProgressViewModel
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

val ProgressModule = module {
    factory { ProgressLocalDataSource(get()) }
    factory { ProgressRepo(get()) }
    viewModel { (todo: ToDo) -> ProgressViewModel(get(),get(), todo) }
}
