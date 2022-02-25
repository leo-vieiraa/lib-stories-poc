package com.example.libstoriespoc.domain.model

import java.io.Serializable

data class Thumbnail(
    val title: String,
    val x1: String,
    val x2: String
) : Serializable

data class Media(
    val title: String,
    val x1: String,
    val x2: String
) : Serializable

data class Action(
    val text: String,
    val action: String,
    val aS: String
) : Serializable

data class Story(
    val key: String,
    val title: String,
    val description: String,
    var viewed: Boolean,
    val time: Int,
    val highlight: Boolean,
    val thumbnail: Thumbnail,
    val media: Media,
    val texts: ArrayList<Object>,
    val action: Action
) : Serializable
