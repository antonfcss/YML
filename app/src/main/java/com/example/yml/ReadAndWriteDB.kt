package com.example.yml

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ReadAndWriteDB {

    private val TAG = "ReadAndWriteSnippets"


    private lateinit var database: DatabaseReference

    fun initializeDbRef() {
        database = Firebase.database.reference
    }

    fun writeNewUser(email: String, uid: String) {
        val user = User(email, uid)
        database.child("users").child(uid).setValue(user)
    }

//    private fun addPostEventListener(postReference: DatabaseReference) {
//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val post = dataSnapshot.getValue<Post>()
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
//            }
//        }
//        postReference.addValueEventListener(postListener)
//    }
}