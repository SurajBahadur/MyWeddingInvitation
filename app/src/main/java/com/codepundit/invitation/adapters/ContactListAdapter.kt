package com.codepundit.invitation.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codepundit.invitation.databinding.ItemContactBinding
import com.codepundit.invitation.model.ContactModel
import com.codepundit.invitation.ui.menu.ContactActivity
import com.codepundit.invitation.utis.loadImageRound

class ContactListAdapter(
    val contactActivity: ContactActivity,
    val contactList: ArrayList<ContactModel>
) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            inContactName.text = contactList[holder.adapterPosition].name
            ivContactImg.loadImageRound(contactList[holder.adapterPosition].image!!)
            inContactCall.setOnClickListener {
                callPhone(contactList[holder.adapterPosition].contact)
            }
        }
    }

    private fun callPhone(phone: String) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            contactActivity.startActivity(intent)
        } catch (e: Exception) {
            //showSnackBar("Contact number not available")
        }
    }

    override fun getItemCount(): Int = contactList.size
}