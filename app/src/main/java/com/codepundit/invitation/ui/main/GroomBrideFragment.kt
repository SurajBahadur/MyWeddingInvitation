package com.codepundit.invitation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codepundit.invitation.R
import com.codepundit.invitation.databinding.FragmentGroomBrideBinding
import com.codepundit.invitation.utis.loadImageRound


class GroomBrideFragment : Fragment() {

    private lateinit var binding: FragmentGroomBrideBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_groom_bride, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (arguments?.getInt(PlaceholderFragment.ARG_SECTION_NUMBER)) {
            1 -> {
                //GROOM
                binding.tvName.text = getString(R.string.groom_name)
                binding.tvDenoteParent.text = "S/O"
                binding.tvParentName.text=getString(R.string.groom_parent)
                binding.ivProfile.loadImageRound(R.drawable.ic_groom)
            }
            2 -> {
                //BRIDE
                binding.tvName.text = getString(R.string.bride_name)
                binding.tvDenoteParent.text = "D/O"
                binding.tvParentName.text=getString(R.string.bride_parent)
                binding.ivProfile.loadImageRound(R.drawable.ic_bride)
            }
            3 -> {
                //INVITATION
                binding.tvName.visibility = View.GONE
                binding.ivProfile.visibility = View.GONE
                Glide.with(this)
                    .load(R.drawable.ic_invitation_card)
                    .centerCrop()
                    .into(binding.ivInvitation)
            }
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): GroomBrideFragment {
            return GroomBrideFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }
}