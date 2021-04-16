package com.codepundit.invitation.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepundit.invitation.R
import com.codepundit.invitation.adapters.ContactListAdapter
import com.codepundit.invitation.databinding.ActivityContactBinding
import com.codepundit.invitation.model.ContactModel

class ContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact)
        binding.toolbar2.title = "Contacts"
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        updateUI()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun updateUI() {
        val contactList = arrayListOf<ContactModel>()
        contactList.apply {
            add(
                ContactModel(
                    "Arjun",
                    "8558908004",
                    ContextCompat.getDrawable(this@ContactActivity, R.drawable.ic_arjun)
                )
            )
            add(
                ContactModel(
                    "Amit",
                    "8054456914",
                    ContextCompat.getDrawable(this@ContactActivity, R.drawable.ic_amit)
                )
            )
            add(
                ContactModel(
                    "Ashok",
                    "8284955190",
                    ContextCompat.getDrawable(this@ContactActivity, R.drawable.ic_ashol)
                )
            )
        }
        binding.rvContactList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ContactListAdapter(this, contactList)
        binding.rvContactList.adapter = adapter
    }
}