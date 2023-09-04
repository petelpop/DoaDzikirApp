package com.pall.doadzikirapp.Interface

import com.pall.doadzikirapp.model.ArticleItem

interface OnItemCallback {
    fun onItemClicked(item: ArticleItem)
}
