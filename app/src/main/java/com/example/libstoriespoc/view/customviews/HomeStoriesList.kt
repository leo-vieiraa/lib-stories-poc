package com.example.libstoriespoc.view.customviews

data class Thumbnail(
    val title: String,
    val x1: String,
    val x2: String
)

data class Media(
    val title: String,
    val x1: String,
    val x2: String
)

data class Action(
    val text: String,
    val action: String,
    val aS: String
)

data class HomeStoriesList(
    val key: String,
    val title: String,
    val description: String,
    val viewed: Boolean,
    val time: Int,
    val highlight: Boolean,
    val thumbnail: Thumbnail,
    val media: Media,
    val texts: ArrayList<Object>,
    val action: Action
)
