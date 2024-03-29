package com.coolya.i1.platform

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.Executors

fun <Key, Value> DataSource.Factory<Key, Value>.toPagedList(
    config: PagedList.Config? = null,
    boundaryCallback: PagedList.BoundaryCallback<Value>? = null
): LiveData<PagedList<Value>> {
    return LivePagedListBuilder(
        this, config ?: PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGING_DEFAULT_INITIAL_LOAD_SIZE_HINT)
            .setPageSize(PAGING_DEFAULT_PAGE_SIZE)
            .setPrefetchDistance(PAGING_DEFAULT_PREFETCH_DISTANCE)
            .setEnablePlaceholders(false)
            .build()
    )
        .setBoundaryCallback(boundaryCallback)
        .setFetchExecutor(Executors.newFixedThreadPool(5))
        .build()
}

private const val PAGING_DEFAULT_PAGE_SIZE = 15
private const val PAGING_DEFAULT_PREFETCH_DISTANCE = 15
private const val PAGING_DEFAULT_INITIAL_LOAD_SIZE_HINT = 30