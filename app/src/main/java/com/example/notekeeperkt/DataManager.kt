package com.example.notekeeperkt

object DataManager {
    val headings = HashMap<String, TopicInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeHeadings()
    }




    private  fun initializeHeadings(){
        var heading = TopicInfo("gen", "General")
      headings.set(heading.HeadingID, heading)

      heading = TopicInfo(HeadingID = "books", title = "Books")
        headings[heading.HeadingID] = heading

      heading = TopicInfo(title = "TODO", HeadingID = "TO DO")
        headings[heading.HeadingID] = heading

      heading = TopicInfo("java_core", "Games")
        headings[heading.HeadingID] = heading
    }


}