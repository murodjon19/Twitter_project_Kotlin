package com.example.twitter_project_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter_project_kotlin.adapter.FeetAdapter
import com.example.twitter_project_kotlin.adapter.StoryAdapter
import com.example.twitter_project_kotlin.model.Post
import com.example.twitter_project_kotlin.model.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerStory: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerStory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerFeed.layoutManager = GridLayoutManager(this,1)

        refreshPostAdapter(getAllPost())
        refreshStoryAdapter(getAllStory())
    }

    private fun getAllPost(): ArrayList<Post> {
        val feed : ArrayList<Post> = ArrayList()
        feed.add(Post(R.drawable.img29,"Murodjon Avazob",R.drawable.img30))

        return feed
    }

    private fun getAllStory(): ArrayList<Story> {
        val chats : ArrayList<Story> = ArrayList()
        chats.add(Story(R.drawable.img30,"Avazov"))
        chats.add(Story(R.drawable.img31,"Abdumajid"))
        chats.add(Story(R.drawable.img33,"Bek"))
        chats.add(Story(R.drawable.img42,"Bek"))
        chats.add(Story(R.drawable.img32,"Bek"))
        chats.add(Story(R.drawable.img42,"Bek"))
        chats.add(Story(R.drawable.img33,"Bek"))
        chats.add(Story(R.drawable.img30,"Bek"))
        chats.add(Story(R.drawable.img31,"Bek"))
        chats.add(Story(R.drawable.img30,"Bek"))
        chats.add(Story(R.drawable.img34,"Bek"))

        return chats
    }

    private fun refreshPostAdapter(feed: ArrayList<Post>) {
        val adapter = FeetAdapter(this,feed)
        recyclerFeed.adapter = adapter
    }

    private fun refreshStoryAdapter(chats: ArrayList<Story>) {
        val adapter = StoryAdapter(this,chats)
        recyclerStory.adapter = adapter
    }
}