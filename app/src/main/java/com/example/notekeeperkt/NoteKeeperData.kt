package com.example.notekeeperkt

data class TopicInfo(val HeadingID: String, val title:String) {
    override fun toString(): String {
        return title
    }
}


data class NoteInfo(var course:TopicInfo?=null, var title: String?=null, var text : String?=null)