/*
 * *
 *  * Created by Alexander on 3/26/22, 10:40 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/26/22, 10:40 PM
 *
 */

package com.example.androidui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CourseRVAdapter(private val context: Context, courseModalArrayList: ArrayList<CourseModal>) :
    RecyclerView.Adapter<CourseRVAdapter.ViewHolder>() {
    private val courseModalArrayList: ArrayList<CourseModal>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // passing our layout file for displaying our card item
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // setting data to our text views from our modal class.
        val courses: CourseModal = courseModalArrayList[position]
        holder.courseNameTV.setText(courses.courseName)
        holder.courseDurationTV.setText(courses.courseDuration)
        holder.courseDescTV.setText(courses.courseDescription)
    }

    override fun getItemCount(): Int {
        return courseModalArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // creating variables for our text views.
        private val courseNameTV: TextView
        private val courseDurationTV: TextView
        private val courseDescTV: TextView

        init {
            // initializing our text views.
            courseNameTV = itemView.findViewById(R.id.idTVCourseName)
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration)
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription)
        }
    }

    // creating a constructor class.
    init {
        this.courseModalArrayList = courseModalArrayList
    }
}
